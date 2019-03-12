package com.simple;

import java.math.BigDecimal;

/**
 * 正常价
 *
 * @author simple
 * @version 1.0
 * @date 2019-03-12 16:52
 * @since 1.0
 */
public class RegularPrice extends AbstractPrice {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public BigDecimal getCharge(int daysRented) {
        BigDecimal result = new BigDecimal("2");
        if (daysRented > 2) {
            result = result.add(
                    new BigDecimal(Integer.toString(daysRented - 2))
                            .multiply(new BigDecimal("1.5"))
            );
        }
        return result;
    }
}
