package com.fasterxml.jackson.dataformat.smile;

/* compiled from: can_viewer_comment_with_sticker */
public class SmileUtil {
    public static int m12001a(int i) {
        if (i < 0) {
            return (i << 1) ^ -1;
        }
        return i << 1;
    }

    public static int m12003b(int i) {
        if ((i & 1) == 0) {
            return i >>> 1;
        }
        return (i >>> 1) ^ -1;
    }

    public static long m12002a(long j) {
        if (j < 0) {
            return (j << 1) ^ -1;
        }
        return j << 1;
    }

    public static long m12004b(long j) {
        if ((1 & j) == 0) {
            return j >>> 1;
        }
        return (j >>> 1) ^ -1;
    }
}
