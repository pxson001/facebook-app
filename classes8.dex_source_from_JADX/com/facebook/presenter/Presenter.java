package com.facebook.presenter;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* compiled from: home_creation_cell_shown */
public abstract class Presenter<V> {
    private V f11094a = null;

    public final void m13029a(V v) {
        Preconditions.checkNotNull(v);
        if (this.f11094a != v) {
            if (this.f11094a != null) {
                mo790b(this.f11094a);
            }
            this.f11094a = v;
            mo789b();
        }
    }

    public void mo790b(V v) {
        Preconditions.checkNotNull(v);
        if (v == this.f11094a) {
            this.f11094a = null;
        }
    }

    public final Optional<V> m13028a() {
        return Optional.fromNullable(this.f11094a);
    }

    protected void mo789b() {
    }

    public final boolean m13032c(V v) {
        return m13028a().isPresent() && m13028a().get() == v;
    }
}
