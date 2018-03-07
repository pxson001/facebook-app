package com.facebook.imagepipeline.animated.impl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableCachingBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableDiagnostics;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;

/* compiled from: TRAVEL_COMPANY */
public class AnimatedDrawableDiagnosticsImpl implements AnimatedDrawableDiagnostics {
    private static final Class<?> f13661a = AnimatedDrawableDiagnostics.class;
    private final AnimatedDrawableUtil f13662b;
    private final DisplayMetrics f13663c;
    private final TextPaint f13664d = new TextPaint();
    private final StringBuilder f13665e = new StringBuilder();
    private final RollingStat f13666f = new RollingStat();
    private final RollingStat f13667g = new RollingStat();
    private AnimatedDrawableCachingBackend f13668h;
    private long f13669i;

    public AnimatedDrawableDiagnosticsImpl(AnimatedDrawableUtil animatedDrawableUtil, DisplayMetrics displayMetrics) {
        this.f13662b = animatedDrawableUtil;
        this.f13663c = displayMetrics;
        this.f13664d.setColor(-16776961);
        this.f13664d.setTextSize((float) m22965c(14));
    }

    public final void mo1267a(AnimatedDrawableCachingBackend animatedDrawableCachingBackend) {
        this.f13668h = animatedDrawableCachingBackend;
    }

    public final void mo1264a() {
        this.f13669i = SystemClock.uptimeMillis();
    }

    public final void mo1268b() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.f13669i;
        if (uptimeMillis > 3) {
            Long.valueOf(uptimeMillis);
        }
    }

    public final void mo1270c() {
        this.f13669i = SystemClock.uptimeMillis();
    }

    public final void mo1271d() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.f13669i;
        if (uptimeMillis > 3) {
            Long.valueOf(uptimeMillis);
        }
    }

    public final void mo1265a(int i) {
        this.f13666f.m22990a(i);
        if (i > 0) {
            Integer.valueOf(i);
        }
    }

    public final void mo1269b(int i) {
        this.f13667g.m22990a(i);
    }

    public final void mo1272e() {
        this.f13669i = SystemClock.uptimeMillis();
    }

    public final void mo1273f() {
        Long.valueOf(SystemClock.uptimeMillis() - this.f13669i);
    }

    public final void mo1266a(Canvas canvas, Rect rect) {
        int i;
        int b = this.f13666f.m22991b(10);
        int b2 = this.f13667g.m22991b(10);
        b += b2;
        int c = m22965c(10);
        int c2 = m22965c(20);
        int c3 = m22965c(5);
        if (b > 0) {
            b = (b2 * 100) / b;
            this.f13665e.setLength(0);
            this.f13665e.append(b);
            this.f13665e.append("%");
            canvas.drawText(this.f13665e, 0, this.f13665e.length(), (float) c, (float) c2, this.f13664d);
            b = ((int) (((float) c) + this.f13664d.measureText(this.f13665e, 0, this.f13665e.length()))) + c3;
        } else {
            b = c;
        }
        b2 = this.f13668h.mo1255j();
        this.f13665e.setLength(0);
        AnimatedDrawableUtil.a(this.f13665e, b2);
        float measureText = this.f13664d.measureText(this.f13665e, 0, this.f13665e.length());
        if (((float) b) + measureText > ((float) rect.width())) {
            c2 = (int) (((float) c2) + (this.f13664d.getTextSize() + ((float) c3)));
            i = c;
        } else {
            i = b;
        }
        canvas.drawText(this.f13665e, 0, this.f13665e.length(), (float) i, (float) c2, this.f13664d);
        b = ((int) (((float) i) + measureText)) + c3;
        this.f13665e.setLength(0);
        this.f13668h.mo1260a(this.f13665e);
        if (this.f13664d.measureText(this.f13665e, 0, this.f13665e.length()) + ((float) b) > ((float) rect.width())) {
            c2 = (int) (((float) c2) + (this.f13664d.getTextSize() + ((float) c3)));
        } else {
            c = b;
        }
        canvas.drawText(this.f13665e, 0, this.f13665e.length(), (float) c, (float) c2, this.f13664d);
    }

    private int m22965c(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, this.f13663c);
    }
}
