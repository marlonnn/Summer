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
             * ��½
             */
            case Config.LOGIN_TYPE:
                url = Config.ADDRESS + "?_mod=user&_act=login";
                break;
            /**
             * ע��
             */
            case Config.REGISTER:
                url = Config.ADDRESS + "?_mod=user&_act=register";
                break;
            /**
             * ��������
             */
            case Config.forget_password:
                url = Config.ADDRESS + "?_mod=user&_act=forgot_password";
                break;
            /**
             * ������֤��
             */
            case Config.VERIFY:
                url = Config.ADDRESS + "?_mod=user&_act=auth_code";
                break;
            /**
             * ������Ϣ���ǳơ��ȼ�����ҡ�������Ϣ��
             */
            case Config.personal_information:
                url = Config.ADDRESS + "?_mod=user&_act=base_info";
                break;
            /**
             * ǩ��
             */
            case Config.sign_in:
                url = Config.ADDRESS + "?_mod=user&_act=check_in";
                break;
            /**
             * ������
             */
            case Config.activities:
                url = Config.ADDRESS + "?_mod=topic&_act=subject";
                break;
            /**
             * ��ֵ
             */
            case Config.top_up:
                url = Config.ADDRESS + "?_mod=user&_act=recharge";
                break;
            /**
             * ������Ϣ
             */
            case Config.star_information:
                url = Config.ADDRESS + "?_mod=starer&_act=base_info";
                break;
            /**
             * ���������ȵ���
             */
            case Config.give_applause_booed:
                url = Config.ADDRESS + "?_mod=user&_act=dig";
                break;
            /**
             * �ӹ�ע
             */
            case Config.and_attention:
                url = Config.ADDRESS + "?_mod=user&_act=follow";
                break;
            /**
             * �����б�
             */
            case Config.friends_list:
                url = Config.ADDRESS + "?_mod=user&_act=friends_list";
                break;
            /**
             * ��ӣ��ж��Ƿ�Ϊƽ̨�û�����ɾ������
             */
            case Config.add_buddy:
                url = Config.ADDRESS + "?_mod=user&_act=add_rm_friends";
                break;
            /**
             * ���Ƿ�����Ϣ�б�
             */
            case Config.stars_release_information_list:
                url = Config.ADDRESS + "?_mod=starer&_act=release_list";
                break;
            /**
             * ���Ƿ�����Ϣ����
             */
            case Config.star_release_information_details:
                url = Config.ADDRESS + "?_mod=starer&_act=release_detail";
                break;
            /**
             * ���Ƚ������б���������ͽ�����������ע������������ע��ʱ��������
             */
            case Config.in_comparison_to_listApply_to_be_a_platform_star_:
                url = Config.ADDRESS + "?_mod=topic&_act=appraise_show_list";
                break;
            /**
             * ��Ʒ�б�
             */
            case Config.goods_list:
                url = Config.ADDRESS + "?_mod=goods&_act=lists";
                break;
            /**
             * �������ң��һ�
             */
            case Config.for_goods:
                url = Config.ADDRESS + "?_mod=bonus&_act=exchange";
                break;
            /**
             * ������Ʒ��ֻ�������ܲ�����
             */
            case Config.release_goods:
                url = Config.ADDRESS + "?_mod=goods&_act=release";
                break;
            /**
             * �����б�
             */
            case Config.list_of_orders:
                url = Config.ADDRESS + "?_mod=order&_act=lists";
                break;
            /**
             * ������
             */

            case Config.order_management:
                url = Config.ADDRESS + "?_mod=order&_act=management";
                break;
            /**
             * �����б�
             */
            case Config.hold_list:
                url = Config.ADDRESS + "?_mod=bonus&_act=lists";
                break;
            /**
             * �����б�
             */
            case Config.a_list:
                url = Config.ADDRESS + "?_mod=bonus&_act=release_list";
                break;
            /**
             * ��Ʒ�嵥
             */
            case Config.the_prize_list:
                url = Config.ADDRESS + "?_mod=prize&_act=lists";
                break;
            /**
             * �齱����ύ
             */
            case Config.lottery_results_submitted:
                url = Config.ADDRESS + "?_mod=prize&_act=result_submited";
                break;
            /**
             * �ѹ�ע�����б�
             */
            case Config.has_concerned_star_list:
                url = Config.ADDRESS + "?_mod=user&_act=starer_followed_list";
                break;
            /**
             * �༭������Ϣ���Ƿ�����Ϊ���ǣ�
             */
            case Config.edit_personal_information:
                url = Config.ADDRESS + "?_mod=user&_act=edit_base_info";
                break;
            /**
             * ������
             */
            case Config.photo_album_management:
                url = Config.ADDRESS + "?_mod=user&_act=album_management";
                break;
            /**
             * �༭���
             */
            case Config.edit_photo_albums:
                url = Config.ADDRESS + "?_mod=user&_act=edit_album";
                break;
            /**
             * ���վ���
             */
            case Config.her_career:
                url = Config.ADDRESS + "?_mod=user&_act=career";
                break;
            /**
             * �༭���վ���
             */
            case Config.editor_of_her_career:
                url = Config.ADDRESS + "?_mod=user&_act=edit_career";
                break;
            /**
             * �ⲿ���ӣ�ͼ�ꡢ���⡢���ӣ�
             */
            case Config.external_links:
                url = Config.ADDRESS + "?_mod=user&_act=external_links";
                break;
            /**
             * �༭�ⲿ����
             */
            case Config.edit_external_links:
                url = Config.ADDRESS + "?_mod=starer&_act=edit_release";
                break;
            /**
             * ������Ϣ
             */
            case Config.business_information:
                url = Config.ADDRESS + "?_mod=user&_act=business_info";
                break;
            /**
             * �༭������Ϣ
             */
            case Config.edit_business_information:
                url = Config.ADDRESS + "?_mod=user&_act=edit_business_info";
                break;
            /**
             * ��۶���
             */
            case Config.value_pricing:
                url = Config.ADDRESS + "?_mod=user&_act=value_pricing";
                break;
            /**
             * ���ͣ��������ң�
             */
            case Config.give:
                url = Config.ADDRESS + "?_mod=bonus&_act=give";
                break;
            /**
             * ����
             */
            case Config.comment:
                url = Config.ADDRESS + "?_mod=user&_act=comment";
                break;
            /**
             * ǩ����Ϣ
             */
            case Config.continuous:
                url = Config.ADDRESS + "?_mod=user&_act=continuous";
                break;
            /**
             * ��������
             */
            case Config.search:
                url = Config.ADDRESS + "?_mod=starer&_act=search";
                break;
            /**
             * �������
             */
            case Config.feedback:
                url = Config.ADDRESS + "?_mod=user&_act=log_feed_balk";
                break;
            /**
             * ���׼�¼��ѯ
             */
            case Config.account:
                url = Config.ADDRESS + "?_mod=user&_act=account";
                break;
            /**
             * ����Ȩ�濨
             */
            case Config.make_equity_card:
                url = Config.ADDRESS + "?_mod=starer&_act=make_equity_card";
                break;
            /**
             * ��ȡȨ�濨�б�
             */
            case Config.equitylists:
                url = Config.ADDRESS + "?_mod=goods&_act=equitylists";
                break;
            /**
             * �һ�Ȩ��
             */
            case Config.subscribe:
                url = Config.ADDRESS + "?_mod=order&_act=subscribe";
                break;
            /**
             * �ҵ�Ȩ�棨��ͨ��
             */
            case Config.my_rights:
                url = Config.ADDRESS + "?_mod=order&_act=my_rights";
                break;
            /**
             * �ҵ�Ȩ�棨���ǣ�
             */
            case Config.my_rights_star:
                url = Config.ADDRESS + "?_mod=order&_act=my_rights_star";
                break;
            /**
             * Ȩ��״̬
             */
            case Config.changeState:
                url = Config.ADDRESS + "?_mod=order&_act=changeState";
                break;
            /**
             * ��ȡ�ⲿ����
             **/
            case Config.outconnect:
                url = Config.ADDRESS + "?_mod=starer&_act=outconnect";
                break;
            /**
             * ����ⲿ��
             **/
            case Config.addoutconnect:
                url = Config.ADDRESS + "?_mod=starer&_act=addoutconnect";
                break;
            /**
             * ɾ���ⲿ����
             **/
            case Config.dltoutconnect:
                url = Config.ADDRESS + "?_mod=starer&_act=dltoutconnect";
                break;
            /**
             * �޸��ⲿ����
             **/
            case Config.updateoutconnect:
                url = Config.ADDRESS + "?_mod=starer&_act=updateoutconnect";
                break;
            /**
             * ��������
             **/
            case Config.contribution:
                url = Config.ADDRESS + "?_mod=topic&_act=contribution";
                break;
            /**
             * K��
             **/
            case Config.k_line_graph:
                url = Config.ADDRESS + "?_mod=starer&_act=k_line_graph";
                break;
            /**
             * ֧���ɹ�
             **/
            case Config.recharge_success:
                url = Config.ADDRESS + "?_mod=user&_act=recharge_success";
                break;
            /**
             * ��Ϊͷ��
             */
            case Config.image:
                url = Config.ADDRESS + "?_mod=user&_act=edit_headIco";
                break;
            /**
             * ��Ϊͷ��
             */
            case Config.delete_picture:
                url = Config.ADDRESS + "?_mod=user&_act=delete_picture";
                break;
            /**
             * ΢��Ԥ֧��
             */
            case Config.wx_pre_pay:
            	url = "http://app.haimianyu.cn/wxpay/wxpay.php";
            	break;
			/**
			 * ΢��֧���ɹ�����ѯ����
			 */
			case Config.wx_pay:
				url = "http://app.haimianyu.cn/index.php?_mod=wxpay&_act=query";
				break;
		    /**
		     * ��Ƶֱ����ѯ
		     */				
			case Config.query_video:
				url = Config.ADDRESS + "?_mod=video&_act=queryVideo";
				break;
			/**
			 * ��Ƶֱ����ѯ
			 */
			case Config.create_video:
				url = Config.ADDRESS + "?_mod=video&_act=createVideo";
				break;
		    /**
		     * ����ֱ��Ƶ����ֱ��״̬
		     */
			case Config.update_status:
				url = Config.ADDRESS + "?_mod=video&_act=updateStatus";
				break;
		    /**
		     * ��������������
		     */				
			case Config.update_room:
				url = Config.ADDRESS + "?_mod=video&_act=updateRoom";
				break;
		    /**
		     * ������������
		     */
			case Config.send_gift:
				url = Config.ADDRESS + "?_mod=video&_act=chatRoomGift";
				break;
		    /**
		     * ��ѯ��Ʊ
		     */
			case Config.query_piao:
				url = Config.ADDRESS + "?_mod=video&_act=queryPiao";
				break;
		    /**
		     * ��ѯ����ֱ�����б�
		     */
			case Config.video_list:
				url = Config.ADDRESS + "?_mod=video&_act=getVideoList";
				break;
			/**
			 * ��ѯֱ����״̬
			 */
			case Config.query_video_status:
				url = Config.ADDRESS + "?_mod=video&_act=queryVideoStatus";
				break;
			/**
			 * ��Ʊ�һ�
			 */
			case Config.exchange_piao:
				url = Config.ADDRESS + "?_mod=user&_act=exchangePiao";
				break;
			/**
			 * �����ҽ����³�Ա
			 */
			case Config.member_in:
				url = Config.ADDRESS + "?_mod=user&_act=queryBaseinfo";
				break;
			/**
			 * ��ѯ�ɶһ�����Ʊ��
			 */
			case Config.query_piao_left:
				url = Config.ADDRESS + "?_mod=video&_act=queryPiaoleft";
				break;
		    /**
		     * �����б� 1��ע 2���� 3����
		     */
			case Config.stat_list:
				url = Config.ADDRESS + "?_mod=topic&_act=appraise_show_list_new";
				break;
		    /**
		     * ��Ʊ���а�
		     */	
			case Config.contribute:
				url = Config.ADDRESS + "?_mod=starer&_act=fans_piao_list";
				break;
			/**
			 * ��������½
			 */
			case Config.third_regist:
				url = Config.ADDRESS + "?_mod=user&_act=login_partner";
				break;
			/**
			 *  ȡ����ע
			 */
			case Config.unfollow_attention:
				url = Config.ADDRESS + "?_mod=user&_act=unfollow";
				break;
			/**
			 * �����֤��Ϣ�ύ
			 */
			case Config.idCheck:
				url = Config.ADDRESS + "?_mod=user&_act=idCheck";
				break;
			/**
			 * �����֤��Ϣ��ȡ 
			 */
			case Config.idGet:
				url = Config.ADDRESS + "?_mod=user&_act=idGet";
				break;
			/**
			 * ��ȡȨ�濨
			 */
			case Config.getProfit:
				url = Config.ADDRESS + "?_mod=profit&_act=getProfit";
				break;
			/**
			 * ��������Ȩ�濨
			 */
			case Config.newProfit:
				url = Config.ADDRESS + "?_mod=profit&_act=newProfit";
				break;
			/**
			 * �µ��ӿ�
			 */
			case Config.profitOrder:
				url = Config.ADDRESS + "?_mod=profit&_act=profitOrder";
				break;
        }
        XLog.i(url);
        return url;
    }
}
