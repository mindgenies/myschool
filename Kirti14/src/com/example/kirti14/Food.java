package com.example.kirti14;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Food {
Bitmap img;
String name, Cal;

	public Food(Context ctx ,int resid, String name, String Cal) {
		// TODO Auto-generated constructor stub
		
		this.img = BitmapFactory.decodeResource(ctx.getResources(), resid);
		this.name = name;
		this.Cal=Cal;
	}

}
