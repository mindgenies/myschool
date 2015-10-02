package com.example.santoshopengl;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	MainSurfaceView msv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		msv = new MainSurfaceView(this);
		setContentView(msv);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		msv.onPause();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		msv.onResume();
	}
	
	

}
