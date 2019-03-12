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
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
