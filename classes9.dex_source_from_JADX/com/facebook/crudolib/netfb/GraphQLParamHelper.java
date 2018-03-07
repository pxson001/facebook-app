package com.facebook.crudolib.netfb;

import com.facebook.common.stringformat.StringFormatUtil;

/* compiled from: TimeSyncMqttResponseProcessorCallback */
public class GraphQLParamHelper {
    GraphQLParamHelper() {
    }

    private static void m26057b(int i, long j) {
        int i2 = (int) (j >>> 32);
        if (i2 != i) {
            throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Trying to pass a param that was generated from the graphql query with identity %d into request with identity %d", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static String m26056a(int i, long j) {
        m26057b(i, j);
        return m26055a((int) j);
    }

    public static String m26055a(int i) {
        switch (i) {
            case 0:
                return "0";
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "11";
            case 12:
                return "12";
            case 13:
                return "13";
            case 14:
                return "14";
            case 15:
                return "15";
            case 16:
                return "16";
            case 17:
                return "17";
            case 18:
                return "18";
            case 19:
                return "19";
            case 20:
                return "20";
            case 21:
                return "21";
            case 22:
                return "22";
            case 23:
                return "23";
            case 24:
                return "24";
            case 25:
                return "25";
            case 26:
                return "26";
            case 27:
                return "27";
            case 28:
                return "28";
            case 29:
                return "29";
            case 30:
                return "30";
            case 31:
                return "31";
            default:
                throw new IllegalStateException(StringFormatUtil.formatStrLocaleSafe("Trying to get the string value of: %d. This exceeds the max value we currently support. Please add more case statements here. We want to make sure that we are always using string literals rather than calling String.valueOf for params", String.valueOf(i)));
        }
    }
}
