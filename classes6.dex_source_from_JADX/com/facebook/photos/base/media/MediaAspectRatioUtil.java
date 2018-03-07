package com.facebook.photos.base.media;

import com.google.common.primitives.Ints;
import javax.annotation.Nullable;

/* compiled from: injected-dedup- */
public class MediaAspectRatioUtil {
    @Nullable
    public static Integer m20079a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Ints.a(str);
    }

    public static float m20078a(int i, int i2, int i3) {
        return (i3 == 90 || i3 == 270) ? ((float) i2) / ((float) i) : ((float) i) / ((float) i2);
    }
}
