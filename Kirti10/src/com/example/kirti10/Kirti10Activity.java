package com.example.kirti10;

import android.app.Activity;
import android.os.Bundle;

public class Kirti10Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView v = new MyView(this); 
		setContentView(v);
		
		
		
		
	}
}
