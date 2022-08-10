package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.config.CreatureType;
import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Island;
import ru.javarush.golf.lykova.model.Location;

import java.text.SimpleDateFormat;
import java.util.*;

public class IslandInfo {

    public void printIslandInfo(Island island) {
        printHeader();
        Map<CreatureType, Integer> classToAmountMap = new TreeMap<>(Comparator.comparing(CreatureType::name));
        for (Location location : island.takeAllLocations()) {
            for (Creature creature : location.takeAllCreatures()) {
                Integer amount = classToAmountMap.getOrDefault(creature.getCreatureType(), 0);
                classToAmountMap.put(creature.getCreatureType(), amount + 1);
            }
        }
        for (Map.Entry<CreatureType, Integer> entry : classToAmountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private void printHeader() {
        String header = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
        System.out.println(header);
    }

}
