package com.example.kirti13;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class Kirti13Activity extends Activity {

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LayoutInflater lf = (LayoutInflater)getSystemService
			      (Context.LAYOUT_INFLATER_SERVICE);
		View v = lf.inflate(R.layout.activity_kirti13, null);
		
		tv= (TextView)v.findViewById(R.id.tv);
		tv.setText("MANOJ");
		
		setContentView(v);
		
		Log.d(Util.TAG, tv.getText().toString());
	}
}
