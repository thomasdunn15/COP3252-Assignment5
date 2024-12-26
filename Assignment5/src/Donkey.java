import java.util.Random;

public class Donkey extends Enemy{

    public Donkey(){
        super("donkey", 20, "Hooves", "Fur");
    }

    @Override
    int fight(){
        return 10;
    }

}
