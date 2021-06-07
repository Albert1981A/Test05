package com.AlbertAbuav.Test05.utils;

public class TestUtils {

    private static int COUNT = 1;

    public static void testInfo(String content) {
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("                      TEST NUMBER - %d: %s%n", COUNT, content);
        System.out.println("---------------------------------------------------------------------------------");
        COUNT++;
    }
}
