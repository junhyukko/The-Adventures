package com.game.lesavantures.Level3;

import com.game.lesavantures.Main.Level;
import com.game.lesavantures.Main.LevelStatistics;
import com.game.lesavantures.Main.StatisticsItem;

import java.util.HashMap;

public class Level3Statistics implements LevelStatistics {
    private int score;

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getNormalizedScore() {
        return score;
    }

    @Override
    //Own score from our own game.
    public HashMap<String, StatisticsItem> getAllStatistics() {
        return null;
    }

    @Override
    public Level getLevel() {
        return Level.LEVEL_3;
    }


}
