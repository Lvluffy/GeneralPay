package com.luffy.paylib.payType.qqWallet;

import java.io.Serializable;

/**
 * Created by lvlufei on 2017/7/9
 *
 * @desc QQ钱包支付参数
 * <p>
 * {
 * "appid": "1105073837",
 * "bargainorId": "1428786201",
 * "callbackScheme": "qwallet1105073837",
 * "nonce": "e89e37a1d178480f9fcec35848a04222",
 * "orderId": "21110480",
 * "pubAcc": "",
 * "pubAccHint": "",
 * "serialNumber": "03505abcd81a458cbe9ebfaafbc1763f",
 * "sigType": "HMAC-SHA1",
 * "sign": "A6AEC5CC64442FD1F8B18FECA7BBF5BB",
 * "timestamp": "1500446807",
 * "tokenId": "6Vbc14129da17edce73267bed1b024b6"
 * }
 */
public class QQWalletPayParameter implements Serializable {
    /*在http://open.qq.com注册的AppId,参与支付签名，签名关键字key为appId*/
    private String appid;
    /*商户号.参与支付签名，签名关键字key为bargainorId*/
    private String bargainorId;
    /*QQ钱包支付结果回调给urlscheme为callbackScheme的activity.，参看后续的“支付回调结果处理”*/
    private String callbackScheme;
    /*随机字段串，每次支付时都要不一样.参与支付签名，签名关键字key为nonce*/
    private String nonce;
    /*手Q公众帐号id.参与支付签名，签名关键字key为pubAcc*/
    private String pubAcc;
    /*支付完成页面，展示给用户的提示语：提醒关注公众帐号*/
    private String pubAccHint;
    /*支付序号,用于标识此次支付*/
    private String serialNumber;
    /*签名时，使用的加密方式，默认为"HMAC-SHA1"*/
    private String sigType;
    /*商户Server下发的数字签名，生成的签名串，参看“数字签名”*/
    private String sign;
    /*时间戳，为1970年1月1日00:00到请求发起时间的秒数*/
    private String timestamp;
    /*QQ钱包支付生成的token_id*/
    private String tokenId;

    /**
     * 订单号，用来验证
     */
    private String orderId;

    public QQWalletPayParameter() {
    }

    /**
     * @param appid          APPID
     * @param bargainorId    商户号
     * @param callbackScheme 支付结果回调
     * @param nonce          随机字段串
     * @param pubAcc         手Q公众帐号id
     * @param pubAccHint     提示语
     * @param serialNumber   支付序号
     * @param sigType        加密方式
     * @param sign           数字签名
     * @param timestamp      时间戳
     * @param tokenId        tokenId
     */
    public QQWalletPayParameter(String appid, String bargainorId, String callbackScheme, String nonce, String pubAcc, String pubAccHint, String serialNumber, String sigType, String sign, String timestamp, String tokenId) {
        this.appid = appid;
        this.bargainorId = bargainorId;
        this.callbackScheme = callbackScheme;
        this.nonce = nonce;
        this.pubAcc = pubAcc;
        this.pubAccHint = pubAccHint;
        this.serialNumber = serialNumber;
        this.sigType = sigType;
        this.sign = sign;
        this.timestamp = timestamp;
        this.tokenId = tokenId;
    }

    /**
     * @param appid          APPID
     * @param bargainorId    商户号
     * @param callbackScheme 支付结果回调
     * @param nonce          随机字段串
     * @param pubAcc         手Q公众帐号id
     * @param pubAccHint     提示语
     * @param serialNumber   支付序号
     * @param sigType        加密方式
     * @param sign           数字签名
     * @param timestamp      时间戳
     * @param tokenId        tokenId
     * @param orderId        订单号
     */
    public QQWalletPayParameter(String appid, String bargainorId, String callbackScheme, String nonce, String pubAcc, String pubAccHint, String serialNumber, String sigType, String sign, String timestamp, String tokenId, String orderId) {
        this.appid = appid;
        this.bargainorId = bargainorId;
        this.callbackScheme = callbackScheme;
        this.nonce = nonce;
        this.pubAcc = pubAcc;
        this.pubAccHint = pubAccHint;
        this.serialNumber = serialNumber;
        this.sigType = sigType;
        this.sign = sign;
        this.timestamp = timestamp;
        this.tokenId = tokenId;
        this.orderId = orderId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getBargainorId() {
        return bargainorId;
    }

    public void setBargainorId(String bargainorId) {
        this.bargainorId = bargainorId;
    }

    public String getCallbackScheme() {
        return callbackScheme;
    }

    public void setCallbackScheme(String callbackScheme) {
        this.callbackScheme = callbackScheme;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPubAcc() {
        return pubAcc;
    }

    public void setPubAcc(String pubAcc) {
        this.pubAcc = pubAcc;
    }

    public String getPubAccHint() {
        return pubAccHint;
    }

    public void setPubAccHint(String pubAccHint) {
        this.pubAccHint = pubAccHint;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSigType() {
        return sigType;
    }

    public void setSigType(String sigType) {
        this.sigType = sigType;
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

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
