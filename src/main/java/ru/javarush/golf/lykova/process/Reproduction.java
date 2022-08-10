package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.Location;
import ru.javarush.golf.lykova.model.Reproductable;

import java.util.concurrent.ThreadLocalRandom;

public class Reproduction {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public boolean reproduce(Reproductable reproductable, Location location, int amountOnLocation, int maxCountInLocation) {
        if (amountOnLocation >= maxCountInLocation) {
            return false;
        }
        if (amountOnLocation < 2) {
            return false;
        }
        double reproductionPossibility = reproductable.getReproductionPossibility();
        if (random.nextDouble() >= reproductionPossibility) {
            return false;
        }
        location.add(reproductable.reproduction());
        return true;
    }
}
