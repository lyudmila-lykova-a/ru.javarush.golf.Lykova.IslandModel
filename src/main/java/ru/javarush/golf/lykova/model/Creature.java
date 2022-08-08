package ru.javarush.golf.lykova.model;

public abstract class Creature {

    private final double weight;
    private final int maxCountInLocation;
    private final int maxSpeed;
    private Location location;

    public Creature(double weight, int maxCountInLocation, int maxSpeed) {
        this.weight = weight;
        this.maxCountInLocation = maxCountInLocation;
        this.maxSpeed = maxSpeed;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountInLocation() {
        return maxCountInLocation;
    }

    // todo move out?
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        // todo check location is not null
        return location;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
