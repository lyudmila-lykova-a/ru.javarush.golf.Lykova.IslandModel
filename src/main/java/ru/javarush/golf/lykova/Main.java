package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;
import ru.javarush.golf.lykova.model.Mouse;
import ru.javarush.golf.lykova.model.Wolf;
import ru.javarush.golf.lykova.process.Eating;
import ru.javarush.golf.lykova.process.Relocation;
import ru.javarush.golf.lykova.process.Reproduction;
import ru.javarush.golf.lykova.process.WorldGenerator;

public class Main {
    public static void main(String[] args) throws ReflectiveOperationException {
        WorldGenerator worldGenerator = new WorldGenerator(3, 3);
        Island island = worldGenerator.generate();
        System.out.println(island);
    }
}
