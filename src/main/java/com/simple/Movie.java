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
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                price = new RegularPrice();
        }
    }

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

    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
