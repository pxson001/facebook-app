package com.facebook.widget.text;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: request_module_analytics_tag */
public class CustomFontHelper {
    public static final HashMap<String, Typeface> f7292a = Maps.m838c();

    /* compiled from: request_module_analytics_tag */
    public enum FontFamily {
        BUILTIN(new String[0]),
        HELVETICA_NEUE("fonts/HelveticaNeue-Thin.ttf", "fonts/HelveticaNeue-Light.ttf", "fonts/HelveticaNeue-Roman.ttf", "fonts/HelveticaNeue-Medium.ttf", "fonts/HelveticaNeue-Bold.ttf", "fonts/HelveticaNeue-Black.ttf"),
        ROBOTO("fonts/Roboto-Thin.ttf", "fonts/Roboto-Light.ttf", "fonts/Roboto-Regular.ttf", "fonts/Roboto-Medium.ttf", "fonts/Roboto-Bold.ttf", "fonts/Roboto-Black.ttf");
        
        public final String[] paths;

        private FontFamily(String... strArr) {
            this.paths = strArr;
        }

        public static FontFamily fromIndex(int i) {
            return values()[i];
        }
    }

    /* compiled from: request_module_analytics_tag */
    public enum FontWeight {
        THIN,
        LIGHT,
        REGULAR,
        MEDIUM,
        BOLD,
        BLACK,
        BUILTIN;

        public static FontWeight fromIndex(int i) {
            return values()[i];
        }
    }

    public static void m11814a(TextView textView, FontFamily fontFamily, FontWeight fontWeight, @Nullable Typeface typeface) {
        Typeface a = m11813a(textView.getContext(), fontFamily, fontWeight, typeface);
        if (a != typeface) {
            textView.setTypeface(a);
        }
    }

    @Nullable
    public static Typeface m11813a(Context context, FontFamily fontFamily, FontWeight fontWeight, @Nullable Typeface typeface) {
        if (fontFamily == FontFamily.BUILTIN) {
            return typeface;
        }
        if (fontWeight != FontWeight.BUILTIN) {
            return m11812a(context, fontFamily, fontWeight);
        }
        if (typeface == null || !typeface.isBold()) {
            return m11812a(context, fontFamily, FontWeight.REGULAR);
        }
        return m11812a(context, fontFamily, FontWeight.BOLD);
    }

    private static Typeface m11812a(Context context, FontFamily fontFamily, FontWeight fontWeight) {
        Typeface create;
        Typeface typeface;
        String str;
        if (fontFamily.equals(FontFamily.ROBOTO)) {
            if (fontWeight == FontWeight.REGULAR) {
                create = Typeface.create("sans-serif", 0);
            } else if (fontWeight == FontWeight.BOLD) {
                create = Typeface.create("sans-serif", 1);
            } else if (fontWeight == FontWeight.LIGHT) {
                create = Typeface.create("sans-serif-light", 0);
            }
            typeface = create;
            if (typeface == null) {
                return typeface;
            }
            str = fontFamily.paths[fontWeight.ordinal()];
            create = (Typeface) f7292a.get(str);
            if (create == null) {
                create = Typeface.createFromAsset(context.getAssets(), str);
                f7292a.put(str, create);
            }
            return create;
        }
        create = null;
        typeface = create;
        if (typeface == null) {
            return typeface;
        }
        str = fontFamily.paths[fontWeight.ordinal()];
        create = (Typeface) f7292a.get(str);
        if (create == null) {
            create = Typeface.createFromAsset(context.getAssets(), str);
            f7292a.put(str, create);
        }
        return create;
    }
}
