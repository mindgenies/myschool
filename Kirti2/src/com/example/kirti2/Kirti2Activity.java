package com.example.kirti2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Kirti2Activity extends Activity implements OnClickListener {
	public LinearLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti2);
		Button b= (Button)findViewById(R.id.button1);
		b.setOnClickListener(this);
		
		ll= (LinearLayout)findViewById(R.id.ll);
		Button b2= (Button)findViewById(R.id.button2);
		b2.setOnClickListener(this);
	}
		
	@Override
	public void onClick(View v) {
		Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show();
		
		ll.setBackgroundColor(Color.RED);
	}
	
}
