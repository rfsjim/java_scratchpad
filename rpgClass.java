/*
 * RPG Based Class Examples 
 * Aim: Example/Test of Classes with inheritance. Creating objects. 
 * Description: Basic text based RPG
 * Player picks a class and a serialised object is created that will save this character for the player.
 */

import java.io.Serializable;
import java.util.Scanner;

public class rpgClass implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int health;
    int attack;
    int defense;

    public rpgClass(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    @Override
    public String toString() {
        return "Class: " + name + "\nHealth: " + health + "\nAttack: " + attack + "\nDefense: " + defense;
    }
}

class Warrior extends rpgClass {
    public Warrior() {
        super("Warrior", 150, 20, 15);
    }
}
class Mage extends rpgClass {
    public Mage() {
        super("Mage", 100, 30, 5);
    }
}
class Rogue extends rpgClass {
    public Rogue() {
        super("Rogue", 120, 25, 10);
    }
}
class Priest extends rpgClass {
    public Priest() {
        super("Priest", 110, 15, 8);
    }
}

class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your class:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Rogue");
        System.out.println("4. Priest");
        int choice = scanner.nextInt();
        rpgClass playerClass = null;
        switch (choice) {
            case 1:
                playerClass = new Warrior();
                break;
            case 2:
                playerClass = new Mage();
                break;
            case 3:
                playerClass = new Rogue();
                break;
            case 4:
                playerClass = new Priest();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }
        System.out.println("You have chosen:");
        System.out.println(playerClass);
        scanner.close();
    }
}