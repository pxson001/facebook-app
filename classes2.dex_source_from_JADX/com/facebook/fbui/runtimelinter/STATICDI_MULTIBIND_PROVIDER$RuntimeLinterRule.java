package com.facebook.fbui.runtimelinter;

import com.facebook.fbui.runtimelinter.rules.ListViewInRelativeLayoutRule;
import com.facebook.fbui.runtimelinter.rules.MaximumViewCountRule;
import com.facebook.fbui.runtimelinter.rules.MaximumViewDepthRule;
import com.facebook.fbui.runtimelinter.rules.UnnecessaryViewGroupRule;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$RuntimeLinterRule implements MultiBindIndexedProvider<RuntimeLinterRule>, Provider<Set<RuntimeLinterRule>> {
    private final InjectorLike f8512a;

    public STATICDI_MULTIBIND_PROVIDER$RuntimeLinterRule(InjectorLike injectorLike) {
        this.f8512a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f8512a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ListViewInRelativeLayoutRule.a(injector);
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return MaximumViewCountRule.a(injector);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return MaximumViewDepthRule.a(injector);
            case 3:
                return UnnecessaryViewGroupRule.a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
