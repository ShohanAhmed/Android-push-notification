package net.mightyegg.pushnotification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondactivity);
		
		Toast.makeText(getApplicationContext(), "u have been redirected here",
				   Toast.LENGTH_LONG).show();
		
	}

}
