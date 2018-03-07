package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: userTitle */
class SwipeRefreshLayout$5 implements AnimationListener {
    final /* synthetic */ SwipeRefreshLayout f546a;

    SwipeRefreshLayout$5(SwipeRefreshLayout swipeRefreshLayout) {
        this.f546a = swipeRefreshLayout;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f546a.p) {
            SwipeRefreshLayout.b(this.f546a, null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
