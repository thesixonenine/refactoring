package com.simple;

import java.math.BigDecimal;

/**
 * 租赁类
 *
 * @author simple
 * @version 1.0
 * @date 2019-03-12 09:24
 * @since 1.0
 */
public class Rental {
    /**
     * 租赁的影片
     */
    private Movie movie;
    /**
     * 租期
     */
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public BigDecimal getCharge() {
        BigDecimal result = BigDecimal.ZERO;
        switch (getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result = result.add(new BigDecimal("2"));
                if (getDaysRented() > 2) {
                    result = result.add(
                            new BigDecimal(Integer.toString(getDaysRented() - 2))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
                break;
            case Movie.NEW_RELEASE:
                result = result.add(
                        new BigDecimal(Integer.toString(getDaysRented() * 3))
                );
                break;
            case Movie.CHILDRENS:
                result = result.add(new BigDecimal("1.5"));
                if (getDaysRented() > 3) {
                    result = result.add(
                            new BigDecimal(Integer.toString(getDaysRented() - 3))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
                break;
            default:
                result = result.add(new BigDecimal("2"));
                if (getDaysRented() > 2) {
                    result = result.add(
                            new BigDecimal(Integer.toString(getDaysRented() - 2))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE &&
                getDaysRented() > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
