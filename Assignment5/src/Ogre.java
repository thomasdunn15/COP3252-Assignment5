public class Ogre extends Enemy {
    public Ogre() {
        super("ogre", 35, "Bare Hands", "Leather");
    }
    @Override
    public int fight(){
        return 20;
    }
}
