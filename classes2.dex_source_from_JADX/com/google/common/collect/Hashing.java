package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_scfg_expired */
public final class Hashing {
    private static int f325a = 1073741824;

    private Hashing() {
    }

    static int m653a(int i) {
        return 461845907 * Integer.rotateLeft(-862048943 * i, 15);
    }

    static int m655a(@Nullable Object obj) {
        return m653a(obj == null ? 0 : obj.hashCode());
    }

    static int m654a(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (((double) highestOneBit) * d))) {
            return highestOneBit;
        }
        highestOneBit <<= 1;
        if (highestOneBit > 0) {
            return highestOneBit;
        }
        return f325a;
    }

    public static boolean m656a(int i, int i2, double d) {
        return ((double) i) > ((double) i2) * d && i2 < f325a;
    }
}
