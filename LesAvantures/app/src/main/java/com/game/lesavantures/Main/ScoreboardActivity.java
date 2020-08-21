package com.game.lesavantures.Main;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import com.game.lesavantures.R;

import org.w3c.dom.Text;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreboardActivity extends AppCompatActivity implements Observer {

    private String TAG = "ScoreboardActivity";
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        linearLayout = findViewById(R.id.scoreboardLayout);

        GameManager.statisticsManager.fetchScoreboard();
        GameManager.statisticsManager.addObserver(this);

    }

    @Override
    public synchronized void update(Observable o, Object arg) {
        Log.d(TAG, "update: ");
        fillScoreboard();
    }

    public void fillScoreboard() {

        Collection<ScoreboardUser> scoreboardUsers = GameManager.statisticsManager.getScoreboard().values();

            for (ScoreboardUser scoreboardUser : scoreboardUsers) {

                LinearLayout scoreCard = new LinearLayout(this);
                scoreCard.setPadding(16, 32, 16, 16);

                String name = "" + scoreboardUser.getDisplayName() + ": " + scoreboardUser.getUserStatistics().getNormalizedScore() + " pts.";
                TextView nameView = createTextViewWithText(name, Typeface.BOLD);
                scoreCard.addView(nameView);

                Drawable background = getDrawable(R.drawable.wood_bg);
                scoreCard.setBackground(background);
                linearLayout.addView(scoreCard);
            }
    }

    public TextView createTextViewWithText(String text, int typeface) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 0);
        textView.setLayoutParams(params);
        textView.setTextSize(18);
        textView.setTypeface(Typeface.create("atma_medium", typeface));
        textView.setText(text);
        return textView;
    }


    public void close(View view) {
        finish();
    }
}
