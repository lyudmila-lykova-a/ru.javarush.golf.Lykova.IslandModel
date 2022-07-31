package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;
import ru.javarush.golf.lykova.model.Wolf;
import ru.javarush.golf.lykova.process.Relocation;
import ru.javarush.golf.lykova.process.Reproduction;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(3, 3);
        System.out.println(island);
        System.out.println();
        Relocation relocation = new Relocation(island);
        Reproduction reproduction = new Reproduction();
        Wolf wolf = new Wolf();
        island.move(wolf, 0, 0);
        System.out.println(island);
        System.out.println();
        reproduction.reproduce(wolf);
        System.out.println(island);
//        for (int i = 0; i < 10000; i++) {
//            relocation.relocate(wolf);
//            System.out.println("x равен " + wolf.getLocation().getX() + ", y равен " + wolf.getLocation().getY());
//        }
    }
}
