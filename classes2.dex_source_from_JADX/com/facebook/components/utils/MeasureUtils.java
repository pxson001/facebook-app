package com.facebook.components.utils;

import com.facebook.components.Size;
import com.facebook.components.SizeSpec;

/* compiled from: friendship/%s/%s */
public final class MeasureUtils {
    public static void m31108a(int i, int i2, Size size) {
        int a = SizeSpec.m30704a(i);
        int b = SizeSpec.m30706b(i);
        int a2 = SizeSpec.m30704a(i2);
        int b2 = SizeSpec.m30706b(i2);
        m31105a(a, a2);
        if (a != 1073741824) {
            if (a == Integer.MIN_VALUE) {
                switch (a2) {
                    case Integer.MIN_VALUE:
                        a = Math.min(b, b2);
                        size.f22987a = a;
                        size.f22988b = a;
                        return;
                    case 0:
                        size.f22987a = b;
                        size.f22988b = b;
                        return;
                    case 1073741824:
                        size.f22988b = b2;
                        size.f22987a = Math.min(b, b2);
                        return;
                    default:
                        break;
                }
            }
        }
        size.f22987a = b;
        switch (a2) {
            case Integer.MIN_VALUE:
                size.f22988b = Math.min(b, b2);
                return;
            case 0:
                size.f22988b = b;
                return;
            case 1073741824:
                size.f22988b = b2;
                return;
        }
        size.f22988b = b2;
        size.f22987a = b2;
    }

    public static void m31107a(int i, int i2, int i3, int i4, float f, Size size) {
        if (SizeSpec.m30704a(i) == Integer.MIN_VALUE && SizeSpec.m30706b(i) > i3) {
            i = SizeSpec.m30705a(i3, Integer.MIN_VALUE);
        }
        if (SizeSpec.m30704a(i2) == Integer.MIN_VALUE && SizeSpec.m30706b(i2) > i4) {
            i2 = SizeSpec.m30705a(i4, Integer.MIN_VALUE);
        }
        m31106a(i, i2, f, size);
    }

    public static void m31106a(int i, int i2, float f, Size size) {
        int a = SizeSpec.m30704a(i);
        int b = SizeSpec.m30706b(i);
        int a2 = SizeSpec.m30704a(i2);
        int b2 = SizeSpec.m30706b(i2);
        int ceil = (int) Math.ceil((double) (((float) b) / f));
        int ceil2 = (int) Math.ceil((double) (((float) b2) * f));
        m31105a(a, a2);
        if (a == Integer.MIN_VALUE && a2 == Integer.MIN_VALUE) {
            if (ceil > b2) {
                size.f22987a = ceil2;
                size.f22988b = b2;
                return;
            }
            size.f22987a = b;
            size.f22988b = ceil;
        } else if (a == 1073741824) {
            if (a2 == 0 || ceil < b2) {
                size.f22987a = b;
                size.f22988b = ceil;
                return;
            }
            throw new MeasureException("Ratio makes height larger than allowed");
        } else if (a2 == 1073741824) {
            if (a == 0 || ceil2 < b) {
                size.f22987a = ceil2;
                size.f22988b = b2;
                return;
            }
            throw new MeasureException("Ratio makes width larger than allowed");
        } else if (a == Integer.MIN_VALUE) {
            size.f22987a = b;
            size.f22988b = ceil;
        } else if (a2 == Integer.MIN_VALUE) {
            size.f22987a = ceil2;
            size.f22988b = b2;
        }
    }

    private static void m31105a(int i, int i2) {
        if (i == 0 && i2 == 0) {
            throw new MeasureException("One of width and height must be specified");
        }
    }
}
