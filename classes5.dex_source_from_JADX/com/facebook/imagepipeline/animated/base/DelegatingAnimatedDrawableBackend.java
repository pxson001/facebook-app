package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.common.references.CloseableReference;

/* compiled from: TREEHOUSE_ANDROID_GROUPS_TAB */
public abstract class DelegatingAnimatedDrawableBackend implements AnimatedDrawableBackend {
    private final AnimatedDrawableBackend f13622a;

    public DelegatingAnimatedDrawableBackend(AnimatedDrawableBackend animatedDrawableBackend) {
        this.f13622a = animatedDrawableBackend;
    }

    public final AnimatedImageResult mo1240a() {
        return this.f13622a.mo1240a();
    }

    public final int mo1242b() {
        return this.f13622a.mo1242b();
    }

    public final int mo1244c() {
        return this.f13622a.mo1244c();
    }

    public final int mo1246d() {
        return this.f13622a.mo1246d();
    }

    public final int mo1248e() {
        return this.f13622a.mo1248e();
    }

    public final int mo1250f() {
        return this.f13622a.mo1250f();
    }

    public final int mo1252g() {
        return this.f13622a.mo1252g();
    }

    public final int mo1253h() {
        return this.f13622a.mo1253h();
    }

    public final AnimatedDrawableFrameInfo mo1239a(int i) {
        return this.f13622a.mo1239a(i);
    }

    public void mo1241a(int i, Canvas canvas) {
        this.f13622a.mo1241a(i, canvas);
    }

    public final int mo1243b(int i) {
        return this.f13622a.mo1243b(i);
    }

    public final int mo1245c(int i) {
        return this.f13622a.mo1245c(i);
    }

    public final int mo1247d(int i) {
        return this.f13622a.mo1247d(i);
    }

    public final int mo1254i() {
        return this.f13622a.mo1254i();
    }

    public int mo1255j() {
        return this.f13622a.mo1255j();
    }

    public final CloseableReference<Bitmap> mo1249e(int i) {
        return this.f13622a.mo1249e(i);
    }

    public final boolean mo1251f(int i) {
        return this.f13622a.mo1251f(i);
    }

    public void mo1256k() {
        this.f13622a.mo1256k();
    }
}
