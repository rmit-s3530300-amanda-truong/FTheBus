package com.struong.fthebus.Model;

import java.io.Serializable;

/**
 * Created by Amanda on 11/11/2017.
 */

public class Card implements Serializable{
    public enum Suit {
        HEART,
        DIAMOND,
        CLUB,
        SPADE
    }

    private int value;
    private Suit suit;

    public Card(int suit, int value) {
        this.suit = convertSuit(suit);
        this.value = value;
    }

    public Suit convertSuit(int num)
    {
        if(num==0)
        {
            return Suit.HEART;
        }
        else if(num==1)
        {
            return Suit.DIAMOND;
        }
        else if(num==2)
        {
            return Suit.CLUB;
        }
        else if(num==3)
        {
            return Suit.SPADE;
        }
        else
        {
            return null;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue()
    {
        return value;
    }
}
