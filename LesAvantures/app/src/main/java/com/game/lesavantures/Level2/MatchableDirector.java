package com.game.lesavantures.Level2;

import java.util.ArrayList;

public interface MatchableDirector {
    public void rebuild();
    public void setMatchableBuildable(MatchableBuildable matchableBuildable);
    public ArrayList<Matchable> getListOfMatchables();
}
