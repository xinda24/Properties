package com.panzhe.property;

import java.io.IOException;
import java.util.Properties;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	private Context context;
	private Properties properties;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		try {
			loadProperties();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.e("", properties.getProperty("name", ""));
	}

	private void loadProperties() throws NotFoundException, IOException {
		properties = new Properties();
		int id = context.getResources().getIdentifier("info", "raw",
				context.getPackageName());
		properties.load(context.getResources().openRawResource(id));
	}
}
