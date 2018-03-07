package com.facebook.controller.connectioncontroller.adapters;

import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionListener;

/* compiled from: original_dimensions */
public abstract class RecyclerViewConnectionListener<TEdge> implements ConnectionListener<TEdge> {
    protected abstract RecyclerViewConnectionAdapter<TEdge> m12396b();

    protected abstract ConnectionController<TEdge, ?> m12398c();

    public final void m12395a(int i, int i2, boolean z) {
        m12396b().m12391a(m12398c().d());
        m12396b().b_(i, i2);
    }

    public final void m12394a(int i, int i2) {
        m12396b().m12391a(m12398c().d());
        m12396b().m12390a(i, i2);
    }

    public final void m12397b(int i, int i2) {
        m12396b().m12391a(m12398c().d());
        m12396b().m12392d(i, i2);
    }

    public final void m12393a() {
        int aZ_ = m12396b().aZ_();
        m12396b().m12391a(m12398c().d());
        m12396b().m12392d(0, aZ_);
    }
}
