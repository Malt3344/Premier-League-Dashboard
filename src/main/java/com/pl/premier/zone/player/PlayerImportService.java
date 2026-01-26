package com.pl.premier.zone.player;

import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class PlayerImportService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerImportService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void importFromCsv(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            List<Player> players = new CsvToBeanBuilder<Player>(reader)
                    .withType(Player.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();

            playerRepository.saveAll(players);
            System.out.println(">>> SUCCESS: " + players.size() + " spillere er importeret til SQL!");
        } catch (Exception e) {
            System.err.println(">>> ERROR under import: " + e.getMessage());
        }
    }
}