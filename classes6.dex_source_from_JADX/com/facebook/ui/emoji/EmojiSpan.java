package com.facebook.ui.emoji;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import com.facebook.ui.emoji.model.Emoji;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: cropBox */
public class EmojiSpan extends ImageSpan {
    private static char f18348a = '﻿';
    public Emoji f18349b;
    private WeakReference<Drawable> f18350c;

    public EmojiSpan(BitmapDrawable bitmapDrawable, Emoji emoji) {
        super(bitmapDrawable, 0);
        this.f18349b = emoji;
    }

    private Drawable m26961b() {
        WeakReference weakReference = this.f18350c;
        Drawable drawable = null;
        if (weakReference != null) {
            drawable = (Drawable) weakReference.get();
        }
        if (drawable != null) {
            return drawable;
        }
        drawable = getDrawable();
        this.f18350c = new WeakReference(drawable);
        return drawable;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, @Nullable FontMetricsInt fontMetricsInt) {
        if (m26960a(charSequence, i, i2)) {
            return 0;
        }
        Rect bounds = m26961b().getBounds();
        int a = m26958a(paint, 2);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -m26959a(paint, bounds);
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right + a;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (!m26960a(charSequence, i, i2)) {
            Drawable b = m26961b();
            Rect bounds = b.getBounds();
            canvas.save();
            canvas.translate(((float) m26958a(paint, 1)) + f, (float) (i5 - m26959a(paint, bounds)));
            b.draw(canvas);
            canvas.restore();
        }
    }

    private int m26959a(Paint paint, Rect rect) {
        return rect.bottom + m26958a(paint, 2);
    }

    private static int m26958a(Paint paint, int i) {
        return (int) ((((float) i) * ((TextPaint) paint).density) + 0.5f);
    }

    private static boolean m26960a(CharSequence charSequence, int i, int i2) {
        int i3 = i;
        while (i3 < i2 && i3 < charSequence.length()) {
            if (charSequence.charAt(i) != f18348a) {
                return false;
            }
            i3++;
        }
        return true;
    }
}
