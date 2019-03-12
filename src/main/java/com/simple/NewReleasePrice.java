package com.simple;

/**
 * 新片价
 *
 * @author simple
 * @version 1.0
 * @date 2019-03-12 16:51
 * @since 1.0
 */
public class NewReleasePrice extends AbstractPrice {
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}
