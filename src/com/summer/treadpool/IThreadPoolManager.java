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
package com.summer.treadpool;

import com.summer.task.BaseTaskObject;


/**
 * @ClassName: IThreadPoolManager
 * @Description:Thread pool manager interface
 * @author wen zhong
 * @Date: 2016/4/7 16:41:14 PM
 *
 */
public interface IThreadPoolManager {
	/**
	 * Add a thread to thread pool
	 * @param task task
	 */
	public void addTask(BaseTaskObject task);
	
	/**
	 * 
	 * @description:Get certain type thread pool
	 * @param @param ThreadPoolType
	 * @return BaseThreadPool
	 * @throws
	 */
	public BaseThreadPool getThreadPool(int threadPoolType);
	
	/**
	 * @Description Remove task
	 * @param task 
	 * @return 
	 */
	public boolean removeTask(BaseTaskObject task);
	
	/**
	 * @Description Stop all task
	 */
	public void stopAllTask();
}
