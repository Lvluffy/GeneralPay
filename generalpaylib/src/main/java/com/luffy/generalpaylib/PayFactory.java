package com.luffy.generalpaylib;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lvlufei on 2021-03-14
 *
 * @name 支付工厂
 */
public class PayFactory {

    private Map<Integer, IPay> map = new HashMap<>();

    private PayFactory() {
        map.put(PayType.wx, new WeChatPay());
        map.put(PayType.ali, new AliPay());
        map.put(PayType.qq, new QQPay());
    }

    public static PayFactory getInstance() {
        return PayFactoryHolder.instance;
    }

    public static class PayFactoryHolder {
        public static PayFactory instance = new PayFactory();
    }

    public IPay getIPay(Integer payType) {
        return map.get(payType);
    }
}
