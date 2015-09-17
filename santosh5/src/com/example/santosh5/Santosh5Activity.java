package com.example.santosh5;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Santosh5Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_santosh5);
		VideoView v = (VideoView) findViewById(R.id.vv);
		MediaController mc = new MediaController(Santosh5Activity.this);
		mc.setAnchorView(v);
		
		Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sample);
		v.setMediaController(mc);
		v.setVideoURI(uri);
		v.requestFocus();
		v.start();
	};
}
