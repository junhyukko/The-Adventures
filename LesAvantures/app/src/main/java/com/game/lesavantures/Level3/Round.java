package com.game.lesavantures.Level3;

public class Round {

    /**
     * whether the current turn belongs to player1. This boolean determines who gets their * attack
     * updated.
     */
    Player player1;
    Player player2;

    public Round (Player p1, Player p2) {
        player1 = p1;
        player2 = p2;
    }

    void setMove1(Move move1) {
        player1.setMove(move1);
    }

    void setMove2(Move move2) {
        player2.setMove(move2);
    }

    /**
     Applies the move and depending on if it's Player1 or Player2, the moves becomes applied
     accordingly.
     */


    void resolveRound() {
        if (player1.getAttackPower() > player2.getDefensePower()){
            player1.updateActionPoints();
            player2.stolenFrom(player1.getMove());
            player1.updateWin();
        }
        if (player1.getDefensePower() < player2.getAttackPower()) {
            player2.updateActionPoints();
            player1.stolenFrom(player2.getMove());
            player2.updateWin();
        }
    }

}
