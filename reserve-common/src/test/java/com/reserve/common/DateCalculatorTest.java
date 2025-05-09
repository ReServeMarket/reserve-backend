package com.reserve.common;

import org.junit.jupiter.api.Test;

import static com.reserve.common.DateCalculator.getAgeDifference;
import static com.reserve.common.DateCalculator.getInternationalAge;

class DateCalculatorTest {

    @Test
    public void calculateAge() {
        String meBirthdate = "19951222";
        String youBirthdate = "19960115";

        int ageDifference = getAgeDifference(meBirthdate, youBirthdate);
        int myInternationalAge = getInternationalAge(meBirthdate);
        int yourInternationalAge = getInternationalAge(youBirthdate);

        /**
         * No Assert
         * - 현재 날짜에 따라 값이 달라짐.
         */
        System.out.println("Age Difference: " + ageDifference);
        System.out.println("My International Age: " + myInternationalAge);
        System.out.println("Your International Age: " + yourInternationalAge);
    }
}