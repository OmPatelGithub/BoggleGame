import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
/*
Implementation of the easy level computer
 */
public class easyComputer implements computerDifficulty{

    public BoggleStats.Player type;

    public easyComputer(BoggleStats.Player type){
        this.type = type;
    }
    /*
    This function updates the words the computer found

    @param all_words  A mutable list of all legal words that can be found, given the boggleGrid grid letters
    @param stats BoggleStats Object
    */
    @Override
    public void computerMove(Map<String, ArrayList<Position>> all_words, BoggleStats stats) {
        // implement
        Set<String> playerWords = stats.getPlayerWords();
        for (String validWord: all_words.keySet()) {
            if (validWord.length() < 5){
                if (!playerWords.contains(validWord)) {
                    double num = Math.random();
                    if (num < 0.5) {
                        stats.addWord(validWord, this.type);
                    }
                }
            }
        }
    }
}
