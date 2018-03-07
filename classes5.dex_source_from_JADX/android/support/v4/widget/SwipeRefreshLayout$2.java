package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: userTitle */
class SwipeRefreshLayout$2 extends Animation {
    final /* synthetic */ SwipeRefreshLayout f541a;

    SwipeRefreshLayout$2(SwipeRefreshLayout swipeRefreshLayout) {
        this.f541a = swipeRefreshLayout;
    }

    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout.setAnimationProgress(this.f541a, f);
    }
}
