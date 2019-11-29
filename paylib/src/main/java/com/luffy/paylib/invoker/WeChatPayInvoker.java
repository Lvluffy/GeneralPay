package com.luffy.paylib.invoker;

import android.content.Context;
import android.widget.Toast;

import com.luffy.paylib.payType.wechat.WeChatPayParameter;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mm.opensdk.utils.Log;

/**
 * Created by lvlufei on 2017/7/10
 *
 * @desc 微信支付-帮助类
 */
public class WeChatPayInvoker {

    private static WeChatPayInvoker mPayHelper;

    private WeChatPayInvoker() {
    }

    public static WeChatPayInvoker getInstance() {
        synchronized (WeChatPayInvoker.class) {
            if (mPayHelper == null) {
                mPayHelper = new WeChatPayInvoker();
            }
        }
        return mPayHelper;
    }

    /**
     * 微信支付
     *
     * @param mContext
     * @param weChatPayParameter
     */
    public void WeChatPay(Context mContext, WeChatPayParameter weChatPayParameter) {
        /*注册微信支付*/
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(mContext, null);
        iwxapi.registerApp(weChatPayParameter.getAppId());
        /*请求微信支付*/
        PayReq request = new PayReq();
        request.appId = weChatPayParameter.getAppId();
        request.partnerId = weChatPayParameter.getPartnerId();
        request.prepayId = weChatPayParameter.getPrepayId();
        request.packageValue = weChatPayParameter.getPackageValue();
        request.nonceStr = weChatPayParameter.getNonceStr();
        request.timeStamp = weChatPayParameter.getTimestamp();
        request.sign = weChatPayParameter.getSign();
        if (weChatCheckArgs(request)) {
            iwxapi.sendReq(request);
        } else {
            Toast.makeText(mContext, "微信支付缺少参数，请通过商户业务接口获取。", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 微信支付参数效验
     *
     * @param request
     * @return
     */
    private boolean weChatCheckArgs(PayReq request) {
        if (request.appId != null && request.appId.length() != 0) {
            if (request.partnerId != null && request.partnerId.length() != 0) {
                if (request.prepayId != null && request.prepayId.length() != 0) {
                    if (request.nonceStr != null && request.nonceStr.length() != 0) {
                        if (request.timeStamp != null && request.timeStamp.length() != 0) {
                            if (request.packageValue != null && request.packageValue.length() != 0) {
                                if (request.sign != null && request.sign.length() != 0) {
                                    return true;
                                } else {
                                    Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid sign");
                                    return false;
                                }
                            } else {
                                Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid packageValue");
                                return false;
                            }
                        } else {
                            Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid timeStamp");
                            return false;
                        }
                    } else {
                        Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid nonceStr");
                        return false;
                    }
                } else {
                    Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid prepayId");
                    return false;
                }
            } else {
                Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid partnerId");
                return false;
            }
        } else {
            Log.e("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid appId");
            return false;
        }
    }
}