package com.facebook.omnistore.module;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$OmnistoreStoredProcedureComponent implements MultiBindIndexedProvider<OmnistoreStoredProcedureComponent>, Provider<Set<OmnistoreStoredProcedureComponent>> {
    public final InjectorLike mInjector;

    public STATICDI_MULTIBIND_PROVIDER$OmnistoreStoredProcedureComponent(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return new MultiBinderSet(this.mInjector.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<OmnistoreStoredProcedureComponent>> getLazySet(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$OmnistoreStoredProcedureComponent(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public static Set<OmnistoreStoredProcedureComponent> getSet(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$OmnistoreStoredProcedureComponent(injectorLike));
    }

    public final int size() {
        return 0;
    }

    public final OmnistoreStoredProcedureComponent provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}
