package com.simple;

import java.math.BigDecimal;

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
    public static final int CHILDREN = 2;
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
    private AbstractPrice price;

    public Movie(String title, int priceCode) {
        this.title = title;
        // 确保任何时候都通过getter或者setter来访问priceCode
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDREN:
                price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                price = new RegularPrice();
        }
    }

    public BigDecimal getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }
}
