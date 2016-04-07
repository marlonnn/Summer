package com.summer.utils;

import java.lang.reflect.Type;

import com.google.gson.Gson;

public class JsonUtil {
	public static Gson gson;

	static {
		gson = new Gson();
	}
	
	/**
	 * json�ַ���ת�����򵥶���
	 * @param jsonStr
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public static <T> T getObject(String jsonStr, Class<T> t) throws Exception {
		return gson.fromJson(jsonStr, t);
	}
	
	/**
	 * json�ַ���ת�������Ӷ���
	 * @param jsonStr
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public static <T> T getObject(String jsonStr, Type type) throws Exception {
		return gson.fromJson(jsonStr, type);
	}

	public static String toString(Object t) {
		return gson.toJson(t);
	}
}
