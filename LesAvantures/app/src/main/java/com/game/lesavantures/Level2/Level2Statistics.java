package com.game.lesavantures.Level2;

import com.game.lesavantures.Main.Level;
import com.game.lesavantures.Main.LevelStatistics;
import com.game.lesavantures.Main.StatisticsItem;

import java.util.HashMap;

public class Level2Statistics implements LevelStatistics {
    private int score;
    Level2Statistics(int score){
        this.score = score;
    }
    public int getNormalizedScore(){
        return score;
    }
    public HashMap<String, StatisticsItem> getAllStatistics(){
        return null;
    }
    public Level getLevel(){
        return Level.LEVEL_2;
    }
}
