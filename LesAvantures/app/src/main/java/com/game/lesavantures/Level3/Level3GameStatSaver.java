package com.game.lesavantures.Level3;

import java.util.ArrayList;

public class Level3GameStatSaver {
    ArrayList<Round> rounds;

    public Level3GameStatSaver () {
    }

  public void saveRound(Round round) {
    rounds.add(round);
    }
}
