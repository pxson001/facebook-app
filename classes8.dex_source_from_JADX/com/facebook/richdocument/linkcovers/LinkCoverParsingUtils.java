package com.facebook.richdocument.linkcovers;

import android.graphics.Color;
import com.facebook.common.util.Hex;
import com.facebook.richdocument.linkcovers.LinkCoverTypes.DimensionF;

/* compiled from: place_tips_settings_helper */
public class LinkCoverParsingUtils {
    public static float m5320a(String str) {
        float f = 0.0f;
        if (str != null) {
            try {
                f = Float.parseFloat(str.substring(0, str.indexOf("pt")));
            } catch (NumberFormatException e) {
            }
        }
        return f;
    }

    private static float m5324c(String str) {
        float f = 0.0f;
        if (str != null) {
            try {
                f = Float.parseFloat(str.substring(0, str.indexOf("grid")));
            } catch (NumberFormatException e) {
            }
        }
        return f;
    }

    public static int m5323b(String str) {
        if (str == null) {
            return 0;
        }
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        byte[] a = Hex.a(str);
        if (a.length == 4) {
            return Color.argb((a[0] + 256) % 256, (a[1] + 256) % 256, (a[2] + 256) % 256, (a[3] + 256) % 256);
        }
        return Color.rgb((a[0] + 256) % 256, (a[1] + 256) % 256, (a[2] + 256) % 256);
    }

    public static float m5321a(String str, LinkCoverMetrics linkCoverMetrics, DimensionF dimensionF) {
        if (str == null) {
            return 0.0f;
        }
        if (str.equals("full_width") && dimensionF != null) {
            return dimensionF.f5416a;
        }
        if (str.equals("padding")) {
            return linkCoverMetrics.f5408b;
        }
        if (str.endsWith("pt")) {
            return m5320a(str) * linkCoverMetrics.m5319a();
        }
        if (str.endsWith("grid")) {
            return m5324c(str) * linkCoverMetrics.f5413g;
        }
        return 0.0f;
    }

    public static float m5322b(String str, LinkCoverMetrics linkCoverMetrics, DimensionF dimensionF) {
        if (str == null) {
            return 0.0f;
        }
        if (str.equals("full_height") && dimensionF != null) {
            return dimensionF.f5417b;
        }
        if (str.equals("padding")) {
            return linkCoverMetrics.f5407a;
        }
        if (str.endsWith("pt")) {
            return m5320a(str) * linkCoverMetrics.m5319a();
        }
        if (str.endsWith("grid")) {
            return m5324c(str) * linkCoverMetrics.f5414h;
        }
        return 0.0f;
    }
}
