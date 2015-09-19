package com.example.kirti15;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Kirti15Activity extends Activity {

	EditText txtMobileNo;
	EditText txtMsg;
	Button btnSend;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti15);
		
		txtMobileNo = (EditText)findViewById(R.id.txtMobileNo);
		txtMsg = (EditText)findViewById(R.id.txtMsg);
		btnSend = (Button)findViewById(R.id.btnsend);
		
		btnSend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			SmsManager sm = SmsManager.getDefault();
			sm.sendTextMessage(txtMobileNo.getText().toString(), "", txtMsg.getText().toString(), null, null);
			
			}
		});
	}

	
}
