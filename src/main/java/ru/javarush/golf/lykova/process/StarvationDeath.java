package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.AbleToEat;
import ru.javarush.golf.lykova.model.Creature;

public class StarvationDeath {

    public void killIfLowSatiety(AbleToEat ableToEat) {
        ableToEat.hunger();
        if (ableToEat.getSatiety() == 0 && ableToEat instanceof Creature creature) {
            creature.getLocation().killCreature(creature);
        }
    }

}
