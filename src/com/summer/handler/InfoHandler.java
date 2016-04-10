package com.summer.handler;

import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class InfoHandler extends Handler{
	
	protected InfoReceiver receiver=null;
	
	public static final int STATE_RESULT_RECEIVED=1;
	
	public static final int STATE_INFO_NOTIFY=2;
	
	public InfoHandler(InfoReceiver receiver){
		super(Looper.getMainLooper());
		this.receiver=receiver;
	}
	
	public interface InfoReceiver {
//		void onInfoReceived(int errcode, T t,HashMap<String, Object> items);
		
		void onInfoReceived(int errcode, HashMap<String, Object> items);

		void onNotifyText(String notify);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(Message msg) {
		
		super.handleMessage(msg);
		if(receiver!=null){
			if(msg.what==STATE_RESULT_RECEIVED){
				receiver.onInfoReceived(msg.arg1, (HashMap<String,Object>)msg.obj);
			}else if(msg.what==STATE_INFO_NOTIFY){
				receiver.onNotifyText((String)msg.obj);
			}
			
		}
	}
}
