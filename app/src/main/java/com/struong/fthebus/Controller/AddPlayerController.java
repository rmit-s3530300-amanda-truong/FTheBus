package com.struong.fthebus.Controller;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.struong.fthebus.Model.Card;
import com.struong.fthebus.Model.GameManager;
import com.struong.fthebus.Model.Player;
import com.struong.fthebus.Model.PlayerManager;
import com.struong.fthebus.R;
import com.struong.fthebus.View.GameActivity;
import com.struong.fthebus.View.MainActivity;
import com.struong.fthebus.ViewModel.PlayerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amanda on 11/11/2017.
 */

public class AddPlayerController implements View.OnClickListener{
    private MainActivity activity;
    private String LOG_TAG = this.getClass().getName();
    private GameManager gm;
    private PlayerAdapter adapter;
    private AlertDialog.Builder alertBuilder;

    public AddPlayerController(MainActivity activity, GameManager gm)
    {
        this.activity = activity;
        this.gm = gm;
    }

    @Override
    public void onClick(View view) {
        int clicked = view.getId();
        if(clicked == R.id.bAddPlayer)
        {
            showAdd();
        }
        else if(clicked == R.id.bRemovePlayer)
        {
            if(gm.getPlayerList().isEmpty())
            {
                Toast.makeText(activity, activity.getResources().getString(R.string.invalidNoPlayer2), Toast.LENGTH_SHORT).show();
            }
            else
            {
                showRemove();
            }
        }
        else if(clicked == R.id.bStartGame)
        {
            if(gm.getPlayerList().isEmpty())
            {
                Toast.makeText(activity, activity.getResources().getString(R.string.invalidNoPlayer), Toast.LENGTH_SHORT).show();
            }
            else
            {
                gm.createShuffledDeck();
                ArrayList<Card> initialFive = gm.dealRound();
                ArrayList<Card> shuffledDeck = gm.getShuffledDeck();
                Intent i = new Intent(activity, GameActivity.class);
                i.putExtra("GameManager", gm);
                i.putExtra("deck", shuffledDeck);
                i.putExtra("initial", initialFive);
                activity.startActivity(i);
            }
        }
    }

    public void showAdd()
    {
        LayoutInflater li = LayoutInflater.from(activity);
        final View dialogView = li.inflate(R.layout.addplayer_dialog, null);
        alertBuilder = new AlertDialog.Builder(activity);
        alertBuilder.setView(dialogView);
        alertBuilder.setTitle(activity.getResources().getString(R.string.add_player));
        final EditText et = (EditText) dialogView.findViewById(R.id.etAddPlayer);
        Log.i(LOG_TAG, "alsdkfj" + et.getText().toString());
        alertBuilder
                .setNegativeButton(activity.getResources().getString(R.string.cancel), null)
                .setPositiveButton(activity.getResources().getString(R.string.add_player), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(et.getText().toString().length() != 0)
                        {
                            gm.addPlayer(new Player(et.getText().toString()));
                            Log.i(LOG_TAG, gm.getPlayerList().toString());
                            Toast.makeText(activity, et.getText().toString() + " " + activity.getResources().getString(R.string.playerAdded), Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Log.i(LOG_TAG, "TIS EMPTY");
                            Toast.makeText(activity, activity.getResources().getString(R.string.invalidEmpty), Toast.LENGTH_SHORT).show();
                            //make it loop if name is empty
                        }
                    }
                });
        alertBuilder.show();
    }

    public void showRemove()
    {
        LayoutInflater li = LayoutInflater.from(activity);
        final View dialogView = li.inflate(R.layout.removeplayer_dialog, null);
        alertBuilder = new AlertDialog.Builder(activity);
        alertBuilder.setView(dialogView);
        alertBuilder.setNegativeButton(activity.getResources().getString(R.string.cancel), null)
                .setTitle(activity.getResources().getString(R.string.remove_player));
        alertBuilder.show();

        adapter = new PlayerAdapter(dialogView.getContext(), R.layout.list_view, gm.getPlayerList());
        ListView listView = (ListView) dialogView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Player clicked = adapter.getItem(i);
                gm.removePlayer(clicked);
                adapter.notifyDataSetChanged();
                //if list is empty, close dialog
            }
        });
    }
}
