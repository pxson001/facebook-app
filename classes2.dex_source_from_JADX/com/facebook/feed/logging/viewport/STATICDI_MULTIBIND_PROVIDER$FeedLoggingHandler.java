package com.facebook.feed.logging.viewport;

import com.facebook.feed.logging.ViewBasedLoggingHandler;
import com.facebook.feed.logging.ViewportLoggingHandler;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FeedLoggingHandler implements MultiBindIndexedProvider<FeedLoggingHandler>, Provider<Set<FeedLoggingHandler>> {
    private final InjectorLike f10040a;

    public STATICDI_MULTIBIND_PROVIDER$FeedLoggingHandler(InjectorLike injectorLike) {
        this.f10040a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f10040a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ViewBasedLoggingHandler.m14137a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ViewportLoggingHandler.m14224a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
