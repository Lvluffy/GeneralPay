package com.luffy.paylib.payType.ali;

import java.io.Serializable;

/**
 * Created by lvlufei on 2017/7/9
 *
 * @desc 支付宝支付
 */
public class AliPayParameter implements Serializable {

    /*订单信息*/
    private String orderInfo;

    public AliPayParameter() {
    }

    /**
     * @param orderInfo 订单信息
     */
    public AliPayParameter(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
}
