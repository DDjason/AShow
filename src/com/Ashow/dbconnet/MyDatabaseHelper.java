package com.Ashow.dbconnet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {
	public static final String CREATE_TABLE_Table = "create table IDTable (" +
			"ID integer primary key ," +
			"Connected integer," +
			"GainTime  TEXT)";
	
	public static final String CREATE_TABLE_TempTable = "create table TempTable (" +
			"ID integer, " +
			"TempID integer," +
			"Temp  REAL)";
	
	private Context mContext;
	
	
	public MyDatabaseHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		mContext = context;
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE_Table);
		db.execSQL(CREATE_TABLE_TempTable);
		Toast.makeText(mContext, "创建成功", Toast.LENGTH_SHORT).show();
		
	}
//	
//	private List<String >Strlist = new ArrayList<String>();
//    private void loadfiles(){
//    	FileInputStream in =null;
//    	BufferedReader reader = null;
//    	try{
//    		in = openFileInput("data.csv");
//    		reader = new BufferedReader(new InputStreamReader(in));
//    		String line = "";
//    		while((line = reader.readLine()) != null){
//    			Strlist.add(line);
//    		}
//    	}catch(IOException ex){
//    		ex.printStackTrace();
//    	}finally{
//    		if(reader != null){
//    			try{
//    				reader.close();
//    			}catch(IOException e){
//    				e.printStackTrace();
//    			}
//    		}
//    	}
//    //	Toast.makeText(MainActivity.this, Strlist.get(4445), Toast.LENGTH_SHORT).show();
//    	return ;
//    }
//    
//    
	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
