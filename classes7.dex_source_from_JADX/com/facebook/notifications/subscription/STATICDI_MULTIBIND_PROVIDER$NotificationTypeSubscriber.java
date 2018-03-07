package com.facebook.notifications.subscription;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class STATICDI_MULTIBIND_PROVIDER$NotificationTypeSubscriber implements MultiBindIndexedProvider<NotificationTypeSubscriber>, Provider<Set<NotificationTypeSubscriber>> {
    private final InjectorLike f8867a;

    public STATICDI_MULTIBIND_PROVIDER$NotificationTypeSubscriber(InjectorLike injectorLike) {
        this.f8867a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8867a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}
