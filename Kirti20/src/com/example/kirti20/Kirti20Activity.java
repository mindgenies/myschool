package com.example.kirti20;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Kirti20Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti20);
		
		DbHandler handler = new DbHandler(this, "person.db", null, 1);
		SQLiteDatabase sqDb = handler.getWritableDatabase();
		
		//String sql = "insert into person values ('indira' , 'gandhi') ";
		//sqDb.execSQL(sql);
		
		ArrayList<Person> list = new ArrayList<Person>();
		
		String sql = " select * from person";
		Cursor c = sqDb.rawQuery(sql, null);
		while(c.moveToNext())
		{
			String fName = c.getString(0);
			String lName = c.getString(1);
			Person p  = new Person(fName, lName);
			list.add(p);
			
		}
		ArrayAdapter<Person> aa = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, list);
		
		ListView lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(aa);
		
		
		
	}

	
}
