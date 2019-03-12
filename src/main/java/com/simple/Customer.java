package com.simple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        // 总共需要支付的金额
        final BigDecimal[] totalAmounts = {new BigDecimal("0")};
        // 常客积分
        AtomicInteger frequentRenterPoints = new AtomicInteger(0);
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ").append(getName()).append("\n");
        for (int i = 0; i < rentalList.size(); i++) {
            Rental rental = rentalList.get(i);
            BigDecimal thisAmount = amountFor(rental);
            frequentRenterPoints.incrementAndGet();
            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE &&
                    rental.getDaysRented() > 1) {
                frequentRenterPoints.incrementAndGet();
            }
            result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount.toString()).append("\n");
            totalAmounts[0] = totalAmounts[0].add(thisAmount);
        }
        result.append("Amount owed is ").append(totalAmounts[0].toString()).append("\n");
        result.append("You earned ").append(frequentRenterPoints.toString()).append(" frequent renter points");
        return result.toString();
    }

    private BigDecimal amountFor(Rental aRental) {
        BigDecimal result = BigDecimal.ZERO;
        switch (aRental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                result = result.add(new BigDecimal("2"));
                if (aRental.getDaysRented() > 2) {
                    result = result.add(
                            new BigDecimal(Integer.toString(aRental.getDaysRented() - 2))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
                break;
            case Movie.NEW_RELEASE:
                result = result.add(
                        new BigDecimal(Integer.toString(aRental.getDaysRented() * 3))
                );
                break;
            case Movie.CHILDRENS:
                result = result.add(new BigDecimal("1.5"));
                if (aRental.getDaysRented() > 3) {
                    result = result.add(
                            new BigDecimal(Integer.toString(aRental.getDaysRented() - 3))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
                break;
            default:
                result = result.add(new BigDecimal("2"));
                if (aRental.getDaysRented() > 2) {
                    result = result.add(
                            new BigDecimal(Integer.toString(aRental.getDaysRented() - 2))
                                    .multiply(new BigDecimal("1.5"))
                    );
                }
        }
        return result;
    }
}
