package com.game.lesavantures.Level3;

import java.util.Random;

public class RandomStrategy implements ComputerStrategy {
    private String[] names = {"Derrick", "Ella", "Alyssa", "PPP Man"};

    @Override
    public String generateName() {
        Random rand = new Random();
        return names[rand.nextInt(names.length)];
    }

    @Override
    public void readStatus() {
    }

    @Override
    public Move generateMove(Player player)
    {
        Move result = new Move();
        int actionPoints = player.getActionPoints();
        int[] powers = randomPartition(actionPoints);
        result.setSteal(powers[0]);
        result.setAttack(powers[1]);
        result.setDefense(powers[2]);
        return result;
    }

    private int[] randomPartition(int n) {
        int[] partitionResults = new int[3];
        int x = 0;
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            if (x < 0) {
                partitionResults[i] = 0;
            } else {
                int j = random.nextInt((n - x)) + 1;
                partitionResults[i] = j;
                x = j;
            }
        }
        return partitionResults;
    }

}
