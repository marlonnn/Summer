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
package com.summer.threadpool.manager;

import java.util.HashMap;
import java.util.Map;

import com.summer.threadpool.interfaces.IThreadPoolManager;

import android.annotation.SuppressLint;


/**
 * @ClassName: ThreadPoolManager
 * @Description:线程池管理类
 * @author wen zhong
 * @Date: 2016年4月7日 上午11:41:14
 *
 */
public class ThreadPoolManager implements IThreadPoolManager{
	
	/**
	 * 不同类型的线程池，可以同时管理多个线程池
	 */
	@SuppressLint("UseSparseArrays")
	private final Map<Integer, BaseThreadPool> threadPoolMap = new HashMap<Integer, BaseThreadPool>();

	@Override
	public void addTask(ThreadTaskObject task) {
		if(task != null)
		{
			BaseThreadPool threadPool = null;
			synchronized(threadPoolMap)
			{
				threadPool = threadPoolMap.get(task.getThreadPoolType());
				//指定类型的线程池不存在则创建一个新的
				if (threadPool == null)
				{
					threadPool = new BaseThreadPool(ThreadPoolParams.getInstance(task.getThreadPoolType()));
					threadPoolMap.put(task.getThreadPoolType(), threadPool);
				}
			}

			threadPool.execute(task);
		}
	}

	@Override
	public BaseThreadPool getThreadPool(int threadPoolType) {
		BaseThreadPool threadPool = null;
		synchronized(threadPoolMap)
		{
			threadPool = threadPoolMap.get(threadPoolType);
			//指定类型的线程池不存在则创建一个新的
			if (threadPool == null)
			{
				threadPool = new BaseThreadPool(ThreadPoolParams.getInstance(threadPoolType));
			}
		}
		
		return threadPool;
	}

	@Override
	public boolean removeTask(ThreadTaskObject task) {
		BaseThreadPool threadPool = threadPoolMap.get(task.getThreadPoolType());

		if (threadPool != null)
		{
			return threadPool.remove(task);
		}
		
		return false;
	}

	@Override
	public void stopAllTask() {
		if (threadPoolMap != null)
		{
			for (Integer key : threadPoolMap.keySet())
			{
				BaseThreadPool threadPool = threadPoolMap.get(key);
				
				if (threadPool != null)
				{
					threadPool.shutdownNow();//试图停止所有正在执行的线程，不再处理还在池队列中等待的任务
				}
			}
			
			threadPoolMap.clear();
		}
	}
}
