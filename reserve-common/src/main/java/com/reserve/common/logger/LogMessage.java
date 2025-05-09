package com.reserve.common.logger;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class LogMessage {

    public static final String DATA_DELIMITER = " -- ";

    public static String format(String message, Data... data) {
        return format(message, Arrays.asList(data));
    }

    public static String format(String message, List<Data> dataList) {
        return message + DATA_DELIMITER + dataList;
    }

    public interface Data {
    }

    @Getter
    @RequiredArgsConstructor
    public static class KeyValueData implements Data {
        private final String key;
        private final Object value;

        @Override
        public String toString() {
            return key + "=" + value;
        }

        public static KeyValueData of(String name, Object value) {
            return new KeyValueData(name, value);
        }
    }
}
