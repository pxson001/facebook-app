package com.facebook.gk.init;

import com.facebook.common.preconditions.Preconditions;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import com.facebook.gk.store.internal.GatekeeperListenersImpl;
import com.facebook.inject.Lazy;

/* compiled from: token_hash */
public abstract class INeedInitForGatekeepersListenerRegistration<T> extends OnGatekeeperChangeListener {
    public static final Class f2423a = INeedInitForGatekeepersListenerRegistration.class;
    private final Lazy<T> f2424b;
    private int[] f2425c;
    private int f2426d = -1;
    private boolean f2427e;

    protected abstract void mo659a(GatekeeperStore gatekeeperStore, int i, T t);

    protected INeedInitForGatekeepersListenerRegistration(Lazy<T> lazy, int i) {
        Preconditions.m2017b(i != -1);
        this.f2424b = lazy;
        this.f2426d = i;
    }

    protected INeedInitForGatekeepersListenerRegistration(Lazy<T> lazy, int... iArr) {
        Preconditions.m2017b(iArr != null);
        this.f2424b = lazy;
        this.f2425c = iArr;
    }

    public final synchronized void m4620a(GatekeeperListenersImpl gatekeeperListenersImpl) {
        if (!this.f2427e) {
            this.f2427e = true;
            if (this.f2425c != null) {
                gatekeeperListenersImpl.m3658a((OnGatekeeperChangeListener) this, this.f2425c);
            } else if (this.f2426d != -1) {
                gatekeeperListenersImpl.m3657a((OnGatekeeperChangeListener) this, this.f2426d);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final void mo545a(GatekeeperStoreImpl gatekeeperStoreImpl, int i) {
        mo659a(gatekeeperStoreImpl, i, this.f2424b.get());
    }
}
