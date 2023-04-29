import java.util.ArrayList;
import java.util.Map;
/*
Abstract Interface for computer difficulty
 */
public interface computerDifficulty {
    public void computerMove(Map<String,ArrayList<Position>> all_words, BoggleStats stats);
}
