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

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.os.Build;


/**
 * @ClassName: BaseThreadPool
 * @Description:基类程池
 * @author wen zhong
 * @Date: 2016年4月7日 上午11:41:14
 *
 */
public class BaseThreadPool extends ThreadPoolExecutor{
	public BaseThreadPool(ThreadPoolParams threadPoolParamter)
	{
		super(threadPoolParamter.getCorePoolSize(), 
				  threadPoolParamter.getMaximumPoolSize(), 
				  threadPoolParamter.getKeepAliveTime(), 
				  TimeUnit.MILLISECONDS, //线程池维护线程所允许的空闲时间的单位
				  new LinkedBlockingDeque<Runnable>(threadPoolParamter.getPoolQueueSize()), //线程池所使用的缓冲队列
				  new ThreadPoolExecutor.CallerRunsPolicy());//线程池对拒绝任务的处理策略,重试添加当前的任务，他会自动重复调用execute()方法
		if (Build.VERSION.SDK_INT > 10) {
			this.allowCoreThreadTimeOut(threadPoolParamter.isAllowCoreThreadTimeOut());
		}
	}

}
