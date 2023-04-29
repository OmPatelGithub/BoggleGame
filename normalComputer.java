import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
/*
Implementation of the normal level computer
 */
public class normalComputer implements computerDifficulty{

    public BoggleStats.Player type;

    public normalComputer(BoggleStats.Player type){
        this.type = type;
    }
    /*
    This function updates the words the computer found

    @param all_words  A mutable list of all legal words that can be found, given the boggleGrid grid letters
    @param stats BoggleStats Object
    */
    @Override
    public void computerMove(Map<String, ArrayList<Position>> all_words, BoggleStats stats) {
        Set<String> playerWords = stats.getPlayerWords();
        for (String validWord: all_words.keySet()) {
            if (validWord.length() < 6){
                if (!playerWords.contains(validWord)) {
                    stats.addWord(validWord, this.type);
                }
            }
        }
    }
}
