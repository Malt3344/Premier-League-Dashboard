package com.pl.premier.zone;

import com.pl.premier.zone.player.PlayerImportService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PremierZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PremierZoneApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PlayerImportService importService) {
		return args -> {
			String path = "src/main/resources/prem_stats.csv";
			importService.importFromCsv(path);
		};
	}
}