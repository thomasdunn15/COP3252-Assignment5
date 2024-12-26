import java.util.Random;

public abstract class Enemy {
    String name;
    int health;
    String weapon;
    String armorType;

    Enemy(String name, int health, String weapon, String armorType){
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.armorType = armorType;
    }

    abstract int fight();

    void takeDamage(int damage) throws InvalidDamageException{
        if (damage < 0){
            throw new InvalidDamageException("Negative damage not allowed");
        }
        health -= damage;
    }

    void setName(String name){ this.name = name; }

    String getName() { return name; }

    void setHealth(int health) { this.health = health; }

    int getHealth(){
        return health;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public String getArmorType() {
        return armorType;
    }

    public static Enemy getRandomEnemy() {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return new Donkey();
            case 1:
                return new Ogre();
            case 2:
                return new Dragon();
            default:
                throw new AssertionError("Unexpected value: " + choice);
        }
    }

    public String Stats() {
        return "Name: " + name + "\n" + "Weapon: " + weapon + "\n" + "HP: " + health + "\n" + "Armor Type: " + armorType + "\n";
    }
}

     class InvalidDamageException extends Exception {
        InvalidDamageException(String message) {
            super(message);
        }
    }