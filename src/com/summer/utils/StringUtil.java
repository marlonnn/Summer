package com.summer.utils;

import java.text.DecimalFormat;

public class StringUtil {
	/**
	 * ������ַ���
	 * 
	 * @param str
	 * @return String
	 */
	public static String doEmpty(String str) {
		return doEmpty(str, "");
	}

	/**
	 * ������ַ���
	 * 
	 * @param str
	 * @param defaultValue
	 * @return String
	 */
	public static String doEmpty(String str, String defaultValue) {
		if (str == null || str.equalsIgnoreCase("null")
				|| str.trim().equals("") || str.trim().equals("����ѡ��")) {
			str = defaultValue;
		} else if (str.startsWith("null")) {
			str = str.substring(4, str.length());
		}
		return str.trim();
	}

	/**
	 * ��ѡ��
	 */
	final static String PLEASE_SELECT = "��ѡ��...";

	public static boolean notEmpty(Object o) {
		return o != null && !"".equals(o.toString().trim())
				&& !"null".equalsIgnoreCase(o.toString().trim())
				&& !"undefined".equalsIgnoreCase(o.toString().trim())
				&& !PLEASE_SELECT.equals(o.toString().trim());
	}

	public static boolean empty(Object o) {
		return o == null || "".equals(o.toString().trim())
				|| "null".equalsIgnoreCase(o.toString().trim())
				|| "undefined".equalsIgnoreCase(o.toString().trim())
				|| PLEASE_SELECT.equals(o.toString().trim());
	}

	public static boolean num(Object o) {
		int n = 0;
		try {
			n = Integer.parseInt(o.toString().trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (n > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean decimal(Object o) {
		double n = 0;
		try {
			n = Double.parseDouble(o.toString().trim());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (n > 0.0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��JID�����û���
	 * 
	 * @param Jid
	 * @return
	 */
	public static String getUserNameByJid(String Jid) {
		if (empty(Jid)) {
			return null;
		}
		if (!Jid.contains("@")) {
			return Jid;
		}
		return Jid.split("@")[0];
	}

	/**
	 * ���û�������JID
	 * 
	 * @param jidFor
	 *            ����//��ahic.com.cn
	 * @param userName
	 * @return
	 */
	public static String getJidByName(String userName, String jidFor) {
		if (empty(jidFor) || empty(jidFor)) {
			return null;
		}
		return userName + "@" + jidFor;
	}

	/**
	 * ���û�������JID,ʹ��Ĭ������ahic.com.cn
	 * 
	 * @param userName
	 * @return
	 */
	public static String getJidByName(String userName) {
		String jidFor = "ahic.com.cn";
		return getJidByName(userName, jidFor);
	}

	/**
	 * ���ݸ�����ʱ���ַ����������� �� ʱ �� ��
	 * 
	 * @param allDate
	 *            like "yyyy-MM-dd hh:mm:ss SSS"
	 * @return
	 */
	public static String getMonthTomTime(String allDate) {
		return allDate.substring(5, 19);
	}

	/**
	 * ���ݸ�����ʱ���ַ����������� �� ʱ �� �µ�����
	 * 
	 * @param allDate
	 *            like "yyyy-MM-dd hh:mm:ss SSS"
	 * @return
	 */
	public static String getMonthTime(String allDate) {
		return allDate.substring(5, 16);
	}

	public static String getCity(String s) {
		String[] strings = s.split("-");
		String city = strings[0];

		if (city.indexOf("��") <= 0 && strings.length > 1) {
			city = strings[1];
		}

		return city;
	}

	public static String getSounty(String s) {
		String[] strings = s.split("-");
		String sounty = s;
		if (strings.length > 1) {
			sounty = strings[strings.length - 2] + strings[strings.length - 1];
		}
		if (sounty.indexOf("��") == sounty.length() - 1) {
			sounty = "";
		}
		if (sounty.indexOf("��Ͻ��") >= 0 && sounty.length() > 3) {
			sounty = sounty.substring(sounty.indexOf("��Ͻ��") + 3);
		}
		if (sounty.indexOf("��") >= 0) {
			sounty = sounty.substring(0, sounty.indexOf("��"));
		}
		return sounty;
	}

	/**
	 * �ٶȵ�ͼ����ת��
	 * 
	 * @param distance
	 * @return
	 */
	public static String distanceFormatter(int distance) {
		if (distance < 1000) {
			return distance + "��";
		} else if (distance % 1000 == 0) {
			return distance / 1000 + "����";
		} else {
			DecimalFormat df = new DecimalFormat("0.0");
			int a1 = distance / 1000; // ʮλ

			double a2 = distance % 1000;
			double a3 = a2 / 1000; // �õ���λ

			String result = df.format(a3);
			double total = Double.parseDouble(result) + a1;
			return total + "����";
		}
	}

	/**
	 * �ٶȵ�ͼʱ��ת��
	 * 
	 * @param minute
	 * @return
	 */
	public static String timeFormatter(int minute) {
		if (minute < 3600) {
			return minute / 60 + "����";
		} else if (minute % 3600 == 0) {
			return minute / 3600 + "Сʱ";
		} else {
			int hour = minute / 3600;
			int minute1 = (minute % 3600) / 60;
			return hour + "Сʱ" + minute1 + "����";
		}

	}
}
