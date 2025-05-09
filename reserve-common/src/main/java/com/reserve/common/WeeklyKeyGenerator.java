package com.reserve.common;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class WeeklyKeyGenerator {

    public static String getCurrentWeeklyKey() {
        return getWeeklyKey(LocalDate.now());
    }

    private static String getWeeklyKey(LocalDate date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekOfYear = date.get(weekFields.weekOfWeekBasedYear());
        int year = date.get(weekFields.weekBasedYear());

        return String.format("%dW%d", year, weekOfYear);
    }
}