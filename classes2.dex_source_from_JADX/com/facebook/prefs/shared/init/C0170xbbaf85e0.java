package com.facebook.prefs.shared.init;

import com.facebook.dialtone.DialtoneUiFeaturesAccessor.OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration;
import com.facebook.http.common.C0172xe097af95;
import com.facebook.http.prefs.delaybasedqp.DelayBasedQPViewController$OnInitSharedPrefsListenerRegistration;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.messaging.prefs.notifications.C0173x9f86acd4;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.zero.FbZeroFeatureVisibilityHelper.ZeroFeatureVisibilityHelperSharedPrefsListenerRegistration;
import com.facebook.zero.FullFbUiFeaturesAccessor.OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration;
import com.facebook.zero.token.request.ZeroTokenHttpRequestHandler.ZeroTokenHttpRequestHandlerSharedPrefsListenerRegistration;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class C0170xbbaf85e0 implements MultiBindIndexedProvider<INeedInitForSharedPrefsListenerRegistration>, Provider<Set<INeedInitForSharedPrefsListenerRegistration>> {
    private final InjectorLike f2457a;

    public C0170xbbaf85e0(InjectorLike injectorLike) {
        this.f2457a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f2457a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 7;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return OnInitDialtoneUiFeaturesAccessorSharedPrefsListenerRegistration.m4670a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new C0172xe097af95(IdBasedSingletonScopeProvider.m1810b(injector, 7173));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new DelayBasedQPViewController$OnInitSharedPrefsListenerRegistration(IdBasedLazy.m1808a(injector, 7204));
            case 3:
                return C0173x9f86acd4.m4702a(injector);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new ZeroFeatureVisibilityHelperSharedPrefsListenerRegistration(IdBasedSingletonScopeProvider.m1810b(injector, 3754));
            case 5:
                return OnInitFullFbUiFeaturesAccessorSharedPrefsListenerRegistration.m4713a(injector);
            case 6:
                return new ZeroTokenHttpRequestHandlerSharedPrefsListenerRegistration(IdBasedSingletonScopeProvider.m1810b(injector, 3821));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
