package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;
import ru.javarush.golf.lykova.model.Mouse;
import ru.javarush.golf.lykova.model.Wolf;
import ru.javarush.golf.lykova.process.Eating;
import ru.javarush.golf.lykova.process.Relocation;
import ru.javarush.golf.lykova.process.Reproduction;

public class Main {
    public static void main(String[] args) {
        Island island = new Island(3, 3);
        Wolf wolf = new Wolf();
        island.move(wolf, 0, 0);
        Mouse mouse = new Mouse();
        island.move(mouse, 0, 0);
        System.out.println(island);
        System.out.println();
        Eating eating = new Eating();
        eating.eat(wolf);
        System.out.println(island);
    }
}
