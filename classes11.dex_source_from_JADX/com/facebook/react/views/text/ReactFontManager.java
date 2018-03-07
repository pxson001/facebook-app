package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: Received odd number of strings; keys and vals unmatched */
public class ReactFontManager {
    private static final String[] f11516a = new String[]{"", "_bold", "_italic", "_bold_italic"};
    private static final String[] f11517b = new String[]{".ttf", ".otf"};
    private static ReactFontManager f11518c;
    private Map<String, FontFamily> f11519d = new HashMap();

    /* compiled from: Received odd number of strings; keys and vals unmatched */
    class FontFamily {
        private SparseArray<Typeface> f11515a;

        public FontFamily() {
            this.f11515a = new SparseArray(4);
        }

        public final Typeface m11971a(int i) {
            return (Typeface) this.f11515a.get(i);
        }

        public final void m11972a(int i, Typeface typeface) {
            this.f11515a.put(i, typeface);
        }
    }

    private ReactFontManager() {
    }

    public static ReactFontManager m11973a() {
        if (f11518c == null) {
            f11518c = new ReactFontManager();
        }
        return f11518c;
    }

    @Nullable
    public final Typeface m11975a(String str, int i, AssetManager assetManager) {
        FontFamily fontFamily = (FontFamily) this.f11519d.get(str);
        if (fontFamily == null) {
            fontFamily = new FontFamily();
            this.f11519d.put(str, fontFamily);
        }
        Typeface a = fontFamily.m11971a(i);
        if (a == null) {
            a = m11974b(str, i, assetManager);
            if (a != null) {
                fontFamily.m11972a(i, a);
            }
        }
        return a;
    }

    @Nullable
    private static Typeface m11974b(String str, int i, AssetManager assetManager) {
        String str2 = f11516a[i];
        String[] strArr = f11517b;
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                return Typeface.createFromAsset(assetManager, "fonts/" + str + str2 + strArr[i2]);
            } catch (RuntimeException e) {
                i2++;
            }
        }
        return Typeface.create(str, i);
    }
}
