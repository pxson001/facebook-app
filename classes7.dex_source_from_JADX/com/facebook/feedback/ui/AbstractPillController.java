package com.facebook.feedback.ui;

import android.view.View;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;
import com.facebook.ui.animations.ViewHelperViewAnimator;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.LazyView;
import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* compiled from: story_graphql_id */
public abstract class AbstractPillController {
    private static final SpringConfig f2955a = SpringConfig.b(5.0d, 10.0d);
    private AnimationSpringListener f2956b;
    public AnimationState f2957c = AnimationState.HIDDEN;
    private Spring f2958d;
    private ViewHelperViewAnimator f2959e;
    private ViewHelperViewAnimatorFactory f2960f;
    private List<AbstractPillController> f2961g;
    private List<AbstractPillController> f2962h;

    /* compiled from: story_graphql_id */
    class AnimationSpringListener extends SimpleSpringListener {
        final /* synthetic */ AbstractPillController f4094a;

        public AnimationSpringListener(AbstractPillController abstractPillController) {
            this.f4094a = abstractPillController;
        }

        public final void m4703c(Spring spring) {
            if (this.f4094a.mo130g() != null) {
                this.f4094a.mo130g().a().setVisibility(0);
            }
        }

        public final void m4701a(Spring spring) {
            this.f4094a.mo229a((float) spring.d());
        }

        public final void m4702b(Spring spring) {
            if (this.f4094a.m3242f()) {
                this.f4094a.mo131h();
            } else if (this.f4094a.m3239c()) {
                this.f4094a.f2957c = AnimationState.SHOWN;
            }
        }
    }

    /* compiled from: story_graphql_id */
    enum AnimationState {
        REVEALING,
        HIDING,
        SHOWN,
        HIDDEN
    }

    protected abstract LazyView<? extends View> mo130g();

    public AbstractPillController(SpringSystem springSystem, ViewHelperViewAnimatorFactory viewHelperViewAnimatorFactory) {
        this.f2960f = viewHelperViewAnimatorFactory;
        this.f2956b = new AnimationSpringListener(this);
        this.f2958d = springSystem.a().a(0.0d).a(this.f2956b).a(f2955a);
    }

    public boolean mo230a() {
        if (m3239c() || m3240d()) {
            return false;
        }
        if (this.f2962h != null) {
            for (AbstractPillController abstractPillController : this.f2962h) {
                if (!abstractPillController.m3239c()) {
                    if (abstractPillController.m3240d()) {
                    }
                }
                return false;
            }
        }
        if (this.f2961g != null) {
            for (AbstractPillController abstractPillController2 : this.f2961g) {
                if (abstractPillController2.m3239c() || abstractPillController2.m3240d()) {
                    abstractPillController2.m3238b();
                }
            }
        }
        if (this.f2959e == null) {
            this.f2959e = this.f2960f.a(mo130g().a());
        }
        this.f2957c = AnimationState.REVEALING;
        this.f2958d.b(1.0d);
        return true;
    }

    public void m3238b() {
        if (!m3242f() && !m3241e()) {
            this.f2957c = AnimationState.HIDING;
            this.f2958d.b(0.0d);
            if (this.f2958d.k()) {
                mo131h();
            }
        }
    }

    protected final boolean m3239c() {
        return AnimationState.REVEALING.equals(this.f2957c);
    }

    protected final boolean m3240d() {
        return AnimationState.SHOWN.equals(this.f2957c);
    }

    protected final boolean m3241e() {
        return AnimationState.HIDDEN.equals(this.f2957c);
    }

    protected final boolean m3242f() {
        return AnimationState.HIDING.equals(this.f2957c);
    }

    protected void mo229a(float f) {
        float a = (float) SpringUtil.a((double) f, 0.0d, 1.0d, 0.5d, 1.0d);
        this.f2959e.a(a);
        this.f2959e.c(a);
        if (m3239c() || m3242f()) {
            this.f2959e.e(f);
        }
    }

    private void mo131h() {
        this.f2957c = AnimationState.HIDDEN;
        if (mo130g() != null && mo130g().b()) {
            mo130g().a().setVisibility(8);
        }
    }

    @VisibleForTesting
    private void m3233c(AbstractPillController abstractPillController) {
        if (this.f2961g == null || !this.f2961g.contains(abstractPillController)) {
            if (this.f2961g == null) {
                this.f2961g = new ArrayList();
            }
            this.f2961g.add(abstractPillController);
            abstractPillController.m3236a(this);
        }
    }

    public final void m3236a(AbstractPillController abstractPillController) {
        if (this.f2962h == null || !this.f2962h.contains(abstractPillController)) {
            if (this.f2962h == null) {
                this.f2962h = new ArrayList();
            }
            this.f2962h.add(abstractPillController);
            abstractPillController.m3233c(this);
        }
    }
}
