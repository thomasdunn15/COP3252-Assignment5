import java.util.Random;

class Knight {
    private String name;
    private String weapon;
    private int hp;
    private String armorType;

    //Constructor for auto-generated Knight.
    public Knight(){
        this.name = "Auto-generated Knight";
        this.hp = new Random().nextInt(100) + 1;
        this.weapon = getRandomWeaponType();
        this.armorType = getRandomArmorType();
    }


    public Knight(String name, String weapon) {
        this.name = name;
        this.weapon = weapon;
        this.hp = 1;
        this.armorType = getRandomArmorType();
    }

    //returns random armor type
    String getRandomArmorType(){
        String[] armorTypes = {"Leather", "Metal", "Chainmail", "Plate"};
        int index = new Random().nextInt(armorTypes.length);
        return armorTypes[index];
    }

    //returns random weapon type
    String getRandomWeaponType(){
        String[] weaponTypes = {"Long Sword", "Battle Axe", "Spear", "Warhammer"};
        int index = new Random().nextInt(weaponTypes.length);
        return weaponTypes[index];
    }

    //accessor and mutator functions
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public int getHP() {
        return hp;
    }

    public void setArmorType(String armorType) {
        this.armorType = armorType;
    }

    public String getArmorType() {
        return armorType;
    }

    //fight function to choose a random amount of damage to do to an opponent
    public void fight(Knight opponent) {
        Random random = new Random();
        int damage = random.nextInt(10) + 1;
        opponent.setHP(opponent.getHP() - damage);
        System.out.println("Cling!");
        System.out.println("Clang!\n");
    }

    public void fight(Enemy opponent) throws InvalidDamageException {
        Random random = new Random();
        Random randomChance = new Random();
        int damage = random.nextInt(15,25);
        int chanceToMiss = randomChance.nextInt(5) + 1;
        if (chanceToMiss == 3){
            System.out.println("Your knight missed!\n");
            opponent.takeDamage(0);
        }else {
            opponent.takeDamage(damage);
        }
        System.out.println("Cling!");
        System.out.println("Clang!\n");
    }

    public String Stats() {
        return "Name: " + name + "\n" + "Weapon: " + weapon + "\n" + "HP: " + hp + "\n" + "Armor Type: " + armorType + "\n";
    }

}

