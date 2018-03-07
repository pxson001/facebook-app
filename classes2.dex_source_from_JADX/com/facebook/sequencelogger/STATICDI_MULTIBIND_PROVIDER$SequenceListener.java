package com.facebook.sequencelogger;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.loom.module.SequenceListenerForLoom;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$SequenceListener implements MultiBindIndexedProvider<SequenceListener>, Provider<Set<SequenceListener>> {
    private final InjectorLike f2037a;

    private STATICDI_MULTIBIND_PROVIDER$SequenceListener(InjectorLike injectorLike) {
        this.f2037a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2037a.getScopeAwareInjector(), this);
    }

    public static Set<SequenceListener> m4121a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$SequenceListener(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new SequenceListenerForLoom();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
