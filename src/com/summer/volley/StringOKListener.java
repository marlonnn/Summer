package com.summer.volley;

import com.android.volley.Response;
import com.summer.activity.BaseActivity;
import com.summer.handler.InfoHandler;
import com.summer.logger.XLog;

/**
 * Created by zhongwen on 2016/4/3.
 */
public class StringOKListener extends BaseResponse implements Response.Listener<String> {

    public StringOKListener(BaseActivity baseActivity) {
        super();
        this.infoHandler = new InfoHandler(baseActivity);
    }

    @Override
    protected void CallBack() {
        super.CallBack();
    }

    @Override
    public void onResponse(String response) {
        result.put("content", response);
        result.put("message", "success");
        result.put("errorCode", 0);
        this.errorCode = 0;
        this.CallBack();
        XLog.i(response);
    }
}
