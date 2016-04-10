package com.summer.fragment;

import java.util.HashMap;

import com.summer.dialog.CustomProgressDialog;
import com.summer.handler.InfoHandler.InfoReceiver;
import com.summer.logger.XLog;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment implements InfoReceiver{
	
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

	@Override
	public void onInfoReceived(int errcode, HashMap<String, Object> items) {
		
	}

	@Override
	public void onNotifyText(String notify) {
		
	}

}
