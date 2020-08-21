package com.game.lesavantures.Level3;

public interface ComputerStrategy {

    String generateName();

    void readStatus();

    Move generateMove(Player player);
}
