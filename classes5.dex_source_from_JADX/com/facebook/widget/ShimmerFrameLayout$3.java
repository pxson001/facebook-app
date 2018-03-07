package com.facebook.widget;

import com.facebook.widget.ShimmerFrameLayout.MaskAngle;
import com.facebook.widget.ShimmerFrameLayout.MaskShape;

/* compiled from: com.google.android.gms.ads.identifier.internal.IAdvertisingIdService */
/* synthetic */ class ShimmerFrameLayout$3 {
    static final /* synthetic */ int[] f5777a = new int[MaskShape.values().length];
    static final /* synthetic */ int[] f5778b = new int[MaskAngle.values().length];

    static {
        try {
            f5778b[MaskAngle.CW_0.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5778b[MaskAngle.CW_90.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5778b[MaskAngle.CW_180.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5778b[MaskAngle.CW_270.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5777a[MaskShape.LINEAR.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f5777a[MaskShape.RADIAL.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
    }
}
