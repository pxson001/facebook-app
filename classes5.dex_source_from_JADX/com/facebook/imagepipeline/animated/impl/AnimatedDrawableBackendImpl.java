package com.facebook.imagepipeline.animated.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageFrame;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import java.util.Arrays;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: TRAVEL_PLANNING */
public class AnimatedDrawableBackendImpl implements AnimatedDrawableBackend {
    private final AnimatedDrawableUtil f13628a;
    private final AnimatedImageResult f13629b;
    private final AnimatedImage f13630c;
    private final Rect f13631d;
    private final int[] f13632e = this.f13630c.d();
    private final int[] f13633f;
    private final int f13634g;
    private final AnimatedDrawableFrameInfo[] f13635h;
    @GuardedBy("this")
    private Bitmap f13636i;

    public AnimatedDrawableBackendImpl(AnimatedDrawableUtil animatedDrawableUtil, AnimatedImageResult animatedImageResult, Rect rect) {
        int i;
        this.f13628a = animatedDrawableUtil;
        this.f13629b = animatedImageResult;
        this.f13630c = animatedImageResult.f13614a;
        int[] iArr = this.f13632e;
        for (i = 0; i < iArr.length; i++) {
            if (iArr[i] < 11) {
                iArr[i] = 100;
            }
        }
        iArr = this.f13632e;
        i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 += iArr[i];
            i++;
        }
        this.f13634g = i2;
        iArr = this.f13632e;
        i = 0;
        int[] iArr2 = new int[iArr.length];
        i2 = 0;
        while (i < iArr.length) {
            iArr2[i] = i2;
            i2 += iArr[i];
            i++;
        }
        this.f13633f = iArr2;
        this.f13631d = m22915a(this.f13630c, rect);
        this.f13635h = new AnimatedDrawableFrameInfo[this.f13630c.c()];
        for (int i3 = 0; i3 < this.f13630c.c(); i3++) {
            this.f13635h[i3] = this.f13630c.b(i3);
        }
    }

    private static Rect m22915a(AnimatedImage animatedImage, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, animatedImage.a(), animatedImage.b());
        }
        return new Rect(0, 0, Math.min(rect.width(), animatedImage.a()), Math.min(rect.height(), animatedImage.b()));
    }

    public final AnimatedImageResult mo1240a() {
        return this.f13629b;
    }

    public final int mo1242b() {
        return this.f13634g;
    }

    public final int mo1244c() {
        return this.f13630c.c();
    }

    public final int mo1246d() {
        return this.f13630c.e();
    }

    public final int mo1248e() {
        return this.f13630c.a();
    }

    public final int mo1250f() {
        return this.f13630c.b();
    }

    public final int mo1252g() {
        return this.f13631d.width();
    }

    public final int mo1253h() {
        return this.f13631d.height();
    }

    public final AnimatedDrawableFrameInfo mo1239a(int i) {
        return this.f13635h[i];
    }

    public final int mo1243b(int i) {
        int binarySearch = Arrays.binarySearch(this.f13633f, i);
        if (binarySearch < 0) {
            binarySearch = ((-binarySearch) - 1) - 1;
        }
        return binarySearch;
    }

    public final int mo1245c(int i) {
        Preconditions.a(i, this.f13633f.length);
        return this.f13633f[i];
    }

    public final int mo1247d(int i) {
        return this.f13632e[i];
    }

    public final int mo1254i() {
        return this.f13629b.f13615b;
    }

    public final AnimatedDrawableBackend mo1259a(Rect rect) {
        return m22915a(this.f13630c, rect).equals(this.f13631d) ? this : new AnimatedDrawableBackendImpl(this.f13628a, this.f13629b, rect);
    }

    public final synchronized int mo1255j() {
        int i;
        i = 0;
        if (this.f13636i != null) {
            i = AnimatedDrawableUtil.a(this.f13636i) + 0;
        }
        return i + this.f13630c.g();
    }

    public final CloseableReference<Bitmap> mo1249e(int i) {
        return this.f13629b.m22881a(i);
    }

    public final boolean mo1251f(int i) {
        return this.f13629b.m22883b(i);
    }

    public final void mo1241a(int i, Canvas canvas) {
        AnimatedImageFrame a = this.f13630c.a(i);
        try {
            if (this.f13630c.f()) {
                m22916a(canvas, a);
            } else {
                m22917b(canvas, a);
            }
            a.mo1087a();
        } catch (Throwable th) {
            a.mo1087a();
        }
    }

    private void m22916a(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        double width = ((double) this.f13631d.width()) / ((double) this.f13630c.a());
        double height = ((double) this.f13631d.height()) / ((double) this.f13630c.b());
        int round = (int) Math.round(((double) animatedImageFrame.mo1089b()) * width);
        int round2 = (int) Math.round(((double) animatedImageFrame.mo1090c()) * height);
        int d = (int) (width * ((double) animatedImageFrame.mo1091d()));
        int e = (int) (height * ((double) animatedImageFrame.mo1092e()));
        synchronized (this) {
            if (this.f13636i == null) {
                this.f13636i = Bitmap.createBitmap(this.f13631d.width(), this.f13631d.height(), Config.ARGB_8888);
            }
            this.f13636i.eraseColor(0);
            animatedImageFrame.mo1088a(round, round2, this.f13636i);
            canvas.drawBitmap(this.f13636i, (float) d, (float) e, null);
        }
    }

    private void m22917b(Canvas canvas, AnimatedImageFrame animatedImageFrame) {
        int b = animatedImageFrame.mo1089b();
        int c = animatedImageFrame.mo1090c();
        int d = animatedImageFrame.mo1091d();
        int e = animatedImageFrame.mo1092e();
        synchronized (this) {
            if (this.f13636i == null) {
                this.f13636i = Bitmap.createBitmap(this.f13630c.a(), this.f13630c.b(), Config.ARGB_8888);
            }
            this.f13636i.eraseColor(0);
            animatedImageFrame.mo1088a(b, c, this.f13636i);
            float width = ((float) this.f13631d.width()) / ((float) this.f13630c.a());
            float height = ((float) this.f13631d.height()) / ((float) this.f13630c.b());
            canvas.save();
            canvas.scale(width, height);
            canvas.translate((float) d, (float) e);
            canvas.drawBitmap(this.f13636i, 0.0f, 0.0f, null);
            canvas.restore();
        }
    }

    public final synchronized void mo1256k() {
        if (this.f13636i != null) {
            this.f13636i.recycle();
            this.f13636i = null;
        }
    }
}
