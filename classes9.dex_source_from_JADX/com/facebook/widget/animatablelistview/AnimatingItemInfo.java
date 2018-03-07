package com.facebook.widget.animatablelistview;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: android.permission.REQUEST_INSTALL_PACKAGES */
public class AnimatingItemInfo<T> {
    private final Set<AnimationListener> f20445a = Sets.a();
    public float f20446b = 1.0f;
    public float f20447c = 1.0f;
    public float f20448d = 1.0f;
    public float f20449e = 1.0f;
    public int f20450f = 0;

    /* compiled from: android.permission.REQUEST_INSTALL_PACKAGES */
    public abstract class AnimationListener {
        public abstract void mo838a();
    }

    public final float m20006a() {
        return this.f20446b;
    }

    public void setAnimationOffset(float f) {
        boolean z = f >= -1.0f && f <= 1.0f;
        Preconditions.checkArgument(z);
        this.f20446b = f;
        m20005f();
    }

    public final float m20008b() {
        return this.f20447c;
    }

    public void setScaleX(float f) {
        this.f20447c = f;
        m20005f();
    }

    public final float m20010c() {
        return this.f20448d;
    }

    public void setScaleY(float f) {
        this.f20448d = f;
        m20005f();
    }

    public final float m20011d() {
        return this.f20449e;
    }

    public void setAlpha(float f) {
        this.f20449e = f;
        m20005f();
    }

    public final int m20012e() {
        return this.f20450f;
    }

    public void setVisibility(int i) {
        this.f20450f = i;
        m20005f();
    }

    public final void m20007a(AnimationListener animationListener) {
        this.f20445a.add(animationListener);
    }

    public final void m20009b(AnimationListener animationListener) {
        this.f20445a.remove(animationListener);
    }

    private void m20005f() {
        for (AnimationListener a : this.f20445a) {
            a.mo838a();
        }
    }
}
