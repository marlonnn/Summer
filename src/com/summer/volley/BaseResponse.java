package com.summer.volley;

import java.util.HashMap;

import com.summer.handler.InfoHandler;
import com.summer.logger.XLog;

public abstract class BaseResponse {

	protected int taskType;
	
    protected int errorCode;

    protected InfoHandler infoHandler;

    protected HashMap<String, Object> result;
    
    public  BaseResponse()
    {
        taskType = -1;// task type
        errorCode = -1; //error code £¬0:OK
        infoHandler = null;
        result = new HashMap<String, Object>();
    }

    protected void CallBack()
    {
        if (infoHandler != null) {
            result.put("taskType", taskType);
            XLog.i(result.toString());
            infoHandler.sendMessage(infoHandler.obtainMessage(
                    InfoHandler.STATE_RESULT_RECEIVED, errorCode, 0, result));
        }
    }
}
