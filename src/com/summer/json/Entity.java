package com.summer.json;

import java.lang.reflect.Type;

import com.summer.utils.JsonUtil;

public class Entity<T>{
	
	private String msg;

	private String status;
	
	private T data;
	
	public Entity() {
	}
	
	public Entity(String msg, String status) {
		super();
		this.msg = msg;
		this.status = status;
	}
	
	public String getMessage() {
		return msg;
	}

	public void setMessage(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
