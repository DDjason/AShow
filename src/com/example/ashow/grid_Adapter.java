package com.example.ashow;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class grid_Adapter extends ArrayAdapter<Temp>{

	private int resourceId;
	
	public grid_Adapter(Context context, int textViewResourceId,
			List<Temp> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Temp temp = getItem(position);
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		
		TextView tempId = (TextView) view.findViewById(R.id.tempId);
		TextView _temp=(TextView) view.findViewById(R.id._temp);
		
		tempId.setText("温度" + String.valueOf(temp.getTempId()));
		_temp.setText(temp.getTemp());
		
		return view;
	}
}
