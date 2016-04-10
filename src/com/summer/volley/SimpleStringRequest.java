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

    private Map<String, String> params;

    public SimpleStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public SimpleStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener, Map<String, String> params) {
        super(method, url, listener, errorListener);
        this.params = params;
    }

    public SimpleStringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        XLog.i(params.toString());
        return params;
    }

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
}
