package com.luffy.paylib.invoker;

import android.content.Context;
import android.widget.Toast;

import com.luffy.paylib.payType.qqWallet.QQWalletPayParameter;
import com.tencent.mobileqq.openpay.api.IOpenApi;
import com.tencent.mobileqq.openpay.api.OpenApiFactory;
import com.tencent.mobileqq.openpay.data.pay.PayApi;

/**
 * Created by lvlufei on 2017/7/10
 *
 * @desc QQ钱包支付-帮助类
 */
public class QQWalletPayInvoker {

    private static QQWalletPayInvoker mPayHelper;

    private QQWalletPayInvoker() {
    }

    public static QQWalletPayInvoker getInstance() {
        synchronized (QQWalletPayInvoker.class) {
            if (mPayHelper == null) {
                mPayHelper = new QQWalletPayInvoker();
            }
        }
        return mPayHelper;
    }

    /**
     * QQ钱包支付
     *
     * @param mContext
     * @param qqWalletPayParameter
     */
    public void QQWalletPay(final Context mContext, final QQWalletPayParameter qqWalletPayParameter) {
        IOpenApi openApi = OpenApiFactory.getInstance(mContext, qqWalletPayParameter.getAppid());
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
            Toast.makeText(mContext, "QQ钱包支付缺少参数，请通过商户业务接口获取。", Toast.LENGTH_SHORT).show();
        }
    }

}