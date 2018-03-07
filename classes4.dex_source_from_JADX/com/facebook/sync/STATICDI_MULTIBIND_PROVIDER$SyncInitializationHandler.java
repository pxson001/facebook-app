package com.facebook.sync;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.payment.sync.PaymentsSyncInitializationHandler;
import com.facebook.messaging.sync.SingleEntityMessagesSyncInitializationHandler;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$SyncInitializationHandler implements MultiBindIndexedProvider<SyncInitializationHandler>, Provider<Set<SyncInitializationHandler>> {
    private final InjectorLike f9357a;

    public STATICDI_MULTIBIND_PROVIDER$SyncInitializationHandler(InjectorLike injectorLike) {
        this.f9357a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f9357a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PaymentsSyncInitializationHandler.m11871a((InjectorLike) injector);
            case 1:
                return SingleEntityMessagesSyncInitializationHandler.m11896a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
