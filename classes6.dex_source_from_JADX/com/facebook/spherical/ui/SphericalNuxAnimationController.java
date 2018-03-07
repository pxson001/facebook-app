package com.facebook.spherical.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import com.facebook.inject.InjectorLike;
import com.facebook.proguard.annotations.DoNotStrip;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: entry_from_checkin */
public class SphericalNuxAnimationController {
    private final Interpolator f16383a = PathInterpolatorCompat.a(0.23f, 1.0f, 0.32f, 1.0f);
    public AnimatorSet f16384b;
    public AnimatorSet f16385c;
    public ObjectAnimator f16386d;
    public ObjectAnimator f16387e;
    public boolean f16388f;

    public static SphericalNuxAnimationController m23868a(InjectorLike injectorLike) {
        return new SphericalNuxAnimationController();
    }

    @Inject
    public SphericalNuxAnimationController() {
        this.f16388f = VERSION.SDK_INT >= 19;
    }

    public final void m23870a(Spherical360GyroAnimationView spherical360GyroAnimationView, long j, long j2, long j3, int i) {
        this.f16384b = new AnimatorSet();
        spherical360GyroAnimationView.setAlpha(0.0f);
        Animator ofFloat = ObjectAnimator.ofFloat(spherical360GyroAnimationView, "alpha", new float[]{1.0f});
        ofFloat.setInterpolator(this.f16383a);
        ofFloat.setDuration(j);
        Animator ofFloat2 = ObjectAnimator.ofFloat(spherical360GyroAnimationView, "alpha", new float[]{0.0f});
        ofFloat2.setInterpolator(this.f16383a);
        ofFloat2.setDuration(j2);
        spherical360GyroAnimationView.m23825a(j3, i);
        this.f16386d = spherical360GyroAnimationView.f16302i;
        this.f16384b.play(ofFloat);
        this.f16384b.play(this.f16386d).after(ofFloat);
        this.f16384b.play(ofFloat2).after(this.f16386d);
    }

    public final void m23871a(Spherical360PhoneAnimationView spherical360PhoneAnimationView, long j, long j2, long j3, long j4) {
        this.f16385c = new AnimatorSet();
        spherical360PhoneAnimationView.setAlpha(0.0f);
        Animator ofFloat = ObjectAnimator.ofFloat(spherical360PhoneAnimationView, "alpha", new float[]{1.0f});
        ofFloat.setInterpolator(this.f16383a);
        ofFloat.setDuration(j);
        Animator ofFloat2 = ObjectAnimator.ofFloat(spherical360PhoneAnimationView, "alpha", new float[]{0.0f});
        ofFloat2.setInterpolator(this.f16383a);
        ofFloat2.setDuration(j2);
        spherical360PhoneAnimationView.m23828a(j3, 1);
        this.f16387e = spherical360PhoneAnimationView.getPhoneAnimator();
        this.f16385c.play(ofFloat);
        this.f16385c.play(this.f16387e).after(ofFloat);
        this.f16385c.play(ofFloat2).after(this.f16387e);
        this.f16385c.setStartDelay(j4);
    }

    public final void m23869a() {
        m23873c();
        m23872b();
    }

    public final void m23872b() {
        if (this.f16385c != null) {
            this.f16385c.end();
        }
    }

    public final void m23873c() {
        if (this.f16384b != null) {
            this.f16384b.end();
        }
    }

    public final void m23874g() {
        if (this.f16384b != null) {
            this.f16384b.start();
        }
    }

    public final void m23875h() {
        if (this.f16385c != null) {
            this.f16385c.start();
        }
    }
}
