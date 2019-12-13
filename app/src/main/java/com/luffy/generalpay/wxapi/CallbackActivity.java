package com.luffy.generalpay.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.luffy.generalpay.constants.ConstantsHelper;
import com.tencent.mobileqq.openpay.api.IOpenApi;
import com.tencent.mobileqq.openpay.api.IOpenApiListener;
import com.tencent.mobileqq.openpay.api.OpenApiFactory;
import com.tencent.mobileqq.openpay.data.base.BaseResponse;
import com.tencent.mobileqq.openpay.data.pay.PayResponse;

/**
 * Created by lvlufei on 2018/10/15
 *
 * @desc QQ钱包支付-回调
 */
public class CallbackActivity extends Activity implements IOpenApiListener {
    IOpenApi openApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openApi = OpenApiFactory.getInstance(this, ConstantsHelper.TencentQQ.APPID);
        openApi.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        openApi.handleIntent(intent, this);
    }


    @Override
    public void onOpenResponse(BaseResponse response) {
        if (response != null) {
            if (response instanceof PayResponse) {
                finish();
                PayResponse payResponse = (PayResponse) response;
                if (payResponse.isSuccess()) {
                    /*订单验证（orderVerify）-发送请求业务接口的消息到支付界面*/
                } else {
                    Toast.makeText(CallbackActivity.this, "QQ钱包支付失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
