package com.facebook.gk.store.internal;

import com.facebook.common.listeners.AbstractWeakListenersManager;
import com.facebook.common.listeners.WeakListenersManager;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.OnGatekeeperChangeListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: updateDiskUsage throws */
public class GatekeeperListenersImpl {
    public final Executor f1826a;
    public final WeakListenersManager<Integer, GatekeeperStore, OnGatekeeperChangeListener> f1827b = new WeakListenersManager();

    public GatekeeperListenersImpl(Executor executor) {
        this.f1826a = executor;
    }

    public final void m3657a(OnGatekeeperChangeListener onGatekeeperChangeListener, int i) {
        this.f1827b.m2115a(Integer.valueOf(i), (Object) onGatekeeperChangeListener);
    }

    public final void m3658a(OnGatekeeperChangeListener onGatekeeperChangeListener, int... iArr) {
        AbstractWeakListenersManager abstractWeakListenersManager = this.f1827b;
        Set hashSet = new HashSet(iArr.length);
        for (int valueOf : iArr) {
            hashSet.add(Integer.valueOf(valueOf));
        }
        abstractWeakListenersManager.m2117a((Collection) hashSet, (Object) onGatekeeperChangeListener);
    }

    public final void m3659b(OnGatekeeperChangeListener onGatekeeperChangeListener, int i) {
        this.f1827b.m2120b(Integer.valueOf(i), onGatekeeperChangeListener);
    }
}
