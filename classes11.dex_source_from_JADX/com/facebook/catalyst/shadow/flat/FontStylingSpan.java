package com.facebook.catalyst.shadow.flat;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import javax.annotation.Nullable;

/* compiled from: locked-open */
public final class FontStylingSpan extends MetricAffectingSpan {
    static final FontStylingSpan f5750a = new FontStylingSpan(Double.NaN, 0, -1, -1, -1, null, true);
    public double f5751b;
    public int f5752c;
    public int f5753d;
    public int f5754e;
    public int f5755f;
    @Nullable
    public String f5756g;
    public boolean f5757h;

    FontStylingSpan() {
    }

    public FontStylingSpan(double d, int i, int i2, int i3, int i4, @Nullable String str, boolean z) {
        this.f5751b = d;
        this.f5752c = i;
        this.f5753d = i2;
        this.f5754e = i3;
        this.f5755f = i4;
        this.f5756g = str;
        this.f5757h = z;
    }

    public final void updateDrawState(TextPaint textPaint) {
        if (!Double.isNaN(this.f5751b)) {
            textPaint.setColor((int) this.f5751b);
        }
        textPaint.bgColor = this.f5752c;
        updateMeasureState(textPaint);
    }

    public final void updateMeasureState(TextPaint textPaint) {
        if (this.f5753d != -1) {
            textPaint.setTextSize((float) this.f5753d);
        }
        m7085a(textPaint);
    }

    private int m7086e(int i) {
        if (this.f5754e != -1) {
            i = (i & -3) | this.f5754e;
        }
        if (this.f5755f != -1) {
            return (i & -2) | this.f5755f;
        }
        return i;
    }

    private void m7085a(TextPaint textPaint) {
        Typeface typeface = textPaint.getTypeface();
        int style = typeface == null ? 0 : typeface.getStyle();
        int e = m7086e(style);
        if (style != e || this.f5756g != null) {
            Typeface typeface2;
            Typeface typeface3;
            Typeface b;
            if (this.f5756g != null) {
                String str = this.f5756g;
                Object obj = (Typeface[]) TypefaceCache.f5828a.get(str);
                if (obj == null) {
                    obj = new Typeface[4];
                    TypefaceCache.f5828a.put(str, obj);
                } else if (obj[e] != null) {
                    typeface3 = obj[e];
                    typeface2 = typeface3;
                }
                b = TypefaceCache.m7243b(str, e);
                obj[e] = b;
                TypefaceCache.f5829b.put(b, obj);
                typeface3 = b;
                typeface2 = typeface3;
            } else {
                if (typeface == null) {
                    typeface3 = Typeface.defaultFromStyle(e);
                } else {
                    Typeface[] typefaceArr = (Typeface[]) TypefaceCache.f5829b.get(typeface);
                    if (typefaceArr == null) {
                        typefaceArr = new Typeface[4];
                        typefaceArr[typeface.getStyle()] = typeface;
                    } else if (typefaceArr[e] != null) {
                        typeface3 = typefaceArr[e];
                    }
                    b = Typeface.create(typeface, e);
                    typefaceArr[e] = b;
                    TypefaceCache.f5829b.put(b, typefaceArr);
                    typeface3 = b;
                }
                typeface2 = typeface3;
            }
            textPaint.setTypeface(typeface2);
        }
    }
}
