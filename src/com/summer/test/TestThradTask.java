package com.summer.test;

import com.summer.task.BaseTaskObject;

public class TestThradTask extends BaseTaskObject{
	
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
