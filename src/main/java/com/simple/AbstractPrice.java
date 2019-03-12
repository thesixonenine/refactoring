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

    public BigDecimal getCharge(int daysRented) {
        BigDecimal result = BigDecimal.ZERO;
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result = result.add(new BigDecimal("2"));
                if (daysRented > 2) {
                    result = result.add(
                            new BigDecimal(Integer.toString(daysRented - 2))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
                break;
            case Movie.NEW_RELEASE:
                result = result.add(
                        new BigDecimal(Integer.toString(daysRented * 3))
                );
                break;
            case Movie.CHILDRENS:
                result = result.add(new BigDecimal("1.5"));
                if (daysRented > 3) {
                    result = result.add(
                            new BigDecimal(Integer.toString(daysRented - 3))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
                break;
            default:
                result = result.add(new BigDecimal("2"));
                if (daysRented > 2) {
                    result = result.add(
                            new BigDecimal(Integer.toString(daysRented - 2))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
        }
        return result;
    }
}
