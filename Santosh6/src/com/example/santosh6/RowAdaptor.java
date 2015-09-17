package com.example.santosh6;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowAdaptor extends ArrayAdapter<food> {
	LayoutInflater lf;
	List foodlst;
	int resid;
	
	public RowAdaptor(Context ctx, int resid, List lst) {
		super(ctx, resid, lst);
		// TODO Auto-generated constructor stub
		lf = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.foodlst = lst;
		this.resid = resid;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View v = lf.inflate(resid, null);
		ImageView iv = (ImageView) v.findViewById(R.id.iv);
		TextView tv1 = (TextView) v.findViewById(R.id.tv1);
		TextView tv2 = (TextView) v.findViewById(R.id.tv2);
		
		food f = (food)foodlst.get(position);

		iv.setImageBitmap(f.img);
		tv1.setText(f.name);
		tv2.setText(f.cal);
		return v;
	}

}
