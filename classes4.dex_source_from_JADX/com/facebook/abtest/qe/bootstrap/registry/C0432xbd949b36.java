package com.facebook.abtest.qe.bootstrap.registry;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: updateDeviceSyncOlderPhotosOnServer */
public final class C0432xbd949b36 implements MultiBindIndexedProvider<SessionlessQuickExperimentSpecificationHolder>, Provider<Set<SessionlessQuickExperimentSpecificationHolder>> {
    private final InjectorLike f9561a;

    public C0432xbd949b36(InjectorLike injectorLike) {
        this.f9561a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f9561a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}
