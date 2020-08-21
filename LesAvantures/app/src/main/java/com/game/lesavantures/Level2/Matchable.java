package com.game.lesavantures.Level2;

import android.graphics.Bitmap;

public interface Matchable {
    public boolean setRank(int rank);
    public int getRank();
    public boolean setSuit(int suit);
    public int getSuit();
    public boolean equals(Matchable matchable);
    public Bitmap flip();
    public Bitmap getCurrentSide();
    public void flipFaceDown();
    public void flipFaceUp();
    public boolean isFaceUp();
    public boolean isFaceDown();
    public Bitmap getFront();
    public Bitmap getBack();
}
