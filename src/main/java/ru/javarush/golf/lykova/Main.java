package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;
import ru.javarush.golf.lykova.model.Wolf;
import ru.javarush.golf.lykova.process.Relocation;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(100, 100);
        Relocation relocation = new Relocation(island);
        Wolf wolf = new Wolf();
        island.move(wolf, 0, 0);
        for (int i = 0; i < 10000; i++) {
            relocation.relocate(wolf);
            System.out.println("x равен " + wolf.getLocation().getX() + ", y равен " + wolf.getLocation().getY());
        }
    }
}
