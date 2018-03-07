package com.facebook.ui.titlebar.search;

import android.animation.Animator;
import android.view.View;
import com.facebook.ui.animations.BaseAnimatorListener;

/* compiled from: nearbyMapFragment */
class Fb4aSearchTitleBar$1 extends BaseAnimatorListener {
    final /* synthetic */ Fb4aSearchTitleBar f5163a;

    Fb4aSearchTitleBar$1(Fb4aSearchTitleBar fb4aSearchTitleBar) {
        this.f5163a = fb4aSearchTitleBar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        View a = Fb4aSearchTitleBar.a(this.f5163a);
        if (a != null) {
            a.setBackgroundResource(0);
        }
        a = Fb4aSearchTitleBar.b(this.f5163a);
        if (a != null) {
            a.setBackgroundResource(0);
        }
    }
}
