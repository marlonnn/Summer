package com.summer.volley;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by zhongwen on 2016/4/3.
 */
public class StringListener extends BaseResponse implements Response.Listener<String>, Response.ErrorListener{
    @Override
    public void onResponse(String response) {
        result.put("content", response);
        result.put("message", "success");
        result.put("errorCode", 0);
        this.errorCode = 0;
        this.CallBack();
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        result.put("content", error.getMessage());
        result.put("message", "failure");
        result.put("errorCode", -1);
        this.errorCode = -1;
        this.CallBack();
    }

    @Override
    public void CallBack() {
        super.CallBack();
    }
}
