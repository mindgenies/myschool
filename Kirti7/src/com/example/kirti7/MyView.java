package com.example.kirti7;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
	Paint p = new Paint();
	ArrayList<PointF> lst = new ArrayList<PointF>();
	//float x=this.getWidth()/2,y=this.getHeight()/2;
	float x,y;
	public MyView(Context context) {
		super(context);
		
	p.setColor(Color.RED);
	p.setStrokeWidth(3f);
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
			PointF pf = new PointF(x,y);
			lst.add(pf);
			invalidate();
		}
		
		if(action==MotionEvent.ACTION_UP)
		{
			
			
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
			PointF pf_Old = lst.get((i-1));
			PointF pf_Cur = lst.get(i);
			c.drawLine(pf_Old.x,pf_Old.y, pf_Cur.x, pf_Cur.y, p);
		}
		
	}
}
