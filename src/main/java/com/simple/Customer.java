package com.simple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 顾客类
 *
 * @author simple
 * @version 1.0
 * @date 2019-03-12 09:27
 * @since 1.0
 */
public class Customer {
    /**
     * 顾客的姓名
     */
    private String name;
    /**
     * 顾客的租赁记录
     */
    private List<Rental> rentalList = Collections.synchronizedList(new ArrayList<>());

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental newRental) {
        rentalList.add(newRental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ").append(getName()).append("\n");
        rentalList.forEach(rental -> result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.getCharge().toString()).append("\n"));
        result.append("Amount owed is ").append(getTotalCharge().toString()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    public String htmlStatement() {
        StringBuilder result = new StringBuilder();
        result.append("<h1>Rentals for <em>").append(getName()).append("</em></h1><p>\n");
        rentalList.forEach(rental -> result.append(rental.getMovie().getTitle()).append(": ").append(rental.getCharge().toString()).append("<br>\n"));
        result.append("<p>You owe <em>").append(getTotalCharge().toString()).append("</em><p>\n");
        result.append("On this rental you earned <em>").append(getTotalFrequentRenterPoints()).append("</em> frequent renter points<p>");
        return result.toString();
    }

    /**
     * 计算常客积分
     *
     * @return 常客积分
     */
    private int getTotalFrequentRenterPoints() {
        return rentalList.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
//        int frequentRenterPoints = 0;
//        for (Rental rental : rentalList) {
//            frequentRenterPoints += rental.getFrequentRenterPoints();
//        }
//        return frequentRenterPoints;
    }

    /**
     * 计算总共需要支付的金额
     *
     * @return 总共需要支付的金额
     */
    private BigDecimal getTotalCharge() {
        return rentalList.stream().map(Rental::getCharge).reduce(BigDecimal.ZERO, BigDecimal::add);
//        BigDecimal totalAmount = new BigDecimal("0");
//        for (Rental rental : rentalList) {
//            totalAmount = totalAmount.add(rental.getCharge());
//        }
//        return totalAmount;
    }
}
