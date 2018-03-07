package com.facebook.richdocument.view.transition;

import android.graphics.Rect;

/* compiled from: overlay_source_media_id */
public abstract class ResizeTransitionStrategy<V, T extends TransitionState> extends AbstractTransitionStrategy<V, T> {
    public Rect f6971a;
    public Rect f6972b;

    public ResizeTransitionStrategy(V v, TransitionSpring transitionSpring) {
        super(v, transitionSpring);
    }

    protected final void m7244a(int i, int i2) {
        this.f6971a = new Rect(0, 0, i, i2);
    }

    protected final void m7246b(int i, int i2) {
        this.f6972b = new Rect(0, 0, i, i2);
    }

    public final Rect m7247q() {
        return this.f6972b;
    }

    protected final void m7245a(T t, Rect rect) {
        MediaLayoutStrategy b = m7201b(t);
        if (b != null) {
            b.f6967k = rect;
        }
    }
}
