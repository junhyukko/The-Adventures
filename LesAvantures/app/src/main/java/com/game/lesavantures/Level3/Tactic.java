package com.game.lesavantures.Level3;

public abstract class Tactic {
    private int power;

    public Tactic() {}

    public Tactic(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
