package com.fantong.logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

public class Objects {

    public static String toString(Object[] args) {
        if (args == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object object : args) {
           stringBuilder.append(toString(object));
           stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }


    public static String toString(Object object) {
        if (object == null) {
            return " null";
        } else if (object instanceof Void) {
            return " void";
        } else if (object instanceof Throwable) {
            return printStackTrace((Throwable) object);
        } else if (object.getClass().isArray()) {
            return printArray(object);
        } else {
            return object.toString();
        }
    }


    private static String printArray(Object array) {
        if (array instanceof Object[]) {
            return Arrays.toString((Object[]) array);
        } else if (array instanceof boolean[]) {
            return Arrays.toString((boolean[]) array);
        } else if (array instanceof byte[]) {
            return Arrays.toString((byte[]) array);
        } else if (array instanceof char[]) {
            return Arrays.toString((char[]) array);
        } else if (array instanceof double[]) {
            return Arrays.toString((double[]) array);
        } else if (array instanceof float[]) {
            return Arrays.toString((float[]) array);
        } else if (array instanceof int[]) {
            return Arrays.toString((int[]) array);
        } else if (array instanceof long[]) {
            return Arrays.toString((long[]) array);
        } else if (array instanceof short[]) {
            return Arrays.toString((short[]) array);
        }
        return array.toString();
    }

    private static String printStackTrace(Throwable throwable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            throwable.printStackTrace(new PrintStream(outputStream));
        } catch (Exception e) {
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream.toString();
    }

}

