package com.struong.fthebus.View;

import android.content.pm.ActivityInfo;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.struong.fthebus.Controller.GameController;
import com.struong.fthebus.Model.Card;
import com.struong.fthebus.Model.GameManager;
import com.struong.fthebus.R;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private ImageView card1, card2, card3, card4, card5;
    private Button bHigher;
    private Button bLower;
    private Button bSame;
    private GameManager gm;
    private ArrayList<Card> initialFive;
    private ArrayList<Card> deck;
    private GameController controller;
    private ImageView current;
    private Card currentCard;
    private TextView tvDeckLeft;
    private String LOG_TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        card1 = (ImageView) findViewById(R.id.card1);
        card2 = (ImageView) findViewById(R.id.card2);
        card3 = (ImageView) findViewById(R.id.card3);
        card4 = (ImageView) findViewById(R.id.card4);
        card5 = (ImageView) findViewById(R.id.card5);

        bHigher = (Button) findViewById(R.id.bHigher);
        bLower = (Button) findViewById(R.id.bLower);
        bSame = (Button)  findViewById(R.id.bSame);

        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            gm = (GameManager) extras.get("GameManager");
            deck = (ArrayList<Card>) extras.get("deck");
            initialFive = (ArrayList<Card>) extras.get("initial");
        }

        for(int i = 0; i<initialFive.size(); i++)
        {
            ImageView view = new ImageView(this);
            if(i==0)
            {
                view = card1;
            }
            else if(i==1)
            {
                view = card2;
            }
            else if(i==2)
            {
                view = card3;
            }
            else if(i==3)
            {
                view = card4;
            }
            else if(i==4)
            {
                view = card5;
            }
            assignImages(initialFive.get(i), view);
        }

        currentCard = initialFive.get(4);

        controller = new GameController(this, gm, initialFive);

        tvDeckLeft = (TextView) findViewById(R.id.tvDeckLeft);
        tvDeckLeft.setText(getResources().getString(R.string.left) + " " + deck.size());

        current = card5;

        bHigher.setOnClickListener(controller);
        bLower.setOnClickListener(controller);
        bSame.setOnClickListener(controller);
    }

    public ImageView getCurrent()
    {
        return current;
    }

    public Card getCurrentCard()
    {
        return currentCard;
    }

    public void setCurrent(String cardNo)
    {
        if(cardNo.equals("1"))
        {
            current = card1;
            currentCard = initialFive.get(0);
        }
        else if(cardNo.equals("2"))
        {
            current = card2;
            currentCard = initialFive.get(1);
        }
        else if(cardNo.equals("3"))
        {
            current = card3;
            currentCard = initialFive.get(2);
        }
        else if(cardNo.equals("4"))
        {
            current = card4;
            currentCard = initialFive.get(3);
        }
        else if(cardNo.equals("5"))
        {
            current = card5;
            currentCard = initialFive.get(4);
        }
    }

    public void updateDeckLeft()
    {
        tvDeckLeft.setText(getResources().getString(R.string.left) + " " + gm.getShuffledDeck().size());
    }

    public void assignImages(Card card, ImageView image)
    {
        if(card.getSuit() == Card.Suit.HEART)
        {
            if(card.getValue() == 1)
            {
                image.setImageResource(R.drawable.ace_of_hearts);
            }
            else if(card.getValue() == 2)
            {
                image.setImageResource(R.drawable.two_of_hearts);
            }
            else if(card.getValue() == 3)
            {
                image.setImageResource(R.drawable.three_of_hearts);
            }
            else if(card.getValue() == 4)
            {
                image.setImageResource(R.drawable.four_of_hearts);
            }
            else if(card.getValue() == 5)
            {
                image.setImageResource(R.drawable.five_of_hearts);
            }
            else if(card.getValue() == 6)
            {
                image.setImageResource(R.drawable.six_of_hearts);
            }
            else if(card.getValue() == 7)
            {
                image.setImageResource(R.drawable.seven_of_hearts);
            }
            else if(card.getValue() == 8)
            {
                image.setImageResource(R.drawable.eight_of_hearts);
            }
            else if(card.getValue() == 9)
            {
                image.setImageResource(R.drawable.nine_of_hearts);
            }
            else if(card.getValue() == 10)
            {
                image.setImageResource(R.drawable.ten_of_hearts);
            }
            else if(card.getValue() == 11)
            {
                image.setImageResource(R.drawable.jack_of_hearts);
            }
            else if(card.getValue() == 12)
            {
                image.setImageResource(R.drawable.queen_of_hearts);
            }
            else if(card.getValue() == 13)
            {
                image.setImageResource(R.drawable.king_of_hearts);
            }
        }
        else if(card.getSuit() == Card.Suit.DIAMOND)
        {
            if(card.getValue() == 1)
            {
                image.setImageResource(R.drawable.ace_of_diamonds);
            }
            else if(card.getValue() == 2)
            {
                image.setImageResource(R.drawable.two_of_diamonds);
            }
            else if(card.getValue() == 3)
            {
                image.setImageResource(R.drawable.three_of_diamonds);
            }
            else if(card.getValue() == 4)
            {
                image.setImageResource(R.drawable.four_of_diamonds);
            }
            else if(card.getValue() == 5)
            {
                image.setImageResource(R.drawable.five_of_diamonds);
            }
            else if(card.getValue() == 6)
            {
                image.setImageResource(R.drawable.six_of_diamonds);
            }
            else if(card.getValue() == 7)
            {
                image.setImageResource(R.drawable.seven_of_diamonds);
            }
            else if(card.getValue() == 8)
            {
                image.setImageResource(R.drawable.eight_of_diamonds);
            }
            else if(card.getValue() == 9)
            {
                image.setImageResource(R.drawable.nine_of_diamonds);
            }
            else if(card.getValue() == 10)
            {
                image.setImageResource(R.drawable.ten_of_diamonds);
            }
            else if(card.getValue() == 11)
            {
                image.setImageResource(R.drawable.jack_of_diamonds);
            }
            else if(card.getValue() == 12)
            {
                image.setImageResource(R.drawable.queen_of_diamonds);
            }
            else if(card.getValue() == 13)
            {
                image.setImageResource(R.drawable.king_of_diamonds);
            }
        }
        else if(card.getSuit() == Card.Suit.CLUB)
        {
            if(card.getValue() == 1)
            {
                image.setImageResource(R.drawable.ace_of_clubs);
            }
            else if(card.getValue() == 2)
            {
                image.setImageResource(R.drawable.two_of_clubs);
            }
            else if(card.getValue() == 3)
            {
                image.setImageResource(R.drawable.three_of_clubs);
            }
            else if(card.getValue() == 4)
            {
                image.setImageResource(R.drawable.four_of_clubs);
            }
            else if(card.getValue() == 5)
            {
                image.setImageResource(R.drawable.five_of_clubs);
            }
            else if(card.getValue() == 6)
            {
                image.setImageResource(R.drawable.six_of_clubs);
            }
            else if(card.getValue() == 7)
            {
                image.setImageResource(R.drawable.seven_of_clubs);
            }
            else if(card.getValue() == 8)
            {
                image.setImageResource(R.drawable.eight_of_clubs);
            }
            else if(card.getValue() == 9)
            {
                image.setImageResource(R.drawable.nine_of_clubs);
            }
            else if(card.getValue() == 10)
            {
                image.setImageResource(R.drawable.ten_of_clubs);
            }
            else if(card.getValue() == 11)
            {
                image.setImageResource(R.drawable.jack_of_clubs);
            }
            else if(card.getValue() == 12)
            {
                image.setImageResource(R.drawable.queen_of_clubs);
            }
            else if(card.getValue() == 13)
            {
                image.setImageResource(R.drawable.king_of_clubs);
            }
        }
        else if(card.getSuit() == Card.Suit.SPADE)
        {
            if(card.getValue() == 1)
            {
                image.setImageResource(R.drawable.ace_of_spades);
            }
            else if(card.getValue() == 2)
            {
                image.setImageResource(R.drawable.two_of_spades);
            }
            else if(card.getValue() == 3)
            {
                image.setImageResource(R.drawable.three_of_spades);
            }
            else if(card.getValue() == 4)
            {
                image.setImageResource(R.drawable.four_of_spades);
            }
            else if(card.getValue() == 5)
            {
                image.setImageResource(R.drawable.five_of_spades);
            }
            else if(card.getValue() == 6)
            {
                image.setImageResource(R.drawable.six_of_spades);
            }
            else if(card.getValue() == 7)
            {
                image.setImageResource(R.drawable.seven_of_spades);
            }
            else if(card.getValue() == 8)
            {
                image.setImageResource(R.drawable.eight_of_spades);
            }
            else if(card.getValue() == 9)
            {
                image.setImageResource(R.drawable.nine_of_spades);
            }
            else if(card.getValue() == 10)
            {
                image.setImageResource(R.drawable.ten_of_spades);
            }
            else if(card.getValue() == 11)
            {
                image.setImageResource(R.drawable.jack_of_spades);
            }
            else if(card.getValue() == 12)
            {
                image.setImageResource(R.drawable.queen_of_spades);
            }
            else if(card.getValue() == 13)
            {
                image.setImageResource(R.drawable.king_of_spades);
            }
        }
    }

}
