package com.simple;

import java.math.BigDecimal;

/**
 * 价格抽象类
 *
 * @author simple
 * @version 1.0
 * @date 2019-03-12 16:48
 * @since 1.0
 */
public abstract class AbstractPrice {
    /**
     * 获得价格类型代码
     *
     * @return 价格类型代码
     */
    abstract int getPriceCode();

    /**
     * 获得价格
     *
     * @param daysRented 租赁时长
     * @return 价格
     */
    abstract BigDecimal getCharge(int daysRented);

    /**
     * 获得常客积分
     * 提供默认的积分计算方法, 子类重写自己的计算规则
     *
     * @param daysRented 租赁时长
     * @return 常客积分
     */
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
