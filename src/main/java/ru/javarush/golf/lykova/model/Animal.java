package ru.javarush.golf.lykova.model;

public abstract class Animal {

    private final int weight;
    private final int maxCountInLocation;
    private final int maxSpeed;
    private final int satiety; // сытость, кг
    private Location location;

    public Animal(int weight, int maxCountInLocation, int maxSpeed, int satiety) {
        this.weight = weight;
        this.maxCountInLocation = maxCountInLocation;
        this.maxSpeed = maxSpeed;
        this.satiety = satiety;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxCountInLocation() {
        return maxCountInLocation;
    }

    public int getMaxSpeed() {
        return maxSpeed;
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
