package com.example.santosh1;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View  {
	
	Paint p = new Paint();
	ArrayList<MyPoinF> lst = new ArrayList<MyPoinF>();
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
		boolean flag;
		if(action==MotionEvent.ACTION_MOVE)
		{
			x = event.getX();
			y = event.getY();
			flag = true;
			MyPoinF pf = new MyPoinF(x,y,flag);
			lst.add(pf);
			invalidate();
		}
		
		if(action==MotionEvent.ACTION_UP)
		{
			x = event.getX();
			y = event.getY();
			flag = false;
			MyPoinF pf = new MyPoinF(x,y,flag);
			lst.add(pf);
			invalidate();
			//lst.clear();
		}
		return true;
	}
	
	
	@Override
	protected void onDraw(Canvas c) {
		// TODO Auto-generated method stub
	
		super.onDraw(c);
		for(int i=1; i<lst.size(); i++)
		{
			MyPoinF pf_Old = lst.get((i-1));
		    if(pf_Old.act)
		    {
			MyPoinF pf_Cur = lst.get(i);
			c.drawLine(pf_Old.x,pf_Old.y, pf_Cur.x, pf_Cur.y, p);
		    }
		}
		
	}


}
