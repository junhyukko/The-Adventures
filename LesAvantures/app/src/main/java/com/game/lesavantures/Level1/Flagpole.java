package com.game.lesavantures.Level1;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.game.lesavantures.R;

class Flagpole extends FieldObject {
    /**
     * Constructor for Bush.
     *
     * @param x       The x coordinate.
     * @param y       The y coordinate.
     * @param context Context object, necessary for calling the decodeResource method.
     */

    protected Flagpole(int x, int y, Context context) {
        super(x, y);
        this.context = context;
        this.sprite = BitmapFactory.decodeResource(context.getApplicationContext().getResources(), R.drawable._flagpole);
    }

}
