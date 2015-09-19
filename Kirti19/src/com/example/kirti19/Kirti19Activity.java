package com.example.kirti19;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.transition.Visibility;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class Kirti19Activity extends Activity implements OnClickListener {

	RadioButton rbRed;
	RadioButton rbBlue;
	RadioButton rbGreen;
	Button btnExit;
	Button btnRemove;
	LinearLayout ll;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti19);
		
		rbRed=(RadioButton)findViewById(R.id.rbRed);
		rbBlue=(RadioButton)findViewById(R.id.rbBlue);
		rbGreen=(RadioButton)findViewById(R.id.rbGreen);
		btnExit=(Button)findViewById(R.id.btnExit);
		btnRemove=(Button)findViewById(R.id.btnRemove);
		ll=(LinearLayout)findViewById(R.id.ll);
		rbRed.setOnClickListener(this);
		rbBlue.setOnClickListener(this);
		rbGreen.setOnClickListener(this);
		btnExit.setOnClickListener(this);
		
		btnRemove.setOnClickListener(this);
		
		sp = PreferenceManager.getDefaultSharedPreferences(this);
		String sColor = sp.getString("Color", "");
		if(sColor.length()>0)
		{
			if(sColor=="BLUE")
			{
				rbBlue.setChecked(true);
				ll.setBackgroundColor(Color.BLUE);
			}
			else if(sColor=="RED")
			{
				rbRed.setChecked(true);
				ll.setBackgroundColor(Color.RED);
			}
			else if(sColor=="GREEN")
			{
				rbGreen.setChecked(true);
				ll.setBackgroundColor(Color.GREEN);
			} 
		}
		else
		{
			rbBlue.setChecked(true);
			ll.setBackgroundColor(Color.BLUE);
			btnExit.setText("Save preferance and Exit");
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Editor ed= sp.edit();
		if(v==rbBlue)
		{
			ll.setBackgroundColor(Color.BLUE);
			ed.putString("Color", "BLUE");
		}
		else if(v==rbRed)
		{
			ll.setBackgroundColor(Color.RED);
			ed.putString("Color", "RED");
		}
		else if(v==rbGreen)
		{
			ll.setBackgroundColor(Color.GREEN);
			ed.putString("Color", "GREEN");
		}
		
		if(v==btnRemove)
		{
			ed.remove("Color");
			btnExit.setText("Exit");
			Toast.makeText(this, "Preferances removed successfully..", Toast.LENGTH_SHORT).show();
		}
		
		ed.commit();
		
		if(v==btnExit)
		{
			finish();
		}
		
	}
}
