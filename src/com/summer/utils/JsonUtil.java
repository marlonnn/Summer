package com.summer.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.summer.logger.Logger;

/**
 * Json util
 * @author wen zhong
 *
 */
public class JsonUtil {
	public static Gson gson;

	static {
		gson = new Gson();
	}
	
	public static List<NameValuePair> requestForNameValuePair(
			HashMap<String, String> valueMap) {
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : valueMap.entrySet()) {
				params.add(new BasicNameValuePair(entry.getKey(), entry
						.getValue()));
			}
			return params;
		} catch (Exception e) {
			Logger.t("jsonUtil").e(e, e.getMessage());
		}
		return null;
	}
	
	public static HashMap<String, String> object2HashMap(Object value) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		String jsonString = toString(value);
		JSONObject object;
		try {
			object = new JSONObject(jsonString);
			hashMap = JsonObject2HashMap(object);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return hashMap;
	}
	
	public static HashMap<String, String> JsonObject2HashMap(JSONObject jo) {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (@SuppressWarnings("unchecked")
		Iterator<String> keys = jo.keys(); keys.hasNext();) {
			try {
				String key1 = keys.next();
				hashMap.put(key1, jo.getString(key1));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hashMap;
	}
	
	/**
	 * json to object
	 * @param jsonStr
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public static <T> T getObject(String jsonStr, Class<T> t) throws Exception {
		return gson.fromJson(jsonStr, t);
	}
	
	/**
	 * json to object
	 * @param jsonStr
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static <T> T getObject(String jsonStr, Type type) throws Exception {
		return gson.fromJson(jsonStr, type);
	}

	/**
	 * object to json string
	 * @param t
	 * @return
	 */
	public static String toString(Object t) {
		return gson.toJson(t);
	}
}
