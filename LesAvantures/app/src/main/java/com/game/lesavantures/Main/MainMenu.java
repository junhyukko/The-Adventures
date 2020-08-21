package com.game.lesavantures.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.game.lesavantures.Level1.Level1MainMenu;
import com.game.lesavantures.Level2.Level2MainMenu;
import com.game.lesavantures.Level3.Level3MainMenu;
import com.game.lesavantures.R;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    ImageView bgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main_menu);

        bgView = findViewById(R.id.bgView);
    }

    /**
     * Handle the system back button, as onClick would otherwise lead to unexpected behaviour (showing login screen). This is only necessary for th main menu, as behaviour is intuitive everywhere else in the app.
     */
    @Override
    public void onBackPressed() {
        return;
    }

    /**
     * in case something occurred, and the main screen is opened without a logged-in user, redirect the user to the Login view
     */
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        if (GameManager.userManager.getLoggedInUser() == null) {
            Intent loginActivity = new Intent(this, LoginActivity.class);
            startActivity(loginActivity);
            finish();
        }
    }

    /**
     * If Level1 button was clicked, redirect accordingly
     *
     * @param view
     */
    public void startLevel1MainMenu(View view) {
        GameManager.levelManager.setCurrentLevel(Level.LEVEL_1);
        Intent level1Activity = new Intent(this, Level1MainMenu.class);
        startActivity(level1Activity);
    }

    /**
     * If Level2 button was clicked, redirect accordingly
     * @param view
     */
    public void startLevel2MainMenu(View view) {
        GameManager.levelManager.setCurrentLevel(Level.LEVEL_2);
        Intent level2Activity = new Intent(this, Level2MainMenu.class);
        startActivity(level2Activity);
    }

    /**
     * If Level3 button was clicked, redirect accordingly
     * @param view
     */
    public void startLevel3MainMenu(View view) {
        GameManager.levelManager.setCurrentLevel(Level.LEVEL_3);
        Intent level3Activity = new Intent(this, Level3MainMenu.class);
        startActivity(level3Activity);
    }

    /**
     * If Logout button was clicked, handle and redirect accordingly
     * @param view
     */
    public void logout(View view) {
        GameManager.userManager.logoutCurrentUser();
        finish();
    }

    /**
     * If Scoreboard button was clicked, redirect accordingly
     * @param view
     */
    public void openScoreboard(View view) {
        LevelStatistics levelStatistics = new LevelStatistics() {
            int extraStat1 = 1234;

            @Override
            public int getNormalizedScore() {
                return 55;
            }

            @Override
            public HashMap<String, StatisticsItem> getAllStatistics() {
                HashMap h = new HashMap<>();
                h.put("extraStat1", extraStat1);
                return h;
            }

            @Override
            public Level getLevel() {
                return Level.LEVEL_2;
            }
        };
        GameManager.saveLevelStatistics(levelStatistics);

        Intent scoreboardActivity = new Intent(this, ScoreboardActivity.class);
        startActivity(scoreboardActivity);
    }
}
