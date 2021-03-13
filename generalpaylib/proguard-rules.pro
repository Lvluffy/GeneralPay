#############################################
#
# 一、对于一些基本指令的添加
#
#############################################

#############################################
#
# 二、Android开发中一些需要保留的公共部分
#
#############################################

#############################################
#
# 三、自身项目相关处理（必须的，否则出问题-包括：实体类）。
# 在开发的时候我们可以将所有的实体类放在一个包内，这样我们写一次混淆就行了。
#
#############################################

#############################################
#
# 四、处理第三方依赖库
#
#############################################

# 微信支付混淆
-keep class com.tencent.mm.opensdk.** {
*;
}
-keep class com.tencent.wxop.** {
*;
}
-keep class com.tencent.mm.sdk.** {
*;
}

# QQ支付混淆

# 支付宝支付混淆
-keep class com.alipay.android.app.IAlixPay{*;}
-keep class com.alipay.android.app.IAlixPay$Stub{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback{*;}
-keep class com.alipay.android.app.IRemoteServiceCallback$Stub{*;}
-keep class com.alipay.sdk.app.PayTask{ public *;}
-keep class com.alipay.sdk.app.AuthTask{ public *;}
-keep class com.alipay.sdk.app.H5PayCallback {
    <fields>;
    <methods>;
}
-keep class com.alipay.android.phone.mrpc.core.** { *; }
-keep class com.alipay.apmobilesecuritysdk.** { *; }
-keep class com.alipay.mobile.framework.service.annotation.** { *; }
-keep class com.alipay.mobilesecuritysdk.face.** { *; }
-keep class com.alipay.tscenter.biz.rpc.** { *; }
-keep class org.json.alipay.** { *; }
-keep class com.alipay.tscenter.** { *; }
-keep class com.ta.utdid2.** { *;}
-keep class com.ut.device.** { *;}
