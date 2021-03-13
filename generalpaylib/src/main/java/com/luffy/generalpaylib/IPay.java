package com.luffy.generalpaylib;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lvlufei on 2021-03-14
 *
 * @name 支付接口
 */
public interface IPay {

    /**
     * 调起支付控件，进入支付流程。
     *
     * @param context 上下文
     * @param extras  参数
     */
    void pay(Activity context, Bundle extras);

}
