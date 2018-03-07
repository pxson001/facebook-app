package com.facebook.common.ui.util;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: shortcut */
public class ViewIdUtil {
    private static final AtomicInteger f2772a = new AtomicInteger(1);

    public static int m3879a() {
        int i;
        int i2;
        do {
            i = f2772a.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!f2772a.compareAndSet(i, i2));
        return i;
    }
}
