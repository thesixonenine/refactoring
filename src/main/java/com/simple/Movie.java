package com.simple;

/**
 * 电影类
 *
 * @author simple
 * @version 1.0
 * @date 2019-03-12 09:17
 * @since 1.0
 */
public class Movie {
    /**
     * 儿童
     */
    public static final int CHILDRENS = 2;
    /**
     * 正常
     */
    public static final int REGULAR = 0;
    /**
     * 最新
     */
    public static final int NEW_RELEASE = 1;
    /**
     * 名称
     */
    private String title;
    /**
     * 价格代码
     */
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
