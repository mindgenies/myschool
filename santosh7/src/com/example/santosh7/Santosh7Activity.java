package com.example.santosh7;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Santosh7Activity extends 	Activity {
	EditText mobileNo;
	Button sbt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_santosh7);
		
		mobileNo = (EditText) findViewById(R.id.et);
		sbt = (Button) findViewById(R.id.btn);
		
		sbt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SmsManager sm = SmsManager.getDefault();
				sm.sendTextMessage(mobileNo.getText().toString(), "", "test my message", null, null);
			}
		});	
		
	}	
}
