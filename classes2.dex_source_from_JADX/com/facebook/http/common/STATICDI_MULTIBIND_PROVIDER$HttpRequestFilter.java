package com.facebook.http.common;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.debug.http.StethoConnectedRequestInterceptor;
import com.facebook.http.blendedvip.BlendedVipHttpFilter;
import com.facebook.http.blendedvip.CustomVipHttpFilter;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.logging.cdn.CdnLoggerRequestInterceptor;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.zero.rewrite.ZeroAwareHttpFilter;
import com.facebook.zero.rewrite.ZeroDebugHttpFilter;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$HttpRequestFilter implements MultiBindIndexedProvider<HttpRequestFilter>, Provider<Set<HttpRequestFilter>> {
    private final InjectorLike f7778a;

    public STATICDI_MULTIBIND_PROVIDER$HttpRequestFilter(InjectorLike injectorLike) {
        this.f7778a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f7778a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 6;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new StethoConnectedRequestInterceptor();
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new BlendedVipHttpFilter(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injector), QeInternalImplMethodAutoProvider.m3744a(injector));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new CustomVipHttpFilter(QeInternalImplMethodAutoProvider.m3744a(injector), AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injector));
            case 3:
                return new CdnLoggerRequestInterceptor();
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new ZeroAwareHttpFilter(IdBasedProvider.m1811a(injector, 814), IdBasedProvider.m1811a(injector, 4395), IdBasedLazy.m1808a(injector, 3782));
            case 5:
                return ZeroDebugHttpFilter.m12330a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
