package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import javax.annotation.Nullable;

/* compiled from: RecommendedPagesInCategory */
public class CustomStyleSpan extends MetricAffectingSpan {
    private final AssetManager f11511a;
    private final int f11512b;
    private final int f11513c;
    @Nullable
    private final String f11514d;

    public CustomStyleSpan(int i, int i2, @Nullable String str, AssetManager assetManager) {
        this.f11512b = i;
        this.f11513c = i2;
        this.f11514d = str;
        this.f11511a = assetManager;
    }

    public void updateDrawState(TextPaint textPaint) {
        m11966a(textPaint, this.f11512b, this.f11513c, this.f11514d, this.f11511a);
    }

    public void updateMeasureState(TextPaint textPaint) {
        m11966a(textPaint, this.f11512b, this.f11513c, this.f11514d, this.f11511a);
    }

    private static void m11966a(Paint paint, int i, int i2, @Nullable String str, AssetManager assetManager) {
        int i3 = 0;
        Typeface typeface = paint.getTypeface();
        int i4;
        if (typeface == null) {
            i4 = 0;
        } else {
            i4 = typeface.getStyle();
        }
        if (i2 == 1 || ((r3 & 1) != 0 && i2 == -1)) {
            i3 = 1;
        }
        if (i == 2 || ((r3 & 2) != 0 && i == -1)) {
            i3 |= 2;
        }
        if (str != null) {
            typeface = ReactFontManager.m11973a().m11975a(str, i3, assetManager);
        } else if (typeface != null) {
            typeface = Typeface.create(typeface, i3);
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
        } else {
            paint.setTypeface(Typeface.defaultFromStyle(i3));
        }
    }
}
