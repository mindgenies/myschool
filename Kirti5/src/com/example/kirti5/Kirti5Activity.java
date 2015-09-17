package com.example.kirti5;

import com.example.kirti5.R.string;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Kirti5Activity extends Activity implements OnClickListener {
LinearLayout ll;
CheckBox chkMilk,chkEgg,chkChappati;
EditText txtResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti5);
		ll= (LinearLayout)findViewById(R.id.ll);
		
		txtResult= (EditText)findViewById(R.id.txtResult);
		
		chkMilk= (CheckBox)findViewById(R.id.chkMilk);
		chkEgg= (CheckBox)findViewById(R.id.chkEgg);
		chkChappati= (CheckBox)findViewById(R.id.chkChappati);
		
		chkMilk.setOnClickListener(this);
		chkEgg.setOnClickListener(this);
		chkChappati.setOnClickListener(this);
		txtResult.setText("");
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String strMsg = " ";
		
		
		
		
			if(chkMilk.isChecked())
				strMsg +=  chkMilk.getText()+",";
			
			if(chkEgg.isChecked())
				strMsg +=  chkEgg.getText()+",";
			
			if(chkChappati.isChecked())
				strMsg +=  chkChappati.getText()+",";
			
			strMsg = strMsg.substring(0, strMsg.length()-1);
		txtResult.setText(strMsg);
	}

}
