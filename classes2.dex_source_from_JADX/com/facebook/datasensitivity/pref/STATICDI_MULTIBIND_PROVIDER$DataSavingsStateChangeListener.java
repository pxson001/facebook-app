package com.facebook.datasensitivity.pref;

import com.facebook.analytics.timespent.TimeSpentEventReporter;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$DataSavingsStateChangeListener implements MultiBindIndexedProvider<DataSavingsStateChangeListener>, Provider<Set<DataSavingsStateChangeListener>> {
    private final InjectorLike f4779a;

    public STATICDI_MULTIBIND_PROVIDER$DataSavingsStateChangeListener(InjectorLike injectorLike) {
        this.f4779a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4779a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return TimeSpentEventReporter.m20164a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
