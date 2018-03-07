package com.facebook.graphql.querybuilder.common;

import android.content.res.Resources;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: ringtone_uri */
public final class GraphQlQueryDefaults {
    public static final ScaleInputPixelRatio f6588a = ScaleInputPixelRatio.NUMBER_1;

    public static final ScaleInputPixelRatio m11417a() {
        return m11418a(m11423e());
    }

    public static final int m11419b() {
        return m11420b(40);
    }

    public static final int m11421c() {
        return m11420b(94);
    }

    public static final int m11422d() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    @VisibleForTesting
    private static ScaleInputPixelRatio m11418a(int i) {
        if (i > 480) {
            return ScaleInputPixelRatio.NUMBER_4;
        }
        if (i > 320) {
            return ScaleInputPixelRatio.NUMBER_3;
        }
        if (i > 240) {
            return ScaleInputPixelRatio.NUMBER_2;
        }
        if (i > 160) {
            return ScaleInputPixelRatio.NUMBER_1_5;
        }
        return ScaleInputPixelRatio.NUMBER_1;
    }

    private static int m11420b(int i) {
        return (m11423e() / 160) * i;
    }

    private static final int m11423e() {
        if (Resources.getSystem() == null || Resources.getSystem().getDisplayMetrics() == null) {
            return 0;
        }
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }
}
