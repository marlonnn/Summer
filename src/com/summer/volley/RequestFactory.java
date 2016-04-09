package com.summer.volley;

import com.android.volley.toolbox.StringRequest;

public class RequestFactory {
	
    private static StringRequest stringRequest;

    private static RequestFactory requestFactory;

    public static RequestFactory GetRequestFactory()
    {
        if (requestFactory == null)
        {
            requestFactory = new RequestFactory();
        }
        return requestFactory;
    }

    public static StringRequest GetStringRequest(String url, int taskType)
    {
        stringRequest = new StringRequest(url, new StringListener(), new StringListener());
        return stringRequest;
    }

}
