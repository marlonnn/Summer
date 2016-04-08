package com.summer.activity;

import java.util.HashMap;

import com.summer.handler.InfoHandler.InfoReceiver;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Base activity
 * @author wen zhong
 *
 */
public abstract class BaseActivity extends FragmentActivity implements InfoReceiver {
	
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		super.onCreate(arg0);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public void onInfoReceived(int errcode, HashMap<String, Object> items) {
		
	}

	@Override
	public void onNotifyText(String notify) {
	}

	
}
