package com.game.lesavantures.Level3;

public interface Level3View {

    void showPlayer1Name();

    void showPlayer2Name();

    void showPlayerTurn(String message);

    void showPlayer1Wins(int p1Wins);

    void showPlayer2Wins(int p1Wins);

    void showPlayer1Actions(int p1AP);

    void showPlayer2Actions(int p2AP);

    void showRound(int round);

    void setAttackEmptyError();

    void setDefenseEmptyError();

    void setActionPowerError();

    void setStealEmptyError();

    void hideActionError();

    void gameOver();
}
