package com.luffy.generalpay.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.luffy.generalpay.R;
import com.luffy.generalpay.constants.ConstantsHelper;
import com.luffy.paylib.constants.PayConstants;
import com.luffy.paylib.invoker.QQWalletPayInvoker;
import com.luffy.paylib.invoker.WeChatPayInvoker;
import com.luffy.paylib.payType.qqWallet.QQWalletPayParameter;
import com.luffy.paylib.payType.wechat.WeChatPayParameter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_wx_pay, R.id.btn_qq_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /*微信支付*/
            case R.id.btn_wx_pay:
                WeChatPayParameter weChatPayParameter = new WeChatPayParameter(
                        ConstantsHelper.Wechat.APPID,
                        ConstantsHelper.Wechat.PARTNERID,
                        "",
                        PayConstants.Wechat.PACKAGE_VALUE,
                        "",
                        "",
                        "",
                        "");
                WeChatPayInvoker.getInstance().WeChatPay(MainActivity.this, weChatPayParameter);
                break;
            /*QQ钱包支付*/
            case R.id.btn_qq_pay:
                QQWalletPayParameter qqWalletPayParameter = new QQWalletPayParameter(
                        ConstantsHelper.TencentQQ.APPID,
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "0",
                        "",
                        "");
                QQWalletPayInvoker.getInstance().QQWalletPay(MainActivity.this, qqWalletPayParameter);
                break;
        }
    }
}
