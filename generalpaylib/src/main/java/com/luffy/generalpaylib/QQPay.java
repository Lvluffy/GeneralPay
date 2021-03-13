package com.luffy.generalpaylib;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.luffy.generalpaylib.payParameter.QQWalletPayParameter;
import com.tencent.mobileqq.openpay.api.IOpenApi;
import com.tencent.mobileqq.openpay.api.OpenApiFactory;
import com.tencent.mobileqq.openpay.data.pay.PayApi;

/**
 * Created by lvlufei on 2021-03-14
 *
 * @name QQ支付
 */
public class QQPay implements IPay {

    @Override
    public void pay(Activity context, Bundle extras) {
        QQWalletPayParameter qqWalletPayParameter = (QQWalletPayParameter) extras.getSerializable(PayExtra.extras_pay_parameter);
        IOpenApi openApi = OpenApiFactory.getInstance(context, qqWalletPayParameter.getAppid());
        PayApi api = new PayApi();
        api.appId = qqWalletPayParameter.getAppid();
        api.serialNumber = qqWalletPayParameter.getSerialNumber();
        api.callbackScheme = qqWalletPayParameter.getCallbackScheme();
        api.tokenId = qqWalletPayParameter.getTokenId();
        api.pubAcc = qqWalletPayParameter.getPubAcc();
        api.pubAccHint = qqWalletPayParameter.getPubAccHint();
        api.nonce = qqWalletPayParameter.getNonce();
        api.timeStamp = Long.parseLong(qqWalletPayParameter.getTimestamp());
        api.bargainorId = qqWalletPayParameter.getBargainorId();
        api.sig = qqWalletPayParameter.getSign();
        api.sigType = qqWalletPayParameter.getSigType();
        if (api.checkParams()) {
            openApi.execApi(api);
        } else {
            Toast.makeText(context, "QQ钱包支付缺少参数，请通过商户业务接口获取。", Toast.LENGTH_SHORT).show();
        }
    }

}
