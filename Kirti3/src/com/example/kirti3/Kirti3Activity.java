package com.example.kirti3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Kirti3Activity extends Activity implements OnClickListener {
	LinearLayout ll;
	Button btnRed,btnGreen,btnBlue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti3);
		ll = (LinearLayout)findViewById(R.id.ll);
		btnRed = (Button)findViewById(R.id.button1);
		btnGreen = (Button)findViewById(R.id.button2);
		btnBlue = (Button)findViewById(R.id.button3);
				
		btnRed.setOnClickListener(this);
		btnGreen.setOnClickListener(this);
		btnBlue.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==btnRed)
			ll.setBackgroundColor(Color.RED);
		else if(v==btnGreen)
			ll.setBackgroundColor(Color.GREEN);
		else 
			ll.setBackgroundColor(Color.BLUE);
	}
}
