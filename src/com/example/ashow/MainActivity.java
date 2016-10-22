package com.example.ashow;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.Ashow.dbconnet.MyDatabaseHelper;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	private List<list_item> listitem = new ArrayList<list_item>();
	
	private ListView list;
//	private MyDatabaseHelper dbHelper = null;
//    private SQLiteDatabase db;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button baidumap1 = (Button)findViewById(R.id.baidulocal);
        baidumap1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, Baishowmap.class);
				startActivity(intent);
			}
		});
        
        Button buttonsearch = (Button)findViewById(R.id.searchbutton1);
        buttonsearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EditText edit1 = (EditText)findViewById(R.id.edit1);
				String input = edit1.getText().toString();
				 list.setSelection(Integer.valueOf(input)-1);
//				Intent intent = new Intent(MainActivity.this, TemplistActivity.class);
//				int extra_data = Integer.valueOf(input);
//				intent.putExtra("idname", extra_data);
//				
//				startActivity(intent);
				
			}
		});
        list = (ListView) findViewById(R.id.list);
       // loadfiles();
        init_listitem();
        list_Adapter adapter = new list_Adapter(MainActivity.this, R.layout.main_item, listitem);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				list_item listItem = listitem.get(position);
				Intent intent = new Intent(MainActivity.this, TemplistActivity.class);
				int extra_data = listItem.getId();
				intent.putExtra("idname", extra_data);
				
				startActivity(intent);
			}
		});
        
    }
    private List<String >Strlist = new ArrayList<String>();
    
    private void loadfiles(){
    	FileInputStream in =null;
    	BufferedReader reader = null;
    	try{
    		in = openFileInput("data.csv");
    		reader = new BufferedReader(new InputStreamReader(in));
    		String line = "";
    		line = reader.readLine();
    		ContentValues values = new ContentValues();
    		int ii;
    		while((line = reader.readLine()) != null){
    			Strlist.add(line);
//    			String []text;
//    			text=line.split(",");
//    			
//    			
//    			values.put("ID", text[0]);
//    			values.put("Connected", text[1]);
//    			values.put("GainTime", text[2]);
//    			db.insert("IDTable", null, values);
//    			values.clear();
//    			
//    			ii = 3;
//    			for(ii=3;ii<text.length;ii++){
//    				values.put("ID", text[0]);
//    				values.put("TempID", ii-2);
//    				values.put("Temp", text[ii]);
//    				
//    				db.insert("TempTable", null, values);
//    				values.clear();
//    			}
    			
    			
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
    	return ;
    }
    public void init_listitem(){
    	 MyDatabaseHelper dbHelper = null;
         SQLiteDatabase db;
    	dbHelper = new MyDatabaseHelper(MainActivity.this, "app.db", null, 1);
        db = dbHelper.getWritableDatabase();
    	Cursor myCursor = db.query("IDTable", null, null, null, null, null, null);
    	
    	list_item _id = null;
    	if(myCursor.moveToFirst()){
    		do{
    			_id = new list_item(myCursor.getInt(myCursor.getColumnIndex("ID")), 
    					myCursor.getInt(myCursor.getColumnIndex("Connected")), 
    					myCursor.getString(myCursor.getColumnIndex("GainTime")));
    			listitem.add(_id);
    		}while(myCursor.moveToNext());
    	}
    	db.close();
    	dbHelper.close();
    }      
}
