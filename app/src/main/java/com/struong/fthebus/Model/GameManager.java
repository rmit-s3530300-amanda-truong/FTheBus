package com.struong.fthebus.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Amanda on 11/11/2017.
 */

public class GameManager implements Serializable{
    private ArrayList<Card> shuffledDeck;
    private ArrayList<Card> initialCards;
    private boolean checkRound;
    private PlayerManager playerManager;

    public GameManager()
    {
        playerManager = new PlayerManager();
    }

    public void addPlayer(Player player)
    {
        playerManager.addPlayer(player);
    }

    public void removePlayer(Player player)
    {
        playerManager.removePlayer(player);
    }

    public void createShuffledDeck()
    {
        Deck deck = new Deck();
        deck.shuffle();
        shuffledDeck = deck.getDeck();
    }

    public ArrayList<Card> dealRound()
    {
        initialCards = new ArrayList<>();
        for(int i=0; i<5; i++)
        {
            Card card = shuffledDeck.get(i);
            initialCards.add(card);
            shuffledDeck.remove(i);
        }
        return initialCards;
    }

    public Card dealNextCard()
    {
        Card card = shuffledDeck.get(0);
        shuffledDeck.remove(0);
        return card;
    }

    public ArrayList<Player> getPlayerList()
    {
        return playerManager.getPlayerList();
    }

}
