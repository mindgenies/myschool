package com.example.kirti7;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.renderscript.Sampler.Value;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MyView extends View {
	Paint p = new Paint();
	ArrayList<MyPoint> lst = new ArrayList<MyPoint>();
	float x,y;
	
	public MyView(Context context) {
		super(context);
		
		this.setBackgroundColor(Color.WHITE);
		p.setColor(Color.BLUE);
		p.setStrokeWidth(5f);
		p.setAntiAlias(true);
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
		//float ax =c.getWidth()/2;
		//float ay =c.getHeight()/2;
		//c.drawCircle(x, y, 10, p);
		//c.drawLine(x, y, x, y, p);
		for(int i=1; i<lst.size(); i++)
		{
			MyPoint pf_Old = lst.get((i-1));
			MyPoint pf_Cur = lst.get(i);
			
			if(pf_Cur.GetIsValid())
				c.drawLine(pf_Old.GetX(),pf_Old.GetY(), pf_Cur.GetX(), pf_Cur.GetY(), p);
		}
		
	}
}

class MyPoint
{
	private float _X;
	private float _Y;
	private boolean _IsValid;
	
	public float GetX()
	{return _X;}
	
	public float SetX(float _Val)
	{return _X=_Val;}
	
	public float GetY()
	{return _Y;}
	
	public float SetY(float _Val)
	{return _Y=_Val;}
	
	public boolean GetIsValid()
	{return _IsValid;}
	
	public boolean SetIsValid(boolean _Val)
	{return _IsValid=_Val;}
}
