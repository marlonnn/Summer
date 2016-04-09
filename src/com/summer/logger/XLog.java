package com.summer.logger;

import android.text.TextUtils;
import android.util.Log;

/**
 * Tag Format: customTagPrefix:className
 * when customTagPrefix == null,Tag Format:className
 * @author zhongwen
 *
 */
public class XLog {

    public static String customTagPrefix = "";

    private XLog() {
    }

    public static boolean allowD = true;
    public static boolean allowE = true;
    public static boolean allowI = true;
    public static boolean allowV = true;
    public static boolean allowW = true;
    public static boolean allowWtf = true;

    public static void setLogState(boolean isOpen){
        allowD = allowE = allowI = allowV = allowW = allowWtf = isOpen;
    }

//    private static String generateTag(StackTraceElement caller) {
//        String tag = "%s.%s(L:%d)";
//        String callerClazzName = caller.getClassName();
//        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
//        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
//        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
//        return tag;
//    }
    
    private static String generateTag(StackTraceElement caller) {
        String tag = "%s";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName);
        tag = TextUtils.isEmpty(customTagPrefix) ? tag : customTagPrefix + ":" + tag;
        return tag;
    }
    
    private static String generateCallerInfo(StackTraceElement caller)
    {
    	String call = "<------%s(L:%d)------>";
    	String callerClazzName = caller.getClassName();
    	callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
    	call = String.format(call, caller.getMethodName(), caller.getLineNumber());
    	return call;
    }

    public static CustomLogger customLogger = new CustomLogger() {
        @Override
        public void d(String tag, Object content) {
            Log.d(tag, ignoreContentNull(content));
        }

        @Override
        public void d(String tag, Object content, Throwable tr) {
            Log.d(tag, ignoreContentNull(content), tr);
        }

        @Override
        public void e(String tag, Object content) {
            Log.e(tag, ignoreContentNull(content));
        }

        @Override
        public void e(String tag, Object content, Throwable tr) {
            Log.e(tag, ignoreContentNull(content));
        }

        @Override
        public void i(String tag, Object content) {
            Log.i(tag, ignoreContentNull(content));
        }

        @Override
        public void i(String tag, Object content, Throwable tr) {
            Log.i(tag, ignoreContentNull(content), tr);
        }

        @Override
        public void v(String tag, Object content) {
            Log.v(tag, ignoreContentNull(content));
        }

        @Override
        public void v(String tag, Object content, Throwable tr) {
            Log.d(tag, ignoreContentNull(content), tr);
        }

        @Override
        public void w(String tag, Object content) {
            Log.w(tag, ignoreContentNull(content));
        }

        @Override
        public void w(String tag, Object content, Throwable tr) {
            Log.w(tag, ignoreContentNull(content), tr);
        }

        @Override
        public void w(String tag, Throwable tr) {
            Log.w(tag, tr);
        }

        @Override
        public void wtf(String tag, Object content) {
            Log.wtf(tag, ignoreContentNull(content));
        }

        @Override
        public void wtf(String tag, Object content, Throwable tr) {
            Log.wtf(tag, ignoreContentNull(content), tr);
        }

        @Override
        public void wtf(String tag, Throwable tr) {
            Log.wtf(tag, tr);
        }
    };

    public static String ignoreContentNull(Object content) {
        if (content == null) {
            content = "println need a message";
        }
        return content.toString();
    }

    public static void d(Object content) {
        if (!allowD) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.d(tag, call + content);
    }

    public static void d(Object content, Throwable tr) {
        if (!allowD) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.d(tag, call + content, tr);
    }

    public static void e(Object content) {
        if (!allowE) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.e(tag, call + content);
    }

    public static void e(Object content, Throwable tr) {
        if (!allowE) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.e(tag, call + content, tr);
    }

    public static void i(Object content) {
        if (!allowI) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.i(tag, call + content);
    }

    public static void i(Object content, Throwable tr) {
        if (!allowI) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.i(tag, call + content, tr);
    }

    public static void v(Object content) {
        if (!allowV) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.v(tag, call + content);
    }

    public static void v(Object content, Throwable tr) {
        if (!allowV) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.v(tag, call + content, tr);
    }

    public static void w(Object content) {
        if (!allowW) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.w(tag, call + content);
    }

    public static void w(Object content, Throwable tr) {
        if (!allowW) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.w(tag, call + content, tr);
    }

    public static void w(Throwable tr) {
        if (!allowW) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.w(tag, call + tr);
    }


    public static void wtf(Object content) {
        if (!allowWtf) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        String call = generateCallerInfo(caller);
        customLogger.wtf(tag, call + content);
    }

    public static void wtf(Object content, Throwable tr) {
        if (!allowWtf) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        customLogger.wtf(tag, content, tr);
    }

    public static void wtf(Throwable tr) {
        if (!allowWtf) return;
        StackTraceElement caller = getCallerStackTraceElement();
        String tag = generateTag(caller);
        customLogger.wtf(tag, tr);
    }


    public static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    public interface CustomLogger {
        void d(String tag, Object content);

        void d(String tag, Object content, Throwable tr);

        void e(String tag, Object content);

        void e(String tag, Object content, Throwable tr);

        void i(String tag, Object content);

        void i(String tag, Object content, Throwable tr);

        void v(String tag, Object content);

        void v(String tag, Object content, Throwable tr);

        void w(String tag, Object content);

        void w(String tag, Object content, Throwable tr);

        void w(String tag, Throwable tr);

        void wtf(String tag, Object content);

        void wtf(String tag, Object content, Throwable tr);

        void wtf(String tag, Throwable tr);
    }

}
