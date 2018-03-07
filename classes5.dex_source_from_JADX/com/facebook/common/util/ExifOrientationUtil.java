package com.facebook.common.util;

import com.google.common.collect.ImmutableBiMap;

/* compiled from: share_preview_title */
public class ExifOrientationUtil {
    private static final ImmutableBiMap<ExifOrientation, Integer> f2779a;
    private static final ImmutableBiMap<Integer, ExifOrientation> f2780b;

    static {
        ImmutableBiMap a = ImmutableBiMap.d().m13353a(ExifOrientation.NORMAL, Integer.valueOf(0)).m13353a(ExifOrientation.ROTATE_90, Integer.valueOf(90)).m13353a(ExifOrientation.ROTATE_180, Integer.valueOf(180)).m13353a(ExifOrientation.ROTATE_270, Integer.valueOf(270)).m13354a();
        f2779a = a;
        f2780b = a.e();
    }

    public static int m3898a(ExifOrientation exifOrientation, int i) {
        Integer num = (Integer) f2779a.get(exifOrientation);
        return num == null ? i : num.intValue();
    }

    public static ExifOrientation m3899a(int i) {
        return m3900a(i, ExifOrientation.NORMAL);
    }

    private static ExifOrientation m3900a(int i, ExifOrientation exifOrientation) {
        ExifOrientation exifOrientation2 = (ExifOrientation) f2780b.get(Integer.valueOf(i));
        return exifOrientation2 == null ? exifOrientation : exifOrientation2;
    }
}
