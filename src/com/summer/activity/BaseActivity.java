package com.summer.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.summer.R;
import com.summer.config.Config;
import com.summer.dialog.CustomProgressDialog;
import com.summer.handler.InfoHandler.InfoReceiver;
import com.summer.logger.XLog;

/**
 * Base activity
 * @author wen zhong
 *
 */
public abstract class BaseActivity extends FragmentActivity implements InfoReceiver {
	
	
	public static ArrayList<Activity> activityList = new ArrayList<Activity>();
	
	private Activity activity;
	
	private CustomProgressDialog progressDialog;
	
	@Override
	protected void onCreate(@Nullable Bundle arg0) {
		super.onCreate(arg0);
		activityList.add(this);
		activity = this;
		XLog.i(Config.hasloadConfig);
		if (!Config.hasloadConfig) {
			File cache = this.getCacheDir();
			Config.setCachePath(cache.getPath());
			XLog.i(cache.getPath());
			Config.setFileDir(getFilesDir().getPath());
			Config.maincontext = this;
			Config.LoadConfig();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (findViewById(R.id.nav_back_view) != null)
		{
			backButton();
		}
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		this.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
	protected void onDestroy() {
		super.onDestroy();
		try {
			activityList.remove(this);
			this.getWindow().setSoftInputMode(
					WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Button backButton() {
		Button button = (Button) findViewById(R.id.nav_back_view);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				try {
					activity.finish();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return button;
	}
	
	protected void setText(int id, String text)
	{
		TextView t = (TextView) findViewById(id);
		t.setText(text);
	}
	
	/**
	 * Show custom dialog progress
	 * @param title
	 */
	protected void ShowProgressDialog(String title) {
		try {
			if (progressDialog != null) 
			{
				return;
			}
			progressDialog = CustomProgressDialog.CreateDialog(this);
			progressDialog.setMessage(title);
			progressDialog.setCancelable(true);
			progressDialog.show();

			progressDialog.setOnCancelListener(
					new DialogInterface.OnCancelListener() 
					{
						@Override
						public void onCancel(DialogInterface arg0) 
						{
							if (progressDialog != null) {
								progressDialog.dismiss();
								progressDialog = null;
							}
						}
					});
		} 
		catch (Exception e) 
		{
			XLog.e("showProgressDialog exception: " + e.toString(), e);
			e.printStackTrace();
		}
	}
	
	protected void RemoveProgressDialog()
	{
		try {
			if (progressDialog != null) {
				progressDialog.dismiss();
				progressDialog = null;
			}
		} catch (Exception e) {
			 XLog.e("showProgressDialog exception: " + e.toString(), e);
		}
	}

	@Override
	public void onInfoReceived(int errorCode, HashMap<String, Object> items) {
		RemoveProgressDialog();
        if (errorCode == 0)
        {
            XLog.i(errorCode);
            String jsonString = (String) items.get("content");
            if (jsonString != null)
            {
                JSONObject object;
                try {
                    object = new JSONObject(jsonString);
                    String msg = object.optString("msg");
                    int code = object.optInt("status", -1);
                    int taskType = (Integer) items.get("taskType");
                    if (code == 0)
                    {
                        RequestSuccessful(jsonString, taskType);
                    }
                    else
                    {
                        RequestFailed(code, msg, taskType);
                    }
                } catch (JSONException e) {
                    //parse error
                    XLog.e(e);
                    e.printStackTrace();
                    RequestFailed(-1, "Json Parse Error", -1);
                }
            }
        }
		
	}

	@Override
	public void onNotifyText(String notify) {
	}

	/**
	 * Get json string and request success callback
	 * @param jsonString
	 * @param taskType
	 */
	public abstract void RequestSuccessful(String jsonString, int taskType);
	
	/**
	 * Get error and show failed toast
	 * @param errcode
	 * @param message
	 * @param taskType
	 */
    public void RequestFailed(int errcode, String message, int taskType)
    {
        if (errcode == 0) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
