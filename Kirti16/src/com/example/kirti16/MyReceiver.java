package com.example.kirti16;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.gsm.SmsManager;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String from="";
		String Message="";
		Bundle bd = intent.getExtras();

		Object[] pdus=(Object[])bd.get("pdus");
		
		for(int i=0; i<=pdus.length-1;i++)
		{
			SmsMessage msg = SmsMessage.createFromPdu((byte[])pdus[i]);
			from = msg.getDisplayOriginatingAddress();
			Message += msg.getMessageBody();
		}
		
		SmsManager sm = SmsManager.getDefault();
		sm.sendTextMessage(from, "", Message, null, null);
	}
}
