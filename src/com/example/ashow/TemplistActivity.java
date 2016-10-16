package com.example.ashow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

public class TemplistActivity  extends Activity{

	private List<Temp> griditem = new ArrayList<Temp>();
	private GridView grid;
	private String Str_data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.temp_item);
		Intent intent = getIntent();
		int _id = intent.getIntExtra("idname", 1);
		//Str_data = intent.getStringExtra("Str_data");
		Toast.makeText(this, _id+"sfsfsfd", Toast.LENGTH_SHORT).show();
		
		
		
		init_griditem(_id);
		
		grid = (GridView) findViewById(R.id.gridlist);
		
		grid_Adapter adapter = new grid_Adapter(TemplistActivity.this, R.layout.grid_item, griditem);
		grid.setAdapter(adapter);
		
		
	}
	private String loadfiles(int _id){
    	FileInputStream in =null;
    	BufferedReader reader = null;
    	String line = null;
    	try{
    		in = openFileInput("data.csv");
    		reader = new BufferedReader(new InputStreamReader(in));
    		int k = 0;
    		while((line = reader.readLine()) != null){
    			if(k == _id){
    				break;
    			}
    			k++;
    		}
    	}catch(IOException ex){
    		ex.printStackTrace();
    	}finally{
    		if(reader != null){
    			try{
    				reader.close();
    			}catch(IOException e){
    				e.printStackTrace();
    			}
    		}
    	}
    	return line;
    }
    public void init_griditem(int _id){
    	Str_data = loadfiles(_id);
    	int i,j,k;
    	
    	i = 0;
    	j = 3;
    	while(j > 0){
    		if(Str_data.charAt(i) == ','){
    			j--;
    		}
    		i++;
    	}
    	char ch;
    	String temp = "";
    	for( k = 1 ; i < Str_data.length();i++){
    		ch = Str_data.charAt(i);
    		if(ch == ','){
    			Temp fir1 = new Temp(_id, k,temp);
    	    	griditem.add(fir1);
    			k++;
    			temp="";
    			continue;
    		}
    		temp+=ch;
    		
    	}
    	Temp fir1 = new Temp(_id, k,temp);
    	griditem.add(fir1);
 
    }

}
