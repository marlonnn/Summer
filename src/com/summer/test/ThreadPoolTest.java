package com.summer.test;

import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;

import com.summer.factory.ThreadPoolFactory;
import com.summer.task.HttpBaseTask;
import com.summer.treadpool.ThreadPoolConst;
import com.summer.utils.JsonUtil;

public class ThreadPoolTest {
	
	private static String url = "http://app.haimianyu.cn/index.php" + "Login";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolFactory.getThreadPoolManager().addTask(new TestThradTask(1, "json测试线程11"));
		ThreadPoolFactory.getThreadPoolManager().addTask(new TestThradTask(2, "http测试线程12"));
		HashMap<String, String> entity = new HashMap<String, String>();
		entity.put("name", "18698583686");
		entity.put("passWord", "123456");
		List<NameValuePair> params = JsonUtil.requestForNameValuePair(entity);
		ThreadPoolFactory.getThreadPoolManager().addTask(
				new HttpBaseTask(ThreadPoolConst.THREAD_TYPE_FILE_HTTP, "loginTask", params, url));
		ThreadPoolFactory.getThreadPoolManager().stopAllTask();
	}

}
