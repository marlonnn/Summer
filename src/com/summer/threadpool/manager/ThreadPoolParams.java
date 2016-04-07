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
 * @Description:单个线程池参数配置
 * @author wen zhong
 * @Date: 2016年4月7日 上午11:41:14
 */
public enum ThreadPoolParams {
	/**
	 * json网络请求线程池
	 */
	jsonHttpThreadPool(ThreadPoolConst.THREAD_TYPE_SIMPLE_HTTP,10,40,ThreadPoolConst.KEEP_ALIVE_TIME, 10000, false),
	
	/**
	 * 文件传输线程池
	 */
	fileHttpThreadPool(ThreadPoolConst.THREAD_TYPE_FILE_HTTP,15,40,ThreadPoolConst.KEEP_ALIVE_TIME, 10000, false),
	
	/**
	 * 工作线程池
	 */
	workThreadPool(ThreadPoolConst.THREAD_TYPE_WORK,10,40,ThreadPoolConst.KEEP_ALIVE_TIME, 10000, false),
	
	/**
	 * 其他线程
	 */
	othersThreadPool(ThreadPoolConst.THREAD_TYPE_OTHERS,10,10,ThreadPoolConst.KEEP_ALIVE_TIME, 10000, false);
	
	/**
	 * 核心线程大小:线程池中存在的线程数，包括空闲线程(就是还在存活时间内，没有干活，等着任务的线程)
	 */
	private int corePoolSize = 0;
	
	/**
	 * 线程池维护线程的最大数量,当基础线程池以及队列都满了的情况继续创建新线程
	 */
	private int maximumPoolSize = 0;
	
	/**
	 * 线程池维护线程所允许的空闲时间,空闲时间超出该值则移除
	 */
	private long keepAliveTime = 0;
	
	/**
	 * 线程池类型
	 */
	private int type = 0;
	
	/**
	 * 线程池所使用的缓冲队列
	 */
	private int poolQueueSize = 0;
	
	/**
	 * 是否可以超时
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
