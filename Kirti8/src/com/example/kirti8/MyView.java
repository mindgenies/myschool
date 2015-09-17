package com.example.kirti8;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.View;

public class MyView extends View implements SensorEventListener{
	Paint p = new Paint();
	float x,y,axisX,axisY,OldX,OldY;
	boolean isFirst=true;
	public MyView(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.WHITE);
		p.setColor(Color.BLUE);
		//p.setStrokeWidth(5f);
		//p.setAntiAlias(true);
		
		SensorManager sm = (SensorManager)c.getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> list=sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
		Sensor s_acc=list.get(0);
		sm.registerListener(this, s_acc, SensorManager.SENSOR_DELAY_FASTEST);
	}
	
	@Override
	protected void onDraw(Canvas c) {
		// TODO Auto-generated method stub
		super.onDraw(c);
			x =(axisX/20)*c.getWidth();
			y =(axisY/20)*c.getHeight();
			if(Math.abs(OldX-x)>1 ||Math.abs(OldY-y)>1)
			{
				c.drawCircle(x, y, 50, p);
			}
				
			OldX=x;
			OldY=y;
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
		axisX =Math.abs(se.values[0]-10);
		axisY =Math.abs(se.values[1]+10);
		invalidate();
	}
}
