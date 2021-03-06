package com.summer.config;

import org.apache.http.client.CookieStore;

import android.content.Context;
import android.graphics.Typeface;

import com.summer.entity.User;

public class Config {

	public static Context maincontext;
	
	public static boolean manualExit = false;
	
	public static final String AthuAddress = "http://app.haimianyu.cn/console/index.php/Check/Index?userid=";
	
    public static final String ADDRESS = "http://app.haimianyu.cn/index.php";
    
	//微信支付
	public static final String URLSTRING = "http://app.haimianyu.cn/wxpay/wxpay.php";
	
	//订单完成查询
	public static final String URLQUERY = "http://app.haimianyu.cn/index.php?_mod=wxpay&_act=query";
	
	//应用ID
	public static final String APP_ID = "wx2044b77eca1acb02";
	
	//商户号
	public static final String MCH_ID = "1321312601";
	
//	//应用ID
//	public static final String APP_ID = "wxb90d68b883edb72f";
//	
//	//商户号
//	public static final String MCH_ID = "1280217801";
	
	//商品或支付单简要描述
    public static final String BODY = "海绵娱娱币";
    
    //扩展字段 时间戳，请见接口规则-参数规定
    public static final String PACKAGE = "Sign=WXPay";
    
    
    public static User User;
    
	// Loading Font Face
	public static Typeface tf = null;

    /**
     * 登录
     */
    public static final int LOGIN_TYPE = -1;

    /**
     * 终端类型
     */
    public static final int POS = 1;

    /**
     * 短信验证码
     */
    public static final int VERIFY = 1;
    /**
     * 注册
     */
    public static final int REGISTER = 2;
    /**
     * 忘记密码
     */
    public static final int forget_password = 3;
    /**
     *
     个人信息（昵称、等级、娱币、基本信息）
     **/
    public static final int personal_information = 4;
    /**
     * 签到
     **/
    public static final int sign_in = 5;
    /**
     * 活动、广告
     **/
    public static final int activities = 6;
    /**
     * 充值
     **/
    public static final int top_up = 7;
    /**
     * 明星信息
     **/
    public static final int star_information = 8;
    /**
     * 给掌声、喝倒彩
     **/
    public static final int give_applause_booed = 9;
    /**
     * 加关注
     **/
    public static final int and_attention = 10;
    /**
     * 好友列表
     **/
    public static final int friends_list = 11;
    /**
     * 添加（判断是否为平台用户）、删除好友
     **/
    public static final int add_buddy = 12;
    /**
     * 明星发布信息列表
     **/
    public static final int stars_release_information_list = 13;
    /**
     * 明星发布信息详情
     **/
    public static final int star_release_information_details = 14;
    /**
     * 评比进行中列表（包含结果和奖励）（按关注度排名）（按注册时间排名）
     **/
    public static final int in_comparison_to_listApply_to_be_a_platform_star_ = 15;
    /**
     * 商品列表
     **/
    public static final int goods_list = 16;
    /**
     * 红包（娱币）兑换
     **/
    public static final int for_goods = 17;
    /**
     * 发布商品（只有明星能操作）
     **/
    public static final int release_goods = 18;
    /**
     * 订单列表
     **/
    public static final int list_of_orders = 19;
    /**
     * 管理订单
     **/
    public static final int order_management = 20;
    /**
     * 持有列表
     **/
    public static final int hold_list = 21;
    /**
     * 发出列表
     **/
    public static final int a_list = 22;
    /**
     * 奖品清单
     **/
    public static final int the_prize_list = 23;
    /**
     * 抽奖结果提交
     **/
    public static final int lottery_results_submitted = 24;
    /**
     * 已关注明星列表
     **/
    public static final int has_concerned_star_list = 25;
    /**
     * 编辑个人信息（是否申请为明星）
     **/
    public static final int edit_personal_information = 26;
    /**
     * 相册管理
     **/
    public static final int photo_album_management = 27;
    /**
     * 编辑相册
     **/
    public static final int edit_photo_albums = 28;
    /**
     * 演艺经历
     **/
    public static final int her_career = 29;
    /**
     * 编辑演艺经历
     **/
    public static final int editor_of_her_career = 30;
    /**
     * 外部链接（图标、标题、链接）
     **/
    public static final int external_links = 31;
    /**
     * 编辑外部链接
     **/
    public static final int edit_external_links = 32;
    /**
     * 商务信息
     **/
    public static final int business_information = 33;
    /**
     * 编辑商务信息
     **/
    public static final int edit_business_information = 34;
    /**
     * 身价定价
     **/
    public static final int value_pricing = 35;
    /**
     * 赠送（红包、娱币）
     **/
    public static final int give = 36;
    /**
     * 评论
     **/
    public static final int comment = 37;
    /**
     * 签到
     **/
    public static final int continuous = 40;
    /**
     * 搜索
     **/
    public static final int search = 41;
    /**
     * 意见反馈
     **/
    public static final int feedback = 42;
    /**
     * 交易记录
     **/
    public static final int account = 43;
    /**
     * 制作权益卡
     **/
    public static final int make_equity_card = 45;
    /**
     * 获取权益卡列表
     **/
    public static final int equitylists = 46;
    /**
     * 认购权益卡
     **/
    public static final int subscribe = 47;
    /**
     * 我的权益卡（普通用户）
     **/
    public static final int my_rights = 48;
    /**
     * 我的权益卡（明星用户）
     **/
    public static final int my_rights_star = 49;
    /**
     * 权益状态变更
     **/
    public static final int changeState = 50;
    /**
     * 获取外部连接
     **/
    public static final int outconnect = 51;
    /**
     * 添加外部链
     **/
    public static final int addoutconnect = 52;
    /**
     * 删除外部链接
     **/
    public static final int dltoutconnect = 53;
    /**
     * 修改外部链接
     **/
    public static final int updateoutconnect = 54;
    /**
     * 贡献排行
     **/
    public static final int contribution = 55;
    /**
     * 日K周K
     **/
    public static final int k_line_graph = 56;
    /**
     * 充值
     **/
    public static final int recharge_success = 57;

    /**
     * 设为头像
     **/
    public static final int image = 58;


    /**
     * 删除照片
     **/
    public static final int delete_picture = 59;

    /**
     * 微信预支付
     */
    public static final int wx_pre_pay = 60;

    /**
     * 微信支付成功
     */
    public static final int wx_pay = 61;
    
    /**
     * 视频直播查询
     */
    public static final int query_video = 62;
    
    /**
     * 创建直播室
     */
    public static final int create_video = 63;
    
    /**
     * 更新直播频道的直播状态
     */
    public static final int update_status = 64;
    
    /**
     * 更新聊天室人数
     */
    public static final int update_room = 65;
    
    /**
     * 聊天室送礼物
     */
    public static final int send_gift = 66;
    
    /**
     * 查询娱票
     */
    public static final int query_piao = 67;
    
    /**
     * 查询在线直播间列表
     */
    public static final int video_list = 68;
    
    /**
     * 查询直播间的状态
     */
    public static final int query_video_status = 69;
    
    /**
     * 娱票兑换
     */
    public static final int exchange_piao = 70;
    
    /**
     * 进入聊天室获取头像相关信息
     */
    public static final int member_in = 71;
    
    /**
     * 查询可兑换的娱票数
     */
    public static final int query_piao_left = 72;
    
    /**
     * 明星列表 1关注 2热门 3最新
     */
    public static final int stat_list = 73;
    
    /**
     * 娱票排行榜
     */
    public static final int contribute = 74;
    
    /**
     * 第三方登录
     */
    public static final int third_regist = 75;
    
    public static final int unfollow_attention = 76;
    
    /**
     * 身份认证信息提交
     */
    public static final int idCheck = 77;
    
    /**
     * 身份认证状态获取
     */
    public static final int idGet = 78;
    
    /**
     * 获取权益卡列表
     */
    public static final int getProfit = 79;
    
    /**
     * 新增发布权益卡
     */
    public static final int newProfit = 80;
    
    /**
     * 下单接口
     */
    public static final int profitOrder = 81;
    
    /**
     * 订单状态
     */
    public static final int orderStatus = 82;
    
    /**
     * 订单列表
     */
    public static final int orderList = 83;
    
    /**
     * 申诉接口
     */
    public static final int appeal = 84;
    
    /**
     * 粉丝列表
     */
    public static final int follow = 85;
    
    /**
     * 获取所有剧组活动
     */
    public static final int getList = 86;
    
    /**
     * 获取消息详情 个推
     */
    public static final int getMessage = 87;
    
    
    //微信支付
    public static final int PAY_WX =0x11;
    
    //支付宝支付
    public static final int PAY_ALI =0x12;
    
    //预支付异常
    public static final int WX_EXCEPTION_ERROR = 0x06;
    
    public static boolean hasloadConfig = false;
    
    private static String fileDir = "";
    
    private static String cachePath = "";
    
    private static final String cfgname = "/sales.cfg";
    
	public static String password = "";
	
	public static String phoneNum = "";
	
	private static boolean isSavePsw = false;
	
	private static boolean isLogin = false;
	
	public static final String KPassword = "password";
	
	public static final String KPhoneNum = "phonenum";
	
	public static final String KClientID = "clientID";
	
	public static final String KUserName = "userName";
	public static final String KNickName = "nickName";
	public static final String KPermission = "permission";
	public static final String KCheckType = "checkType";
	public static final String KImage = "image";
	public static final String KShareCode = "shareCode";
	public static final String KToken = "token";
	public static final String KPushUrl = "pushUrl";
	
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

//	public static void setSavePsw(boolean isSavePsw) {
//		Config.isSavePsw = isSavePsw;
//		Config.saveConfig();
//	}

	public static String getPhoneNum() {
		return phoneNum;
	}

	public static void setPhoneNum(String phoneNo) {
		phoneNum = phoneNo;
	}

	public static void setPassword(String passwordString) {
		password = passwordString;
	}

//	public static void clearPassword() {
//		password = "";
//		saveConfig();
//	}
//
//	public static void saveUser(String phone, String pwd) {
//		if (phone == null || pwd == null) {
//			return;
//		}
//		phoneNum = phone;
//		password = pwd;
//		Config.saveConfig();
//	}
//	
//    public static void LoadUser() 
//    {
//		hasloadConfig = true;
//		FileInputStream stream = null;
//		String filename = Config.fileDir + Config.cfgname;
//		
//		try {
//			File file = new File(filename);
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//
//			stream = new FileInputStream(filename);
//			Properties properties = new Properties();
//			properties.load(stream);
//			Config.password = properties.getProperty(KPassword, "");
//			Config.phoneNum = properties.getProperty(KPhoneNum, "");
//			Config.User = new User();
//			
//			Config.User.setClientID(properties.getProperty(KClientID, ""));
//			Config.User.setUserName(properties.getProperty(KUserName, ""));
//			Config.User.setNickName(properties.getProperty(KNickName, ""));
//			Config.User.setPermission(properties.getProperty(KPermission, ""));
//			Config.User.setCheckType(properties.getProperty(KCheckType, ""));
//			Config.User.setImage(properties.getProperty(KImage, ""));
//			Config.User.setShareCode(properties.getProperty(KShareCode, ""));
//			Config.User.setToken(properties.getProperty(KToken, ""));
//			Config.User.setPushUrl(properties.getProperty(KPushUrl, ""));
//			
//			String w = properties.getProperty("isSavePsw", "false");
//			Config.isSavePsw = Boolean.valueOf(w).booleanValue();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			XLog.e(e.getMessage(), e);
//		} catch (IOException e) {
//			e.printStackTrace();
//			XLog.e(e.getMessage(), e);
//		}finally {
//			if (stream != null) {
//				try {
//					stream.close();
//					stream = null;
//				} catch (IOException e) {
//					XLog.e(e.getMessage(), e);
//				}
//			}
//		}
//    }
//	
//	public static void saveUser() {
//		Properties properties = new Properties();
//		properties.setProperty(Config.KClientID,
//				String.valueOf(Config.User.getClientID()));
//		properties.setProperty(Config.KUserName,
//				String.valueOf(Config.User.getUserName()));
//		
//		properties.setProperty(Config.KNickName,
//				String.valueOf(Config.User.getNickName()));
//		properties.setProperty(Config.KPermission,
//				String.valueOf(Config.User.getPermission()));
//		
//		properties.setProperty(Config.KCheckType,
//				String.valueOf(Config.User.getCheckType()));
//		properties.setProperty(Config.KImage,
//				String.valueOf(Config.User.getImage()));
//		
//		properties.setProperty(Config.KShareCode,
//				String.valueOf(Config.User.getShareCode()));
//		properties.setProperty(Config.KToken,
//				String.valueOf(Config.User.getToken()));
//		properties.setProperty(Config.KPushUrl,
//				String.valueOf(Config.User.getPushUrl()));
//		properties.setProperty("cookieStore",
//				String.valueOf(Config.cookieStore));
//		
//		properties.setProperty(Config.KPhoneNum,
//				String.valueOf(Config.phoneNum));
//		properties.setProperty(Config.KPassword,
//				String.valueOf(Config.password));
//		properties.setProperty("isSavePsw", String.valueOf(Config.isSavePsw));
//		FileOutputStream stream = null;
//		String filename = Config.fileDir + Config.cfgname;
//		try {
//
//			File f = new File(filename);
//			if (!f.exists()) {
//				File dir = new File(Config.fileDir);
//				dir.mkdirs();
//				f.createNewFile();
//			}
//			stream = new FileOutputStream(f);
//			properties.store(stream, "");
//		} catch (FileNotFoundException e) {
//			XLog.e("saveConfig" + e.toString(), e);
//		} catch (Exception e) {
//			XLog.e("saveConfig" + e.toString(), e);
//		} finally {
//			if (stream != null) {
//				try {
//					stream.close();
//					stream = null;
//				} catch (IOException e) {
//					XLog.e("saveConfig" + e.toString(), e);
//				}
//			}
//		}
//	}
//
//	public static String getPassword() {
//		return password;
//	}
    
//	/**
//	 * Load config from local file
//	 */
//    public static void LoadConfig() 
//    {
//		hasloadConfig = true;
//		FileInputStream stream = null;
//		String filename = Config.fileDir + Config.cfgname;
//		
//		try {
//			File file = new File(filename);
//			if (!file.exists()) {
//				file.createNewFile();
//			}
//
//			stream = new FileInputStream(filename);
//			Properties properties = new Properties();
//			properties.load(stream);
//			Config.password = properties.getProperty(KPassword, "");
//			Config.phoneNum = properties.getProperty(KPhoneNum, "");
//			String w = properties.getProperty("isSavePsw", "false");
//			Config.isSavePsw = Boolean.valueOf(w).booleanValue();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			XLog.e(e.getMessage(), e);
//		} catch (IOException e) {
//			e.printStackTrace();
//			XLog.e(e.getMessage(), e);
//		}finally {
//			if (stream != null) {
//				try {
//					stream.close();
//					stream = null;
//				} catch (IOException e) {
//					XLog.e(e.getMessage(), e);
//				}
//			}
//		}
//    }
    
//	public static void saveConfig() {
//		Properties properties = new Properties();
//		properties.setProperty(Config.KPhoneNum,
//				String.valueOf(Config.phoneNum));
//		properties.setProperty(Config.KPassword,
//				String.valueOf(Config.password));
//		properties.setProperty("cookieStore",
//				String.valueOf(Config.cookieStore));
//		properties.setProperty("isSavePsw", String.valueOf(Config.isSavePsw));
//		FileOutputStream stream = null;
//		String filename = Config.fileDir + Config.cfgname;
//		try {
//
//			File f = new File(filename);
//			if (!f.exists()) {
//				File dir = new File(Config.fileDir);
//				dir.mkdirs();
//				f.createNewFile();
//			}
//			stream = new FileOutputStream(f);
//			properties.store(stream, "");
//		} catch (FileNotFoundException e) {
//			XLog.e("saveConfig" + e.toString(), e);
//		} catch (Exception e) {
//			XLog.e("saveConfig" + e.toString(), e);
//		} finally {
//			if (stream != null) {
//				try {
//					stream.close();
//					stream = null;
//				} catch (IOException e) {
//					XLog.e("saveConfig" + e.toString(), e);
//				}
//			}
//		}
//	}

}
