package com.luffy.paylib.payType.wechat;

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
    private String packageValue;
    private String nonceStr;
    private String sign;
    private String timestamp;
    /*订单号，用来验证*/
    private String orderId;

    public WeChatPayParameter() {
    }

    /**
     * @param appId        APP_ID
     * @param partnerId    商户ID
     * @param prepayId     预支付ID
     * @param packageValue packageValue(固定值)
     * @param nonceStr     随机数
     * @param sign         签名
     * @param timestamp    时间戳
     */
    public WeChatPayParameter(String appId, String partnerId, String prepayId, String packageValue, String nonceStr, String sign, String timestamp) {
        this.appId = appId;
        this.partnerId = partnerId;
        this.prepayId = prepayId;
        this.packageValue = packageValue;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.timestamp = timestamp;
    }

    /**
     * @param appId        APP_ID
     * @param partnerId    商户ID
     * @param prepayId     预支付ID
     * @param packageValue packageValue(固定值)
     * @param nonceStr     随机数
     * @param sign         签名
     * @param timestamp    时间戳
     * @param orderId      订单号
     */
    public WeChatPayParameter(String appId, String partnerId, String prepayId, String packageValue, String nonceStr, String sign, String timestamp, String orderId) {
        this.appId = appId;
        this.partnerId = partnerId;
        this.prepayId = prepayId;
        this.packageValue = packageValue;
        this.nonceStr = nonceStr;
        this.sign = sign;
        this.timestamp = timestamp;
        this.orderId = orderId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
