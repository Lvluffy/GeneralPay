package com.luffy.generalpaylib;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.luffy.generalpaylib.payParameter.WeChatPayParameter;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mm.opensdk.utils.Log;

/**
 * Created by lvlufei on 2021-03-14
 *
 * @name 微信支付
 */
public class WeChatPay implements IPay {

    @Override
    public void pay(Activity context, Bundle extras) {
        WeChatPayParameter weChatPayParameter = (WeChatPayParameter) extras.getSerializable(PayExtra.extras_pay_parameter);
        /*注册微信支付*/
        IWXAPI iwxapi = WXAPIFactory.createWXAPI(context, null);
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
            Toast.makeText(context, "微信支付缺少参数，请通过商户业务接口获取。", Toast.LENGTH_SHORT).show();
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
