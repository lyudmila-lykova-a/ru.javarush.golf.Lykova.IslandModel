package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;

import java.text.SimpleDateFormat;
import java.util.*;

public class IslandInfo {

    public void printIslandInfo(Island island) {
        printHeader();
        Map<Class<?>, Integer> classToAmountMap = new TreeMap<>(Comparator.comparing(Class::getSimpleName));
        for (Location location : island.takeAllLocations()) {
            for (Creature creature : location.takeAllCreatures()) {
                Integer amount = classToAmountMap.getOrDefault(creature.getClass(), 0);
                classToAmountMap.put(creature.getClass(), amount + 1);
            }
        }
        for (Map.Entry<Class<?>, Integer> entry : classToAmountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private void printHeader() {
        String header = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
        System.out.println(header);
    }

}
