package com.qiren.miniproj.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static void log(String log) {
        System.out.println("LOG: " + sdf.format(new Date()) + " " + log);
    }
}
