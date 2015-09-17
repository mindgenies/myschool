package com.example.santosh4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.Toast;

public class MyView extends View implements Runnable {
	Paint p = new Paint();
	float x,y;
	Socket s;
	BufferedReader br;
	Boolean isFirst=true;
	int OldX,OldY;
	ArrayList<MyPoint> lst = new ArrayList<MyPoint>(); 
	
	public MyView(Context context) {
		super(context);
		p.setColor(Color.BLUE);
		p.setStrokeWidth(5f);
		p.setAntiAlias(true);
		
		
		try 
        {
            ServerSocket ss = new ServerSocket(9999);
            Toast.makeText(context,"Waitting for Connection", Toast.LENGTH_SHORT).show();
            Socket s= ss.accept();
            Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();
            InputStream is = s.getInputStream();  
			InputStreamReader isr = new InputStreamReader(is); 
			br= new BufferedReader(isr);
			
			Thread  t = new Thread(this);
			t.start();
        } 
        catch (IOException ex) 
        {
        	Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show();
        }		
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
		
		while(true)
        {
            String str;
            try 
            { 
                    str = br.readLine();
                    String sArr[] = str.split(",");
                    int x = Integer.parseInt(sArr[0]);
                    int y = Integer.parseInt(sArr[1]);
                    
                    MyPoint pf = new MyPoint();
        			pf.SetX(x);
        			pf.SetY(y);
        			pf.SetIsValid(true);
        			lst.add(pf);
        			invalidate();
            } 
            catch (IOException e) 
            {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
		
	}

}
