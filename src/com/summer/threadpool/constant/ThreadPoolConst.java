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
 * @Description:线程池参数常量
 * @author wen zhong
 * @Date: 2016年4月7日 上午11:41:14
 */
public class ThreadPoolConst {
	
	/**
	 * 普通工作线程池
	 */
	public static final int THREAD_TYPE_WORK = 0;
	
	/**
	 * 接口请求线程池
	 */
	public static final int THREAD_TYPE_SIMPLE_HTTP = 1;
	
	/**
	 * 文件传输线程池
	 */
	public static final int THREAD_TYPE_FILE_HTTP = 2;
	
	/**
	 * 其他线程池
	 */
	public static final int THREAD_TYPE_OTHERS = 3;
	
	/**
	 * 空闲线程存活时间,5秒
	 */
	public static final long KEEP_ALIVE_TIME = 5000;

	/**
	 * 有界队列长度
	 */
	public final static int DEFAULT_WORK_QUEUE_SIZE = 10;

}
