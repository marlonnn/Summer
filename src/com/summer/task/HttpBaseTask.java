package com.summer.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.summer.config.Config;
import com.summer.handler.InfoHandler;
import com.summer.logger.XLog;

/**
 * @ClassName: HttpBaseTask
 * @Description:Http base task
 * @author wen zhong
 * @Date: 2016/4/8 15:34:14 PM
 */
public class HttpBaseTask extends BaseTaskObject{
	
	protected int taskType = -1;

	protected String url;
	
	private InfoHandler infoHandler;
	
	protected boolean isUsePostType = false;
	
	protected HashMap<String, Object> result;
	
	public CookieStore cookieStore = null;
	
	/**
	 * HTTP POST Content
	 */
	protected String content;
	
	/**
	 * HTTP POST Params
	 */
	protected List<NameValuePair> params;
	
	/**
	 * HTTP Get Method
	 * @param url
	 */
	public HttpBaseTask(String url)
	{
		super();
		this.isUsePostType = false;
		result = new HashMap<String, Object>();
	}

	/**
	 * HTTP Post method with content
	 * @param content
	 * @param url
	 */
	public HttpBaseTask(String content, String url)
	{
		super();
		this.content = content;
		this.url = url;
		this.isUsePostType = true;
		result = new HashMap<String, Object>();
	}
	
	/**
	 * HTTP Post method with params
	 * @param params
	 * @param url
	 */
	public HttpBaseTask(List<NameValuePair> params, String url)
	{
		super();
		this.params = params;
		this.url = url;
		this.isUsePostType = true;
		result = new HashMap<String, Object>();
	}
	
	public HttpBaseTask(int threadPoolType, String threadTaskName)
	{
		super(threadPoolType, threadTaskName);
		result = new HashMap<String, Object>();
	}
	/**
	 * HTTP Post method
	 * @param threadPoolType
	 * @param threadTaskName
	 * @param url
	 */
	public HttpBaseTask(int threadPoolType, String threadTaskName, String url)
	{
		super(threadPoolType, threadTaskName);
		this.isUsePostType = false;
		result = new HashMap<String, Object>();
	}
	
	/**
	 * HTTP Post method with params
	 * @param threadPoolType
	 * @param threadTaskName
	 * @param params
	 * @param url
	 */
	public HttpBaseTask(int threadPoolType, String threadTaskName, List<NameValuePair> params, String url)
	{
		super(threadPoolType, threadTaskName);
		this.params = params;
		this.url = url;
		this.isUsePostType = true;
		result = new HashMap<String, Object>();
	}
	
	/**
	 * HTTP Post method with content
	 * @param threadPoolType
	 * @param threadTaskName
	 * @param content
	 * @param url
	 */
	public HttpBaseTask(int threadPoolType, String threadTaskName, String content, String url)
	{
		super(threadPoolType, threadTaskName);
		this.content = content;
		this.url = url;
		this.isUsePostType = true;
		result = new HashMap<String, Object>();
	}
	
	/**
	 * send message to target handler
	 */
	private void sendInfoMessage() {
		if (infoHandler != null) {
			result.put("taskType", taskType);
			infoHandler.sendMessage(infoHandler.obtainMessage(
					InfoHandler.STATE_RESULT_RECEIVED, errorCode, 0, result));
		}
	}
	
	@Override
	public void run() {
		super.run();
		if (IsCancel())
		{
			return;
		}
		InputStream in = getInputStream();
		try {
			if (in != null)
			{
				dealwithData(in);
				sendInfoMessage();
				in.close();
				in = null;
			}
			else
			{
				result.put("message", message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * deal with receive data
	 * @param in
	 */
	private void dealwithData(InputStream in) 
	{
		if (!validateInternet(Config.maincontext)) {
			result.put("message", "Not connected to the network");
			result.put("errorCode", -2);
			errorCode = -2;
			return;
		}
		if (in == null) {
			result.put("message", "Server returns an error");
			result.put("errorCode", -1);
			errorCode = -1;
			return;
		}
		String jsonString = readJsonData(in);
		if (jsonString == null) {
			result.put("message", "Server returns parameter error");
			result.put("errorCode", -1);
			errorCode = -1;
			return;
		}
		result.put("taskType", taskType);
		result.put("content", jsonString);
		XLog.i("taskType: " + taskType);
		XLog.i("json string: " + jsonString);
	}
	
	/**
	 * validate network status
	 * @param context
	 * @return
	 */
	@SuppressWarnings("static-access")
	private boolean validateInternet(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context
				.getSystemService(context.CONNECTIVITY_SERVICE);
		if (manager == null) {
			return false;
		} else {
			NetworkInfo[] info = manager.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * read json data
	 * @param in
	 * @return
	 */
	private String readJsonData(InputStream in) {
		StringBuffer returnBuffer = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, "utf-8"));
			String line = "";
			while ((line = reader.readLine()) != null) {
				returnBuffer.append(line);
			}
			this.errorCode = 0;
			reader.close();
		} catch (Exception e) {
			this.errorCode = -1;
			e.printStackTrace();
		}
		return returnBuffer.toString();
	}
	
	private InputStream getInputStream()
	{
		InputStream in = null;
		if (isUsePostType)
		{
			if (content != null)
			{
				in = getInputStreamWithPostType4WebService();
			}
			else if(params != null)
			{
				in = getInputStreamWithPostType();
			}
		}
		else
		{
			in = getInputStreamWithGetType();
		}
		return in;
	}
	
	private InputStream getInputStreamWithPostType4WebService() {
		InputStream in = null;
		try {
			XLog.i("POST with content: " + "url:" + url + "\nreq:" + content);
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 50000);
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					50000);

			HttpPost method = new HttpPost(url);
			method.addHeader("Content-Type", "application/json; charset=utf-8");
			StringEntity se;
			if (content != null) {
				se = new StringEntity(content, HTTP.UTF_8);
				method.setEntity(se);
			}
			HttpResponse response = client.execute(method);
			in = response.getEntity().getContent();
			XLog.i("httpResponse.getStatusLine().getStatusCode() = "
					+ response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			message = "Network error";
			XLog.e("error: " + e.toString());
			e.printStackTrace();
		}
		return in;
	}
	
	private InputStream getInputStreamWithPostType() {
		InputStream in = null;
		XLog.i("POST with params: " + "url:" + url + "\nreq:" + params);
		try {
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 50000);
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					50000);
			HttpPost method = new HttpPost(url);
			if (cookieStore != null) {
				client.setCookieStore(cookieStore);
			}
			method.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpResponse response = client.execute(method);
			cookieStore = client.getCookieStore();
			in = response.getEntity().getContent();
			XLog.i("httpResponse.getStatusLine().getStatusCode() = "
					+ response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			message = "Network error";
			XLog.e("error: " + e.toString());
			e.printStackTrace();
		}
		return in;
	}
	
	private InputStream getInputStreamWithGetType() {
		try {
			XLog.i("url:" + url);
			HttpGet getRequest = new HttpGet(url);
			DefaultHttpClient client = new DefaultHttpClient();
			client.getParams().setParameter(
					CoreConnectionPNames.CONNECTION_TIMEOUT, 15000);
			client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
					15000);
			HttpResponse response = client.execute(getRequest);
			return response.getEntity().getContent();
		} catch (Exception e) {
			message = "Network error";
			XLog.e("error: " + e.toString());
			e.printStackTrace();
		}
		return null;
	}

	
	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

	public InfoHandler getInfoHandler() {
		return infoHandler;
	}

	public void setInfoHandler(InfoHandler infoHandler) {
		this.infoHandler = infoHandler;
	}
	
	public void setRequestType(boolean isUsePostType) {
		this.isUsePostType = isUsePostType;
	}
}
