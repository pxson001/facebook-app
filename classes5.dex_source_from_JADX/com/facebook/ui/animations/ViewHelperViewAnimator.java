package com.facebook.ui.animations;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: component_logical_path */
public class ViewHelperViewAnimator {
    public final WeakReference<View> f5389a;
    private final AnimatorListener f5390b = new C04981(this);
    @Nullable
    public WeakReference<ViewAnimator$Listener> f5391c;
    public boolean f5392d = false;
    public int f5393e = 0;

    /* compiled from: component_logical_path */
    class C04981 implements AnimatorListener {
        final /* synthetic */ ViewHelperViewAnimator f5388a;

        C04981(ViewHelperViewAnimator viewHelperViewAnimator) {
            this.f5388a = viewHelperViewAnimator;
        }

        public void onAnimationStart(@Nullable Animator animator) {
            if (this.f5388a.f5393e == 0 && this.f5388a.f5391c != null) {
                ViewAnimator$Listener viewAnimator$Listener = (ViewAnimator$Listener) this.f5388a.f5391c.get();
                if (viewAnimator$Listener != null) {
                    viewAnimator$Listener.mo625a();
                }
            }
            ViewHelperViewAnimator viewHelperViewAnimator = this.f5388a;
            viewHelperViewAnimator.f5393e++;
        }

        public void onAnimationEnd(@Nullable Animator animator) {
            ViewHelperViewAnimator viewHelperViewAnimator = this.f5388a;
            viewHelperViewAnimator.f5393e--;
            if (this.f5388a.f5393e == 0) {
                this.f5388a.f5392d = false;
                if (this.f5388a.f5391c != null) {
                    ViewAnimator$Listener viewAnimator$Listener = (ViewAnimator$Listener) this.f5388a.f5391c.get();
                    if (viewAnimator$Listener != null) {
                        viewAnimator$Listener.mo626b();
                    }
                }
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public ViewHelperViewAnimator(View view) {
        this.f5389a = new WeakReference(view);
        view.animate().setListener(this.f5390b);
    }

    public final void m10281a(long j) {
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
    }

    public final void m10282a(@Nullable ViewAnimator$Listener viewAnimator$Listener) {
        if (viewAnimator$Listener == null) {
            this.f5391c = null;
        } else {
            this.f5391c = new WeakReference(viewAnimator$Listener);
        }
    }

    public final void m10279a(float f) {
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.setScaleX(f);
        }
    }

    public final void m10283b(float f) {
        m10277b();
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.animate().scaleX(f);
        }
    }

    public final void m10284c(float f) {
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.setScaleY(f);
        }
    }

    public final void m10285d(float f) {
        m10277b();
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.animate().scaleY(f);
        }
    }

    public final void m10286e(float f) {
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.setAlpha(f);
        }
    }

    public final void m10287f(float f) {
        m10277b();
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void m10288g(float f) {
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.setTranslationX(f);
        }
    }

    public final void m10289h(float f) {
        m10277b();
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.animate().translationX(f);
        }
    }

    public final void m10290i(float f) {
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.setTranslationY(f);
        }
    }

    public final void m10291j(float f) {
        m10277b();
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }

    public final void m10280a(float f, float f2) {
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.setPivotX(f);
            view.setPivotY(f2);
        }
    }

    public final void m10278a() {
        View view = (View) this.f5389a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    private void m10277b() {
        this.f5392d = true;
    }
}
