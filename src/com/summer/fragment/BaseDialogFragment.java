package com.summer.fragment;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.widget.TextView;
import android.widget.Toast;

import com.summer.dialog.CustomProgressDialog;
import com.summer.handler.InfoHandler.InfoReceiver;
import com.summer.logger.XLog;

public abstract class BaseDialogFragment extends DialogFragment implements InfoReceiver{
	
	protected CustomProgressDialog progressDialog;
	
	public void ShowProgressDialog(String title) 
	{
		try {
			if (progressDialog != null) {
				return;
			}
			progressDialog = CustomProgressDialog.CreateDialog(this
					.getActivity());
			progressDialog.setMessage(title);
			progressDialog.setCancelable(true);
			progressDialog.show();

			progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
						@Override
						public void onCancel(DialogInterface arg0) {
							if (progressDialog == null) {
								return;
							}
							progressDialog.dismiss();
							progressDialog = null;
						}
					});
		} catch (Exception e) {
			XLog.e(e.getMessage(), e);
		}
	}
	
	public void removeProgressDialog() 
	{
		try {
			if (progressDialog != null) {
				progressDialog.dismiss();
				progressDialog = null;
			}
		} catch (Exception e) {
			XLog.e(e.getMessage(), e);
		}
	}
	
	protected void setText(int Id, String text) {
		TextView textView = (TextView) getView().findViewById(Id);
		textView.setText(text);
	}

	@Override
	public void onInfoReceived(int errorCode, HashMap<String, Object> items) {
		RemoveProgressDialog();
        if (errorCode == 0)
        {
            String jsonString = (String) items.get("content");
            if (jsonString != null)
            {
                JSONObject object;
                try {
                    object = new JSONObject(jsonString);
                    String msg = object.optString("msg");
                    int code = object.optInt("status", -1);
                    int taskType = (Integer) items.get("taskType");
                    XLog.i("code: " + errorCode);
                    XLog.i("taskType: " + taskType);
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
            Toast.makeText(this.getActivity(), message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this.getActivity(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
