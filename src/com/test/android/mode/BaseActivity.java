package com.test.android.mode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class BaseActivity extends Activity implements OnClickListener {

	protected TextView mText;
	protected Button mBtnA, mBtnB, mBtnC;
	protected RadioButton mStandard, mSingleTop, mSingleTask, mSingleInstance;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mText = (TextView) findViewById(R.id.text);

		mBtnA = (Button) findViewById(R.id.btnA);
		mBtnA.setOnClickListener(this);
		mBtnB = (Button) findViewById(R.id.btnB);
		mBtnB.setOnClickListener(this);
		mBtnC = (Button) findViewById(R.id.btnC);
		mBtnC.setOnClickListener(this);

		mStandard = (RadioButton) findViewById(R.id.radioStandard);
		mSingleTop = (RadioButton) findViewById(R.id.radioSingleTop);
		mSingleTask = (RadioButton) findViewById(R.id.radioSingleTask);
		mSingleInstance = (RadioButton) findViewById(R.id.radioSingleInstance);
	}

	@Override
	public void onClick(View v) {

		if (v == mBtnA) {
			Intent i = new Intent(this, ActivityA.class);
			launchIntent(i);
		} else if (v == mBtnB) {
			Intent i = new Intent(this, ActivityB.class);
			launchIntent(i);
		} else if (v == mBtnC) {
			Intent i = new Intent(this, ActivityC.class);
			launchIntent(i);
		}
	}

	private void launchIntent(Intent i) {

		if (mStandard.isChecked()) {
		} else if (mSingleTop.isChecked()) {
			i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		} else if (mSingleTask.isChecked()) {
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		} else if (mSingleInstance.isChecked()) {
			i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		}
		startActivity(i);
	}
}
