package android.support.v4.graphics;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutCompat;

/* compiled from: viewer_timeline_collections_supported */
public class ColorUtils {
    private ColorUtils() {
    }

    public static int m238a(int i, int i2) {
        float alpha = ((float) Color.alpha(i)) / 255.0f;
        float alpha2 = ((float) Color.alpha(i2)) / 255.0f;
        return Color.argb((int) ((alpha + alpha2) * (1.0f - alpha)), (int) ((((float) Color.red(i)) * alpha) + ((((float) Color.red(i2)) * alpha2) * (1.0f - alpha))), (int) ((((float) Color.green(i)) * alpha) + ((((float) Color.green(i2)) * alpha2) * (1.0f - alpha))), (int) (((1.0f - alpha) * (alpha2 * ((float) Color.blue(i2)))) + (((float) Color.blue(i)) * alpha)));
    }

    public static double m237a(int i) {
        double red = ((double) Color.red(i)) / 255.0d;
        double green = ((double) Color.green(i)) / 255.0d;
        double blue = ((double) Color.blue(i)) / 255.0d;
        return (((red < 0.03928d ? red / 12.92d : Math.pow((red + 0.055d) / 1.055d, 2.4d)) * 0.2126d) + ((green < 0.03928d ? green / 12.92d : Math.pow((green + 0.055d) / 1.055d, 2.4d)) * 0.7152d)) + (0.0722d * (blue < 0.03928d ? blue / 12.92d : Math.pow((blue + 0.055d) / 1.055d, 2.4d)));
    }

    private static double m243c(int i, int i2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent");
        }
        if (Color.alpha(i) < 255) {
            i = m238a(i, i2);
        }
        double a = m237a(i) + 0.05d;
        double a2 = m237a(i2) + 0.05d;
        return Math.max(a, a2) / Math.min(a, a2);
    }

    public static int m239a(int i, int i2, float f) {
        int i3 = 0;
        int i4 = 255;
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent");
        } else if (m243c(m242b(i, 255), i2) < ((double) f)) {
            return -1;
        } else {
            int i5 = 0;
            while (i5 <= 10 && i4 - i3 > 10) {
                int i6 = (i3 + i4) / 2;
                if (m243c(m242b(i, i6), i2) >= ((double) f)) {
                    i4 = i6;
                    i6 = i3;
                }
                i5++;
                i3 = i6;
            }
            return i4;
        }
    }

    public static void m241a(int i, int i2, int i3, float[] fArr) {
        float f = ((float) i) / 255.0f;
        float f2 = ((float) i2) / 255.0f;
        float f3 = ((float) i3) / 255.0f;
        float max = Math.max(f, Math.max(f2, f3));
        float min = Math.min(f, Math.min(f2, f3));
        float f4 = max - min;
        float f5 = (max + min) / 2.0f;
        if (max == min) {
            f = 0.0f;
            f2 = 0.0f;
        } else {
            if (max == f) {
                f = ((f2 - f3) / f4) % 6.0f;
            } else if (max == f2) {
                f = ((f3 - f) / f4) + 2.0f;
            } else {
                f = ((f - f2) / f4) + 4.0f;
            }
            f2 = f4 / (1.0f - Math.abs((2.0f * f5) - 1.0f));
        }
        fArr[0] = (f * 60.0f) % 360.0f;
        fArr[1] = f2;
        fArr[2] = f5;
    }

    public static int m240a(float[] fArr) {
        int round;
        int round2;
        int round3;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float abs = (1.0f - Math.abs((2.0f * f3) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = abs * (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f));
        switch (((int) f) / 60) {
            case 0:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round(255.0f * f4);
                break;
            case 1:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round(255.0f * f4);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                round = Math.round(255.0f * f4);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            case 3:
                round = Math.round(255.0f * f4);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round(255.0f * f4);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case 5:
            case 6:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round(255.0f * f4);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            default:
                round3 = 0;
                round2 = 0;
                round = 0;
                break;
        }
        return Color.rgb(Math.max(0, Math.min(255, round)), Math.max(0, Math.min(255, round2)), Math.max(0, Math.min(255, round3)));
    }

    public static int m242b(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
