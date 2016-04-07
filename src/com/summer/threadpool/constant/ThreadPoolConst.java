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
 * @Description:�̳߳ز�������
 * @author wen zhong
 * @Date: 2016��4��7�� ����11:41:14
 */
public class ThreadPoolConst {
	
	/**
	 * ��ͨ�����̳߳�
	 */
	public static final int THREAD_TYPE_WORK = 0;
	
	/**
	 * �ӿ������̳߳�
	 */
	public static final int THREAD_TYPE_SIMPLE_HTTP = 1;
	
	/**
	 * �ļ������̳߳�
	 */
	public static final int THREAD_TYPE_FILE_HTTP = 2;
	
	/**
	 * �����̳߳�
	 */
	public static final int THREAD_TYPE_OTHERS = 3;
	
	/**
	 * �����̴߳��ʱ��,5��
	 */
	public static final long KEEP_ALIVE_TIME = 5000;

	/**
	 * �н���г���
	 */
	public final static int DEFAULT_WORK_QUEUE_SIZE = 10;

}
