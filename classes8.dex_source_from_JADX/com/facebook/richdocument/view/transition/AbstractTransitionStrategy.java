package com.facebook.richdocument.view.transition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: page/%s/native_notifications */
public abstract class AbstractTransitionStrategy<V, T extends TransitionState> {
    public final V f6946a;
    private final Map<T, ViewLayoutStrategy<V, T>> f6947b = new HashMap();
    private final Map<T, ViewLayout> f6948c = new HashMap();
    public T f6949d;
    private ViewLayout f6950e;
    private boolean f6951f;
    public TransitionSpring f6952g;
    private TransitionSpringListener f6953h;
    public final List<TransitionListener> f6954i;

    protected abstract void mo418g();

    public AbstractTransitionStrategy(V v, TransitionSpring transitionSpring) {
        this.f6946a = v;
        m7199a(transitionSpring);
        this.f6954i = new ArrayList();
    }

    public final void m7199a(TransitionSpring transitionSpring) {
        if (this.f6953h != null) {
            TransitionSpringListener transitionSpringListener = this.f6953h;
            transitionSpringListener.f6991b.f6987c.b(transitionSpringListener);
        }
        if (transitionSpring != null) {
            this.f6952g = transitionSpring;
            this.f6953h = new TransitionSpringListener(this.f6952g, this);
            TransitionSpring transitionSpring2 = this.f6952g;
            transitionSpring2.f6987c.a(this.f6953h);
        }
    }

    public T mo420d() {
        return this.f6949d;
    }

    public final T m7205e() {
        return mo417a(false).mo427a();
    }

    public final T m7206f() {
        T t = this.f6952g.f6989e;
        return t == null ? m7205e() : t;
    }

    public final void m7200a(ViewLayout viewLayout) {
        if (viewLayout == null || !this.f6948c.containsKey(viewLayout.mo427a())) {
            this.f6950e = viewLayout;
        } else {
            this.f6950e = viewLayout.mo434c();
        }
        if (this.f6950e != null) {
            ViewLayout viewLayout2 = this.f6950e;
            for (TransitionListener a : this.f6954i) {
                a.mo479a(viewLayout2);
            }
        }
    }

    public ViewLayout mo417a(boolean z) {
        if (this.f6950e == null || z) {
            ViewLayout a = m7196a(mo420d(), z);
            if (a != null) {
                this.f6950e = a.mo434c();
            }
        }
        return this.f6950e;
    }

    public final ViewLayout m7196a(T t, boolean z) {
        if (!z && this.f6948c.containsKey(t)) {
            return (ViewLayout) this.f6948c.get(t);
        }
        MediaLayoutStrategy b = m7201b(t);
        if (b != null) {
            if (!this.f6951f || z) {
                this.f6951f = true;
                mo418g();
            }
            ViewLayout f = b.m7233f();
            if (f != null) {
                this.f6948c.put(t, f);
                return f;
            }
        }
        if (!this.f6948c.containsKey(t)) {
            this.f6948c.put(t, null);
        }
        return null;
    }

    public final ViewLayoutStrategy<V, T> m7201b(T t) {
        return (MediaLayoutStrategy) this.f6947b.get(t);
    }

    protected final void m7198a(ViewLayoutStrategy<V, T> viewLayoutStrategy) {
        this.f6947b.put(viewLayoutStrategy.f6961e, viewLayoutStrategy);
    }

    protected final void m7202c(T t) {
        this.f6947b.remove(t);
    }

    public final void m7204d(T t) {
        if (m7196a(t, false) != null) {
            TransitionSpring transitionSpring = this.f6952g;
            transitionSpring.f6989e = t;
            transitionSpring.f6987c.a(0.0d);
            transitionSpring.f6987c.b(1.0d);
        }
    }
}
