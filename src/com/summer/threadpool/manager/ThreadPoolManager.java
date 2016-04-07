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
 * @Description:�̳߳ع�����
 * @author wen zhong
 * @Date: 2016��4��7�� ����11:41:14
 *
 */
public class ThreadPoolManager implements IThreadPoolManager{
	
	/**
	 * ��ͬ���͵��̳߳أ�����ͬʱ�������̳߳�
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
				//ָ�����͵��̳߳ز������򴴽�һ���µ�
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
			//ָ�����͵��̳߳ز������򴴽�һ���µ�
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
					threadPool.shutdownNow();//��ͼֹͣ��������ִ�е��̣߳����ٴ����ڳض����еȴ�������
				}
			}
			
			threadPoolMap.clear();
		}
	}
}
