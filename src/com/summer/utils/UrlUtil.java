package com.summer.utils;

import com.summer.config.Config;
import com.summer.logger.XLog;

public class UrlUtil {

    public static String GetUrl (int taskType)
    {
        String url = "";
        switch (taskType)
        {
            /**
             * 登陆
             */
            case Config.LOGIN_TYPE:
                url = Config.ADDRESS + "?_mod=user&_act=login";
                break;
            /**
             * 注册
             */
            case Config.REGISTER:
                url = Config.ADDRESS + "?_mod=user&_act=register";
                break;
            /**
             * 忘记密码
             */
            case Config.forget_password:
                url = Config.ADDRESS + "?_mod=user&_act=forgot_password";
                break;
            /**
             * 短信验证码
             */
            case Config.VERIFY:
                url = Config.ADDRESS + "?_mod=user&_act=auth_code";
                break;
            /**
             * 个人信息（昵称、等级、娱币、基本信息）
             */
            case Config.personal_information:
                url = Config.ADDRESS + "?_mod=user&_act=base_info";
                break;
            /**
             * 签到
             */
            case Config.sign_in:
                url = Config.ADDRESS + "?_mod=user&_act=check_in";
                break;
            /**
             * 活动、广告
             */
            case Config.activities:
                url = Config.ADDRESS + "?_mod=topic&_act=subject";
                break;
            /**
             * 充值
             */
            case Config.top_up:
                url = Config.ADDRESS + "?_mod=user&_act=recharge";
                break;
            /**
             * 明星信息
             */
            case Config.star_information:
                url = Config.ADDRESS + "?_mod=starer&_act=base_info";
                break;
            /**
             * 给掌声、喝倒彩
             */
            case Config.give_applause_booed:
                url = Config.ADDRESS + "?_mod=user&_act=dig";
                break;
            /**
             * 加关注
             */
            case Config.and_attention:
                url = Config.ADDRESS + "?_mod=user&_act=follow";
                break;
            /**
             * 好友列表
             */
            case Config.friends_list:
                url = Config.ADDRESS + "?_mod=user&_act=friends_list";
                break;
            /**
             * 添加（判断是否为平台用户）、删除好友
             */
            case Config.add_buddy:
                url = Config.ADDRESS + "?_mod=user&_act=add_rm_friends";
                break;
            /**
             * 明星发布信息列表
             */
            case Config.stars_release_information_list:
                url = Config.ADDRESS + "?_mod=starer&_act=release_list";
                break;
            /**
             * 明星发布信息详情
             */
            case Config.star_release_information_details:
                url = Config.ADDRESS + "?_mod=starer&_act=release_detail";
                break;
            /**
             * 评比进行中列表（包含结果和奖励）（按关注度排名）（按注册时间排名）
             */
            case Config.in_comparison_to_listApply_to_be_a_platform_star_:
                url = Config.ADDRESS + "?_mod=topic&_act=appraise_show_list";
                break;
            /**
             * 商品列表
             */
            case Config.goods_list:
                url = Config.ADDRESS + "?_mod=goods&_act=lists";
                break;
            /**
             * 红包（娱币）兑换
             */
            case Config.for_goods:
                url = Config.ADDRESS + "?_mod=bonus&_act=exchange";
                break;
            /**
             * 发布商品（只有明星能操作）
             */
            case Config.release_goods:
                url = Config.ADDRESS + "?_mod=goods&_act=release";
                break;
            /**
             * 订单列表
             */
            case Config.list_of_orders:
                url = Config.ADDRESS + "?_mod=order&_act=lists";
                break;
            /**
             * 管理订单
             */

            case Config.order_management:
                url = Config.ADDRESS + "?_mod=order&_act=management";
                break;
            /**
             * 持有列表
             */
            case Config.hold_list:
                url = Config.ADDRESS + "?_mod=bonus&_act=lists";
                break;
            /**
             * 发出列表
             */
            case Config.a_list:
                url = Config.ADDRESS + "?_mod=bonus&_act=release_list";
                break;
            /**
             * 奖品清单
             */
            case Config.the_prize_list:
                url = Config.ADDRESS + "?_mod=prize&_act=lists";
                break;
            /**
             * 抽奖结果提交
             */
            case Config.lottery_results_submitted:
                url = Config.ADDRESS + "?_mod=prize&_act=result_submited";
                break;
            /**
             * 已关注明星列表
             */
            case Config.has_concerned_star_list:
                url = Config.ADDRESS + "?_mod=user&_act=starer_followed_list";
                break;
            /**
             * 编辑个人信息（是否申请为明星）
             */
            case Config.edit_personal_information:
                url = Config.ADDRESS + "?_mod=user&_act=edit_base_info";
                break;
            /**
             * 相册管理
             */
            case Config.photo_album_management:
                url = Config.ADDRESS + "?_mod=user&_act=album_management";
                break;
            /**
             * 编辑相册
             */
            case Config.edit_photo_albums:
                url = Config.ADDRESS + "?_mod=user&_act=edit_album";
                break;
            /**
             * 演艺经历
             */
            case Config.her_career:
                url = Config.ADDRESS + "?_mod=user&_act=career";
                break;
            /**
             * 编辑演艺经历
             */
            case Config.editor_of_her_career:
                url = Config.ADDRESS + "?_mod=user&_act=edit_career";
                break;
            /**
             * 外部链接（图标、标题、链接）
             */
            case Config.external_links:
                url = Config.ADDRESS + "?_mod=user&_act=external_links";
                break;
            /**
             * 编辑外部链接
             */
            case Config.edit_external_links:
                url = Config.ADDRESS + "?_mod=starer&_act=edit_release";
                break;
            /**
             * 商务信息
             */
            case Config.business_information:
                url = Config.ADDRESS + "?_mod=user&_act=business_info";
                break;
            /**
             * 编辑商务信息
             */
            case Config.edit_business_information:
                url = Config.ADDRESS + "?_mod=user&_act=edit_business_info";
                break;
            /**
             * 身价定价
             */
            case Config.value_pricing:
                url = Config.ADDRESS + "?_mod=user&_act=value_pricing";
                break;
            /**
             * 赠送（红包、娱币）
             */
            case Config.give:
                url = Config.ADDRESS + "?_mod=bonus&_act=give";
                break;
            /**
             * 评论
             */
            case Config.comment:
                url = Config.ADDRESS + "?_mod=user&_act=comment";
                break;
            /**
             * 签到信息
             */
            case Config.continuous:
                url = Config.ADDRESS + "?_mod=user&_act=continuous";
                break;
            /**
             * 搜索明星
             */
            case Config.search:
                url = Config.ADDRESS + "?_mod=starer&_act=search";
                break;
            /**
             * 意见反馈
             */
            case Config.feedback:
                url = Config.ADDRESS + "?_mod=user&_act=log_feed_balk";
                break;
            /**
             * 交易记录查询
             */
            case Config.account:
                url = Config.ADDRESS + "?_mod=user&_act=account";
                break;
            /**
             * 制作权益卡
             */
            case Config.make_equity_card:
                url = Config.ADDRESS + "?_mod=starer&_act=make_equity_card";
                break;
            /**
             * 获取权益卡列表
             */
            case Config.equitylists:
                url = Config.ADDRESS + "?_mod=goods&_act=equitylists";
                break;
            /**
             * 兑换权益
             */
            case Config.subscribe:
                url = Config.ADDRESS + "?_mod=order&_act=subscribe";
                break;
            /**
             * 我的权益（普通）
             */
            case Config.my_rights:
                url = Config.ADDRESS + "?_mod=order&_act=my_rights";
                break;
            /**
             * 我的权益（明星）
             */
            case Config.my_rights_star:
                url = Config.ADDRESS + "?_mod=order&_act=my_rights_star";
                break;
            /**
             * 权益状态
             */
            case Config.changeState:
                url = Config.ADDRESS + "?_mod=order&_act=changeState";
                break;
            /**
             * 获取外部连接
             **/
            case Config.outconnect:
                url = Config.ADDRESS + "?_mod=starer&_act=outconnect";
                break;
            /**
             * 添加外部链
             **/
            case Config.addoutconnect:
                url = Config.ADDRESS + "?_mod=starer&_act=addoutconnect";
                break;
            /**
             * 删除外部链接
             **/
            case Config.dltoutconnect:
                url = Config.ADDRESS + "?_mod=starer&_act=dltoutconnect";
                break;
            /**
             * 修改外部链接
             **/
            case Config.updateoutconnect:
                url = Config.ADDRESS + "?_mod=starer&_act=updateoutconnect";
                break;
            /**
             * 贡献排行
             **/
            case Config.contribution:
                url = Config.ADDRESS + "?_mod=topic&_act=contribution";
                break;
            /**
             * K线
             **/
            case Config.k_line_graph:
                url = Config.ADDRESS + "?_mod=starer&_act=k_line_graph";
                break;
            /**
             * 支付成功
             **/
            case Config.recharge_success:
                url = Config.ADDRESS + "?_mod=user&_act=recharge_success";
                break;
            /**
             * 设为头像
             */
            case Config.image:
                url = Config.ADDRESS + "?_mod=user&_act=edit_headIco";
                break;
            /**
             * 设为头像
             */
            case Config.delete_picture:
                url = Config.ADDRESS + "?_mod=user&_act=delete_picture";
                break;
            /**
             * 微信预支付
             */
            case Config.wx_pre_pay:
            	url = "http://app.haimianyu.cn/wxpay/wxpay.php";
            	break;
			/**
			 * 微信支付成功，查询订单
			 */
			case Config.wx_pay:
				url = "http://app.haimianyu.cn/index.php?_mod=wxpay&_act=query";
				break;
		    /**
		     * 视频直播查询
		     */				
			case Config.query_video:
				url = Config.ADDRESS + "?_mod=video&_act=queryVideo";
				break;
			/**
			 * 视频直播查询
			 */
			case Config.create_video:
				url = Config.ADDRESS + "?_mod=video&_act=createVideo";
				break;
		    /**
		     * 更新直播频道的直播状态
		     */
			case Config.update_status:
				url = Config.ADDRESS + "?_mod=video&_act=updateStatus";
				break;
		    /**
		     * 更新聊天室人数
		     */				
			case Config.update_room:
				url = Config.ADDRESS + "?_mod=video&_act=updateRoom";
				break;
		    /**
		     * 聊天室送礼物
		     */
			case Config.send_gift:
				url = Config.ADDRESS + "?_mod=video&_act=chatRoomGift";
				break;
		    /**
		     * 查询娱票
		     */
			case Config.query_piao:
				url = Config.ADDRESS + "?_mod=video&_act=queryPiao";
				break;
		    /**
		     * 查询在线直播间列表
		     */
			case Config.video_list:
				url = Config.ADDRESS + "?_mod=video&_act=getVideoList";
				break;
			/**
			 * 查询直播间状态
			 */
			case Config.query_video_status:
				url = Config.ADDRESS + "?_mod=video&_act=queryVideoStatus";
				break;
			/**
			 * 娱票兑换
			 */
			case Config.exchange_piao:
				url = Config.ADDRESS + "?_mod=user&_act=exchangePiao";
				break;
			/**
			 * 聊天室进入新成员
			 */
			case Config.member_in:
				url = Config.ADDRESS + "?_mod=user&_act=queryBaseinfo";
				break;
			/**
			 * 查询可兑换的娱票数
			 */
			case Config.query_piao_left:
				url = Config.ADDRESS + "?_mod=video&_act=queryPiaoleft";
				break;
		    /**
		     * 明星列表 1关注 2热门 3最新
		     */
			case Config.stat_list:
				url = Config.ADDRESS + "?_mod=topic&_act=appraise_show_list_new";
				break;
		    /**
		     * 娱票排行榜
		     */	
			case Config.contribute:
				url = Config.ADDRESS + "?_mod=starer&_act=fans_piao_list";
				break;
			/**
			 * 第三方登陆
			 */
			case Config.third_regist:
				url = Config.ADDRESS + "?_mod=user&_act=login_partner";
				break;
			/**
			 *  取消关注
			 */
			case Config.unfollow_attention:
				url = Config.ADDRESS + "?_mod=user&_act=unfollow";
				break;
			/**
			 * 身份认证信息提交
			 */
			case Config.idCheck:
				url = Config.ADDRESS + "?_mod=user&_act=idCheck";
				break;
			/**
			 * 身份认证信息获取 
			 */
			case Config.idGet:
				url = Config.ADDRESS + "?_mod=user&_act=idGet";
				break;
			/**
			 * 获取权益卡
			 */
			case Config.getProfit:
				url = Config.ADDRESS + "?_mod=profit&_act=getProfit";
				break;
			/**
			 * 新增发布权益卡
			 */
			case Config.newProfit:
				url = Config.ADDRESS + "?_mod=profit&_act=newProfit";
				break;
			/**
			 * 下单接口
			 */
			case Config.profitOrder:
				url = Config.ADDRESS + "?_mod=profit&_act=profitOrder";
				break;
        }
        XLog.i(url);
        return url;
    }
}
