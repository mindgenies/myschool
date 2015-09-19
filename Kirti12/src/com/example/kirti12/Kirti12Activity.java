package com.example.kirti12;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class Kirti12Activity extends Activity implements OnTouchListener, SensorEventListener {
int index=0;
int tx,ty;
Bitmap bitmap;
Resources rs ;
ArrayList<Bitmap> arr = new ArrayList<Bitmap>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti12);
		
		rs = getResources();
		
		arr.add(BitmapFactory.decodeResource(rs, R.drawable.a0));
		arr.add(BitmapFactory.decodeResource(rs, R.drawable.a1));
		arr.add(BitmapFactory.decodeResource(rs, R.drawable.a2));
		arr.add(BitmapFactory.decodeResource(rs, R.drawable.a4));
		arr.add(BitmapFactory.decodeResource(rs, R.drawable.a5));
		arr.add(BitmapFactory.decodeResource(rs, R.drawable.a6));
		arr.add(BitmapFactory.decodeResource(rs, R.drawable.a7));
		
		
		ImageView im = (ImageView)findViewById(R.id.imImage);
		im.setImageBitmap(arr.get(0));
		im.setOnTouchListener(this);
		
		SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> list=sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
		Sensor s_acc=list.get(0);
		sm.registerListener(this, s_acc, SensorManager.SENSOR_DELAY_FASTEST);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		if(action==MotionEvent.ACTION_DOWN)
		{
			tx=(int)event.getX(); 
		}
		int x;
		if(action==MotionEvent.ACTION_UP)
		{
			x=(int)event.getX();
			
			if((x-tx)<-20)
			{
				index--;
				if(index<0)
					index=6;
				ImageView im = (ImageView)findViewById(R.id.imImage);
				im.setImageBitmap(arr.get(index));
				
			}
			else if((x-tx)>20)
			{
				index++;
				if(index>6)
					index=0;
				ImageView im = (ImageView)findViewById(R.id.imImage);
				im.setImageBitmap(arr.get(index));
				
			}
			
			
		}
		
		return true;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
		float X =se.values[0];
		float Y =se.values[1];
		float Z =se.values[2];
		
		double _result = Math.sqrt(X*X+Y*Y+Z*Z);
		if(_result>30)
		{
			if(index>6)
			{
				index=0;
			}
			
			ImageView im = (ImageView)findViewById(R.id.imImage);
			im.setImageBitmap(arr.get(index));
			index++;
		}
	}
}
