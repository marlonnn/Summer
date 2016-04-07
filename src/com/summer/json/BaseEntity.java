/**
 *  Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package com.summer.json;

import java.lang.reflect.Type;

import com.summer.utils.JsonUtil;

/**
 * @ClassName BaseEntity
 * @Description json实体类，可以解析成对应实体对象
 * @author wen zhong
 * @Date: 2016年4月7日 上午11:41:14
 * @param <T>
 */
public class BaseEntity<T> {
	private String message;

	private String status;

	private T data;

	public BaseEntity() {
	}
	
	public BaseEntity(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public static <T> BaseEntity<T> parse(String json, Type type) {
		try {
			return JsonUtil.getObject(json, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BaseEntity<T> result = new BaseEntity<T>("数据格式错误", "2");
		return result;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
