package com.game.lesavantures.Level3;

import android.content.Intent;
import android.os.Bundle;

import com.game.lesavantures.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Level3MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void startReadyHuman(View view) {
        Intent intent = new Intent(this, Level3Ready.class);
        startActivity(intent);
    }

    public void startReadyComputer(View view) {
        Intent intent = new Intent(this, Level3ComputerMain.class);
        startActivity(intent);
    }
}
