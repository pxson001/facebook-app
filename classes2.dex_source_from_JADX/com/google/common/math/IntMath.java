package com.google.common.math;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.math.RoundingMode;

@GwtCompatible
/* compiled from: open_divebar */
public final class IntMath {
    @VisibleForTesting
    static final byte[] f10977a = new byte[]{(byte) 9, (byte) 9, (byte) 9, (byte) 8, (byte) 8, (byte) 8, (byte) 7, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 4, (byte) 4, (byte) 4, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    @VisibleForTesting
    static final int[] f10978b = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    @VisibleForTesting
    static final int[] f10979c = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    @VisibleForTesting
    static int[] f10980d = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    private static final int[] f10981e = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* compiled from: open_divebar */
    /* synthetic */ class C04641 {
        static final /* synthetic */ int[] f10982a = new int[RoundingMode.values().length];

        static {
            try {
                f10982a[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10982a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10982a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10982a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10982a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10982a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f10982a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f10982a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    @VisibleForTesting
    private static int m16295b(int i, int i2) {
        return (((i - i2) ^ -1) ^ -1) >>> 31;
    }

    public static int m16294a(int i, RoundingMode roundingMode) {
        MathPreconditions.m16297a("x", i);
        switch (C04641.f10982a[roundingMode.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                int i2;
                int i3 = 1;
                if (i > 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (((i - 1) & i) != 0) {
                    i3 = 0;
                }
                MathPreconditions.m16298a(i3 & i2);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
                break;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + m16295b(-1257966797 >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m16293a(int r7, int r8, java.math.RoundingMode r9) {
        /*
        r0 = 1;
        r1 = 0;
        com.google.common.base.Preconditions.checkNotNull(r9);
        if (r8 != 0) goto L_0x000f;
    L_0x0007:
        r0 = new java.lang.ArithmeticException;
        r1 = "/ by zero";
        r0.<init>(r1);
        throw r0;
    L_0x000f:
        r2 = r7 / r8;
        r3 = r8 * r2;
        r3 = r7 - r3;
        if (r3 != 0) goto L_0x0019;
    L_0x0017:
        r0 = r2;
    L_0x0018:
        return r0;
    L_0x0019:
        r4 = r7 ^ r8;
        r4 = r4 >> 31;
        r5 = r4 | 1;
        r4 = com.google.common.math.IntMath.C04641.f10982a;
        r6 = r9.ordinal();
        r4 = r4[r6];
        switch(r4) {
            case 1: goto L_0x0030;
            case 2: goto L_0x0035;
            case 3: goto L_0x0041;
            case 4: goto L_0x0036;
            case 5: goto L_0x003d;
            case 6: goto L_0x0045;
            case 7: goto L_0x0045;
            case 8: goto L_0x0045;
            default: goto L_0x002a;
        };
    L_0x002a:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x0030:
        if (r3 != 0) goto L_0x003b;
    L_0x0032:
        com.google.common.math.MathPreconditions.m16298a(r0);
    L_0x0035:
        r0 = r1;
    L_0x0036:
        if (r0 == 0) goto L_0x006d;
    L_0x0038:
        r0 = r2 + r5;
        goto L_0x0018;
    L_0x003b:
        r0 = r1;
        goto L_0x0032;
    L_0x003d:
        if (r5 > 0) goto L_0x0036;
    L_0x003f:
        r0 = r1;
        goto L_0x0036;
    L_0x0041:
        if (r5 < 0) goto L_0x0036;
    L_0x0043:
        r0 = r1;
        goto L_0x0036;
    L_0x0045:
        r3 = java.lang.Math.abs(r3);
        r4 = java.lang.Math.abs(r8);
        r4 = r4 - r3;
        r3 = r3 - r4;
        if (r3 != 0) goto L_0x0069;
    L_0x0051:
        r3 = java.math.RoundingMode.HALF_UP;
        if (r9 == r3) goto L_0x0062;
    L_0x0055:
        r3 = java.math.RoundingMode.HALF_EVEN;
        if (r9 != r3) goto L_0x0065;
    L_0x0059:
        r4 = r0;
    L_0x005a:
        r3 = r2 & 1;
        if (r3 == 0) goto L_0x0067;
    L_0x005e:
        r3 = r0;
    L_0x005f:
        r3 = r3 & r4;
        if (r3 == 0) goto L_0x0063;
    L_0x0062:
        r1 = r0;
    L_0x0063:
        r0 = r1;
        goto L_0x0036;
    L_0x0065:
        r4 = r1;
        goto L_0x005a;
    L_0x0067:
        r3 = r1;
        goto L_0x005f;
    L_0x0069:
        if (r3 > 0) goto L_0x0036;
    L_0x006b:
        r0 = r1;
        goto L_0x0036;
    L_0x006d:
        r0 = r2;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.a(int, int, java.math.RoundingMode):int");
    }

    private IntMath() {
    }
}
