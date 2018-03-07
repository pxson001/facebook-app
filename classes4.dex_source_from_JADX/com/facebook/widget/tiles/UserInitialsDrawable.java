package com.facebook.widget.tiles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.util.Patterns;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.common.util.StringUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: oxygen_map_default_reporter_dialog_clicked */
public class UserInitialsDrawable extends Drawable implements Callback {
    public final Paint f5716a = new Paint();
    private final Rect f5717b;
    public final RectF f5718c;
    public String f5719d;
    private String f5720e;
    public int f5721f;
    public boolean f5722g;
    private InitialsStyle f5723h = InitialsStyle.ONE_LETTER;

    /* compiled from: oxygen_map_default_reporter_dialog_clicked */
    public enum InitialsStyle {
        ONE_LETTER,
        TWO_LETTER
    }

    public UserInitialsDrawable() {
        this.f5716a.setFlags(1);
        this.f5716a.setTextAlign(Align.CENTER);
        this.f5717b = new Rect();
        this.f5718c = new RectF();
    }

    public final boolean m6202a(String str) {
        if (!Objects.equal(this.f5720e, str)) {
            this.f5720e = str;
            String a = m6195a(str, this.f5723h);
            if (a != null) {
                m6196c(StringLocaleUtil.b(a));
            }
        }
        return this.f5719d != null;
    }

    public final void m6198a() {
        this.f5720e = null;
        this.f5722g = false;
        m6196c(null);
    }

    public final boolean m6204b(String str) {
        return Objects.equal(this.f5720e, str);
    }

    public final void m6200a(int i) {
        this.f5720e = null;
        m6196c(String.valueOf(Character.toChars(i)));
    }

    public void draw(Canvas canvas) {
        if (!StringUtil.a(this.f5719d)) {
            Rect bounds = getBounds();
            if (this.f5722g) {
                int color = this.f5716a.getColor();
                this.f5716a.setColor(this.f5721f);
                this.f5718c.set(bounds);
                canvas.drawOval(this.f5718c, this.f5716a);
                this.f5716a.setColor(color);
            }
            this.f5716a.getTextBounds(this.f5719d, 0, this.f5719d.length(), this.f5717b);
            canvas.drawText(this.f5719d, bounds.exactCenterX(), bounds.exactCenterY() + ((float) (this.f5717b.height() / 2)), this.f5716a);
        }
    }

    public final void m6199a(float f) {
        this.f5716a.setTextSize(f);
    }

    public final void m6203b(@ColorInt int i) {
        this.f5716a.setColor(i);
    }

    public final void m6201a(Context context, @ColorRes int i) {
        if (VERSION.SDK_INT >= 23) {
            this.f5716a.setColor(context.getColor(i));
        } else {
            this.f5716a.setColor(context.getResources().getColor(i));
        }
    }

    public final void m6205c(@ColorInt int i) {
        this.f5722g = true;
        this.f5721f = i;
    }

    public void setAlpha(int i) {
        this.f5716a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f5716a.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    private void m6196c(String str) {
        if (!Objects.equal(str, this.f5719d)) {
            this.f5719d = str;
            invalidateSelf();
        }
    }

    @Nullable
    @VisibleForTesting
    private static String m6195a(String str, InitialsStyle initialsStyle) {
        if (StringUtil.a(str)) {
            return null;
        }
        Object trim = str.trim();
        if (StringUtil.a(trim) || Patterns.PHONE.matcher(trim).matches()) {
            return null;
        }
        List a = StringUtil.a(trim, ' ');
        StringBuilder appendCodePoint = new StringBuilder().appendCodePoint(m6197d((String) a.get(0)));
        if (initialsStyle == InitialsStyle.TWO_LETTER && a.size() > 1) {
            appendCodePoint.appendCodePoint(m6197d((String) a.get(a.size() - 1)));
        }
        return appendCodePoint.toString();
    }

    private static int m6197d(String str) {
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            if (Character.isLetterOrDigit(codePointAt)) {
                return codePointAt;
            }
            i += Character.charCount(codePointAt);
        }
        return str.codePointAt(0);
    }
}
