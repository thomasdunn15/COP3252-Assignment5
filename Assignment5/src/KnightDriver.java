import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class KnightDriver {
    public static void main(String[] args) throws InvalidDamageException {
        Scanner input = new Scanner(System.in);

        Knight Knight = new Knight();
        Knight autoGenerated = new Knight();
        Knight userDefined = new Knight("name", "weapon");

        char playAgain, playAgain2;
        int enemyHealth = 100;
        String name;

        //do while function that makes the player fight against another knight.
        //code used from previous assignment
        do {
            playAgain = 'n';

            System.out.println("Welcome to Knight Fight!");
            System.out.print("Enter the name of your Knight: ");
            name = input.next();

            Knight.setName(name);
            Knight.setHP(new Random().nextInt(100) + 1);

            System.out.println("Now select your weapon! (Choose number)");
            System.out.println("1) Long Sword");
            System.out.println("2) Battle Axe");
            System.out.println("3) Spear");
            System.out.println("4) Warhammer");

            System.out.print("Your choice my liege? : ");
            int weaponOption = input.nextInt();

            if (weaponOption == 5){
                break;
            }

            //switch case to choose weapon
            switch (weaponOption) {
                case 1 -> Knight.setWeapon("Long Sword");
                case 2 -> Knight.setWeapon("Battle Axe");
                case 3 -> Knight.setWeapon("Spear");
                case 4 -> Knight.setWeapon("Warhammer");
            }

            //ask if user wants knight auto generated or not
            System.out.print("Would you like to auto generate your opponent? (y|n): ");
            char autoGenerate = input.next().charAt(0);

            //auto generates new knight
            if (autoGenerate == 'y') {

                //prints out stats
                System.out.println();
                System.out.println("Your Knight: ");
                System.out.println(Knight.Stats());

                System.out.println("Opponents Knight: ");
                System.out.println(autoGenerated.Stats());

                //press any key to begin function
                System.out.print("Press any key to begin battle: ");
                try {
                    System.in.read();
                    input.nextLine();
                } catch (Exception ignored) {
                }

                System.out.println();
                System.out.println("Begin!" + "\n");

                int round = 1;

                //while a knight is not dead fight function is called
                while (Knight.getHP() > 0 || autoGenerated.getHP() > 0) {

                    System.out.println("Round " + round);
                    Knight.fight(autoGenerated);
                    autoGenerated.fight(Knight);
                    System.out.println("Your Knight: ");
                    System.out.println(Knight.Stats());

                    if (Knight.getHP() <= 0) {
                        System.out.println(Knight.getName() + " died!");
                        break;
                    }

                    System.out.println("Opponents Knight: ");
                    System.out.println(autoGenerated.Stats());

                    if (autoGenerated.getHP() <= 0) {
                        System.out.println(autoGenerated.getName() + " died!\n");
                        enemyHealth = autoGenerated.getHP();
                        break;
                    }

                    round++;
                }


            } else if (autoGenerate == 'n') {

                System.out.print("Enter the name of your Opponent: ");
                String opponentName = input.next();

                System.out.println("Now select your opponents weapon! (Choose number)");
                System.out.println("1) Long Sword");
                System.out.println("2) Battle Axe");
                System.out.println("3) Spear");
                System.out.println("4) Warhammer");

                System.out.print("Your choice my liege? : ");
                int opponentWeapon = input.nextInt();

                userDefined.setName(opponentName);

                switch (opponentWeapon) {
                    case 1 -> userDefined.setWeapon("Long Sword");
                    case 2 -> userDefined.setWeapon("Battle Axe");
                    case 3 -> userDefined.setWeapon("Spear");
                    case 4 -> userDefined.setWeapon("Warhammer");
                }

                System.out.println();
                System.out.println("Your Knight: ");
                System.out.println(Knight.Stats());

                System.out.println("Opponents Knight: ");
                System.out.println(userDefined.Stats());

                System.out.print("Press any key to begin battle: ");
                try {
                    System.in.read();
                    input.nextLine();
                } catch (Exception ignored) {
                }

                System.out.println();
                System.out.println("Begin!" + "\n");

                int round = 1;

                while (Knight.getHP() > 0 || userDefined.getHP() > 0) {

                    System.out.println("Round " + round);
                    Knight.fight(userDefined);
                    userDefined.fight(Knight);
                    System.out.println("Your Knight: ");
                    System.out.println(Knight.Stats());

                    if (Knight.getHP() <= 0) {
                        System.out.println(Knight.getName() + " died!");
                        break;
                    }

                    System.out.println("Opponents Knight: ");
                    System.out.println(userDefined.Stats());

                    if (userDefined.getHP() <= 0) {
                        System.out.println(userDefined.getName() + " died!");
                        enemyHealth = userDefined.getHP();
                        break;
                    }

                    round++;
                }

            } else {
                System.out.print("Invalid option, goodbye!\n");
            }

            if (Knight.getHP() <= 0){
                System.out.print("Would you like to play again? (y|n): ");
                playAgain = input.next().charAt(0);
            }
        } while (playAgain == 'y' || enemyHealth > 0 || name == "skip");

        do{

            playAgain2 = 'n';

        System.out.println("\nYour Knight has survived! However, now they have to pass through " +
                "the JavaBean Forest to get to their final destination.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Unfortunately for your knight, its midnight. Visibility is " +
                "zero and JavaBean forest is full of the most evil characters.\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Your Knight finds the Excalibur sword in a chest! " +
                "Your Knights Damage has increased by 15.  \n");

        Knight.setWeapon("Excalibur");

        System.out.print("Would you like to rest by the fire for the night and heal? (y|n): ");
        char heal = input.next().charAt(0);

        if (heal == 'y')
        {
            System.out.println("\nYou decide to sit by the fire and heal to full health.\n");
            Knight.setHP(100);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        else {
            System.out.println("\nYou decide to carry on through the forest.\n");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Oh no! Your knight is getting ambushed!");
        System.out.println("How many enemies do you see?\n");

        int numOfEnemies;

        do {
            System.out.print("Number of enemies (1-3): ");
            numOfEnemies = input.nextInt();
            if (numOfEnemies < 1 || numOfEnemies > 3){
                System.out.println("Please enter in either 1, 2, or 3.\n");
            }
        }while(numOfEnemies < 1 || numOfEnemies > 3);

        Enemy[] enemies = new Enemy[numOfEnemies];

        for (int i = 0; i < numOfEnemies; i++) {
            enemies[i] = Enemy.getRandomEnemy();
            if (i == 0)
                System.out.print("\nYou see ");
            if ((numOfEnemies == 2 && i == 1) || (numOfEnemies == 3 && i == 2))
                System.out.print("and ");
            if (Objects.equals(enemies[i].getName(), "ogre")){
                System.out.print("an ");
            } else
                System.out.print("a ");
            System.out.print(enemies[i].getName() + " with " + enemies[i].getHealth() + " health");

            if (numOfEnemies == 1 || numOfEnemies == 2 && i == 1 || numOfEnemies == 3 && i == 2)
                System.out.println(".");
            else {
                System.out.println(",");
            }
        }

            System.out.println("\nThey rush you and attack!");

            //press any key to begin function
            System.out.print("Press any key to begin battle: ");
            try {
                System.in.read();
                input.nextLine();
            } catch (Exception ignored) {
            }

            System.out.println();
            System.out.println("Begin!" + "\n");

            int round = 1;

            if (numOfEnemies == 1) {
                while (Knight.getHP() > 0 || (enemies[0].getHealth() > 0)) {

                    System.out.println("Round " + round);
                    for (int i = 0; i < numOfEnemies; i++){
                        Knight.fight(enemies[i]);
                        int damage = enemies[i].fight();
                        Knight.setHP((Knight.getHP()) - damage);
                    }

                    System.out.println("Your Knight: ");
                    System.out.println(Knight.Stats());

                    System.out.println("The Enemies: ");
                    for (int i = 0; i < numOfEnemies; i++){
                        System.out.println(enemies[i].Stats());
                    }

                    round++;

                    if (Knight.getHP() <= 0) {
                        System.out.println(Knight.getName() + " died!");
                        break;
                    }

                    if (enemies[0].getHealth() <= 0){
                        System.out.println("The " + enemies[0].getName() + " died!");
                        break;
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (numOfEnemies == 2){
                while (Knight.getHP() > 0 || (enemies[0].getHealth() > 0) &&
                        (enemies[1].getHealth() > 0)) {

                    System.out.println("Round " + round);
                    for (int i = 0; i < numOfEnemies; i++){
                        Knight.fight(enemies[i]);
                        int damage = enemies[i].fight() / 2;
                        Knight.setHP((Knight.getHP()) - damage);
                    }

                    System.out.println("Your Knight: ");
                    System.out.println(Knight.Stats());

                    System.out.println("The Enemies: ");
                    for (int i = 0; i < numOfEnemies; i++){
                        System.out.println(enemies[i].Stats());
                    }

                    round++;

                    if (Knight.getHP() <= 0) {
                        System.out.println(Knight.getName() + " died!");
                        break;
                    }

                    if (enemies[0].getHealth() <= 0 && enemies[1].getHealth() <= 0){
                        System.out.println("The " + enemies[0].getName() + " and "
                                + enemies[1].getName() + " died!");
                        break;
                    }

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            } else if (numOfEnemies == 3){
                while (Knight.getHP() > 0 || (enemies[0].getHealth() > 0) &&
                        (enemies[1].getHealth() > 0) && (enemies[2].getHealth() > 0)) {

                    System.out.println("Round " + round);
                    for (int i = 0; i < numOfEnemies; i++){
                        Knight.fight(enemies[i]);
                        int damage = enemies[i].fight() / 3;
                        Knight.setHP((Knight.getHP()) - damage);
                    }

                    System.out.println("Your Knight: ");
                    System.out.println(Knight.Stats());

                    System.out.println("The Enemies: ");
                    for (int i = 0; i < numOfEnemies; i++){
                        System.out.println(enemies[i].Stats());
                    }

                    round++;

                    if (Knight.getHP() <= 0) {
                        System.out.println(Knight.getName() + " died!");
                        break;
                    }

                    if (enemies[0].getHealth() <= 0 && enemies[1].getHealth() <= 0){
                        System.out.println("The " + enemies[0].getName() + ", "
                                + enemies[1].getName() + " and " + enemies[2].getName() + " died!");
                        break;
                    }

                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
            if (Knight.getHP() > 0){
                System.out.println("\nAfter your knights battle they have finally made " +
                        "it out of the JavaBean Forest, and they live to fight another day.");
                System.out.println("Where will this adventure take you?");
                break;
            }

            if (Knight.getHP() <= 0){
                System.out.print("Would you like to restart from a checkpoint? (y|n): ");
                playAgain2 = input.next().charAt(0);
            }
    } while (playAgain2 == 'y');
        }
    }
