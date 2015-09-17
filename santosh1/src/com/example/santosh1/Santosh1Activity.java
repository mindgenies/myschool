package com.example.santosh1;

import android.app.Activity;
import android.os.Bundle;


public class Santosh1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			
		MyView v = new MyView(this);
		setContentView(v);

	}
}
