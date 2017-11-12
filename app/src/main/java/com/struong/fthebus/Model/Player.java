package com.struong.fthebus.Model;

import java.io.Serializable;

/**
 * Created by Amanda on 11/11/2017.
 */

public class Player implements Serializable{
    private String name;
    private Boolean roundOver;

    public Player(String name)
    {
        this.name = name;
    }

    public void setRoundOver(Boolean check)
    {
        roundOver = check;
    }

    public String getName()
    {
        return name;
    }
}
