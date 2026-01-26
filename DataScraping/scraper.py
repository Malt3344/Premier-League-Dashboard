import requests
from bs4 import BeautifulSoup
import pandas as pd
import time

output_path = "../src/main/resources/prem_stats.csv"

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.0 Safari/605.1.15'
}

all_teams = []
url = 'https://fbref.com/en/comps/9/Premier-League-Stats'
print("Forbinder til FBRef... vent lige lidt.")

try:
    response = requests.get(url, headers=headers)
    
    if response.status_code == 429:
        print("Fejl: Vi er blevet blokeret midlertidigt (Rate Limited). Vent 10-15 minutter.")
    else:
        soup = BeautifulSoup(response.text, 'lxml')
        tables = soup.find_all('table', class_='stats_table')
        
        if not tables:
            print("Kunne ikke finde tabellen. Prøv at åbne FBRef i din browser for at se om du skal løse en captcha.")
        else:
            table = tables[0]
            links = [l.get("href") for l in table.find_all('a')]
            links = [f"https://fbref.com{l}" for l in links if '/squads/' in l]
            team_urls = list(set(links)) 

            print(f"Fandt {len(team_urls)} hold. Jeg går i gang...")

            for team_url in team_urls:
                team_name = team_url.split("/")[-1].replace("-Stats", "").replace("-", " ")
                print(f"Henter data for: {team_name}...")
                
                data = requests.get(team_url, headers=headers).text
                
                df = pd.read_html(data, match="Standard Stats")[0]
                df.columns = df.columns.droplevel()
                
                keep_columns = ['Player', 'Nation', 'Pos', 'Age', 'MP', 'Starts', 'Min', 'Gls', 'Ast', 'PK', 'CrdY', 'CrdR', 'xG', 'xAG']
                df = df[df['Player'] != 'Squad Total']
                df = df[keep_columns].copy()
                df["Team"] = team_name
                
                df['Nation'] = df['Nation'].str.split(' ').str[-1]
                df['Age'] = df['Age'].str.split('-').str[0]
                
                all_teams.append(df)
                time.sleep(10) 

            final_df = pd.concat(all_teams, ignore_index=True)
            final_df.dropna(subset=['Player'], inplace=True)
            final_df.to_csv(output_path, index=False)
            print(f"\nSucces! 'prem_stats.csv' er opdateret.")

except Exception as e:
    print(f"Der skete en fejl: {e}")
