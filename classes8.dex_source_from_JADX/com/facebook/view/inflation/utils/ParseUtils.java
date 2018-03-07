package com.facebook.view.inflation.utils;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.widget.ImageView.ScaleType;
import com.facebook.common.util.SizeUtil;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: location_opt_in_lh_notification_not_now_tapped */
public class ParseUtils {
    private final Map<String, TruncateAt> f9819a = ImmutableMap.of("end", TruncateAt.END, "start", TruncateAt.START);
    private final Map<String, Integer> f9820b = ImmutableBiMap.b("bold", Integer.valueOf(1));
    private final Map<String, Typeface> f9821c = ImmutableBiMap.b("sans", Typeface.SANS_SERIF);
    private final Map<String, Integer> f9822d = ImmutableMap.of("gone", Integer.valueOf(8), "visible", Integer.valueOf(0));
    private final Map<String, ScaleType> f9823e = ImmutableBiMap.b("centerCrop", ScaleType.CENTER_CROP);
    private final Map<String, Integer> f9824f = ImmutableMap.of("left", Integer.valueOf(3), "center", Integer.valueOf(17), "center_vertical", Integer.valueOf(16), "bottom", Integer.valueOf(80));
    private final Map<String, Integer> f9825g = ImmutableMap.of("match_parent", Integer.valueOf(-1), "wrap_content", Integer.valueOf(-2));
    public final Set<String> f9826h = ImmutableSet.of("http://schemas.android.com/apk/res/android", "");
    private final Resources f9827i;

    @Inject
    public ParseUtils(Resources resources) {
        this.f9827i = resources;
    }

    public final int m11540b(String str) {
        return SizeUtil.a(this.f9827i, Float.parseFloat(str.replaceAll("dp", "")));
    }

    public static float m11531c(String str) {
        return Float.parseFloat(str.replaceAll("sp", ""));
    }

    public static String m11532d(String str) {
        if (str.startsWith("@+id/")) {
            return str.substring(5);
        }
        throw new IllegalArgumentException("could not extract id declaration from = " + str);
    }

    public static String m11533e(String str) {
        if (str.startsWith("@id/")) {
            return str.substring(4);
        }
        throw new IllegalArgumentException("could not extract id reference from = " + str);
    }

    public static String m11534f(String str) {
        if (str.startsWith("@drawable/")) {
            return str.substring(10);
        }
        throw new IllegalArgumentException("could not extract drawable reference from = " + str);
    }

    public final String m11541g(String str) {
        if (m11539t(str)) {
            return str.substring(7);
        }
        throw new IllegalArgumentException("could not extract color reference from = " + str);
    }

    public static String m11535h(String str) {
        if (str.startsWith("@layout/")) {
            return str.substring(8);
        }
        throw new IllegalArgumentException("could not extract layout reference from = " + str);
    }

    public static String m11536i(String str) {
        if (str.startsWith("@android:color/transparent")) {
            return str.substring(1);
        }
        throw new IllegalArgumentException("could not extract android color reference from = " + str);
    }

    public final int m11542j(String str) {
        Integer num = (Integer) this.f9825g.get(str);
        if (num == null) {
            return m11540b(str);
        }
        return num.intValue();
    }

    public final TruncateAt m11543k(String str) {
        TruncateAt truncateAt = (TruncateAt) this.f9819a.get(str);
        if (truncateAt != null) {
            return truncateAt;
        }
        throw new IllegalArgumentException("could not extract TruncateAt from = " + str);
    }

    public final ScaleType m11544l(String str) {
        ScaleType scaleType = (ScaleType) this.f9823e.get(str);
        if (scaleType != null) {
            return scaleType;
        }
        throw new IllegalArgumentException("could not extract ScaleType from = " + str);
    }

    public final Typeface m11545m(String str) {
        Typeface typeface = (Typeface) this.f9821c.get(str);
        if (typeface != null) {
            return typeface;
        }
        throw new IllegalArgumentException("could not extract parseTypeface from = " + str);
    }

    public final int m11546n(String str) {
        Integer num = (Integer) this.f9820b.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("could not extract style from = " + str);
    }

    public final int m11547o(String str) {
        Integer num = (Integer) this.f9822d.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("could not extract visibility from = " + str);
    }

    public final int m11548p(String str) {
        int i = 0;
        for (Object obj : str.split("\\|")) {
            Integer num = (Integer) this.f9824f.get(obj);
            if (num == null) {
                throw new IllegalArgumentException("could not extract gravity from = " + str);
            }
            i |= num.intValue();
        }
        return i;
    }

    public static boolean m11537r(String str) {
        return str.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{8})$");
    }

    public static boolean m11538s(String str) {
        return str.startsWith("@android:color/transparent");
    }

    public static boolean m11539t(String str) {
        return str.startsWith("@color/");
    }
}
