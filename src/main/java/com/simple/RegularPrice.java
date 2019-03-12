package com.simple;

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
}
