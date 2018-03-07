package com.facebook.common.time;

/* compiled from: requestTime */
public class TimeConversions {
    public static long m11967a(long j) {
        return j / 3600000;
    }

    public static long m11970d(long j) {
        return j / 60000;
    }

    public static long m11971f(long j) {
        return j / 86400000;
    }

    public static long m11972k(long j) {
        return j / 31536000000L;
    }

    public static long m11968a(long j, long j2) {
        return (long) Math.ceil(((double) j) / ((double) j2));
    }

    public static long m11969b(long j, long j2) {
        return Math.round(((double) j) / ((double) j2));
    }

    public static long m11973m(long j) {
        return j / 1000;
    }

    public static double m11974n(long j) {
        return ((double) j) / 1000.0d;
    }

    public static long m11975o(long j) {
        return 1000 * j;
    }

    public static long m11976p(long j) {
        return 60000 * j;
    }

    public static long m11977q(long j) {
        return (500000 + j) / 1000000;
    }

    public static long m11978r(long j) {
        return (500 + j) / 1000;
    }
}
