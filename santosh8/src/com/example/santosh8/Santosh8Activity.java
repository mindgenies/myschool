package com.example.santosh8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.ScriptGroup.Input;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Santosh8Activity extends Activity {
	EditText InputText;
	Button btn; 
	File fl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_santosh8);
		
		File bPath = Environment.getExternalStorageDirectory();
		fl = new File(bPath + "/Download/demotext.txt");
		
		InputText = (EditText) findViewById(R.id.et);
		btn = (Button) findViewById(R.id.btn);
		
		if(fl.exists())
		{
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(fl));
				String str="";
				String line;
				try {
					while((line=br.readLine())!=null)
					{
						str=str+line + "\n";
					}
					
					InputText.setText(str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		

		}
		
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
							
				PrintWriter pw;
				try {
					pw = new PrintWriter(fl);
					pw.println(InputText.getText().toString());
					pw.flush();
					Toast.makeText(Santosh8Activity.this, "file created successfully.", Toast.LENGTH_SHORT).show();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace(); 
				} 				
				
			}
		});
	}	
}
