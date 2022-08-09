package ru.javarush.golf.lykova.model;

import ru.javarush.golf.lykova.config.ApplicationConfig;

import java.util.Collections;
import java.util.Map;

public abstract class Animal extends Creature implements AbleToEat, Reproductable {

    private final Map<Class<? extends Creature>, Double> creatureClassToEatingPossibilityMap;
    private final double fullSatiety;
    private double satiety; // сытость, кг
    private final double reproductionPossibility; // вероятность размножения 0 - 1;

    public Animal(double width, int maxCountInLocation, int maxSpeed, double reproductionPossibility,
                  Map<Class<? extends Creature>, Double> creatureClassToEatingPossibilityMap, double satiety) {
        super(width, maxCountInLocation, maxSpeed);
        this.creatureClassToEatingPossibilityMap = creatureClassToEatingPossibilityMap;
        this.fullSatiety = satiety;
        this.satiety = satiety;
        this.reproductionPossibility = reproductionPossibility;
    }

    @Override
    public void eat(Creature creature) {
        satiety = Math.min(satiety + creature.getWeight(), fullSatiety);
    }

    @Override
    public Map<Class<? extends Creature>, Double> getCreatureClassToEatingPossibilityMap() {
        return Collections.unmodifiableMap(creatureClassToEatingPossibilityMap);
    }

    @Override
    public double getSatiety() {
        return satiety;
    }

    @Override
    public double getFullSatiety() {
        return fullSatiety;
    }

    @Override
    public double getReproductionPossibility() {
        return reproductionPossibility;
    }

    @Override
    public void hunger() {
        double decreaseSatiety = satiety - fullSatiety * ApplicationConfig.HUNGER_FACTOR;
        satiety = Math.max(satiety - decreaseSatiety, 0);
    }

}
