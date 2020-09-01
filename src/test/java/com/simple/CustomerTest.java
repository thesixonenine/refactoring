package com.simple;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author simple
 * @version 1.0
 * @date 2019-03-12 11:32
 * @since 1.0
 */
@DisplayName("顾客测试")
class CustomerTest {
    private Customer customer;
    /**
     * 测试会员名称
     */
    private static final String customerName = "Simple";
    /**
     * 测试电影1的名称
     */
    public static final String movie1Title = "Speed";
    /**
     * 测试电影1的类型代码
     */
    public static final int movie1PriceCode = 0;
    /**
     * 测试电影1的租赁天数
     */
    public static final int movie1DaysRented = 5;
    /**
     * 测试电影2的名称
     */
    public static final String movie2Title = "Just";
    /**
     * 测试电影2的类型代码
     */
    public static final int movie2PriceCode = 1;
    /**
     * 测试电影2的租赁天数
     */
    public static final int movie2DaysRented = 6;
    private static final String result = "Rental Record for Simple\n" +
            "\tSpeed\t6.5\n" +
            "\tJust\t18\n" +
            "Amount owed is 24.5\n" +
            "You earned 3 frequent renter points";

    @BeforeEach
    void init() {
        customer = new Customer(customerName);
        Movie movie1 = new Movie(movie1Title, movie1PriceCode);
        Rental rental1 = new Rental(movie1, movie1DaysRented);
        customer.addRental(rental1);

        Movie movie2 = new Movie(movie2Title, movie2PriceCode);
        Rental rental2 = new Rental(movie2, movie2DaysRented);
        customer.addRental(rental2);
    }

    @Test
    @DisplayName("第一次测试")
    void statementTest01() {
        assertEquals(customer.statement(), result);
    }
}