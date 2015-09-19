package com.example.kirti18;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Kirti18Activity extends Activity {
	EditText  etUserName;
	EditText  etPassword;
	Button  btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti18);
		
		etUserName = (EditText)findViewById(R.id.etUserName);
		etPassword = (EditText)findViewById(R.id.etPassword);
		btnLogin = (Button)findViewById(R.id.btnLogin);
		
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Kirti18Activity.this);
		etUserName.setText(sp.getString("Username", "Not Found"));
		etPassword.setText(sp.getString("Password", "Not Found"));
			
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Kirti18Activity.this);
				
				Editor ed= sp.edit();
				ed.putString("Username", etUserName.getText().toString());
				ed.putString("Password", etPassword.getText().toString());
				ed.commit();
				Toast.makeText(Kirti18Activity.this, "Username and Password has been saved in SharedPreferences.", Toast.LENGTH_SHORT).show();
				
			
			}
		});
	}
}
