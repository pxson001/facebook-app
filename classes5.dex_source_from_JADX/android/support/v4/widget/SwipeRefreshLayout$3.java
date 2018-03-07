package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: userTitle */
class SwipeRefreshLayout$3 extends Animation {
    final /* synthetic */ SwipeRefreshLayout f542a;

    SwipeRefreshLayout$3(SwipeRefreshLayout swipeRefreshLayout) {
        this.f542a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.setAnimationProgress(this.f542a, 1.0f - f);
    }
}
