package com.example.santosh6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class food {
	Bitmap img;
	String name , cal;
	public food(Context ctx, int rid, String name, String cal) {
		this.cal = cal;
		this.name = name;
		this.img = BitmapFactory.decodeResource(ctx.getResources(), rid);
		// TODO Auto-generated constructor stub
	}

}
