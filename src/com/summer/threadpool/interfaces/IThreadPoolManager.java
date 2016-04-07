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
package com.summer.threadpool.interfaces;

import com.summer.threadpool.manager.BaseThreadPool;
import com.summer.threadpool.manager.ThreadTaskObject;


/**
 * @ClassName: IThreadPoolManager
 * @Description:线程池管理接口
 * @author wen zhong
 * @Date: 2016年4月7日 上午11:41:14
 *
 */
public interface IThreadPoolManager {
	/**
	 * 往线程池中增加一个线程任务
	 * @param task 线程任务
	 */
	public void addTask(ThreadTaskObject task);
	
	/**
	 * 
	 * @description:获取指定类型的线程池，如果不存在则创建
	 * @param @param ThreadPoolType
	 * @return BaseThreadPool
	 * @throws
	 */
	public BaseThreadPool getThreadPool(int threadPoolType);
	
	/**
	 * @Description 从线程队列中移除一个线程任务
	 * @param task 线程任务
	 * @return 是否移除成功
	 */
	public boolean removeTask(ThreadTaskObject task);
	
	/**
	 * @Description 停止所有任务
	 */
	public void stopAllTask();
}
