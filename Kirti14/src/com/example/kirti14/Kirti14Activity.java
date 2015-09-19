package com.example.kirti14;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Kirti14Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayList<Food> alst = new ArrayList<Food>(); 
		alst.add(new Food(this, R.drawable.food1, "Food1","101"));
		alst.add(new Food(this, R.drawable.food2, "Food2","102"));
		alst.add(new Food(this, R.drawable.food3, "Food3","103"));
		alst.add(new Food(this, R.drawable.food4, "Food4","104"));
		alst.add(new Food(this, R.drawable.food5, "Food5","105"));
		alst.add(new Food(this, R.drawable.food6, "Food6","106"));
		alst.add(new Food(this, R.drawable.food7, "Food7","107"));
		alst.add(new Food(this, R.drawable.food8, "Food8","108"));
		alst.add(new Food(this, R.drawable.food9, "Food9","109"));
		alst.add(new Food(this, R.drawable.food10, "Food10","110"));
		alst.add(new Food(this, R.drawable.food11, "Food11","111"));
		alst.add(new Food(this, R.drawable.food12, "Food12","112"));
		
		setContentView(R.layout.activity_kirti14);
		ListView lv = (ListView)findViewById(R.id.lvMain);
		RowAdaptor ra = new RowAdaptor(this, R.layout.row, alst);
		lv.setAdapter(ra);
		
	}
}
