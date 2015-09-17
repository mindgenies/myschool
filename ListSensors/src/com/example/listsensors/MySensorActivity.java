package com.example.listsensors;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MySensorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_sensor);
		ListView lv = (ListView) findViewById(R.id.lv);
		ArrayList<String> al= new ArrayList<String>();
		
		SensorManager mgr = (SensorManager) getSystemService(SENSOR_SERVICE);
	    List<Sensor> sensors = mgr.getSensorList(Sensor.TYPE_ALL);
	    for (Sensor sensor : sensors) {
	       al.add(sensor.getName());
	    }
	    ArrayAdapter<String> aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
	    lv.setAdapter(aa);
	    lv.setBackgroundColor(Color.BLACK);
	}	
}
