package ru.javarush.golf.lykova.model;

import java.util.Arrays;

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

    public void move(Animal animal, int x, int y) {
        takeLocation(x, y).add(animal);
    }

    public void moveOffset(Animal animal, int xOffset, int yOffset) {
        if (xOffset == 0 && yOffset == 0) {
            return;
        }
        Location location = animal.getLocation();
        if (location != null) {
            int x = correctX(location.getX() + xOffset);
            int y = correctY(location.getY() + yOffset);
            move(animal, x, y);
        }
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

    @Override
    public String toString() {
        return "Island{" +
                "locations=" + Arrays.deepToString(locations) +
                '}';
    }
}
