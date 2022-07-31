package ru.javarush.golf.lykova.model;

public abstract class Animal {

    private final int weight;
    private final int maxCountInLocation;
    private final int maxSpeed;
    private final double reproductionPossibility; // вероятность размножения 0 - 1;
    private final int satiety; // сытость, кг
    private Location location;

    public Animal(int weight, int maxCountInLocation, int maxSpeed, double reproductionPossibility, int satiety) {
        this.weight = weight;
        this.maxCountInLocation = maxCountInLocation;
        this.maxSpeed = maxSpeed;
        this.reproductionPossibility = reproductionPossibility;
        this.satiety = satiety;
    }

    public abstract Animal reproduction();

    public int getWeight() {
        return weight;
    }

    public int getMaxCountInLocation() {
        return maxCountInLocation;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getReproductionPossibility() {
        return reproductionPossibility;
    }

    public int getSatiety() {
        return satiety;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        // todo check location is not null
        return location;
    }
}
