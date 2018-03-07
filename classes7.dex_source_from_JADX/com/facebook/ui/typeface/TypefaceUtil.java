package com.facebook.ui.typeface;

import android.graphics.Typeface;
import android.text.TextPaint;
import javax.annotation.Nullable;

/* compiled from: empty_state_action */
public class TypefaceUtil {
    public static Typeface m19326a(@Nullable Typeface typeface, int i) {
        if (typeface == null) {
            return Typeface.defaultFromStyle(i);
        }
        return Typeface.create(typeface, i);
    }

    public static void m19327a(TextPaint textPaint, Typeface typeface, int i) {
        int style;
        boolean z = false;
        textPaint.setTypeface(typeface);
        if (typeface != null) {
            style = typeface.getStyle();
        } else {
            style = 0;
        }
        style = (style ^ -1) & i;
        if ((style & 1) != 0) {
            z = true;
        }
        textPaint.setFakeBoldText(z);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
    }
}
