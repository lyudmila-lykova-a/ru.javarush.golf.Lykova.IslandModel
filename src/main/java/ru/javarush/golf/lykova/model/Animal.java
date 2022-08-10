package ru.javarush.golf.lykova.model;

import ru.javarush.golf.lykova.config.ApplicationConfig;
import ru.javarush.golf.lykova.config.CreatureType;

import java.util.Collections;
import java.util.Map;

public class Animal extends Creature implements AbleToEat, Reproductable {

    private double satiety; // сытость, кг

    public Animal(CreatureType creatureType) {
        super(creatureType);
        this.satiety = creatureType.getFullSatiety();
    }

    @Override
    public void eat(Creature creature) {
        satiety = Math.min(satiety + creature.getWeight(), creatureType.getFullSatiety());
    }

    @Override
    public Map<CreatureType, Double> getCreatureTypeToEatingPossibilityMap() {
        return Collections.unmodifiableMap(creatureType.getCreatureTypeToEatingPossibilityMap());
    }

    @Override
    public double getSatiety() {
        return satiety;
    }

    @Override
    public double getFullSatiety() {
        return creatureType.getFullSatiety();
    }

    @Override
    public double getReproductionPossibility() {
        return creatureType.getReproductionPossibility();
    }

    @Override
    public Creature reproduction() {
        return creatureType.reproduction();
    }

    @Override
    public void hunger() {
        double decreaseSatiety = creatureType.getFullSatiety() * ApplicationConfig.HUNGER_FACTOR;
        satiety = Math.max(satiety - decreaseSatiety, 0);
    }

}
