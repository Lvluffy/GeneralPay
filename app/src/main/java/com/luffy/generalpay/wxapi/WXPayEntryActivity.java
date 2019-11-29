package com.luffy.generalpay.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.luffy.generalpay.constants.ConstantsHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by lvlufei on 2018/10/15
 *
 * @desc 微信支付-回调
 */
public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, ConstantsHelper.Wechat.APPID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        finish();
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            if (resp.errCode == 0) {
                /*订单验证（orderVerify）-发送请求业务接口的消息到支付界面*/
            } else if (resp.errCode == -1) {
                Toast.makeText(WXPayEntryActivity.this, "微信支付失败", Toast.LENGTH_SHORT).show();
            } else if (resp.errCode == -2) {
                Toast.makeText(WXPayEntryActivity.this, "微信支付取消", Toast.LENGTH_SHORT).show();
            }
        }
    }
}