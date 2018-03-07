package com.facebook.video.player;

import android.view.ViewGroup.LayoutParams;
import javax.annotation.Nullable;

/* compiled from: composer_minutiae */
public class ScaleViewUtil {
    @Nullable
    public static LayoutParams m27999a(int i, int i2, int i3) {
        if (i3 <= 0 || i2 <= 0 || i <= 0) {
            return null;
        }
        int i4;
        if (i2 < i3) {
            i4 = i;
            i = (int) ((((double) i3) * ((double) i)) / ((double) i2));
        } else {
            i4 = (int) ((((double) i2) * ((double) i)) / ((double) i3));
        }
        return new LayoutParams(i4, i);
    }

    @Nullable
    public static LayoutParams m28000a(int i, int i2, int i3, int i4) {
        if (i4 <= 0 || i3 <= 0 || i <= 0 || i2 <= 0) {
            return null;
        }
        int i5;
        if (i3 < i4) {
            i5 = (int) ((((double) i3) * ((double) i2)) / ((double) i4));
            if (i5 > i) {
                i2 = (int) ((((double) i4) * ((double) i)) / ((double) i3));
            } else {
                i = i5;
            }
        } else {
            i5 = (int) ((((double) i4) * ((double) i)) / ((double) i3));
            if (i5 > i2) {
                i = (int) ((((double) i3) * ((double) i2)) / ((double) i4));
            } else {
                i2 = i5;
            }
        }
        return new LayoutParams(i, i2);
    }
}
