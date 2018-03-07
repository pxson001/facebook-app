package com.fasterxml.jackson.dataformat.smile;

/* compiled from: can_viewer_edit */
public final class SmileConstants {
    public static final int[] f6272a;

    static {
        int[] iArr = new int[256];
        for (int i = 128; i < 256; i++) {
            int i2;
            if ((i & 224) == 192) {
                i2 = 1;
            } else if ((i & 240) == 224) {
                i2 = 2;
            } else if ((i & 248) == 240) {
                i2 = 3;
            } else {
                i2 = -1;
            }
            iArr[i] = i2;
        }
        f6272a = iArr;
    }
}
