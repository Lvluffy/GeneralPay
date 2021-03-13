package com.luffy.generalpaylib;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.luffy.generalpaylib.payParameter.AliPayParameter;

import java.lang.ref.WeakReference;
import java.util.Map;

/**
 * Created by lvlufei on 2021-03-14
 *
 * @name 支付宝支付
 */
public class AliPay implements IPay {

    private static final int SDK_PAY_FLAG = 1;
    private static final String TAG = "AliPay";

    @Override
    public void pay(final Activity context, Bundle extras) {
        final AliPayResultHandler handler = new AliPayResultHandler(context);
        final AliPayParameter aliPayParameter = (AliPayParameter) extras.getSerializable(PayExtra.extras_pay_parameter);
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(context);
                Map<String, String> result = alipay.payV2(aliPayParameter.getOrderInfo(), true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                handler.sendMessage(msg);
            }
        };
        /*必须异步调用*/
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private static class AliPayResultHandler extends Handler {

        private WeakReference<Activity> activityRef;

        AliPayResultHandler(Activity activity) {
            activityRef = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            Activity activity = activityRef.get();
            if (msg.what == SDK_PAY_FLAG && activity != null) {
                AliPayResult aliPayResult = new AliPayResult((Map<String, String>) msg.obj);
                String resultStatus = aliPayResult.getResultStatus();
                // 判断resultStatus 为9000则代表支付成功
                if (TextUtils.equals(resultStatus, "9000")) {
                    Log.d(TAG, "支付宝-支付成功");
                } else {
                    Log.d(TAG, "支付宝-支付失败");
                }
            }
        }
    }

    /**
     * 支付宝-支付返回结果
     */
    private static class AliPayResult {
        private String resultStatus;
        private String result;
        private String memo;

        public AliPayResult(Map<String, String> rawResult) {
            if (rawResult == null) {
                return;
            }
            for (String key : rawResult.keySet()) {
                if (TextUtils.equals(key, "resultStatus")) {
                    resultStatus = rawResult.get(key);
                } else if (TextUtils.equals(key, "result")) {
                    result = rawResult.get(key);
                } else if (TextUtils.equals(key, "memo")) {
                    memo = rawResult.get(key);
                }
            }
        }

        public String getResultStatus() {
            return resultStatus;
        }

        public void setResultStatus(String resultStatus) {
            this.resultStatus = resultStatus;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }
    }

}
