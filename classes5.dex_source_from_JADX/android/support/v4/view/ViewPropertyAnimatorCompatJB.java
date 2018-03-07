package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: vertex_photo_inline */
class ViewPropertyAnimatorCompatJB {

    /* compiled from: vertex_photo_inline */
    public final class C00271 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimatorListener f370a;
        final /* synthetic */ View f371b;

        public C00271(ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            this.f370a = viewPropertyAnimatorListener;
            this.f371b = view;
        }

        public final void onAnimationCancel(Animator animator) {
            this.f370a.mo89c(this.f371b);
        }

        public final void onAnimationEnd(Animator animator) {
            this.f370a.mo88b(this.f371b);
        }

        public final void onAnimationStart(Animator animator) {
            this.f370a.mo87a(this.f371b);
        }
    }

    ViewPropertyAnimatorCompatJB() {
    }
}
