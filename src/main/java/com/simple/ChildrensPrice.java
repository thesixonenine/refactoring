package com.simple;

/**
 * 儿童价
 *
 * @author simple
 * @version 1.0
 * @date 2019-03-12 16:50
 * @since 1.0
 */
public class ChildrensPrice extends AbstractPrice {
    @Override
    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
