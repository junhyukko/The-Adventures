package com.game.lesavantures.Level3;

import com.game.lesavantures.Main.GameManager;

class Level3ScoreCalculator {
    private Level3Statistics statistics;

    Level3ScoreCalculator() {
        this.statistics = new Level3Statistics();
    }

    void setScore(int score) {statistics.setScore(score);}

    void saveScore() {
        GameManager.statisticsManager.saveLevelStatistics(statistics);
    }
}
