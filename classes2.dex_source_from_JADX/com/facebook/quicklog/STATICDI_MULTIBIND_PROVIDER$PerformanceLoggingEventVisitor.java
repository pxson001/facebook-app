package com.facebook.quicklog;

import com.facebook.common.dextricksdi.QPLVisitorForDexInfo;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.quicklog.module.QPLVisitorForCTScanMethodAutoProvider;
import com.facebook.quicklog.module.QPLVisitorForNetworkInfo;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$PerformanceLoggingEventVisitor implements MultiBindIndexedProvider<PerformanceLoggingEventVisitor>, Provider<Set<PerformanceLoggingEventVisitor>> {
    private final InjectorLike f1558a;

    private STATICDI_MULTIBIND_PROVIDER$PerformanceLoggingEventVisitor(InjectorLike injectorLike) {
        this.f1558a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f1558a.getScopeAwareInjector(), this);
    }

    public static Set<PerformanceLoggingEventVisitor> m3056a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$PerformanceLoggingEventVisitor(injectorLike));
    }

    public final int size() {
        return 3;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return QPLVisitorForDexInfo.m3220a((InjectorLike) injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return QPLVisitorForCTScanMethodAutoProvider.m3192a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return QPLVisitorForNetworkInfo.m3222a((InjectorLike) injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
