package com.luffy.paylib.utils;

import com.luffy.paylib.payType.wechat.WeChatPayParameter;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by lvlufei on 2018/7/10
 *
 * @desc 微信签名工具
 */
public class WechatSignUtils {

    /**
     * 获取微信签名
     *
     * @param weChatPayParameter
     * @param wechatKey          商户秘钥
     * @return
     */
    public static String getWechatSign(WeChatPayParameter weChatPayParameter, String wechatKey) {
        //获取参数的值
        PayReq request = new PayReq();
        request.appId = weChatPayParameter.getAppId();
        request.partnerId = weChatPayParameter.getPartnerId();
        request.prepayId = weChatPayParameter.getPrepayId();
        request.packageValue = weChatPayParameter.getPackageValue();
        request.nonceStr = weChatPayParameter.getNonceStr();
        request.timeStamp = weChatPayParameter.getTimestamp();
        //把参数的值传进去SortedMap集合里面
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", request.appId);
        parameters.put("noncestr", request.nonceStr);
        parameters.put("package", request.packageValue);
        parameters.put("partnerid", request.partnerId);
        parameters.put("prepayid", request.prepayId);
        parameters.put("timestamp", request.timeStamp);
        String sign = createSign("UTF-8", parameters, wechatKey);
        return sign;
    }

    /**
     * 微信支付签名算法sign
     *
     * @param characterEncoding
     * @param parameters
     * @param wechatKey         商户秘钥
     * @return
     */
    private static String createSign(String characterEncoding, SortedMap<Object, Object> parameters, String wechatKey) {
        StringBuffer mStringBuffer = new StringBuffer();
        Set mSet = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
        Iterator it = mSet.iterator();
        while (it.hasNext()) {
            @SuppressWarnings("rawtypes")
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            if (null != value && !"".equals(value) && !"sign".equals(key) && !"key".equals(key)) {
                mStringBuffer.append(key + "=" + value + "&");
            }
        }
        mStringBuffer.append("key=" + wechatKey);
        String sign = WechatMD5Utils.MD5Encode(mStringBuffer.toString(), characterEncoding).toUpperCase();
        return sign;
    }

}
