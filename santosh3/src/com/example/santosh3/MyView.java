package com.example.santosh3;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View implements Runnable {
	Paint p = new Paint();
	ArrayList<MyPoint> lst = new ArrayList<MyPoint>();
	float x,y;
	Socket s;
	PrintWriter pw; 
	public MyView(Context context) {
		super(context);
		p.setColor(Color.BLUE);
		p.setStrokeWidth(5f);
		p.setAntiAlias(true);
		
		Thread  t = new Thread(this); 
		t.start();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		if(action==MotionEvent.ACTION_MOVE)
		{
			x = event.getX();
			y = event.getY();
			MyPoint pf = new MyPoint();
			pf.SetX(x);
			pf.SetY(y);
			pf.SetIsValid(true);
			lst.add(pf);
			
			String str = (int)x +","+(int)y;
			pw.println(str);
			pw.flush();
			invalidate();
		}
		
		if(action==MotionEvent.ACTION_DOWN)
		{
			x = event.getX();
			y = event.getY();
			MyPoint pf = new MyPoint();
			pf.SetX(x);
			pf.SetY(y);
			pf.SetIsValid(false);
			lst.add(pf);
			
			
		}
		
		return true;
	}
	
	@Override
	protected void onDraw(Canvas c) {
		// TODO Auto-generated method stub
	
		super.onDraw(c);
		
		for(int i=1; i<lst.size(); i++)
		{
			MyPoint pf_Old = lst.get((i-1));
			MyPoint pf_Cur = lst.get(i);
			
			if(pf_Cur.GetIsValid())
			{
				c.drawLine(pf_Old.GetX(),pf_Old.GetY(), pf_Cur.GetX(), pf_Cur.GetY(), p); 				
				
			}
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("192.168.1.102",9999);   
			OutputStream os = s.getOutputStream();
			pw = new PrintWriter(os);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
}

