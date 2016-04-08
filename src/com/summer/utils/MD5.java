package com.summer.utils;

import java.security.MessageDigest;

import com.summer.logger.Logger;

import android.util.Log;


public class MD5 {
	public static MD5 getInstance(){
		return new MD5();
	}
	public  String getMd5(String str) {
		String[] ss = {str};
		String md5="";
	    for(int i=0;i<ss.length;i++){
	     md5 +=get(ss[i]);
	    }
	    md5 = md5.toLowerCase();
	    return md5;
	}
	
	public String get(String s){
		try {
	     	byte[] btInput = s.getBytes();
	     	MessageDigest mdInst = MessageDigest.getInstance("MD5");
	     	mdInst.update(btInput);
	     	byte[] md = mdInst.digest();
	     	StringBuffer sb = new StringBuffer();
	     	for (int i = 0; i < md.length; i++) {
	     		int val = md[i] & 0xff;
	     		if (val < 16)
	     			sb.append("0");
	      			sb.append(Integer.toHexString(val));
	     	}
	     	return sb.toString();
	    } catch (Exception e) {
	    	Logger.t("MD5").e(e,e.toString());
	     	return null;
	    }
	}
}
