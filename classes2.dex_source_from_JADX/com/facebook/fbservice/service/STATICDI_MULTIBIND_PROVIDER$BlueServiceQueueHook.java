package com.facebook.fbservice.service;

import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$BlueServiceQueueHook implements MultiBindIndexedProvider<BlueServiceQueueHook>, Provider<Set<BlueServiceQueueHook>> {
    private final InjectorLike f23654a;

    public STATICDI_MULTIBIND_PROVIDER$BlueServiceQueueHook(InjectorLike injectorLike) {
        this.f23654a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f23654a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return BackgroundTaskManager.m32118a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
