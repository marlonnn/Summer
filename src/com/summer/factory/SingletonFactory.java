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
package com.summer.factory;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.summer.logger.Logger;

/**
 *  
 * @ClassName: ThreadPoolFactory
 * @Description:Singleton factory
 * @author wen zhong
 * @Date: 2016/4/7 13:41:14
 *
 */
public class SingletonFactory {
	private static final String TAG = SingletonFactory.class.getSimpleName();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Map<String, Object> objectCache = Collections
			.synchronizedMap(new HashMap());

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getInstance(Class<T> clazz) 
	{
		Object result = null;
		synchronized (SingletonFactory.class) {
			if (objectCache == null) {
				objectCache = Collections.synchronizedMap(new HashMap());
			}
		}

		synchronized (objectCache) {
			result = objectCache.get(clazz.getName());
			if (result == null) {
				result = createInstance(clazz);

				if (result != null) {
					objectCache.put(clazz.getName(), result);
				}
			}
		}

		return (T) result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getInstance(Class<T> clazz, Class<?>[] parameterTypes,
			Object[] paramValues) {
		String key = clazz.getName();
		Object result = null;
		synchronized (SingletonFactory.class) {
			if (objectCache == null) {
				objectCache = Collections.synchronizedMap(new HashMap());
			}

		}

		synchronized (objectCache) {
			if (paramValues != null) {
				for (int nIndex = 0; nIndex < paramValues.length; nIndex++) {
					key = key + "|";
					key = key + paramValues[nIndex].toString();
				}
			}

			result = objectCache.get(key);
			if (result == null) {
				result = createInstance(clazz, parameterTypes, paramValues);

				if (result != null) {
					objectCache.put(key, result);
				}
			}
		}

		return (T) result;
	}

	private static <T> T createInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			Logger.t(TAG).e("Failed to create instalce!" + e.toString());
			return null;
		} catch (IllegalAccessException e) {
			Logger.t(TAG).e("Failed to create instalce!" + e.toString());
		}
		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> T createInstance(Class<T> clazz,
			Class<?>[] parameterTypes, Object[] paramValues) {
		try {
			Constructor constructor = clazz.getConstructor(parameterTypes);

			return (T) constructor.newInstance(paramValues);
		} catch (InstantiationException e) {
			Logger.t(TAG).e("Failed to create instalce!" + e.toString());
			return null;
		} catch (Exception e) {
			Logger.t(TAG).e("Failed to create instalce!" + e.toString());
		}
		return null;
	}

	public static void releaseCache() {
		if (objectCache != null) {
			objectCache.clear();
		}
	}

	protected void finalize() throws Throwable {
		releaseCache();
		super.finalize();
	}
}
