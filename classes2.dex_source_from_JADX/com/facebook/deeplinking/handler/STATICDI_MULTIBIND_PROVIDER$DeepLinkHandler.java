package com.facebook.deeplinking.handler;

import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.deeplinking.DeepLinkingUtils;
import com.facebook.deeplinking.logging.DeepLinkLoggingUtils;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.xconfig.core.XConfigReader;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$DeepLinkHandler implements MultiBindIndexedProvider<DeepLinkHandler>, Provider<Set<DeepLinkHandler>> {
    private final InjectorLike f4848a;

    public STATICDI_MULTIBIND_PROVIDER$DeepLinkHandler(InjectorLike injectorLike) {
        this.f4848a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4848a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<DeepLinkHandler>> m8683a(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$DeepLinkHandler(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 11;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new BlacklistedDeepLinkHandler(XConfigReader.m2681a(injector), DeepLinkingUtils.b(injector));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new CommerceDeepLinkHandler(DeepLinkingUtils.b(injector));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new EventsDeepLinkHandler(DeepLinkingUtils.b(injector));
            case 3:
                return new FeedDeepLinkHandler(DeepLinkingUtils.b(injector));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new GroupsDeepLinkHandler(DeepLinkingUtils.b(injector));
            case 5:
                return new NotificationsDeepLinkHandler(FbHttpRequestProcessor.m12260a((InjectorLike) injector), FbErrorReporterImpl.m2317a((InjectorLike) injector), DeepLinkingUtils.b(injector), DeepLinkLoggingUtils.b(injector), m8683a(injector));
            case 6:
                return new PageDeepLinkHandler(DeepLinkingUtils.b(injector));
            case 7:
                return new PhotoDeepLinkHandler(DeepLinkingUtils.b(injector));
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return new StoryDeepLinkHandler();
            case 9:
                return new TimelineDeepLinkHandler(DeepLinkingUtils.b(injector));
            case 10:
                return new VideoDeepLinkHandler(DeepLinkingUtils.b(injector));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
