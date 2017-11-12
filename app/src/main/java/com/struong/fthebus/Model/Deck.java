package com.struong.fthebus.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Amanda on 11/11/2017.
 */

public class Deck implements Serializable{
    private List<Card> deck;

    public Deck()
    {
        deck = new ArrayList<>();
        for(int x=0; x<4; x++)
        {
            for(int y=1; y<=13; y++)
            {
                Card card = new Card(x,y);
                deck.add(card);
            }
        }
    }

    public ArrayList<Card> getDeck()
    {
        return (ArrayList<Card>) deck;
    }

    public List<Card> shuffle()
    {
        Collections.shuffle(deck);
        return deck;
    }
}
