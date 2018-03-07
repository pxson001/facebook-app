package com.facebook.http.engine;

import com.facebook.http.push.ImagePushSubscriber;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$HttpPushCallback implements MultiBindIndexedProvider<HttpPushCallback>, Provider<Set<HttpPushCallback>> {
    private final InjectorLike f8777a;

    private STATICDI_MULTIBIND_PROVIDER$HttpPushCallback(InjectorLike injectorLike) {
        this.f8777a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8777a.getScopeAwareInjector(), this);
    }

    public static Set<HttpPushCallback> m13630a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$HttpPushCallback(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ImagePushSubscriber.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
