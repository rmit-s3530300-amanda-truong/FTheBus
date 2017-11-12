package com.struong.fthebus.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.struong.fthebus.Model.Player;
import com.struong.fthebus.R;

import java.util.ArrayList;

/**
 * Created by Amanda on 12/11/2017.
 */

public class PlayerAdapter extends ArrayAdapter<Player> {
    private ArrayList<Player> playerList;

    public PlayerAdapter(Context context, int textViewResourceId, ArrayList<Player> objects)
    {
        super(context, textViewResourceId, objects);
        playerList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        LayoutInflater layoutInflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.list_view, null);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(playerList.get(position).getName());
        return view;
    }
}
