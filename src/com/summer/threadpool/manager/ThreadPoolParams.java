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
 * @ClassName: ThreadPoolParams
 * @Description:single task params
 * @author wen zhong
 * @Date: 2016/4/7 16:41:14 PM
 */
public enum ThreadPoolParams {
	/**
	 * json thread pool
	 */
	jsonHttpThreadPool(ThreadPoolConst.THREAD_TYPE_SIMPLE_HTTP,10,40,ThreadPoolConst.KEEP_ALIVE_TIME, 10000, false),
	
	/**
	 * file http thread pool
	 */
	fileHttpThreadPool(ThreadPoolConst.THREAD_TYPE_FILE_HTTP,15,40,ThreadPoolConst.KEEP_ALIVE_TIME, 10000, false),
	
	/**
	 * work thread pool
	 */
	workThreadPool(ThreadPoolConst.THREAD_TYPE_WORK,10,40,ThreadPoolConst.KEEP_ALIVE_TIME, 10000, false),
	
	/**
	 * others thread pool
	 */
	othersThreadPool(ThreadPoolConst.THREAD_TYPE_OTHERS,10,10,ThreadPoolConst.KEEP_ALIVE_TIME, 10000, false);
	
	/**
	 * The core thread size: the number of threads in the thread pool, 
	 * including the idle thread (that is still without work in survival time, waiting for the thread)
	 */
	private int corePoolSize = 0;
	
	/**
	 * The maximum number of threads maintained by the thread pool, 
	 * where the underlying thread pool and continues to create a new thread that queues are full
	 */
	private int maximumPoolSize = 0;
	
	/**
	 * Maintained by the thread pool thread the free time allowed, 
	 * the idle time exceeds this value are removed
	 */
	private long keepAliveTime = 0;
	
	/**
	 * thread pool type
	 */
	private int type = 0;
	
	/**
	 * pool queue size
	 */
	private int poolQueueSize = 0;
	
	/**
	 * whether can time out
	 */
	private boolean allowCoreThreadTimeOut = true;
	
	private ThreadPoolParams(int type, int corePoolSize,int maximumPoolSize,long keepAliveTime, int poolQueueSize, boolean allowCoreThreadTimeOut)
	{
		this.type = type;
		this.corePoolSize = corePoolSize;
		this.maximumPoolSize = maximumPoolSize;
		this.keepAliveTime = keepAliveTime;
		this.poolQueueSize = poolQueueSize;
		this.allowCoreThreadTimeOut = allowCoreThreadTimeOut;
	}
	
	public static ThreadPoolParams getInstance(int type)
	{
		for(ThreadPoolParams threadPoolParams : ThreadPoolParams.values())
		{
			if(type == threadPoolParams.getType())
			{
				return threadPoolParams;
			}
		}
		return ThreadPoolParams.othersThreadPool;
	}

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public int getMaximumPoolSize() {
		return maximumPoolSize;
	}

	public void setMaximumPoolSize(int maximumPoolSize) {
		this.maximumPoolSize = maximumPoolSize;
	}

	public long getKeepAliveTime() {
		return keepAliveTime;
	}

	public void setKeepAliveTime(long keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getPoolQueueSize() {
		return poolQueueSize;
	}

	public void setPoolQueueSize(int poolQueueSize) {
		this.poolQueueSize = poolQueueSize;
	}

	public boolean isAllowCoreThreadTimeOut() {
		return allowCoreThreadTimeOut;
	}

	public void setAllowCoreThreadTimeOut(boolean allowCoreThreadTimeOut) {
		this.allowCoreThreadTimeOut = allowCoreThreadTimeOut;
	}
}
