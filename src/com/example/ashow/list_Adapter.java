package com.example.ashow;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class list_Adapter extends ArrayAdapter<list_item>{

	private int resourceId;
	
	public list_Adapter(Context context, int textViewResourceId,
			List<list_item> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		list_item listitem = getItem(position);
		if(convertView == null)
			convertView = LayoutInflater.from(getContext()).inflate(resourceId, null);
		
		TextView Id = (TextView) convertView.findViewById(R.id.Id);
		TextView Connected=(TextView) convertView.findViewById(R.id.Connected);
		TextView GainTime = (TextView) convertView.findViewById(R.id.GainTime);
		
		Id.setText(String.valueOf(listitem.getId()));
		Connected.setText(listitem.getConnected());
		GainTime.setText(listitem.getGainTime());
		
		return convertView;
	}

	
}
