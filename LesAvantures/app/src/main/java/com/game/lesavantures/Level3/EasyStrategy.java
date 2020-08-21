package com.game.lesavantures.Level3;

public class EasyStrategy implements ComputerStrategy{

    @Override
    public String generateName() {
        return "StrangeOrange";
    }

    @Override
    public void readStatus() {}

    @Override
    public Move generateMove(Player player) {
        return new Move();
    }
}
