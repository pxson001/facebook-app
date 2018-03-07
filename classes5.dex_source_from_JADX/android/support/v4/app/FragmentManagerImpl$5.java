package android.support.v4.app;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: wilde_group_profile_upsell */
class FragmentManagerImpl$5 implements AnimationListener {
    final /* synthetic */ Fragment f70a;
    final /* synthetic */ FragmentManagerImpl f71b;

    FragmentManagerImpl$5(FragmentManagerImpl fragmentManagerImpl, Fragment fragment) {
        this.f71b = fragmentManagerImpl;
        this.f70a = fragment;
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f70a.l != null) {
            this.f70a.l = null;
            this.f71b.a(this.f70a, this.f70a.m, 0, 0, false);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
