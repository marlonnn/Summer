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
 * @Description:thread pool manager
 * @author wen zhong
 * @Date: 2016/4/7 16:41:14 PM
 *
 */
public class ThreadPoolManager implements IThreadPoolManager{
	
	/**
	 * Different type of thread poll
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
					threadPool.shutdownNow();
				}
			}
			
			threadPoolMap.clear();
		}
	}
}
