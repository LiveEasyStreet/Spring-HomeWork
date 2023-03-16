package liveeasystreet.dicegame.service.sinwonogyoon_service;

import liveeasystreet.dicegame.domain.DiceHistory;
import liveeasystreet.dicegame.repository.sinwongyoon_repo.wongyoon_diceRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sin_ServiceTest {

    private wongyoon_diceRepo diceRepo;
    private wongyoon_diceService service;

    @AfterEach
    public void reset() {
        DiceHistory diceHistory = diceRepo.findAll();
        diceHistory.getHistory().clear();
    }

    @Test
    void save() {
    }

    @Test
    void loadHistory() {
    }
}