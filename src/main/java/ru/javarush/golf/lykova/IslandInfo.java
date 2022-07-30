package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.model.Island;

public class IslandInfo {

    private final Island island;

    public IslandInfo(Island island) {
        this.island = island;
    }

    public String takeInfo() {
        StringBuilder result = new StringBuilder();
        result.append(island.toString());
        return result.toString();
    }
}
