package com.luffy.generalpaylib.payParameter;

import java.io.Serializable;

/**
 * Created by lvlufei on 2017/7/9
 *
 * @desc 微信支付参数
 * <p>
 * {
 * "appId": "wx5e64e231c4ca52ed",
 * "nonceStr": "974b0db59e9042e1ad3299e09426a043",
 * "package": "Sign=WXPay",
 * "partnerId": "1380146802",
 * "prepayId": "wx201707100930468f1fa9806f0953934840",
 * "sign": "E86B7292B8B6F5A63AA31C1E93DF6592",
 * "timestamp": "1499650246"
 * }
 */
public class WeChatPayParameter implements Serializable {

    /*微信支付参数*/
    private String appId;
    private String partnerId;
    private String prepayId;
    private String packageValue = "Sign=WXPay";
    private String nonceStr;
    private String sign;
    private String timestamp;
    /*订单号，用来验证*/
    private String orderId;

    /**
     * @param appId     APP_ID
     * @param partnerId 商户ID
     * @param prepayId  预支付ID
     * @param nonceStr  随机数
     * @param sign      签名
     * @param timestamp 时间戳
     * @param orderId   订单号
     */
    public WeChatPayParameter(String appId, String partnerId, String prepayId, String nonceStr, String sign, String timestamp, String orderId) {
        this.appId = appId;
        this.partnerId = partnerId;
        this.prepayId = prepayId;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.timestamp = timestamp;
        this.orderId = orderId;
    }

    public String getAppId() {
        return appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getOrderId() {
        return orderId;
    }
}
