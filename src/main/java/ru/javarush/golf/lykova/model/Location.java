package ru.javarush.golf.lykova.model;

import java.util.*;

public class Location {

    private final int x;
    private final int y;
    private final List<Creature> creatureList = new ArrayList<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void add(Creature creature) {
        if (creature.getLocation() != null) {
            creature.getLocation().creatureList.remove(creature);
        }
        creature.setLocation(this);
        creatureList.add(creature);
    }

    public void killCreature(Creature creature) {
        creature.die();
        creatureList.remove(creature);
    }

    public int takeCreatureAmount(Creature creature) {
        int result = 0;
        for (Creature currentCreature : creatureList) {
            if (currentCreature.getClass().getName().equals(creature.getClass().getName())) {
                result++;
            }
        }
        return result;
    }

    public List<Creature> takeCreatures(Collection<Class<? extends Creature>> creatureClassList) {
        List<Creature> result = new ArrayList<>();
        for (Creature creature : creatureList) {
            if (creatureClassList.contains(creature.getClass())) {
                result.add(creature);
            }
        }
        return result;
    }

    public Set<Creature> takeAllCreatures() {
        return Set.copyOf(creatureList);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", animalList=" + creatureList +
                '}';
    }


}
