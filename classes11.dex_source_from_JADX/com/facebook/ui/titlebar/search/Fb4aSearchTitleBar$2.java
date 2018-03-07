package com.facebook.ui.titlebar.search;

import android.animation.Animator;
import android.view.ViewGroup.MarginLayoutParams;
import com.facebook.ui.animations.BaseAnimatorListener;

/* compiled from: nearbyMapFragment */
class Fb4aSearchTitleBar$2 extends BaseAnimatorListener {
    final /* synthetic */ Fb4aSearchTitleBar f5164a;

    Fb4aSearchTitleBar$2(Fb4aSearchTitleBar fb4aSearchTitleBar) {
        this.f5164a = fb4aSearchTitleBar;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.f5164a.d();
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f5164a.getLayoutParams();
        if (this.f5164a.n.a()) {
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, 0, marginLayoutParams.bottomMargin);
        } else {
            marginLayoutParams.setMargins(0, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        this.f5164a.setLayoutParams(marginLayoutParams);
        this.f5164a.requestLayout();
    }
}
