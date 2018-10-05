package com.example.externkoutsodimakis.tddkatas_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.String.*;

public class StringCalculator {

    public int add(String numbers) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(",|n");
        List negativeNumbers = new ArrayList();
        for (String number : numbersArray) {
            if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number);
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                } else if (numberInt <= 1000) {
                    returnValue += numberInt;
                }
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Exception!!!");
        }
        return returnValue;
    }
}