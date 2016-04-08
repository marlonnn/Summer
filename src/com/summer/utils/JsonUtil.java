package com.summer.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;

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
