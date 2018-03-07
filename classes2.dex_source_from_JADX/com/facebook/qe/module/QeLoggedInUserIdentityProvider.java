package com.facebook.qe.module;

import com.facebook.common.util.SecureHashUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: unsupported_carrier */
public class QeLoggedInUserIdentityProvider {
    final Provider<String> f1853a;

    public static QeLoggedInUserIdentityProvider m3746b(InjectorLike injectorLike) {
        return new QeLoggedInUserIdentityProvider(IdBasedProvider.m1811a(injectorLike, 4442));
    }

    @Inject
    public QeLoggedInUserIdentityProvider(Provider<String> provider) {
        this.f1853a = provider;
    }

    public final String m3747a() {
        String str = (String) this.f1853a.get();
        return str != null ? SecureHashUtil.a(str) : null;
    }
}
