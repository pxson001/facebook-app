package com.facebook.catalyst.shadow.flat;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import com.facebook.infer.annotation.Assertions;
import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: layout_places */
public final class TypefaceCache {
    public static final HashMap<String, Typeface[]> f5828a = new HashMap();
    public static final HashMap<Typeface, Typeface[]> f5829b = new HashMap();
    private static final String[] f5830c = new String[]{"", "_bold", "_italic", "_bold_italic"};
    private static final String[] f5831d = new String[]{".ttf", ".otf"};
    @Nullable
    public static AssetManager f5832e = null;

    TypefaceCache() {
    }

    public static Typeface m7243b(String str, int i) {
        StringBuilder append = new StringBuilder(32).append("fonts/").append(str).append(f5830c[i]);
        int length = append.length();
        String[] strArr = f5831d;
        int length2 = strArr.length;
        int i2 = 0;
        while (i2 < length2) {
            try {
                return Typeface.createFromAsset(f5832e, append.append(strArr[i2]).toString());
            } catch (RuntimeException e) {
                append.setLength(length);
                i2++;
            }
        }
        return (Typeface) Assertions.a(Typeface.create(str, i));
    }
}
