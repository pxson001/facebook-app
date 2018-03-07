package com.facebook.imagepipeline.memory;

/* compiled from: page/messages/%s */
public class BitmapCounterProvider {
    public static final int f10548a;
    private static BitmapCounter f10549b;

    static {
        int min = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        if (((long) min) > 16777216) {
            min = (min / 4) * 3;
        } else {
            min /= 2;
        }
        f10548a = min;
    }

    public static BitmapCounter m15670a() {
        if (f10549b == null) {
            f10549b = new BitmapCounter(384, f10548a);
        }
        return f10549b;
    }
}
