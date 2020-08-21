package com.game.lesavantures.Level1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.game.lesavantures.R;

public class Level1MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_main_menu);

    }


    public void startLevel1EasyMode(View view) {
        Intent intent = new Intent(this, Level1MainActivity.class);
        intent.putExtra("laneInterval", 5);
        intent.putExtra("carSpeed", 15);
        intent.putExtra("numberOfLanes", 1);
        intent.putExtra("rows", 30);
        startActivity(intent);
        finish();
    }

    public void startLevel1NormalMode(View view){
        Intent intent = new Intent(this, Level1MainActivity.class);
        intent.putExtra("laneInterval", 4);
        intent.putExtra("carSpeed", 20);
        intent.putExtra("numberOfLanes", 2);
        intent.putExtra("rows", 60);
        startActivity(intent);
        finish();
    }

    public void startLevel1HardMode(View view){
        Intent intent = new Intent(this, Level1MainActivity.class);
        intent.putExtra("laneInterval", 3);
        intent.putExtra("carSpeed", 25);
        intent.putExtra("numberOfLanes", 3);
        intent.putExtra("rows", 80);
        startActivity(intent);
        finish();
    }

    public void startLevel1InsaneMode(View view){
        Intent intent = new Intent(this, Level1MainActivity.class);
        intent.putExtra("laneInterval", 2);
        intent.putExtra("carSpeed", 30);
        intent.putExtra("numberOfLanes", 4);
        intent.putExtra("rows", 100);
        startActivity(intent);
        finish();
    }

}
