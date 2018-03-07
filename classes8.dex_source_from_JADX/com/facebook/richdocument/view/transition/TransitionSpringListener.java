package com.facebook.richdocument.view.transition;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentMediaTransitionEvent;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import javax.inject.Inject;

/* compiled from: originalPhone */
public class TransitionSpringListener extends SimpleSpringListener implements InjectableComponentWithoutContext {
    @Inject
    public RichDocumentEventBus f6990a;
    public final TransitionSpring f6991b;
    public final AbstractTransitionStrategy f6992c;
    public ViewLayout f6993d;
    public ViewLayout f6994e;
    public ViewLayout f6995f;

    public static void m7286a(Object obj, Context context) {
        ((TransitionSpringListener) obj).f6990a = RichDocumentEventBus.m5130a(FbInjector.get(context));
    }

    public TransitionSpringListener(TransitionSpring transitionSpring, AbstractTransitionStrategy abstractTransitionStrategy) {
        Class cls = TransitionSpringListener.class;
        m7286a(this, transitionSpring.getContext());
        this.f6991b = transitionSpring;
        this.f6992c = abstractTransitionStrategy;
    }

    public final void m7288a(Spring spring) {
        super.a(spring);
        m7287e(spring);
        float d = (float) spring.d();
        if (d != 0.0f) {
            Object obj;
            TransitionState transitionState = this.f6991b.f6989e;
            if (this.f6994e == null || !transitionState.equals(this.f6994e.mo427a())) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                ViewLayout a = this.f6993d.mo430a(this.f6994e, d);
                if (!a.equals(this.f6995f)) {
                    this.f6992c.m7200a(a);
                    this.f6995f = a;
                    this.f6990a.a(new RichDocumentMediaTransitionEvent(this.f6992c.f6946a, (MediaTransitionState) this.f6994e.mo427a(), d, false));
                    return;
                }
                return;
            }
        }
        TransitionState transitionState2 = this.f6991b.f6989e;
        this.f6993d = this.f6992c.mo417a(false);
        this.f6994e = this.f6992c.m7196a(transitionState2, false);
        this.f6995f = null;
    }

    public final void m7289b(Spring spring) {
        super.b(spring);
        m7287e(spring);
        if (this.f6994e != null) {
            this.f6992c.m7200a(this.f6994e);
            this.f6990a.a(new RichDocumentMediaTransitionEvent(this.f6992c.f6946a, (MediaTransitionState) this.f6994e.mo427a(), (float) spring.d(), true));
            this.f6994e = null;
        }
    }

    private void m7287e(Spring spring) {
        Object obj;
        if (spring == this.f6991b.f6987c) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            throw new IllegalArgumentException("Caller Spring is not its TransitionSpring");
        }
    }
}
