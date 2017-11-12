package com.struong.fthebus.Controller;

import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.struong.fthebus.Model.Card;
import com.struong.fthebus.Model.GameManager;
import com.struong.fthebus.Model.Player;
import com.struong.fthebus.R;
import com.struong.fthebus.View.GameActivity;
import com.struong.fthebus.View.MainActivity;

import java.util.ArrayList;

/**
 * Created by Amanda on 12/11/2017.
 */

public class GameController implements View.OnClickListener {
    private GameActivity activity;
    private GameManager gm;
    private ArrayList<Card> initial;
    private ArrayList<Card> deck;

    private String LOG_TAG = this.getClass().getName();

    public GameController(GameActivity activity, GameManager gm, ArrayList<Card> initial)
    {
        this.activity = activity;
        this.gm = gm;
        this.initial = initial;
        deck = gm.getShuffledDeck();
    }

    @Override
    public void onClick(View view) {
        int clicked = view.getId();
        if(clicked == R.id.bQuit)
        {
            Intent i = new Intent(activity, MainActivity.class);
            i.putExtra("GameManager", gm);
            activity.startActivity(i);
        }
        else
        {
            if(gm.getShuffledDeck().size()!=0)
            {
                Card card = gm.dealNextCard();
                activity.assignImages(card, activity.getCurrent());
                initial.remove(activity.getCurrentCard());
                String tag = activity.getCurrent().getTag().toString();
                initial.add(Integer.parseInt(tag)-1, card);
                activity.updateDeckLeft();
                Log.i(LOG_TAG, "Before : " + activity.getCurrentCard().getSuit().toString() + " " + activity.getCurrentCard().getValue() + "After : " + card.getSuit().toString() + " " + card.getValue());
                if(clicked == R.id.bSame)
                {
                    Log.i(LOG_TAG, "same");
                    if(activity.getCurrentCard().getValue() == card.getValue())
                    {
                        Log.i(LOG_TAG, "right same");
                        Toast.makeText(activity, activity.getResources().getString(R.string.correct), Toast.LENGTH_SHORT);
                        if(activity.getCurrent().getTag().equals("1"))
                        {
                            Player next = getNextPlayer();
                            activity.setCurrent("5");
                            activity.setCurrentPlayer(next);
                        }
                        else if(activity.getCurrent().getTag().equals("2"))
                        {
                            activity.setCurrent("1");
                        }
                        else if(activity.getCurrent().getTag().equals("3"))
                        {
                            activity.setCurrent("2");
                        }
                        else if(activity.getCurrent().getTag().equals("4"))
                        {
                            activity.setCurrent("3");
                        }
                        else if(activity.getCurrent().getTag().equals("5"))
                        {
                            activity.setCurrent("4");
                        }
                    }
                    else
                    {
                        Log.i(LOG_TAG, "wrong same");
                        Toast.makeText(activity, activity.getResources().getString(R.string.wrong), Toast.LENGTH_SHORT);
                        activity.setCurrent("5");
                    }
                }
                else if(clicked == R.id.bHigher)
                {
                    Log.i(LOG_TAG, "higher");
                    if(activity.getCurrentCard().getValue() < card.getValue())
                    {
                        Log.i(LOG_TAG, "right higher");
                        Toast.makeText(activity, activity.getResources().getString(R.string.correct), Toast.LENGTH_SHORT);
                        if(activity.getCurrent().getTag().equals("1"))
                        {
                            Player next = getNextPlayer();
                            activity.setCurrent("5");
                            activity.setCurrentPlayer(next);
                        }
                        else if(activity.getCurrent().getTag().equals("2"))
                        {
                            activity.setCurrent("1");
                        }
                        else if(activity.getCurrent().getTag().equals("3"))
                        {
                            activity.setCurrent("2");
                        }
                        else if(activity.getCurrent().getTag().equals("4"))
                        {
                            activity.setCurrent("3");
                        }
                        else if(activity.getCurrent().getTag().equals("5"))
                        {
                            activity.setCurrent("4");
                        }
                    }
                    else
                    {
                        Log.i(LOG_TAG, "wrong higher");
                        Toast.makeText(activity, activity.getResources().getString(R.string.wrong), Toast.LENGTH_SHORT);
                        activity.setCurrent("5");
                    }
                }
                else if(clicked == R.id.bLower)
                {
                    Log.i(LOG_TAG, "lower");
                    if(activity.getCurrentCard().getValue() > card.getValue())
                    {
                        Log.i(LOG_TAG, "right higher");
                        Toast.makeText(activity, activity.getResources().getString(R.string.correct), Toast.LENGTH_SHORT);
                        if(activity.getCurrent().getTag().equals("1"))
                        {
                            Player next = getNextPlayer();
                            activity.setCurrent("5");
                            activity.setCurrentPlayer(next);
                        }
                        else if(activity.getCurrent().getTag().equals("2"))
                        {
                            activity.setCurrent("1");
                        }
                        else if(activity.getCurrent().getTag().equals("3"))
                        {
                            activity.setCurrent("2");
                        }
                        else if(activity.getCurrent().getTag().equals("4"))
                        {
                            activity.setCurrent("3");
                        }
                        else if(activity.getCurrent().getTag().equals("5"))
                        {
                            activity.setCurrent("4");
                        }
                    }
                    else
                    {
                        Log.i(LOG_TAG, "wrong lower");
                        Toast.makeText(activity, activity.getResources().getString(R.string.wrong), Toast.LENGTH_SHORT);
                        activity.setCurrent("5");
                    }
                }
            }
            else
            {
                Toast.makeText(activity, activity.getResources().getString(R.string.noMoreCards), Toast.LENGTH_SHORT);

            }
        }
    }

    public Player getNextPlayer()
    {
        ArrayList<Player> playerList = gm.getPlayerList();
        Player current = activity.getCurrentPlayer();
        for(int i=0; i< playerList.size(); i++)
        {
            if(current == playerList.get(i))
            {
                if(i+1 > playerList.size()-1)
                {
                    return playerList.get(0);
                }
                else
                {
                    return playerList.get(i+1);
                }
            }
        }
        return null;
    }
}
