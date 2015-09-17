package com.example.santosh2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.View;

public class MyView extends View implements SensorEventListener {
	
	Paint p = new Paint();
	Paint pl = new Paint();
	double axisX,axisY,tempy;
	boolean isFirst=true;
	final float alpha = 0.8f;
	float[]  gravity = new float[3]; 
	
	static final float NS2S = 1.0f / 180000000.0f;//
	float[] last_values = null;
	float[] velocity = null;
	float[] position = null;
	long last_timestamp = 0;
	ArrayList<mycls> Al = new ArrayList<mycls>(); 

	public MyView(Context c) {
		super(c);
		// TODO Auto-generated constructor stub
		this.setBackgroundColor(Color.WHITE);
		p.setColor(Color.BLUE);
		pl.setColor(Color.RED);
		pl.setStrokeWidth(5);
		SensorManager sm = (SensorManager)c.getSystemService(Context.SENSOR_SERVICE);
		List<Sensor> list=sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
		Sensor s_acc=list.get(0);
		sm.registerListener(this, s_acc, SensorManager.SENSOR_DELAY_FASTEST);
	}
	
	@Override
	protected void onDraw(Canvas c) {
		// TODO Auto-generated method stub
		super.onDraw(c);
				
		mycls c1 = new mycls(100,0,c.getWidth()-150);		
		Al.add(c1);
		
		mycls c2 = new mycls(250,100,c.getWidth());
		Al.add(c2);
		
		mycls c3 = new mycls(350,0,c.getWidth()/2);
		Al.add(c3);
		
		mycls c4 = new mycls(350,c.getWidth()/2 + 150,c.getWidth());
		Al.add(c4);
		
		mycls c5 = new mycls(475,100,c.getWidth());
		Al.add(c5);
		
		mycls c6 = new mycls(650,0,c.getWidth()-150);		
		Al.add(c6);
		
		mycls c7 = new mycls(800,100,c.getWidth());
		Al.add(c7);
		
		mycls c8 = new mycls(950,0,c.getWidth()/2);
		Al.add(c8);
		
		mycls c9 = new mycls(950,c.getWidth()/2 + 150,c.getWidth());
		Al.add(c9);
		
	    Iterator<mycls> itr=Al.iterator();  
		//traversing elements of ArrayList object  
		while(itr.hasNext())
		{  
		  mycls st=itr.next();  
		  c.drawLine(st.x1, st.ay, st.x2, st.ay, pl);  
		}
		
		double x =(axisX/19.62)*c.getWidth();
		double y= (axisY/19.62)*c.getHeight();
		//START
		/*
		   tempy = (axisY/19.62)*c.getHeight();
		  Iterator<mycls> itr=Al.iterator();  
		  //traversing elements of ArrayList object  
		  while(itr.hasNext())
		  {  
			  mycls st=itr.next();  
			  if((tempy>=st.ay-50 && tempy<=st.ay+50) && x >= st.x1 && x<= st.x2)
			  {
				 if(tempy>=st.ay-50)
					 	y=st.ay-50;
				 else
					    y=st.ay+50;
			  }	
			  else
			  {
				  y =(axisY/19.62)*c.getHeight();
			  }			  
		  }*/
		//END
		
		 
		
		
		if(x<=50)
			x=50;
		if(x>=c.getWidth()-50)
			x=c.getWidth()-50;
		
		if(y<=50)
			y=50;
		if(y>=c.getHeight()-50)
			y=c.getHeight()-50;
		
			
		c.drawCircle((float)x, (float)y, 50, p);		
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
		
		double xt;
		double yt;
		//Log.d("SANTOSH","X=" + se.values[0] + ", Y= " + se.values[1]);
		
		gravity[0] = alpha * gravity[0] + (1 - alpha) * se.values[0];
        gravity[1] = alpha * gravity[1] + (1 - alpha) * se.values[1];
         
        se.values[0] = se.values[0] - gravity[0];
        se.values[1] = se.values[1] - gravity[1];	
        se.values[2] = se.values[2] - gravity[2];
		
		//Log.d("SANTOSH","After Filter X=" + xt + ", Y= " + yt);
		
		if(last_values != null)
		{
	        float dt = (se.timestamp - last_timestamp) * NS2S;

	        for(int index = 0; index < 3;++index)
	        {
	            velocity[index] += (se.values[index] + last_values[index])/2 * dt;
	            position[index] += velocity[index] * dt;
	        }
	    }
	    else
	    {
	        last_values = new float[3];
	        velocity = new float[3];
	        position = new float[3];
	        velocity[0] = velocity[1] = velocity[2] = 0f;
	        position[0] = position[1] = position[2] = 0f;
	    }
		
	    System.arraycopy(se.values, 0, last_values, 0, 3);
	    last_timestamp = se.timestamp;
		
	    //Log.d("SANTOSH1","Velocity Filter X=" + velocity[0] + ", Y= " + velocity[1] + " || Position Filter X=" + position[0] + ", Y= " + position[1]);
	    
	    if(position[0] <= -9.81)
	    	position[0] = -9.81f;
	    if(position[0] >= 9.81)
	    	position[0] = 9.81f;
	    if(position[1] <= -9.81)
	    	position[1] = -9.81f;
	    if(position[1] >= 9.81)
	    	position[1] = 9.81f;
	    
		axisX =Math.abs(position[0]-9.81);
		
		//if(Math.abs(position[1]+9.81) == 5)
			axisY =Math.abs(position[1]+9.81);
		
		invalidate();
	}	

}