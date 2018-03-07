package com.facebook.commerce.publishing.util;

import android.content.res.Resources;
import com.facebook.fbui.glyph.GlyphColorizer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cta_promotion */
public class AdminShopTextUtil {
    private final GlyphColorizer f15640a;
    private final Resources f15641b;

    @Inject
    public AdminShopTextUtil(GlyphColorizer glyphColorizer, Resources resources) {
        this.f15640a = glyphColorizer;
        this.f15641b = resources;
    }

    public static boolean m16111a(@Nullable String str, @Nullable String str2) {
        return m16110a(str).equals(m16110a(str2));
    }

    private static String m16110a(@Nullable String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }
}
