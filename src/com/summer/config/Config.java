package com.summer.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.client.CookieStore;
import com.summer.entity.User;
import com.summer.logger.XLog;

import android.content.Context;
import android.graphics.Typeface;

public class Config {

	public static Context maincontext;
	
    public static final String ADDRESS = "http://app.haimianyu.cn/index.php";
    
	//΢��֧��
	public static final String URLSTRING = "http://app.haimianyu.cn/wxpay/wxpay.php";
	
	//������ɲ�ѯ
	public static final String URLQUERY = "http://app.haimianyu.cn/index.php?_mod=wxpay&_act=query";
	
	//Ӧ��ID
	public static final String APP_ID = "wx2044b77eca1acb02";
	
	//�̻���
	public static final String MCH_ID = "1321312601";
	
	//��Ʒ��֧������Ҫ����
    public static final String BODY = "���������";
    
    //��չ�ֶ� ʱ���������ӿڹ���-�����涨
    public static final String PACKAGE = "Sign=WXPay";
    
    
    public static User User;
    
	// Loading Font Face
	public static Typeface tf = null;

    /**
     * ��¼
     */
    public static final int LOGIN_TYPE = -1;

    /**
     * �ն�����
     */
    public static final int POS = 1;

    /**
     * ������֤��
     */
    public static final int VERIFY = 1;
    /**
     * ע��
     */
    public static final int REGISTER = 2;
    /**
     * ��������
     */
    public static final int forget_password = 3;
    /**
     *
     ������Ϣ���ǳơ��ȼ�����ҡ�������Ϣ��
     **/
    public static final int personal_information = 4;
    /**
     * ǩ��
     **/
    public static final int sign_in = 5;
    /**
     * ������
     **/
    public static final int activities = 6;
    /**
     * ��ֵ
     **/
    public static final int top_up = 7;
    /**
     * ������Ϣ
     **/
    public static final int star_information = 8;
    /**
     * ���������ȵ���
     **/
    public static final int give_applause_booed = 9;
    /**
     * �ӹ�ע
     **/
    public static final int and_attention = 10;
    /**
     * �����б�
     **/
    public static final int friends_list = 11;
    /**
     * ��ӣ��ж��Ƿ�Ϊƽ̨�û�����ɾ������
     **/
    public static final int add_buddy = 12;
    /**
     * ���Ƿ�����Ϣ�б�
     **/
    public static final int stars_release_information_list = 13;
    /**
     * ���Ƿ�����Ϣ����
     **/
    public static final int star_release_information_details = 14;
    /**
     * ���Ƚ������б���������ͽ�����������ע������������ע��ʱ��������
     **/
    public static final int in_comparison_to_listApply_to_be_a_platform_star_ = 15;
    /**
     * ��Ʒ�б�
     **/
    public static final int goods_list = 16;
    /**
     * �������ң��һ�
     **/
    public static final int for_goods = 17;
    /**
     * ������Ʒ��ֻ�������ܲ�����
     **/
    public static final int release_goods = 18;
    /**
     * �����б�
     **/
    public static final int list_of_orders = 19;
    /**
     * ������
     **/
    public static final int order_management = 20;
    /**
     * �����б�
     **/
    public static final int hold_list = 21;
    /**
     * �����б�
     **/
    public static final int a_list = 22;
    /**
     * ��Ʒ�嵥
     **/
    public static final int the_prize_list = 23;
    /**
     * �齱����ύ
     **/
    public static final int lottery_results_submitted = 24;
    /**
     * �ѹ�ע�����б�
     **/
    public static final int has_concerned_star_list = 25;
    /**
     * �༭������Ϣ���Ƿ�����Ϊ���ǣ�
     **/
    public static final int edit_personal_information = 26;
    /**
     * ������
     **/
    public static final int photo_album_management = 27;
    /**
     * �༭���
     **/
    public static final int edit_photo_albums = 28;
    /**
     * ���վ���
     **/
    public static final int her_career = 29;
    /**
     * �༭���վ���
     **/
    public static final int editor_of_her_career = 30;
    /**
     * �ⲿ���ӣ�ͼ�ꡢ���⡢���ӣ�
     **/
    public static final int external_links = 31;
    /**
     * �༭�ⲿ����
     **/
    public static final int edit_external_links = 32;
    /**
     * ������Ϣ
     **/
    public static final int business_information = 33;
    /**
     * �༭������Ϣ
     **/
    public static final int edit_business_information = 34;
    /**
     * ��۶���
     **/
    public static final int value_pricing = 35;
    /**
     * ���ͣ��������ң�
     **/
    public static final int give = 36;
    /**
     * ����
     **/
    public static final int comment = 37;
    /**
     * ǩ��
     **/
    public static final int continuous = 40;
    /**
     * ����
     **/
    public static final int search = 41;
    /**
     * �������
     **/
    public static final int feedback = 42;
    /**
     * ���׼�¼
     **/
    public static final int account = 43;
    /**
     * ����Ȩ�濨
     **/
    public static final int make_equity_card = 45;
    /**
     * ��ȡȨ�濨�б�
     **/
    public static final int equitylists = 46;
    /**
     * �Ϲ�Ȩ�濨
     **/
    public static final int subscribe = 47;
    /**
     * �ҵ�Ȩ�濨����ͨ�û���
     **/
    public static final int my_rights = 48;
    /**
     * �ҵ�Ȩ�濨�������û���
     **/
    public static final int my_rights_star = 49;
    /**
     * Ȩ��״̬���
     **/
    public static final int changeState = 50;
    /**
     * ��ȡ�ⲿ����
     **/
    public static final int outconnect = 51;
    /**
     * ����ⲿ��
     **/
    public static final int addoutconnect = 52;
    /**
     * ɾ���ⲿ����
     **/
    public static final int dltoutconnect = 53;
    /**
     * �޸��ⲿ����
     **/
    public static final int updateoutconnect = 54;
    /**
     * ��������
     **/
    public static final int contribution = 55;
    /**
     * ��K��K
     **/
    public static final int k_line_graph = 56;
    /**
     * ��ֵ
     **/
    public static final int recharge_success = 57;

    /**
     * ��Ϊͷ��
     **/
    public static final int image = 58;


    /**
     * ɾ����Ƭ
     **/
    public static final int delete_picture = 59;

    /**
     * ΢��Ԥ֧��
     */
    public static final int wx_pre_pay = 60;

    /**
     * ΢��֧���ɹ�
     */
    public static final int wx_pay = 61;
    
    /**
     * ��Ƶֱ����ѯ
     */
    public static final int query_video = 62;
    
    /**
     * ����ֱ����
     */
    public static final int create_video = 63;
    
    /**
     * ����ֱ��Ƶ����ֱ��״̬
     */
    public static final int update_status = 64;
    
    /**
     * ��������������
     */
    public static final int update_room = 65;
    
    /**
     * ������������
     */
    public static final int send_gift = 66;
    
    /**
     * ��ѯ��Ʊ
     */
    public static final int query_piao = 67;
    
    /**
     * ��ѯ����ֱ�����б�
     */
    public static final int video_list = 68;
    
    /**
     * ��ѯֱ�����״̬
     */
    public static final int query_video_status = 69;
    
    /**
     * ��Ʊ�һ�
     */
    public static final int exchange_piao = 70;
    
    
    //΢��֧��
    public static final int PAY_WX =0x11;
    
    //֧����֧��
    public static final int PAY_ALI =0x12;
    
    //Ԥ֧���쳣
    public static final int WX_EXCEPTION_ERROR = 0x06;
    
    public static boolean hasloadConfig = false;
    
    private static String fileDir = "";
    
    private static String cachePath = "";
    
    private static final String cfgname = "/sales.cfg";
    
	private static String password = "";
	
	private static String phoneNum = "";
	
	private static boolean isSavePsw = false;
	
	private static boolean isLogin = false;
	
	public static final String KPassword = "password";
	
	public static final String KPhoneNum = "phonenum";
	
	public static CookieStore cookieStore = null;
	
	private static int state = 0;
	
	public static int getState() {
		return state;
	}

	public static void setState(int state) {
		Config.state = state;
	}

	public static boolean isLogin() {
		return isLogin;
	}
	
	public static void setFileDir(String path) {

		fileDir = path;
	}

	public static void setCachePath(String path) {

		cachePath = path;
	}

	public static String getCachePath() {

		return cachePath;
	}

	public static String getFileDir() {

		return fileDir;
	}

	public static boolean isSavePsw() {
		return isSavePsw;
	}

	public static void setSavePsw(boolean isSavePsw) {
		Config.isSavePsw = isSavePsw;
		Config.saveConfig();
	}

	public static String getPhoneNum() {
		return phoneNum;
	}

	public static void setPhoneNum(String phoneNo) {
		phoneNum = phoneNo;
	}

	public static void setPassword(String passwordString) {
		password = passwordString;
	}

	public static void clearPassword() {
		password = "";
		saveConfig();
	}

	public static void saveUser(String phone, String pwd) {
		if (phone == null || pwd == null) {
			return;
		}
		phoneNum = phone;
		password = pwd;
		Config.saveConfig();
	}

	public static String getPassword() {
		return password;
	}
    
	/**
	 * Load config from local file
	 */
    public static void LoadConfig() 
    {
		hasloadConfig = true;
		FileInputStream stream = null;
		String filename = Config.fileDir + Config.cfgname;
		
		try {
			File file = new File(filename);
			if (!file.exists()) {
				file.createNewFile();
			}

			stream = new FileInputStream(filename);
			Properties properties = new Properties();
			properties.load(stream);
			Config.password = properties.getProperty(KPassword, "");
			Config.phoneNum = properties.getProperty(KPhoneNum, "");
			String w = properties.getProperty("isSavePsw", "false");
			Config.isSavePsw = Boolean.valueOf(w).booleanValue();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			XLog.e(e.getMessage(), e);
		} catch (IOException e) {
			e.printStackTrace();
			XLog.e(e.getMessage(), e);
		}finally {
			if (stream != null) {
				try {
					stream.close();
					stream = null;
				} catch (IOException e) {
					XLog.e(e.getMessage(), e);
				}
			}
		}
    }
    
	public static void saveConfig() {
		Properties properties = new Properties();
		properties.setProperty(Config.KPhoneNum,
				String.valueOf(Config.phoneNum));
		properties.setProperty(Config.KPassword,
				String.valueOf(Config.password));
		properties.setProperty("cookieStore",
				String.valueOf(Config.cookieStore));
		properties.setProperty("isSavePsw", String.valueOf(Config.isSavePsw));
		FileOutputStream stream = null;
		String filename = Config.fileDir + Config.cfgname;
		try {

			File f = new File(filename);
			if (!f.exists()) {
				File dir = new File(Config.fileDir);
				dir.mkdirs();
				f.createNewFile();
			}
			stream = new FileOutputStream(f);
			properties.store(stream, "");
		} catch (FileNotFoundException e) {
			XLog.e("saveConfig" + e.toString(), e);
		} catch (Exception e) {
			XLog.e("saveConfig" + e.toString(), e);
		} finally {
			if (stream != null) {
				try {
					stream.close();
					stream = null;
				} catch (IOException e) {
					XLog.e("saveConfig" + e.toString(), e);
				}
			}
		}
	}

}
