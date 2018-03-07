package com.facebook.feedback.reactions.ui.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewCompat;
import android.widget.PopupWindow;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.injectable.DisplayUtil;
import com.facebook.feedback.reactions.ui.ReactionsClientInfo;
import com.facebook.feedback.reactions.ui.ReactionsOverlayVectorBasedView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.widget.springbutton.TouchSpring;
import javax.inject.Inject;

@ContextScoped
/* compiled from: send_info_mutation_status */
public class ReactionsSingleFaceListBumpingOverlay {
    private static ReactionsSingleFaceListBumpingOverlay f4019p;
    private static final Object f4020q = new Object();
    private final Activity f4021a;
    private final DisplayUtil f4022b;
    public final int f4023c;
    public final int f4024d;
    public final int f4025e;
    private final int f4026f;
    public ReactionsOverlayVectorBasedView f4027g;
    public PopupWindow f4028h;
    private ReactionsClientInfo f4029i;
    public TouchSpring f4030j;
    private Spring f4031k;
    public int f4032l;
    public int f4033m;
    private Spring f4034n;
    public int f4035o;

    /* compiled from: send_info_mutation_status */
    class OverlayViewSpringListener extends SimpleSpringListener {
        final /* synthetic */ ReactionsSingleFaceListBumpingOverlay f4016a;

        public OverlayViewSpringListener(ReactionsSingleFaceListBumpingOverlay reactionsSingleFaceListBumpingOverlay) {
            this.f4016a = reactionsSingleFaceListBumpingOverlay;
        }

        public final void m4647a(Spring spring) {
            ReactionsSingleFaceListBumpingOverlay reactionsSingleFaceListBumpingOverlay = this.f4016a;
            float d = (float) spring.d();
            if (reactionsSingleFaceListBumpingOverlay.f4028h.isShowing()) {
                float f = 0.25f + (0.75f * d);
                ViewCompat.b(reactionsSingleFaceListBumpingOverlay.f4027g, ((float) reactionsSingleFaceListBumpingOverlay.f4024d) + (((float) (reactionsSingleFaceListBumpingOverlay.f4025e - reactionsSingleFaceListBumpingOverlay.f4024d)) * d));
                ViewCompat.c(reactionsSingleFaceListBumpingOverlay.f4027g, d);
                ViewCompat.e(reactionsSingleFaceListBumpingOverlay.f4027g, f);
                ViewCompat.f(reactionsSingleFaceListBumpingOverlay.f4027g, 1.0f);
            }
        }

        public final void m4648b(Spring spring) {
            if (spring.g(0.0d)) {
                ReactionsSingleFaceListBumpingOverlay.m4656a(this.f4016a);
            }
        }

        public final void m4649c(Spring spring) {
        }

        public final void m4650d(Spring spring) {
        }
    }

    /* compiled from: send_info_mutation_status */
    class PopoverSpringListener extends SimpleSpringListener {
        final /* synthetic */ ReactionsSingleFaceListBumpingOverlay f4017a;
        private boolean f4018b;

        public PopoverSpringListener(ReactionsSingleFaceListBumpingOverlay reactionsSingleFaceListBumpingOverlay) {
            this.f4017a = reactionsSingleFaceListBumpingOverlay;
        }

        public final void m4651a(Spring spring) {
            float f;
            if (this.f4017a.f4030j != null) {
                if (!this.f4018b && spring.i() && spring.d() > 1.0d) {
                    this.f4018b = true;
                }
                if (this.f4018b) {
                    TouchSpring touchSpring = this.f4017a.f4030j;
                    touchSpring.g.a(spring.d()).l();
                }
            }
            ReactionsSingleFaceListBumpingOverlay reactionsSingleFaceListBumpingOverlay = this.f4017a;
            if (this.f4018b) {
                f = 1.0f;
            } else {
                f = (float) spring.d();
            }
            if (reactionsSingleFaceListBumpingOverlay.f4028h.isShowing()) {
                reactionsSingleFaceListBumpingOverlay.f4028h.update((int) (((float) reactionsSingleFaceListBumpingOverlay.f4032l) * f), (int) (((float) reactionsSingleFaceListBumpingOverlay.f4035o) + (((float) (reactionsSingleFaceListBumpingOverlay.f4033m - reactionsSingleFaceListBumpingOverlay.f4035o)) * f)), reactionsSingleFaceListBumpingOverlay.f4023c, reactionsSingleFaceListBumpingOverlay.f4023c);
                ViewCompat.e(reactionsSingleFaceListBumpingOverlay.f4027g, 1.0f - f);
                ViewCompat.f(reactionsSingleFaceListBumpingOverlay.f4027g, 1.0f - f);
                ViewCompat.c(reactionsSingleFaceListBumpingOverlay.f4027g, 1.0f - f);
            }
        }

        public final void m4652b(Spring spring) {
            if (spring.g(1.0d)) {
                ReactionsSingleFaceListBumpingOverlay.m4656a(this.f4017a);
            }
            this.f4018b = false;
        }

        public final void m4653c(Spring spring) {
        }

        public final void m4654d(Spring spring) {
            this.f4018b = false;
        }
    }

    private static ReactionsSingleFaceListBumpingOverlay m4657b(InjectorLike injectorLike) {
        return new ReactionsSingleFaceListBumpingOverlay(ActivityMethodAutoProvider.b(injectorLike), SpringSystem.b(injectorLike), DisplayUtil.a(injectorLike));
    }

    public static ReactionsSingleFaceListBumpingOverlay m4655a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionsSingleFaceListBumpingOverlay b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4020q) {
                ReactionsSingleFaceListBumpingOverlay reactionsSingleFaceListBumpingOverlay;
                if (a2 != null) {
                    reactionsSingleFaceListBumpingOverlay = (ReactionsSingleFaceListBumpingOverlay) a2.a(f4020q);
                } else {
                    reactionsSingleFaceListBumpingOverlay = f4019p;
                }
                if (reactionsSingleFaceListBumpingOverlay == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4657b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4020q, b3);
                        } else {
                            f4019p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionsSingleFaceListBumpingOverlay;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionsSingleFaceListBumpingOverlay(Activity activity, SpringSystem springSystem, DisplayUtil displayUtil) {
        this.f4021a = activity;
        this.f4022b = displayUtil;
        Resources resources = this.f4021a.getResources();
        this.f4023c = resources.getDimensionPixelSize(2131428769);
        this.f4024d = resources.getDimensionPixelSize(2131428771);
        this.f4025e = resources.getDimensionPixelSize(2131428772);
        this.f4026f = resources.getDimensionPixelSize(2131428773);
        this.f4031k = springSystem.a().a(SpringConfig.b(15.0d, 20.0d)).a(0.0d).l().a(new PopoverSpringListener(this));
        this.f4034n = springSystem.a().a(SpringConfig.b(20.0d, 10.0d)).a(0.0d).l().a(new OverlayViewSpringListener(this));
    }

    public static void m4656a(ReactionsSingleFaceListBumpingOverlay reactionsSingleFaceListBumpingOverlay) {
        if (!reactionsSingleFaceListBumpingOverlay.f4021a.isFinishing()) {
            reactionsSingleFaceListBumpingOverlay.f4028h.dismiss();
            reactionsSingleFaceListBumpingOverlay.f4032l = 0;
            reactionsSingleFaceListBumpingOverlay.f4033m = 0;
            reactionsSingleFaceListBumpingOverlay.f4030j = null;
            reactionsSingleFaceListBumpingOverlay.f4029i = null;
            reactionsSingleFaceListBumpingOverlay.f4035o = 0;
        }
    }
}
