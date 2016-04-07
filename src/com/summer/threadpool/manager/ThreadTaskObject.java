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

import com.summer.threadpool.constant.ThreadPoolConst;

/**
 * @ClassName: ThreadTaskObject
 * @Description:基本线程任务，未统一管理，业务中使用的线程都需要继承该类
 * @author wen zhong
 * @Date: 2016年4月7日 上午11:41:14
 *
 */
public class ThreadTaskObject implements Runnable{
	
	/**
	 * 线程池类型
	 */
	protected int threadPoolType;
	
	protected String taskName = null;
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public int getThreadPoolType()
	{
		return threadPoolType;
	}
	
	public ThreadTaskObject(int threadPoolType, String threadTaskName)
	{
		initThreadTaskObject(threadPoolType, threadTaskName);
	}
	
	public ThreadTaskObject(int threadPoolType)
	{
		initThreadTaskObject(threadPoolType, this.toString());
	}
	
	/**
	 * 在默认线程池中执行
	 */
	public ThreadTaskObject()
	{
		initThreadTaskObject(ThreadPoolConst.THREAD_TYPE_WORK, this.toString());
	}
	
	/**
	 * 初始化线程任务
	* @param threadPoolType 线程池类型
	 * @param threadTaskName 线程任务名称
	 */
	private void initThreadTaskObject(int threadPoolType, String threadTaskName)
	{
		this.threadPoolType = threadPoolType;
		String name = ThreadPoolParams.getInstance(threadPoolType).name();
		if(threadTaskName != null)
		{
			name = name + "_" + threadTaskName;
		}
		
		setTaskName(name);
	}

	@Override
	public void run() {
		//执行线程任务
	}

	
}
