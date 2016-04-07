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

import com.summer.threadpool.interfaces.IThreadPoolManager;
import com.summer.threadpool.manager.ThreadPoolManager;

/**
 * 
 * @ClassName: ThreadPoolFactory
 * @Description:线程池工厂
 * @author wen zhong
 * @Date: 2016年4月7日 上午11:41:14
 *
 */
public class ThreadPoolFactory {
	public static IThreadPoolManager getThreadPoolManager()
	{
		return SingletonFactory.getInstance(ThreadPoolManager.class);
	}

}
