package com.facebook.multirow.api.renderers;

import android.view.View;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;

/* compiled from: timeStamp */
public class SimpleRenderer<P, E extends AnyEnvironment, V extends View> {
    public final SinglePartDefinition<P, ?, E, V> f3054a;
    public final E f3055b;
    private P f3056c;
    public PartHolder f3057d;
    private V f3058e;

    public SimpleRenderer(SinglePartDefinition<P, ?, E, V> singlePartDefinition, E e) {
        this.f3054a = singlePartDefinition;
        this.f3055b = e;
    }

    public final void m4050a(P p) {
        if (this.f3056c != p) {
            PartHolder partHolder = this.f3057d;
            this.f3056c = p;
            this.f3057d = null;
            if (this.f3058e != null) {
                m4046a(partHolder);
                m4047a(this.f3056c, this.f3058e);
            }
        }
    }

    public final void m4049a(V v) {
        m4047a(this.f3056c, v);
        this.f3058e = v;
    }

    public final void m4048a() {
        m4046a(this.f3057d);
        this.f3058e = null;
    }

    public final boolean m4051b() {
        return this.f3058e != null;
    }

    private void m4047a(P p, V v) {
        if (this.f3057d == null) {
            this.f3057d = new PartHolder(this.f3054a, -1, p);
            RendererUtils.a(this.f3055b, this.f3057d);
        }
        RendererUtils.a(this.f3055b, this.f3057d, v);
    }

    private void m4046a(PartHolder partHolder) {
        RendererUtils.b(this.f3055b, partHolder, this.f3058e);
    }
}
