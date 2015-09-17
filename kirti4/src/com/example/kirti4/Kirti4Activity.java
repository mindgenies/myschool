package com.example.kirti4;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class Kirti4Activity extends Activity implements OnClickListener {
	LinearLayout ll;
	RadioButton rdbRed,rdbGreen,rdbBlue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti4);
		
		ll = (LinearLayout) findViewById(R.id.ll);
		rdbRed = (RadioButton) findViewById(R.id.rdbRed);
		rdbGreen = (RadioButton) findViewById(R.id.rdbGreen);
		rdbBlue = (RadioButton) findViewById(R.id.rdbBlue);
		ll.setBackgroundColor(Color.RED);
		rdbRed.setOnClickListener(this);
		rdbGreen.setOnClickListener(this);
		rdbBlue.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		if(v==rdbRed)
		{
			ll.setBackgroundColor(Color.RED);
		}
		else if(v==rdbGreen)
		{
			ll.setBackgroundColor(Color.GREEN);
		}
		else if(v==rdbBlue)
		{
			ll.setBackgroundColor(Color.BLUE);
		}
		
	}
	
}
