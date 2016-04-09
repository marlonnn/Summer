package com.summer.volley;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.summer.activity.BaseActivity;
import com.summer.handler.InfoHandler;

/**
 * Created by zhongwen on 2016/4/3.
 */
public class StringErrorListener extends BaseResponse implements Response.ErrorListener {
    public StringErrorListener(BaseActivity baseActivity) {
        super();
        this.infoHandler = new InfoHandler(baseActivity);
    }

    @Override
    protected void CallBack() {
        super.CallBack();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        result.put("content", error.getMessage());
        result.put("message", "failure");
        result.put("errorCode", -1);
        this.errorCode = -1;
        this.CallBack();
    }
}
