package ru.javarush.golf.lykova.process;

import ru.javarush.golf.lykova.model.Animal;
import ru.javarush.golf.lykova.model.Location;
import ru.javarush.golf.lykova.model.Reproductable;

import java.util.concurrent.ThreadLocalRandom;

public class Reproduction {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    public void reproduce(Reproductable reproductable, Location location, int amountOnLocation, int maxCountInLocation) {
        if (amountOnLocation >= maxCountInLocation) {
            return;
        }
        if (amountOnLocation < 2) {
            return;
        }
        double reproductionPossibility = reproductable.getReproductionPossibility();
        if (random.nextDouble() >= reproductionPossibility) {
            return;
        }
       location.add(reproductable.reproduction());
    }
}
