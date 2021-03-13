package com.luffy.generalpay.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.luffy.generalpay.R;
import com.luffy.generalpay.constants.ConstantsHelper;
import com.luffy.generalpaylib.PayExtra;
import com.luffy.generalpaylib.PayFactory;
import com.luffy.generalpaylib.PayType;
import com.luffy.generalpaylib.payParameter.QQWalletPayParameter;
import com.luffy.generalpaylib.payParameter.WeChatPayParameter;

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
        int id = view.getId();
        if (id == R.id.btn_wx_pay) {
            /*微信支付*/
            Bundle extras = new Bundle();
            extras.putSerializable(PayExtra.extras_pay_parameter, new WeChatPayParameter(
                    ConstantsHelper.Wechat.APPID,
                    ConstantsHelper.Wechat.PARTNERID,
                    "",
                    "",
                    "",
                    "",
                    ""));
            PayFactory.getInstance().getIPay(PayType.wx).pay(this, extras);
        } else if (id == R.id.btn_qq_pay) {
            /*QQ钱包支付*/
            Bundle extras = new Bundle();
            extras.putSerializable(PayExtra.extras_pay_parameter, new QQWalletPayParameter(
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
                    ""));
            PayFactory.getInstance().getIPay(PayType.qq).pay(this, extras);
        }
    }
}
