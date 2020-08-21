package com.game.lesavantures.Level2;

import android.os.AsyncTask;
import android.util.Log;

public class CardButtonHandler extends AsyncTask<Void, String, String>  {
    @Override
    protected String doInBackground(Void... voids) {
        Log.d("ASYNC_T", "doInBackground: test");
        return null;
    }
}
