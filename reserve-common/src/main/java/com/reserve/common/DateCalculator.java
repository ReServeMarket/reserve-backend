package com.reserve.common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateCalculator {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static int getAgeDifference(String meBirthdate, String youBirthdate) {
        LocalDate meDate = LocalDate.parse(meBirthdate, FORMATTER);
        LocalDate youDate = LocalDate.parse(youBirthdate, FORMATTER);
        return meDate.getYear() - youDate.getYear();
    }

    public static int getInternationalAge(String birthdate) {
        LocalDate birthDate = LocalDate.parse(birthdate, FORMATTER);
        LocalDate currentDate = LocalDate.now();

        int internationalAge = currentDate.getYear() - birthDate.getYear();
        if (currentDate.getMonthValue() < birthDate.getMonthValue() ||
                (currentDate.getMonthValue() == birthDate.getMonthValue() && currentDate.getDayOfMonth() < birthDate.getDayOfMonth())) {
            internationalAge -= 1;
        }

        return internationalAge;
    }
}
