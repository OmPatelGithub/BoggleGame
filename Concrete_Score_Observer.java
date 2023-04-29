public class Concrete_Score_Observer implements Observer{
    int value;
    //Constructor that initializes value
    public Concrete_Score_Observer(){
        this.value = 0;
    }

    //update method from abstract class
    @Override
    public void Update(int score) {
        this.value += score;
    }
}
