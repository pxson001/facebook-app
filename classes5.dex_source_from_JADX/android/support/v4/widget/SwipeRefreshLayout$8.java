package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: userTitle */
class SwipeRefreshLayout$8 extends Animation {
    final /* synthetic */ SwipeRefreshLayout f547a;

    SwipeRefreshLayout$8(SwipeRefreshLayout swipeRefreshLayout) {
        this.f547a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.setAnimationProgress(this.f547a, this.f547a.v + ((-this.f547a.v) * f));
        SwipeRefreshLayout.b(this.f547a, f);
    }
}
