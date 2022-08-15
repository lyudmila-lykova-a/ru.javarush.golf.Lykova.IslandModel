package ru.javarush.golf.lykova;

import ru.javarush.golf.lykova.config.ApplicationConfig;
import ru.javarush.golf.lykova.model.*;
import ru.javarush.golf.lykova.process.*;

import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class LifeCycle {

    private final Eating eating = new Eating();
    private final Reproduction reproduction = new Reproduction();
    private final Relocation relocation = new Relocation();
    private final StarvationDeath starvationDeath = new StarvationDeath();
    private final IslandInfo islandInfo = new IslandInfo();
    private Island island;
    private ScheduledExecutorService executorService;
    private final AtomicBoolean hasLife = new AtomicBoolean();
    private final AtomicBoolean hasAction = new AtomicBoolean();
    private CountDownLatch countDownLatch;

    public void startLife() {
        WorldGenerator worldGenerator = new WorldGenerator(ApplicationConfig.ISLAND_WIDTH, ApplicationConfig.ISLAND_HEIGHT);
        island = worldGenerator.generate();
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(
                this::iterationProcessing,
                0,
                ApplicationConfig.TACT_DURATION_MS,
                TimeUnit.MILLISECONDS);
    }

    private void iterationProcessing() {
        hasLife.set(false);
        hasAction.set(false);
        try {
            ExecutorService iterationExecutorService = Executors.newCachedThreadPool();
            Set<Location> allLocations = island.takeAllLocations();
            countDownLatch = new CountDownLatch(allLocations.size());

            for (Location location : allLocations) {
                Set<Creature> allCreaturesOnLocation = location.takeAllCreatures();
                iterationExecutorService.execute(() -> {
                    try {
                        creaturesProcessing(allCreaturesOnLocation);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                });
            }
            if (!countDownLatch.await(5, TimeUnit.SECONDS)) {
                System.out.println("Iteration processing interrupted after 5 seconds.");
            }
            iterationExecutorService.shutdown();
            islandInfo.printIslandInfo(island);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!hasLife.get()) {
            System.out.println("Все умерли. Симуляция создания мира завершена.");
            executorService.shutdown();
        }
        if (!hasAction.get()) {
            System.out.println("Активности нет. Симуляция мира остановлена.");
            executorService.shutdown();
        }
    }

    private void creaturesProcessing(Set<Creature> creatureSet) {
        for (Creature creature : creatureSet) {
            if (!creature.isAlive()) {
                continue;
            }
            hasLife.set(true);
            singleCreatureProcessing(creature);
            if (creature instanceof AbleToEat ableToEat) {
                starvationDeath.killIfLowSatiety(ableToEat);
            }
        }
    }

    private void singleCreatureProcessing(Creature creature) {
        if (creature instanceof AbleToEat ableToEat) {
            boolean eat = eating.eat(ableToEat, creature.getLocation());
            if (eat) {
                hasAction.set(true);
                return;
            }
        }

        if (creature instanceof Reproductable reproductable) {
            int amountOnLocation = creature.getLocation().takeCreatureAmount(creature);
            boolean reproduce = reproduction.reproduce(reproductable, creature.getLocation(), amountOnLocation, creature.getMaxCountInLocation());
            if (reproduce) {
                hasAction.set(true);
                return;
            }
        }

        boolean relocate = relocation.relocate(island, creature);
        if (relocate) {
            hasAction.set(true);
        }
    }

}
