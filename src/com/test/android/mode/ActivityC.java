package com.test.android.mode;

import android.os.Bundle;

public class ActivityC extends BaseActivity {

	private static int mCount = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mCount++;

		mText.setText("This is Activity C, " + mCount);
	}
	
	@Override
	protected void onStart() {

		super.onStart();
		System.out.println("start");
	}
	
	@Override
	protected void onRestart() {

		super.onRestart();
		System.out.println("restart");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		
		System.out.println("cccdes");
		mCount--;
	}
}
