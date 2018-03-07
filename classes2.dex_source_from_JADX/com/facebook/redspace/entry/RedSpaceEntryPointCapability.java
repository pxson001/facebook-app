package com.facebook.redspace.entry;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import javax.inject.Inject;

/* compiled from: sponsored_link */
public class RedSpaceEntryPointCapability {
    private final QeAccessor f4199a;

    public static RedSpaceEntryPointCapability m7792b(InjectorLike injectorLike) {
        return new RedSpaceEntryPointCapability(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public RedSpaceEntryPointCapability(QeAccessor qeAccessor) {
        this.f4199a = qeAccessor;
    }

    public final boolean m7793a() {
        return this.f4199a.mo596a(ExperimentsForRedSpaceExperimentsModule.f7063h, false) && this.f4199a.mo596a(ExperimentsForRedSpaceExperimentsModule.f7062g, true);
    }

    public final boolean m7794b() {
        return this.f4199a.mo596a(ExperimentsForRedSpaceExperimentsModule.f7063h, false) && !this.f4199a.mo596a(ExperimentsForRedSpaceExperimentsModule.f7062g, true);
    }
}
