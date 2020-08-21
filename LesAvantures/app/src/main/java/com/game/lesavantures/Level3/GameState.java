package com.game.lesavantures.Level3;

/*Gamestate class record information and status about a game.*/
/*player 1 and player 2 are the two players. By default player 2 is computer.*/
/*apply moves allow moves to be applied to the game in order to update the game,*/
public class GameState {
    /**
     * the two players.
     */
    private Player player1;
    private Player player2;
    private Round round;
    private boolean isPlayer1Turn = true;
    private Level3ScoreCalculator level3ScoreCalculator = new Level3ScoreCalculator();
    /**
    * whether the current turn belongs to player1. This boolean determines who gets their * attack
    * updated.
    */
    /*
     * Round counter to determine if the game is over.
     */
    private int roundCounter = 1;
    /**
     * The number of rounds finished.
     */

    GameState(Player Player1, Player Player2) {
        this.player1 = Player1;
        this.player2 = Player2;
        this.createNewRound();

    }

    private void createNewRound() {
        this.round = new Round(this.player1, this.player2);
    }

    void update() {
        /*The next line determines if the game should progress to next round or not.*/
        isPlayer1Turn = !isPlayer1Turn;
        if (isPlayer1Turn) {
            this.nextRound();
            this.createNewRound();
        }
    }

    boolean getIsGameOver() {
        return this.roundCounter >= 3;
    }

    private String declareWinner() {
        if (player1.getWins() > player2.getWins()){
            return "Player 1 is the winner of chicken dinner.";
        }
        else if (player1.getWins() < player2.getWins()){
            return "Player 2 is the winner of chicken dinner.";
        }
        else {
            return "Both players are losers (or winners if you want to make yourself feel better.";
        }


    }

    /*Moves the round to the next round.*/
    private void nextRound() {
        if (roundCounter < 3) {
            round.resolveRound();
            roundCounter += 1;
        }
        else {
            this.declareWinner();
        }
    };

    String getPlayerName() {
        if (isPlayer1Turn) {
            return player1.getPlayerName();
        } else {
            return player2.getPlayerName();
        }
    }

    String getPlayer1Name() {
        return player1.getPlayerName();

    }

    String getPlayer2Name() {
        return player2.getPlayerName();
    }

    int getRoundCounter() {return this.roundCounter;}

    boolean isValidMove(Move move) {
        if (isPlayer1Turn)
            return player1.hasValidMove(move);
        else {
            return player2.hasValidMove(move);
        }
    }

    public int getNormalizedScore() {
        return (player1.getWins() / (player1.getWins() + player2.getWins())) * 100 ;
    };

    public int getp1AP() {
        return player1.getActionPoints();
    }

    public int getp2AP() {
        return player2.getActionPoints();
    }

    public int getp1Wins() {
        return player1.getWins();}

    public int getp2Wins() {
        return player2.getWins();
    }

    void setMoveToPlayer(Move move) {
        if (isPlayer1Turn) {
            round.setMove1(move);
        } else {
            round.setMove2(move);
        }
    }

    private boolean isPlayer1WinnerOfGame() {
        return (player1.getWins() > player2.getWins());
    }

    private String toStringWinner() {
        if (this.getIsGameOver()) {
            if (isPlayer1WinnerOfGame()) {
                return this.player1.getPlayerName();
            } else {
                return this.player2.getPlayerName();
            }
        }
        return null;
    }

    String getWinnerMessage() {
        return this.toStringWinner() + " is the winner of chicken dinner.";
    }

    boolean getIsPlayer1Turn () {
        return isPlayer1Turn;
    }

    void calculateScore() {
        this.level3ScoreCalculator.setScore(player1.getWins());
        this.level3ScoreCalculator.saveScore();
    }

    Move getPlayer1Move() {
        return this.player1.getMove();
    }

    Move getPlayer2Move() {
        return this.player2.getMove();
    }
}
