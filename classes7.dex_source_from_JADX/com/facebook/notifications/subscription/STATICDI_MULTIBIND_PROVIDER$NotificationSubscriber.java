package com.facebook.notifications.subscription;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.prefetch.notifications.NotificationStorySubscriber;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class STATICDI_MULTIBIND_PROVIDER$NotificationSubscriber implements MultiBindIndexedProvider<NotificationSubscriber>, Provider<Set<NotificationSubscriber>> {
    private final InjectorLike f8866a;

    public STATICDI_MULTIBIND_PROVIDER$NotificationSubscriber(InjectorLike injectorLike) {
        this.f8866a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8866a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return NotificationStorySubscriber.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
