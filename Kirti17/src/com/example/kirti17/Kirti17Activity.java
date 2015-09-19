package com.example.kirti17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

public class Kirti17Activity extends Activity {
	TextView tvDisplay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti17);
		tvDisplay =(TextView)findViewById(R.id.tvDisplay);
		File sPath= Environment.getExternalStorageDirectory(); 

		Toast.makeText(this, sPath.getAbsolutePath()+"/download/demotext.txt", Toast.LENGTH_LONG).show();

		File file = new File(sPath.getAbsolutePath()+"/download/demotext.txt");
		PrintWriter pw;

		try {
			if(file.exists())
			{
				pw = new PrintWriter(file);
				pw.println("Hello World in file system. New file created.");
				pw.flush();
				Toast.makeText(this, "file created successfully.", Toast.LENGTH_SHORT).show();

				BufferedReader br= new BufferedReader(new FileReader(file));
				String str="";
				String line;
				while((line=br.readLine())!=null)
				{
					str=str+line + "\n";
				}
				br.close();
				tvDisplay.setText(str);
			}

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
