package liveeasystreet.dicegame.service.tk108;

import liveeasystreet.dicegame.domain.*;
import liveeasystreet.dicegame.repository.tk108.tk108_DiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class tk108_DiceService implements tk108_DiceServiceInterface{
    private final tk108_DiceRepo diceRepository;
    private static int sequence = 0;
    private static final int p_len = 5;

    @Override
    public void save(TK_Dice dice) {
        diceRepository.save(++sequence,dice);
    }

    @Override
    public void save_temp(TK_Dice dice) {
        diceRepository.save(0,dice);
    }

    @Override
    public TK_DiceList findTen() {
        TK_DiceHistory diceHistory = diceRepository.findAll();
        int history_len = diceHistory.getHistory().size()-p_len;
        TK_DiceList diceList = new TK_DiceList();
        if (history_len>=0){
            for(int i=p_len;i<history_len-1;i++){
                diceList.add(diceHistory.getHistory().get(i));
            }
        }
        else{
            for(int i=0;i<history_len;i++){
                diceList.add(diceHistory.getHistory().get(i));
            }
        }
        return diceList;
    }

    @Override
    public TK_DiceHistory findAll() {
        return diceRepository.findAll();
    }

    @Override
    public void clearHistory() {
        sequence=0;
        diceRepository.clearHistory();
    }
}
