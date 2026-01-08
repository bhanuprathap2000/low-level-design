package prototype;

import java.util.ArrayList;
import java.util.List;

public class Enemy {

    private String type;
    private int health;
    private double speed;
    private boolean armored;
    private List<String> weapons;


    public Enemy(String type, int health, double speed, boolean armored, List<String> weapons) {
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.armored = armored;
        this.weapons = weapons;
    }

    public Enemy clone(){

        return new Enemy(type,health,speed,armored,new ArrayList<>(weapons));
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public List<String> getWeapons(){
        return this.weapons;
    }

    public void printStats() {
        System.out.println(type + " [Health: " + health +
                ", Speed: " + speed +
                ", Armored: " + armored +
                ", Weapon: " + weapons + "]");
    }
}
