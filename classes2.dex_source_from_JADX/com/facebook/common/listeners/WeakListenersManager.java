package com.facebook.common.listeners;

import com.facebook.gk.store.OnGatekeeperChangeListener;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: update */
public class WeakListenersManager<K, A, T extends Listener<A, K>> extends AbstractWeakListenersManager<K, A, T> {
    protected final void mo325a(Object obj, Object obj2, Object obj3) {
        ((OnGatekeeperChangeListener) obj).m3663a(obj2, obj3);
    }
}
