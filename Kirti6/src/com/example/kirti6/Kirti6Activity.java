package com.example.kirti6;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class Kirti6Activity extends Activity implements SensorEventListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti6);
		
		SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> list=sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
		//for(Sensor s:list)
		//{
			//Log.d("MANOJ", s.getName() + ", " + s.getVendor());
		//}
		Sensor s_acc=list.get(0);
		sm.registerListener(this, s_acc, SensorManager.SENSOR_DELAY_GAME);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
		float ax = se.values[0];
		float ay = se.values[1];
		float az = se.values[2];
		
		EditText txtax = (EditText)findViewById(R.id.ax);
		EditText txtay = (EditText)findViewById(R.id.ay);
		EditText txtaz = (EditText)findViewById(R.id.az);
		
		txtax.setText(ax+""); 
		txtay.setText(ay+""); 
		txtaz.setText(az+""); 
	}
}
