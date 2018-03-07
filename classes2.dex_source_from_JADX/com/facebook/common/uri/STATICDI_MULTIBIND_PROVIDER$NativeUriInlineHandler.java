package com.facebook.common.uri;

import com.facebook.directinstall.feed.DirectInstallNativeUriInlineHandler;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$NativeUriInlineHandler implements MultiBindIndexedProvider<NativeUriInlineHandler>, Provider<Set<NativeUriInlineHandler>> {
    private final InjectorLike f4859a;

    public STATICDI_MULTIBIND_PROVIDER$NativeUriInlineHandler(InjectorLike injectorLike) {
        this.f4859a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4859a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return DirectInstallNativeUriInlineHandler.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
