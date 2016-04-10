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
 * @Description Base json entity
 * @author wen zhong
 * @Date: 2016/4/7 13:41:14
 * @param <T>
 */
public class BaseEntity {
	private String msg;

	private String status;

	public BaseEntity() {
	}
	
	public BaseEntity(String msg, String status) {
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

}
