package ru.javarush.golf.lykova.model;

import ru.javarush.golf.lykova.config.CreatureType;

public class Creature {

    protected final CreatureType creatureType;
    private Location location;
    private boolean alive = true;

    public Creature(CreatureType creatureType) {
        this.creatureType = creatureType;
    }

    public double getWeight() {
        return creatureType.getWeight();
    }

    public CreatureType getCreatureType() {
        return creatureType;
    }

    public int getMaxCountInLocation() {
        return creatureType.getMaxCountInLocation();
    }

    public int getMaxSpeed() {
        return creatureType.getMaxSpeed();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        location = null;
        alive = false;
    }

}
