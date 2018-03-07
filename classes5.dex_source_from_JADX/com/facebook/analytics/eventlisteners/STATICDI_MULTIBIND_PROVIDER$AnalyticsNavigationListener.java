package com.facebook.analytics.eventlisteners;

import com.facebook.analytics.NavigationLogger;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$AnalyticsNavigationListener implements MultiBindIndexedProvider<AnalyticsNavigationListener>, Provider<Set<AnalyticsNavigationListener>> {
    private final InjectorLike f1897a;

    public STATICDI_MULTIBIND_PROVIDER$AnalyticsNavigationListener(InjectorLike injectorLike) {
        this.f1897a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1897a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return NavigationLogger.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
