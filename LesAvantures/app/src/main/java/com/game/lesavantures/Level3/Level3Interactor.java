package com.game.lesavantures.Level3;

import android.text.TextUtils;
import android.widget.Button;

class Level3Interactor {

    interface OnMoveFinishedListener {
        void onMoveMade(boolean isP1Turn);

    }

    interface OnGameOverListener {
        void onGameOver(Button enterMove);
    }

    interface OnPowerEnteredListener {
        void onAttackEmptyError();
        void onDefenseEmptyError();
        void onStealEmptyError();
        void onSuccess(GameState gameState, String attackPower, String defensePower, String stealPower);
        void onActionPowerError();

    }

    private int toPower(String textPower) {
        return Integer.parseInt(textPower);}
    /**
     * Taking in users move and update it to the game;
     */

    Move createMove(String attackPower, String defensePower, String stealPower) {
        Move move = new Move();
        move.setAttack(toPower(attackPower));
        move.setDefense(toPower(defensePower));
        move.setSteal(toPower(stealPower));
        return move;
    }

    void enterPower(GameState gameState, final String inputAttack, final String inputDefense, final String inputSteal, final OnPowerEnteredListener listener) {
        // Raise errors when illegal attack or defense power inputs are entered.
        if (TextUtils.isEmpty(inputAttack)) {
            listener.onAttackEmptyError();
            return;
        }

        if (TextUtils.isEmpty(inputDefense)) {
            listener.onDefenseEmptyError();
            return;
            }

        if (TextUtils.isEmpty(inputSteal)) {
            listener.onStealEmptyError();
            return;
        }

        if (!gameState.isValidMove(createMove(inputAttack, inputDefense, inputSteal))) {
            listener.onActionPowerError();
            return;
        }
        listener.onSuccess(gameState, inputAttack, inputDefense, inputSteal);
    }

}
