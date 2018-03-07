package com.facebook.photos.galleryutil;

import android.os.Handler;
import android.view.View;
import com.facebook.entitycards.view.EntityCardContainerPresenter.2;
import com.facebook.entitycards.view.EntityCardContainerView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.animations.ViewAnimator.SimpleListener;
import com.facebook.ui.animations.ViewHelperViewAnimator;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;

/* compiled from: hide_reply_button */
public class VisibilityAnimator {
    private View f13017a;
    private boolean f13018b;
    private float f13019c;
    private float f13020d;
    public ViewHelperViewAnimator f13021e;
    private ShowListener f13022f;
    private HideListener f13023g;
    private Handler f13024h;
    private HideRunnable f13025i;
    public 2 f13026j;

    /* compiled from: hide_reply_button */
    class HideListener extends SimpleListener {
        final /* synthetic */ VisibilityAnimator f13015a;

        public HideListener(VisibilityAnimator visibilityAnimator) {
            this.f13015a = visibilityAnimator;
        }

        public final void m20358b() {
            VisibilityAnimator.m20361f(this.f13015a);
            this.f13015a.f13021e.a(null);
            if (this.f13015a.f13026j != null) {
                2 2 = this.f13015a.f13026j;
                EntityCardContainerView entityCardContainerView = 2.a;
                entityCardContainerView.b.removeView(2.b);
            }
        }
    }

    /* compiled from: hide_reply_button */
    class ShowListener extends SimpleListener {
        final /* synthetic */ VisibilityAnimator f13016a;

        public ShowListener(VisibilityAnimator visibilityAnimator) {
            this.f13016a = visibilityAnimator;
        }

        public final void m20359b() {
            this.f13016a.f13021e.a(null);
        }
    }

    public VisibilityAnimator(View view, long j, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory) {
        this(view, j, true, viewHelperViewAnimatorFactory);
    }

    public VisibilityAnimator(View view, long j, boolean z, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory) {
        this(view, j, z, viewHelperViewAnimatorFactory, 1.0f, 0.0f);
    }

    public VisibilityAnimator(View view, long j, boolean z, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory, float f, float f2) {
        this.f13017a = view;
        this.f13018b = z;
        this.f13019c = f;
        this.f13020d = f2;
        this.f13021e = viewHelperViewAnimatorFactory.a(view);
        this.f13021e.a(j);
        this.f13022f = new ShowListener(this);
        this.f13023g = new HideListener(this);
        this.f13024h = new Handler();
    }

    public final boolean m20364a() {
        return this.f13017a.getVisibility() == 0;
    }

    public final void m20365b() {
        if (m20364a()) {
            m20366b(true);
        } else {
            m20363a(true);
        }
    }

    public final void m20367c() {
        m20363a(true);
    }

    public final void m20363a(boolean z) {
        m20360e();
        if (z) {
            this.f13021e.a(this.f13022f);
            this.f13021e.f(this.f13019c);
        } else {
            this.f13021e.a(null);
            this.f13021e.a();
            this.f13021e.e(this.f13019c);
        }
        this.f13017a.setVisibility(0);
    }

    public final void m20368d() {
        m20366b(true);
    }

    public final void m20366b(boolean z) {
        m20360e();
        if (z) {
            this.f13021e.a(this.f13023g);
            this.f13021e.f(this.f13020d);
            return;
        }
        this.f13021e.e(this.f13020d);
        m20361f(this);
    }

    public final void m20362a(float f) {
        this.f13021e.e(f);
    }

    private void m20360e() {
        if (this.f13025i != null) {
            HandlerDetour.a(this.f13024h, this.f13025i);
            this.f13025i = null;
        }
    }

    public static void m20361f(VisibilityAnimator visibilityAnimator) {
        if (visibilityAnimator.f13020d != 0.0f) {
            return;
        }
        if (visibilityAnimator.f13018b) {
            visibilityAnimator.f13017a.setVisibility(4);
        } else {
            visibilityAnimator.f13017a.setVisibility(8);
        }
    }
}
