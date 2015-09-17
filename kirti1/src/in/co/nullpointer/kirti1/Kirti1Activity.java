package in.co.nullpointer.kirti1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class Kirti1Activity extends Activity implements OnClickListener{

	LinearLayout ll;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kirti1);
		Button b = (Button)findViewById(R.id.button1);
		b.setOnClickListener(this);
		ll = (LinearLayout) findViewById(R.id.ll);
		 
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ll.setBackgroundColor(Color.RED);
		
	}

	

	
}
