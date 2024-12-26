public class Dragon extends Enemy {
    public Dragon() {
        super("dragon",50, "Fire-Breath", "Scales");
    }

    @Override
    int fight(){
        return 30;
    }
}
