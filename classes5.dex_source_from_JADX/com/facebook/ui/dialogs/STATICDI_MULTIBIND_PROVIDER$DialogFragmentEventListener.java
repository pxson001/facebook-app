package com.facebook.ui.dialogs;

import com.facebook.analytics.eventlisteners.AnalyticsDialogFragmentEventListener;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$DialogFragmentEventListener implements MultiBindIndexedProvider<DialogFragmentEventListener>, Provider<Set<DialogFragmentEventListener>> {
    private final InjectorLike f5443a;

    public STATICDI_MULTIBIND_PROVIDER$DialogFragmentEventListener(InjectorLike injectorLike) {
        this.f5443a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5443a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return AnalyticsDialogFragmentEventListener.m2568a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
