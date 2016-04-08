package com.summer.test;

import com.summer.threadpool.task.ThreadTaskObject;

public class TestThradTask extends ThreadTaskObject{
	
	public TestThradTask()
	{
		super();
	}
	
	public TestThradTask(int threadPoolType)
	{
		super(threadPoolType);
	}
	
	public TestThradTask(int threadPoolType, String threadTaskName)
	{
		super(threadPoolType, threadTaskName);
	}

	@Override
	public void run() {
		super.run();
		System.out.print("threadPoolType: " + threadPoolType + " taskName: " + taskName + "\n");
	}
}
