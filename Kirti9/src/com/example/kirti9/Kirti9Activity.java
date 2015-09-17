package com.example.kirti9;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Kirti9Activity extends Activity implements SensorEventListener {
EditText editText1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti9);
		editText1 =(EditText)findViewById(R.id.editText1);
		
		SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> list=sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
		Sensor s_acc=list.get(0);
		sm.registerListener(this, s_acc, SensorManager.SENSOR_DELAY_FASTEST);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
		float X =se.values[0];
		float Y =se.values[1];
		float Z =se.values[2];
		
		double _result = Math.sqrt(X*X+Y*Y+Z*Z);
		if(_result>33)
		{
			Intent i = new Intent(Intent.ACTION_CALL);
			i.setData(Uri.parse("tel:"+editText1.getText()));
			startActivity(i);
			//Toast.makeText(this, "Threshold is "+_result,Toast.LENGTH_SHORT).show();
			_result=0;
			//Log.d("MANOJ", _result+"");
		}
		
	}
}
