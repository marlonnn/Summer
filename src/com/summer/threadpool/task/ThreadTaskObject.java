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
package com.summer.threadpool.task;

import com.summer.threadpool.constant.ThreadPoolConst;
import com.summer.threadpool.manager.ThreadPoolParams;

/**
 * @ClassName: ThreadTaskObject
 * @Description:base thread task, custom thread should extends this
 * @author wen zhong
 * @Date: 2016/4/7 16:41:14 PM
 *
 */
public class ThreadTaskObject implements Runnable{
	
	/**
	 * thread pool type
	 */
	protected int threadPoolType;
	
	protected String taskName = null;
	
	protected String message;
	
	protected int errorCode=-1;
	
	protected boolean isCancel=false;
	
	public boolean IsCancel() {
		
		return isCancel;
	}
	
	public void CancelTask() {
		
		isCancel=true;
	}
	
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
	 * execute in default thread pool
	 */
	public ThreadTaskObject()
	{
		initThreadTaskObject(ThreadPoolConst.THREAD_TYPE_WORK, this.toString());
	}
	
	/**
	 * initialize thread pool task
	* @param threadPoolType 
	 * @param threadTaskName
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
		//execute task
	}

	
}
