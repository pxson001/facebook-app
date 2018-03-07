package com.facebook.debug.http;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$DebugHttpFlowReporter implements MultiBindIndexedProvider<DebugHttpFlowReporter>, Provider<Set<DebugHttpFlowReporter>> {
    private final InjectorLike f12095a;

    public STATICDI_MULTIBIND_PROVIDER$DebugHttpFlowReporter(InjectorLike injectorLike) {
        this.f12095a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f12095a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return FileReporter.m17872a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return GraphQLReporter.m17887a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
