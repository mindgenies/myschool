package com.example.kirti14;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowAdaptor extends ArrayAdapter<Food> {
	LayoutInflater lf;
	List lst;
	int resid;
	
	public RowAdaptor(Context ctx, int resid, List lst) {
		// TODO Auto-generated constructor stub
		super(ctx, resid,lst);
		lf = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.lst=lst;
		this.resid=resid;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = lf.inflate(resid, null);
		ImageView iv =(ImageView)v.findViewById(R.id.iv);
		TextView tvname = (TextView)v.findViewById(R.id.tvName);
		TextView tvCal = (TextView)v.findViewById(R.id.tvCal);
		
		tvname.setBackgroundColor(Color.CYAN);
		tvCal.setBackgroundColor(Color.YELLOW);
		
		tvname.setTextColor(Color.RED);
		tvCal.setTextColor(Color.RED);
		
		Food f = (Food)lst.get(position);
		iv.setImageBitmap(f.img);
		tvname.setText(f.name);
		tvCal.setText(f.Cal);
		
		return v;
	}

}
