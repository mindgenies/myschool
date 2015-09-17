package com.example.mysensor2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ImageView;

public class MySensor2Activity extends Activity implements SensorEventListener {
	private SensorManager mSensorManager;
    private Sensor mSensor;
	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_sensor2);
		
		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		mSensorManager.registerListener(this, mSensor,SensorManager.SENSOR_DELAY_NORMAL);
		iv = (ImageView) findViewById(R.id.ivimg);
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		if (event.values[0] == 0) 
		{
			   iv.setImageResource(R.drawable.hand);
    	} 
		else 
		{
			   iv.setImageResource(R.drawable.nohand);
    	}
	}
}
