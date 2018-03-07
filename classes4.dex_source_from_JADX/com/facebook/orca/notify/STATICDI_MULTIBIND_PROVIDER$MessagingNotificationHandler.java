package com.facebook.orca.notify;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class STATICDI_MULTIBIND_PROVIDER$MessagingNotificationHandler implements MultiBindIndexedProvider<MessagingNotificationHandler>, Provider<Set<MessagingNotificationHandler>> {
    private final InjectorLike f10078a;

    public STATICDI_MULTIBIND_PROVIDER$MessagingNotificationHandler(InjectorLike injectorLike) {
        this.f10078a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10078a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<MessagingNotificationHandler>> m10555a(InjectorLike injectorLike) {
        return ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$MessagingNotificationHandler(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ChatHeadMessagingNotificationHandler.m2435a((InjectorLike) injector);
            case 1:
                return DashMessagingNotificationHandler.m2475a((InjectorLike) injector);
            case 2:
                return DefaultMessagingNotificationHandler.m2502a((InjectorLike) injector);
            case 3:
                return LauncherBadgesMessagingNotificationHandler.m3113a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
