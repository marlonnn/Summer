package com.summer.json;

import java.lang.reflect.Type;

import com.summer.utils.JsonUtil;

public class Entity<T> extends BaseEntity{

	private T data;
	
	public Entity() {
	}
	
	public Entity(String msg, String status) {
		super(msg, status);
	}
	
	public static <T> Entity<T> parse(String json, Type type) {
		try {
			return JsonUtil.getObject(json, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Entity<T> result = new Entity<T>("Data format error", "2");
		return result;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
