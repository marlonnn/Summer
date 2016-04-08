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
package com.summer.threadpool.constant;

/***
 * @ClassName: ThreadPoolConst
 * @Description:Thread pool params
 * @author wen zhong
 * @Date: 2016/4/7 16:41:14 PM
 */
public class ThreadPoolConst {
	
	/**
	 * Normal thread
	 */
	public static final int THREAD_TYPE_WORK = 0;
	
	/**
	 * Http thread
	 */
	public static final int THREAD_TYPE_SIMPLE_HTTP = 1;
	
	/**
	 * File thread
	 */
	public static final int THREAD_TYPE_FILE_HTTP = 2;
	
	/**
	 * Others thread
	 */
	public static final int THREAD_TYPE_OTHERS = 3;
	
	/**
	 * Idle alive time 5s
	 */
	public static final long KEEP_ALIVE_TIME = 5000;

	/**
	 * Limited queue size
	 */
	public final static int DEFAULT_WORK_QUEUE_SIZE = 10;

}
