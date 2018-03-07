package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.collect.MapMaker.RemovalListener;
import com.google.common.collect.MapMaker.RemovalNotification;

@GwtCompatible
@Deprecated
@Beta
/* compiled from: wifi_scan_throwable */
public abstract class GenericMapMaker<K0, V0> {
    @GwtIncompatible("To be supported")
    public RemovalListener<K0, V0> f756a;

    @GwtIncompatible("To be supported")
    /* compiled from: wifi_scan_throwable */
    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public final void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    GenericMapMaker() {
    }

    @GwtIncompatible("To be supported")
    final <K extends K0, V extends V0> RemovalListener<K, V> m1490a() {
        return (RemovalListener) MoreObjects.firstNonNull(this.f756a, NullListener.INSTANCE);
    }
}
