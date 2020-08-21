package com.game.lesavantures.Level2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.game.lesavantures.R;

public class CustomView extends View {

    private Paint paint;
    private Drawable mCustomImage;

    public CustomView(Context context) {
        super(context);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        canvas.drawCircle(200, 200, 100, paint);
        Rect r = new Rect();
        r.set(10, 10, 100, 100);
        canvas.drawRect(r, paint);
    }

}