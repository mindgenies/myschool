package com.example.santosh9;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Santosh9Activity extends Activity {
	EditText Username;
	EditText Password;
	Button Login;
	SharedPreferences sp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_santosh9);
		
		Username = (EditText) findViewById(R.id.et1);
		Password = (EditText) findViewById(R.id.et2);
		
		Login = (Button) findViewById(R.id.btn);
		
		sp = PreferenceManager.getDefaultSharedPreferences(Santosh9Activity.this);
		Username.setText(sp.getString("Username", "Username Not Found"));
		Password.setText(sp.getString("Password", "Username Not Found"));
		
		Login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sp.edit().putString("Username", Username.getText().toString()).putString("Password", Password.getText().toString()).commit();
				Toast.makeText(Santosh9Activity.this, "Username and Password has been saved in SharedPreferences.", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
