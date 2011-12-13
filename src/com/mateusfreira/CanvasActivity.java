package com.mateusfreira;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class CanvasActivity extends Activity {
	DrawView drawView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		drawView = new DrawView(this);
		setContentView(drawView);
		drawView.requestFocus();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		drawView.clear();
		return super.onMenuItemSelected(featureId, item);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("Limpar");
		return true;
	}
}