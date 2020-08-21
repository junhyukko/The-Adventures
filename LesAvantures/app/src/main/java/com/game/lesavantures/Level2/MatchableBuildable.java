package com.game.lesavantures.Level2;

import android.graphics.Bitmap;

public interface MatchableBuildable{
    /**
     * returns the built card
     * @return the card
     */
    public Matchable getResult();
    public void setSuit(int suit);
    public void setRank(int rank);
    public void setEqualityStrategy(EqualityStrategy equalityStrategy);
}
