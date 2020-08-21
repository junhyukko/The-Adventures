package com.game.lesavantures.Level3;

public class Steal extends Tactic {

    private double chance = 1 - this.getPower()/10;
    private double success = Math.random();

    Steal() {
        super();
    }

    Steal(int stealPower) {
        super(stealPower);
    }

    @Override
    public void setPower(int power) {
        super.setPower(power);
        success = Math.random();
    }

    boolean isSuccessful() {
        if (this.getPower() == 0) {
            return false;
        }
        return success >= chance;
    }
}
