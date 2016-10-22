package com.example.ashow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.Ashow.dbconnet.MyDatabaseHelper;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
		
		
		Toast.makeText(this, "ID="+_id, Toast.LENGTH_SHORT).show();
		init_griditem(_id);
		
		grid = (GridView) findViewById(R.id.gridlist);
		
		grid_Adapter adapter = new grid_Adapter(TemplistActivity.this, R.layout.grid_item, griditem);
		grid.setAdapter(adapter);
		
		
	}
    public void init_griditem(int _id){
    	MyDatabaseHelper dbHelper = null;
        SQLiteDatabase db;
   	dbHelper = new MyDatabaseHelper(this, "app.db", null, 1);
       db = dbHelper.getWritableDatabase();
   	Cursor myCursor = db.rawQuery("select * from TempTable where ID = "
       +String.valueOf(_id).toString() +";", null);
   	Temp mytemp = null;
   	if(myCursor.moveToFirst()){
   		do{
   			mytemp = new Temp(_id,
   					myCursor.getInt(myCursor.getColumnIndex("TempID")),
   					myCursor.getDouble(myCursor.getColumnIndex("Temp")));
   			
   			griditem.add(mytemp);
   		}while(myCursor.moveToNext());
   	}
   	db.close();
   	dbHelper.close();
    }

}
