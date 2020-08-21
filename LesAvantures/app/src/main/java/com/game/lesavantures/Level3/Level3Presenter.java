package com.game.lesavantures.Level3;

import android.widget.Button;


public class Level3Presenter implements Level3Interactor.OnMoveFinishedListener, Level3Interactor.OnGameOverListener, Level3Interactor.OnPowerEnteredListener {

    private Level3View level3View;
    private Level3Interactor interactor;

    Level3Presenter(Level3View level3View, Level3Interactor interactor) {
        this.level3View = level3View;
        this.interactor = interactor;
    }

    void validateMove(GameState game, String attackEntered, String defenseEntered, String stealEntered) {
        if (level3View != null) {
            interactor.enterPower(game,attackEntered, defenseEntered, stealEntered,this);
            level3View.showRound(game.getRoundCounter());
            updatePlayerInfo(game);
        }
    }

    @Override
    public void onMoveMade(boolean isP1Turn) {
        String player;
        if (isP1Turn) {
            player = "Player 1 ";
        } else {player = "Player 2";
        }

        if (level3View != null) {
            level3View.showPlayerTurn(String.format("%s turn", player));
        }
    }

    @Override
    public void onGameOver(Button button) {
        button.setEnabled(false);
        level3View.gameOver();
    }

    @Override
    public void onAttackEmptyError() {
        if (level3View != null) {
            level3View.setAttackEmptyError();
        }
    }

    @Override
    public void onDefenseEmptyError() {
        if (level3View != null) {
            level3View.setDefenseEmptyError();
        }
    }

    @Override
    public void onStealEmptyError() {
        if (level3View != null) {
            level3View.setStealEmptyError();
        }
    };

    @Override
    public void onSuccess(GameState gameState, String attackPower, String defensePower, String stealPower) {
        if (level3View != null) {
            gameState.setMoveToPlayer(interactor.createMove(attackPower, defensePower, stealPower));
            gameState.update();
        }
    }

    @Override
    public void onActionPowerError() {
        if (level3View != null) {
            level3View.setActionPowerError();
        }
    }

    void updatePlayerInfo(GameState gameState) {
        level3View.showPlayer1Actions(gameState.getp1AP());
        level3View.showPlayer2Actions(gameState.getp2AP());
        level3View.showPlayer1Wins(gameState.getp1Wins());
        level3View.showPlayer2Wins(gameState.getp2Wins());
    }

}
