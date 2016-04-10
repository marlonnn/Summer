package com.summer.activity;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.summer.handler.InfoHandler.InfoReceiver;
import com.summer.json.BaseEntity;
import com.summer.logger.XLog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

/**
 * Base activity
 * @author wen zhong
 *
 */
public abstract class BaseActivity extends FragmentActivity implements InfoReceiver {
	
	private BaseEntity baseEntity;
	
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
	public void onInfoReceived(int errorCode, HashMap<String, Object> items) {
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

	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}
}
