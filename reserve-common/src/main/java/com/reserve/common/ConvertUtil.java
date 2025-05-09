package com.reserve.common;

import java.util.ArrayList;
import java.util.Arrays;

public class ConvertUtil {

    /**
     * [공통함수] string to ArrayList
     */
    public static ArrayList<String> convertStrToArray(String str){
        String[] strSplit = str.split(",");
        return new ArrayList<>(
                Arrays.asList(strSplit)
        );
    }

}

