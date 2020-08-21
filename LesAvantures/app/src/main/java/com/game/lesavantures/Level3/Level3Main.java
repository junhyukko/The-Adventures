package com.game.lesavantures.Level3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

//import com.bumptech.glide.Glide;
import com.game.lesavantures.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Level3Main extends AppCompatActivity implements Level3View{

    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");
    GameState game = new GameState(player1, player2);
    private Level3Presenter presenter;

    private EditText player1Attack;
    private EditText player1Defense;
    private EditText player1Steal;
    private EditText player2Attack;
    private EditText player2Defense;
    private EditText player2Steal;

    private Toolbar toolbar;
    private Level3Interactor.OnGameOverListener gameOverListener;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter = new Level3Presenter(this, new Level3Interactor());

        this.player1Attack = (EditText) findViewById(R.id.player1attackpower);
        this.player1Defense = (EditText) findViewById(R.id.player1defensepower);
        this.player1Steal = (EditText) findViewById(R.id.player1stealpower);
        this.player2Attack = (EditText) findViewById(R.id.player2attackpower);
        this.player2Defense = (EditText) findViewById(R.id.player2defensepower);
        this.player2Steal = (EditText) findViewById(R.id.player2stealpower);

        showPlayer1Name();
        showPlayer2Name();

        presenter.updatePlayerInfo(game);
        setGameOverListener(presenter);

        final Button enterButton = (Button) findViewById(R.id.enter);
        enterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                hideActionError();
                validateMove();
                if(game.getIsGameOver() && gameOverListener != null) {
                    game.calculateScore();
                    // call the listener here, note that we don't want to a strong coupling
                    // between the listener and where the event is occurring. With this pattern
                    // the code has the flexibility of assigning the listener
                    presenter.onGameOver(enterButton);
                }
            }
        });
    }

    @Override
    public void showPlayerTurn(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    };

    @Override
    public void showPlayer1Wins(int p1Wins) {
        TextView player1Wins = (TextView) findViewById(R.id.wins1);
        player1Wins.setText("Player 1 Wins: " + Integer.toString(p1Wins));
    };

    @Override
    public void showPlayer2Wins(int p2Wins) {
        TextView player2Wins = (TextView) findViewById(R.id.wins2);
        player2Wins.setText("Player 2 Wins: "+Integer.toString(p2Wins));
    };

    @Override
    public void showPlayer1Actions(int p1AP) {
        TextView player1Actions = (TextView) findViewById(R.id.actions1);
        player1Actions.setText("Player 1 Actions: " + Integer.toString(p1AP));
    };

    @Override
    public void showPlayer2Actions(int p2AP) {
        TextView player2Actions = (TextView) findViewById(R.id.actions2);
        player2Actions.setText("Player 2 Actions" + Integer.toString(p2AP));
    };

    @Override
    public void setAttackEmptyError() {
        if (game.getIsPlayer1Turn()) {
            player1Attack.setError(getString(R.string.attack_error));
        } else {
            player2Attack.setError(getString(R.string.attack_error));
        }
    }

    @Override
    public void setStealEmptyError() {
        if (game.getIsPlayer1Turn()) {
            player1Steal.setError(getString(R.string.steal_error));
        } else {
            player2Steal.setError(getString(R.string.steal_error));
        }
    }

    @Override
    public void setDefenseEmptyError() {
        if (game.getIsPlayer1Turn()) {
            player1Defense.setError(getString(R.string.defense_error));
        } else {
            player2Defense.setError(getString(R.string.defense_error));
        }
    }

    @Override
    public void showRound(int round) {
        toolbar.setTitle("Round " + game.getRoundCounter() + " " + game.getPlayerName() + "'s turn");
    };

    @Override
    public void setActionPowerError() {
        if (game.getIsPlayer1Turn()) {
            player1Attack.setError("You don't have enough power");
            player1Defense.setError("You don't have enough power");
            player1Steal.setError("You don't have enough power");
        } else {
            player2Attack.setError("You don't have enough power");
            player2Defense.setError("You don't have enough power");
            player2Steal.setError("You don't have enough power");
        }
    }

    public String toTextPower(EditText inputPower) {
        return inputPower.getText().toString();
    }

    private void validateMove(){
        if (game.getIsPlayer1Turn()) {
            presenter.validateMove(game, toTextPower(player1Attack), toTextPower(player1Defense), toTextPower(player1Steal));
        } else {presenter.validateMove(game, toTextPower(player2Attack), toTextPower(player2Defense), toTextPower(player2Steal));}
    }

    @Override
    public void gameOver() {
        if (this.game.getIsGameOver()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(game.getWinnerMessage())
                    .setPositiveButton("Finish Game", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    })
                    .show();
            //Next two lines grab the ImageView from XML and the Glide will store the gif into
            //ImageView and that ImageView can be used to show animated Game Over message.
            //If you can make it appear and then disappear when the next round begins, that will
            //be ideal.
            ImageView gameOver = findViewById(R.id.gameOverView);
            //Glide.with(this).load(R.drawable.gameover).into(gameOver);
        }
    }

    @Override
    public void hideActionError() {
        if (game.getIsPlayer1Turn()) {
            player1Attack.setError(null);
            player1Defense.setError(null);
            player1Steal.setError(null);
        } else {
            player2Attack.setError(null);
            player2Defense.setError(null);
            player2Steal.setError(null);
        }
    };

    public void setGameOverListener(Level3Interactor.OnGameOverListener gameOverListener) {
        this.gameOverListener = gameOverListener;
    }

    @Override
    public void showPlayer1Name() {
        TextView player1Name = (TextView) findViewById(R.id.name1);
        player1Name.setText(game.getPlayer1Name());
    };

    @Override
    public void showPlayer2Name() {
        TextView player2Name = (TextView) findViewById(R.id.name2);
        player2Name.setText(game.getPlayer2Name());
    };
}
