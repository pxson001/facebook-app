package com.facebook.components;

import android.view.View.MeasureSpec;
import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: gatekeepers */
public class SizeSpec {

    /* compiled from: gatekeepers */
    /* synthetic */ class C09271 {
        static final /* synthetic */ int[] f22986a = new int[CSSMeasureMode.values().length];

        static {
            try {
                f22986a[CSSMeasureMode.EXACTLY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22986a[CSSMeasureMode.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22986a[CSSMeasureMode.AT_MOST.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static int m30705a(int i, int i2) {
        return MeasureSpec.makeMeasureSpec(i, i2);
    }

    public static int m30704a(int i) {
        return MeasureSpec.getMode(i);
    }

    public static int m30706b(int i) {
        return MeasureSpec.getSize(i);
    }

    public static int m30707b(int i, int i2) {
        switch (m30704a(i)) {
            case Integer.MIN_VALUE:
                return Math.min(m30706b(i), i2);
            case 0:
                return i2;
            case 1073741824:
                return m30706b(i);
            default:
                throw new IllegalStateException("Unexpected size mode: " + m30704a(i));
        }
    }

    static int m30703a(float f, CSSMeasureMode cSSMeasureMode) {
        int i;
        switch (C09271.f22986a[cSSMeasureMode.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                i = 1073741824;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                i = 0;
                break;
            case 3:
                i = Integer.MIN_VALUE;
                break;
            default:
                throw new IllegalArgumentException("Unexpected CSSMeasureMode: " + cSSMeasureMode);
        }
        return m30705a(FastMath.m31104a(f), i);
    }

    public static float m30708c(int i) {
        int b = m30706b(i);
        switch (m30704a(i)) {
            case Integer.MIN_VALUE:
            case 1073741824:
                return (float) b;
            case 0:
                return Float.NaN;
            default:
                throw new IllegalArgumentException("Unrecognized size spec mode");
        }
    }
}
