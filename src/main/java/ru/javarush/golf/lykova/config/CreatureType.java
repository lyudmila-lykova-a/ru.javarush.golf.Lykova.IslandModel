package ru.javarush.golf.lykova.config;

import ru.javarush.golf.lykova.model.Creature;
import ru.javarush.golf.lykova.model.Mouse;
import ru.javarush.golf.lykova.model.Plant;
import ru.javarush.golf.lykova.model.Wolf;

public enum CreatureType {

    WOLF(Wolf.class, 2),
    MOUSE(Mouse.class, 2),
    PLANT(Plant.class, 2);

    private final Class<? extends Creature> creatureClass;
    private final int initAmount;

    CreatureType(Class<? extends Creature> creatureClass, int initAmount) {
        this.creatureClass = creatureClass;
        this.initAmount = initAmount;
    }

    public Class<? extends Creature> getCreatureClass() {
        return creatureClass;
    }

    public int getInitAmount() {
        return initAmount;
    }
}

