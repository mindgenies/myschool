package com.example.kirti11;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Kirti11Activity extends Activity implements OnItemClickListener {
	ArrayList<String> countries;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti11);
		
		ListView lv = (ListView)findViewById(R.id.lvCountries);
		ArrayList<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("Pakistan");
		countries.add("Sri Lanka");
		countries.add("Bangladesh");
		countries.add("Nepal");
		countries.add("Bhutan");
		countries.add("Thailand");
		countries.add("Malashiya");
		countries.add("Indonesia");
		countries.add("Singapore");
		countries.add("South Africa");
		countries.add("Australia");
		countries.add("Estonia");
		ArrayAdapter<String> aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, countries);
		lv.setAdapter(aa);
		lv.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(this, arg0.getItemAtPosition(arg2).toString(), Toast.LENGTH_SHORT).show();
	}
	
}
