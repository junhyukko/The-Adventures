package com.game.lesavantures.Level1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;

/**
 * Class meant to manage car generation and movement.
 */
class CarManager {

    private ArrayList<Car> carArray = new ArrayList<>();

    private ArrayList<Integer[]> actionableRows = new ArrayList<>();

    private int objectWidth;

    private int speed;

    public CarManager(int objectWidth, int speed) {
        this.objectWidth = objectWidth;
        this.speed = speed;
    }


    /**
     * Generates an ArrayList of Integer arrays, with each array containing information pertaining to the
     * position of each actionable row (an actionable row defined as a row on which cars are able to move and
     * be generated), and to whether the row contains at most one car.
     *
     * @param laneInterval Integer meant to give information as to the frequency of actionable rows, and thus their
     *                             initial positions.
     * @param rows                 The number of rows contained in the grid.
     * @return An array of Integer objects.
     */
    ArrayList<Integer[]> generateActionableRows(int laneInterval, int numberOfLanes, int rows, int laneHeight) {
        ArrayList<Integer[]> returnArrayList = new ArrayList<>();
        for (int i = laneInterval*laneHeight; i < (rows * laneHeight); i += (laneInterval * laneHeight +((numberOfLanes) * laneHeight))) {
            for(int j = 0; j<numberOfLanes; j++){
                returnArrayList.add(new Integer[]{i+(j*objectWidth), 0});
            }

        }
        return returnArrayList;
    }

    /**
     * Generates, moves and removes cars as necessary.
     * @param context Context object, necessary for calling the decodeResource method, used in the
     *
     */
    void manageCars(Context context, ArrayList<Obstacle> obstacleArray, int screenWidth, int screenHeight, int objectWidth) {

        manageActionableRowDeletion(objectWidth);

        manageCarDeletion(screenWidth, obstacleArray);

        manageCarGeneration(context, screenHeight, obstacleArray);

        moveCars();
    }

    /**
     * Helper method, used to obtain the index of an actionable row, used in the method above.
     * @param position Integer value corresponding to an actionable row's position.
     * @return Returns an index.
     */
    int getActionableRowIndex(int position) {
        int index = 0;
        for (int i = 0; i < this.actionableRows.size(); i++) {
            if (this.actionableRows.get(i)[0] == position) {
                index = i;
                break;
            }

        }
        return index;
    }

    /**
     * Helper method, used to move cars in the manageCars method above.
     *
     */
    void moveCars() {
        for (Car car : this.carArray) {
            car.setX(car.getX()+car.getSpeed());
        }
    }

    /**
     * Manages actionable rows: deletes them when no longer visible on the screen and creates instances
     * of Car objects where possible.
     * @param context Context object used in the Car object constructor
     */
    private void manageCarGeneration(Context context, int height, ArrayList<Obstacle> obstacleArray){
        for (Integer[] lane: this.actionableRows) {
             if (lane[0] < height && lane[1] == 0) { //Makes sure there is at most 1 car on every lane.
                 Car car = new Car(0, lane[0], speed, context);
                 car.setSprite(Bitmap.createScaledBitmap(car.getSprite(), this.objectWidth, this.objectWidth, false));
                 this.carArray.add(car);
                 obstacleArray.add(car);
                 lane[1] = 1;
            }
        }
    }
    //Helper method for both deleting lanes that are no longer on the screen and their respective car.
    private void manageActionableRowDeletion(int objectWidth){

        if(this.actionableRows.get(0)[0]<=-objectWidth){
            Car tempCar = null;
            int tempActionableRowPosition = this.actionableRows.get(0)[0];
            this.actionableRows.remove(this.actionableRows.get(0));
            for(Car car: this.carArray){
                if(car.getY()==tempActionableRowPosition){
                    tempCar = car;
                    break;
                }
            }
            this.carArray.remove(tempCar);

        }
    }


    private void manageCarDeletion(int width, ArrayList<Obstacle> obstacleArray){
        ArrayList<Car> tempCars = new ArrayList<>();
        for (Car car : carArray) {

            if (car.getX() >= width) {
                tempCars.add(car);
                this.actionableRows.get(getActionableRowIndex(car.getY()))[1] = 0;

            }
        }
        this.carArray.removeAll(tempCars);
        obstacleArray.removeAll(tempCars);

    }

    /**
     * Draws the Car objects contained in the carArray instance variable.
     * @param canvas The canvas object necessary for calling the drawBitmap method.
     * @param paint Object holding style and color information.
     */

    /**
     * Getter for carArray.
     * @return A ArrayList of Car.
     */

    public ArrayList<Car> getCarArray() {
        return carArray;
    }

    /**
     * Getter for actionableRows.*
     * @return An ArrayList of Integer arrays.
     */
    public ArrayList<Integer[]> getActionableRows() {
        return actionableRows;
    }

    /**
     * Setter for actionableRows.
     * @param actionableRows
     */
    public void setActionableRows(ArrayList<Integer[]> actionableRows) {
        this.actionableRows = actionableRows;
    }


}
