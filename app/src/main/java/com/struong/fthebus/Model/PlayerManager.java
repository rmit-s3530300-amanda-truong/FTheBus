package com.struong.fthebus.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Amanda on 11/11/2017.
 */

public class PlayerManager implements Serializable{
    private ArrayList<Player> playerList;

    public PlayerManager()
    {
        if(playerList == null)
        {
            playerList = new ArrayList<>();
        }
    }

    public void addPlayer(Player player)
    {
        playerList.add(player);
    }

    public void removePlayer(Player player)
    {
        if(playerList.contains(player))
        {
            playerList.remove(player);
        }
    }

    public ArrayList<Player> getPlayerList()
    {
        return playerList;
    }
}
