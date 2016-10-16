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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	private List<list_item> listitem = new ArrayList<list_item>();
	
	private ListView list;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);
        loadfiles();
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
				//Toast.makeText(MainActivity.this, String.valueOf(listItem.getId()), Toast.LENGTH_SHORT).show();
				int extra_data = listItem.getId();
				intent.putExtra("idname", extra_data);
				//intent.putExtra("Str_data",Strlist.get(extra_data));
				
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
    		while((line = reader.readLine()) != null){
    			Strlist.add(line);
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
    //	Toast.makeText(MainActivity.this, Strlist.get(4445), Toast.LENGTH_SHORT).show();
    	return ;
    }
    public void init_listitem(){
    	int i,j,k;
    	String line = "";
    	list_item fir;
    	for(i=1;i<Strlist.size();i++){
    		line = Strlist.get(i);
    		//Toast.makeText(MainActivity.this, line, Toast.LENGTH_SHORT).show();
    		k = 2;
    		j = 0;
    		char ch;
    		String str[] = {"","",""};
    		while(k>-1){
    			ch  = line.charAt(j++) ;
    			if( ch == ','){
    				k--;
    				continue;
    			}
    			str[k]+=ch;
    		}
    		fir = new list_item(Integer.valueOf(str[2]).intValue(), str[1], str[0]);
        	listitem.add(fir);
    	}
    }
    
    
}
