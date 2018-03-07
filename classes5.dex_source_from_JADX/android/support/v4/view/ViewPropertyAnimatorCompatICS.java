package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* compiled from: vertex_photo_vote_module */
class ViewPropertyAnimatorCompatICS {

    /* compiled from: vertex_photo_vote_module */
    public final class C00261 extends AnimatorListenerAdapter {
        final /* synthetic */ ViewPropertyAnimatorListener f368a;
        final /* synthetic */ View f369b;

        public C00261(ViewPropertyAnimatorListener viewPropertyAnimatorListener, View view) {
            this.f368a = viewPropertyAnimatorListener;
            this.f369b = view;
        }

        public final void onAnimationCancel(Animator animator) {
            this.f368a.mo89c(this.f369b);
        }

        public final void onAnimationEnd(Animator animator) {
            this.f368a.mo88b(this.f369b);
        }

        public final void onAnimationStart(Animator animator) {
            this.f368a.mo87a(this.f369b);
        }
    }

    ViewPropertyAnimatorCompatICS() {
    }
}
