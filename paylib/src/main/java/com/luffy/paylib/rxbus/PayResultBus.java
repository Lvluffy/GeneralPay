package com.luffy.paylib.rxbus;

/**
 * Created by lvlufei on 2018/7/11
 *
 * @desc 消息通知-支付结果
 */
public enum PayResultBus {
    AliPaySuccess,//支付宝支付成功
    AliPayFail, //支付宝支付失败
    WechatPaySuccess,//微信支付成功
    WechatPayFail,//微信支付失败
    QQWalletPaySuccess,//QQ钱包支付成功
    QQWalletPayFail//QQ钱包支付失败
}
