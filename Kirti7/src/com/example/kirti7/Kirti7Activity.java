package com.example.kirti7;


import android.app.Activity;
import android.os.Bundle;


public class Kirti7Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		MyView v = new MyView(this);
		setContentView(v);
	}

}
