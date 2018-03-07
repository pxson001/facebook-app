package android.support.v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: vertex_permanently_closed_dialog */
class ViewPropertyAnimatorCompatKK {

    /* compiled from: vertex_permanently_closed_dialog */
    public final class C00281 implements AnimatorUpdateListener {
        final /* synthetic */ ViewPropertyAnimatorUpdateListener f372a;
        final /* synthetic */ View f373b;

        public C00281(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
            this.f372a = viewPropertyAnimatorUpdateListener;
            this.f373b = view;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f372a.mo241a();
        }
    }

    ViewPropertyAnimatorCompatKK() {
    }
}
