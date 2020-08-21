package com.game.lesavantures.Level3;

public class Move{

  private Attack attack = new Attack();
  private Defense defense = new Defense();
  private Steal steal = new Steal();

  Move() {}

  public Move(Attack attack, Defense defense, Steal steal) {
    this.attack = attack;
    this.defense = defense;
    this.steal = steal;
  }

  void setSteal(int steal) {
    this.steal.setPower(steal);
  }

  void setAttack(int attack) {
    this.attack.setPower(attack);
  }

  void setDefense(int defense) {
    this.defense.setPower(defense);
  }

  boolean isValidMove(int actionPoint) {
    return (attack.getPower() + defense.getPower() + steal.getPower() <= actionPoint);
  }

  boolean getIsSuccessfulSteal() {
    return steal.isSuccessful();
  }

  int getAttackPower() {
    return attack.getPower();
  }

  int getDefensePower() {
    return defense.getPower();
  }

  int getStealPower() {
    return steal.getPower();
  }
}
