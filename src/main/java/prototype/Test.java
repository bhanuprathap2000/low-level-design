package prototype;


import java.util.List;

public class Test {

    public static void main(String[] args) {

        Enemy flying1 = new Enemy("Flying", 100, 10.5, false, List.of("Laser","Sword","Gun"));
        Enemy flying2 = new Enemy("Flying", 100, 10.5, false, List.of("Laser","Sword","Gun"));

        Enemy clonedEnemy = flying1.clone();


        System.out.println(flying1.getWeapons() == clonedEnemy.getWeapons());

    }
}
