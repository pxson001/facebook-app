package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* compiled from: userTitle */
class SwipeRefreshLayout$4 extends Animation {
    final /* synthetic */ int f543a;
    final /* synthetic */ int f544b;
    final /* synthetic */ SwipeRefreshLayout f545c;

    SwipeRefreshLayout$4(SwipeRefreshLayout swipeRefreshLayout, int i, int i2) {
        this.f545c = swipeRefreshLayout;
        this.f543a = i;
        this.f544b = i2;
    }

    public void applyTransformation(float f, Transformation transformation) {
        this.f545c.w.setAlpha((int) (((float) this.f543a) + (((float) (this.f544b - this.f543a)) * f)));
    }
}
