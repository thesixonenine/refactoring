package com.simple;

import java.math.BigDecimal;

/**
 * 儿童价
 *
 * @author simple
 * @version 1.0
 * @date 2019-03-12 16:50
 * @since 1.0
 */
public class ChildrenPrice extends AbstractPrice {
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    @Override
    public BigDecimal getCharge(int daysRented) {
        BigDecimal result = new BigDecimal("1.5");
        if (daysRented > 3) {
            result = result.add(
                    new BigDecimal(Integer.toString(daysRented - 3))
                            .multiply(new BigDecimal("1.5"))
            );
        }
        return result;
    }
}
