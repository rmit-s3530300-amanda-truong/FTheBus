package com.struong.fthebus.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.struong.fthebus.Controller.AddPlayerController;
import com.struong.fthebus.Model.GameManager;
import com.struong.fthebus.Model.PlayerManager;
import com.struong.fthebus.R;

public class MainActivity extends AppCompatActivity {

    private GameManager gm;
    private AddPlayerController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras!= null)
        {
            gm = (GameManager) extras.get("GameManager");
            if(gm == null)
            {
                gm = new GameManager();
            }
        }
        else
        {
            gm = new GameManager();
        }

        controller = new AddPlayerController(this, gm);
        Button bAddPlayer = (Button) findViewById(R.id.bAddPlayer);
        Button bRemovePlayer = (Button) findViewById(R.id.bRemovePlayer);
        Button bStartGame = (Button) findViewById(R.id.bStartGame);
        bAddPlayer.setOnClickListener(controller);
        bRemovePlayer.setOnClickListener(controller);
        bStartGame.setOnClickListener(controller);
    }
}
