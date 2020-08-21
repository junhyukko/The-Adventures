package com.game.lesavantures.Level3;

import android.content.Intent;
import android.os.Bundle;

import com.game.lesavantures.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Level3Ready extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3_ready);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void startLevel3(View view) {
        Intent intent = new Intent(this, Level3Main.class);
        startActivity(intent);

    }

    public void startLevel3Computer(View view) {
        Intent intent = new Intent(this, Level3ComputerMain.class);
        startActivity(intent);
    }
}
