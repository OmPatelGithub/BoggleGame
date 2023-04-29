public class Concrete_Round_Observer implements Observer{
    int value;
    //Constructor that initializes value
    public Concrete_Round_Observer(){
        this.value = 0;
    }

    //update method from abstract class
    @Override
    public void Update(int value) {
        this.value++;
    }
}
