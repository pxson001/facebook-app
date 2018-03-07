package com.facebook.debug.debugoverlay;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.debugoverlay.MessagesDebugOverlaySettingsTags;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: ्औ */
public final class STATICDI_MULTIBIND_PROVIDER$DebugOverlayTagSetProvider implements MultiBindIndexedProvider<DebugOverlayTagSetProvider>, Provider<Set<DebugOverlayTagSetProvider>> {
    private final InjectorLike f2586a;

    public STATICDI_MULTIBIND_PROVIDER$DebugOverlayTagSetProvider(InjectorLike injectorLike) {
        this.f2586a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2586a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new MessagesDebugOverlaySettingsTags();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
