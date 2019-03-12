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
     * @param daysRented 租赁市场
     * @return 价格
     */
    abstract BigDecimal getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
