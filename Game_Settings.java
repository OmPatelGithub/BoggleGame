import java.util.ArrayList;

public class Game_Settings {
    int round;
    int score;

    //ArrayLists for score and round observers
    ArrayList<Concrete_Score_Observer> scoreObserverCollection;
    ArrayList<Concrete_Round_Observer> roundObserverCollection;

    public Game_Settings(){
        //round and score is set to 0 at construction of class
        this.scoreObserverCollection = new ArrayList<>();
        this.roundObserverCollection = new ArrayList<>();
        this.round = 0;
        this.score = 0;

    }

    //registers score observer to scoreObserverCollection
    public void registerScoreObserver(Observer score_observer){
        if(score_observer instanceof Concrete_Score_Observer) {
            this.scoreObserverCollection.add((Concrete_Score_Observer) score_observer);
        }
    }

    //unregisters score observer when given valid index
    public void unregisterScoreObserver(int index){
        if (0 <= index & index <= this.scoreObserverCollection.size()){
            this.scoreObserverCollection.remove(index);
        }
    }

    //notifies all score observers by invoking their .Update method.
    public void notifyScoreObservers(int score){
        for(Concrete_Score_Observer ob : this.scoreObserverCollection){
            ob.Update(score);
        }
    }

    //registers round observer to roundObserverCollection
    public void registerRoundObserver(Observer round_observer){
        if(round_observer instanceof Concrete_Round_Observer) {
            this.roundObserverCollection.add((Concrete_Round_Observer) round_observer);
        }
    }

    //unregisters round observer when given valid index
    public void unregisterRoundObserver(int index){
        if (0 <= index & index <= this.roundObserverCollection.size()){
            this.roundObserverCollection.remove(index);
        }
    }

    //notifies all round observers by invoking their .Update method.
    public void notifyRoundObservers(int roundIncrement){
        for(Concrete_Round_Observer ob : this.roundObserverCollection){
            ob.Update(roundIncrement);
        }
    }


    //increments round attribute
    public void incrementRound(){this.round ++;}

    //increments score -> requires how much score is to be incremented by
    public void incrementScore(int score){this.score += score;}

}
