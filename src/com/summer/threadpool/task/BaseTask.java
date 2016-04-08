package com.summer.threadpool.task;

import com.summer.threadpool.constant.ThreadPoolConst;
import com.summer.threadpool.manager.ThreadPoolParams;

public abstract class BaseTask implements Runnable{
	
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
	
	public BaseTask(int threadPoolType, String threadTaskName)
	{
		initThreadTaskObject(threadPoolType, threadTaskName);
	}
	
	public BaseTask(int threadPoolType)
	{
		initThreadTaskObject(threadPoolType, this.toString());
	}
	
	/**
	 * execute in default thread pool
	 */
	public BaseTask()
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
