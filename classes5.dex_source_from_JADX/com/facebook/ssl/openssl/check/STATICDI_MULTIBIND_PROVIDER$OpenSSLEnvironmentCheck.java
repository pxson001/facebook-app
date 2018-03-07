package com.facebook.ssl.openssl.check;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: transaction_status_display */
public final class STATICDI_MULTIBIND_PROVIDER$OpenSSLEnvironmentCheck implements MultiBindIndexedProvider<OpenSSLEnvironmentCheck>, Provider<Set<OpenSSLEnvironmentCheck>> {
    private final InjectorLike f5330a;

    private STATICDI_MULTIBIND_PROVIDER$OpenSSLEnvironmentCheck(InjectorLike injectorLike) {
        this.f5330a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5330a.getScopeAwareInjector(), this);
    }

    public static Set<OpenSSLEnvironmentCheck> m10226a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$OpenSSLEnvironmentCheck(injectorLike));
    }

    public final int size() {
        return 5;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return CheckFakeSocketImpl.m10211a(injector);
            case 1:
                return CheckOpenSSLImplHasRequiredMethods.m10214a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return CheckSSLParametersGetter.m10217a(injector);
            case 3:
                return CheckSSLSessionTimeoutSetter.m10220a(injector);
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                return CheckSocketImplSetter.m10223a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
