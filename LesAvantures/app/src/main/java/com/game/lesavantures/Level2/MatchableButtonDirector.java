package com.game.lesavantures.Level2;

import java.util.ArrayList;

public class MatchableButtonDirector {
    private ArrayList<MatchableButton> listOfMatchableButtons;
    private MatchableBuildable matchableBuildable;
    private int numRows;
    private int numColumns;

    MatchableButtonDirector(MatchableBuildable matchableBuildable, int numRows, int numColumns){
        this.matchableBuildable = matchableBuildable;
        listOfMatchableButtons = new ArrayList<MatchableButton>();
        if (!setNumRows(numRows)){
            this.numRows = 7;
        }
        if(!setNumColumns(numColumns)){
            this.numColumns = 4;
        }
        constructMatchableList();
    }

    public void rebuild(){
        this.listOfMatchableButtons.clear();
        constructMatchableList();
    }

    public void setMatchableBuildable(MatchableBuildable matchableBuildable){
        this.matchableBuildable = matchableBuildable;
    }

    public ArrayList<MatchableButton> getListOfMatchables(){
        return listOfMatchableButtons;
    }

    private void constructMatchableList(){
        for(int i = 0; i < numRows; i++){
            this.matchableBuildable.setRank(i+1);
            for(int j =0; j < numColumns; j++){
                this.matchableBuildable.setSuit(j+1);
                Matchable myMatchable = this.matchableBuildable.getResult();
                listOfMatchableButtons.add((MatchableButton)myMatchable);
            }
        }
    }

    private boolean setNumRows(int numRows){
        if (numRows > 0){
            this.numRows = numRows;
            return true;
        }
        return false;
    }

    private boolean setNumColumns(int numColumns){
        if ((numColumns > 0) && (numColumns % 2 == 0)){
            this.numColumns = numColumns;
            return true;
        }
        return false;
    }



}
