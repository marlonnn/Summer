package com.summer.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.summer.logger.XLog;

import java.util.Map;

/**
 * Created by zhongwen on 2016/4/3.
 */
public class SimpleStringRequest extends StringRequest {

    private Map<String, String> map;

    public SimpleStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public SimpleStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener, Map<String, String> map) {
        super(method, url, listener, errorListener);
        this.map = map;
    }

    public SimpleStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        XLog.i(map.toString());
        return map;
    }
}
