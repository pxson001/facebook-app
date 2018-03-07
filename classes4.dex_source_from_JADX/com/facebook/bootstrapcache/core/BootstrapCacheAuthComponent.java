package com.facebook.bootstrapcache.core;

import com.facebook.auth.component.AbstractAuthComponent;
import com.facebook.auth.component.AuthenticationResult;
import javax.inject.Inject;

/* compiled from: sys_storage_threshold_max_bytes */
public class BootstrapCacheAuthComponent extends AbstractAuthComponent {
    private final BootstrapCache f1396a;

    @Inject
    public BootstrapCacheAuthComponent(BootstrapCache bootstrapCache) {
        this.f1396a = bootstrapCache;
    }

    public final void m1631a(AuthenticationResult authenticationResult) {
        this.f1396a.m1644d();
    }

    public final void m1632c() {
        this.f1396a.m1643c();
    }
}
