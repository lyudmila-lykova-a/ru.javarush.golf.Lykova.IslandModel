package ru.javarush.golf.lykova.model;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Island {

    private final int width;
    private final int height;
    private final Location[][] locations;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                locations[y][x] = new Location(x, y);
            }
        }
    }

    public Location takeLocation(int x, int y) {
        // todo check coordinates
        return locations[y][x];
    }

    public Location takeLocationByOffset(Creature creature, int xOffset, int yOffset) {
        Location location = creature.getLocation();
        int x = correctX(location.getX() + xOffset);
        int y = correctY(location.getY() + yOffset);
        return takeLocation(x, y);
    }

    public void move(Creature creature, int x, int y) {
        takeLocation(x, y).add(creature);
    }

    public void moveOffset(Creature creature, int xOffset, int yOffset) {
        if (xOffset == 0 && yOffset == 0) {
            return;
        }
        Location location = creature.getLocation();
        int x = correctX(location.getX() + xOffset);
        int y = correctY(location.getY() + yOffset);
        move(creature, x, y);
    }

    private int correctX(int x) {
        if (x < 0) {
            return 0;
        } else if (x >= width) {
            return width - 1;
        } else {
            return x;
        }
    }

    private int correctY(int y) {
        if (y < 0) {
            return 0;
        } else if (y >= height) {
            return height - 1;
        } else {
            return y;
        }
    }

    public Set<Location> takeAllLocations() {
        Set<Location> result = new LinkedHashSet<>();
        for (Location[] locationArray : locations) {
            result.addAll(Arrays.asList(locationArray));
        }
        return result;
    }

    @Override
    public String toString() {
        return "Island{" +
                "locations=" + Arrays.deepToString(locations) +
                '}';
    }
}
