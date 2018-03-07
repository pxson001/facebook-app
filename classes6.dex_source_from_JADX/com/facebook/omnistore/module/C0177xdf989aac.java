package com.facebook.omnistore.module;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.omnistore.module.OmnistoreCallbackRegistration.FilteredCallbackMultibindWrapper;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class C0177xdf989aac implements MultiBindIndexedProvider<FilteredCallbackMultibindWrapper>, Provider<Set<FilteredCallbackMultibindWrapper>> {
    public final InjectorLike mInjector;

    public C0177xdf989aac(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return new MultiBinderSet(this.mInjector.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<FilteredCallbackMultibindWrapper>> getLazySet(InjectorLike injectorLike) {
        return ProviderLazy.a(new C0177xdf989aac(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public static Set<FilteredCallbackMultibindWrapper> getSet(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0177xdf989aac(injectorLike));
    }

    public final int size() {
        return 0;
    }

    public final FilteredCallbackMultibindWrapper provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}
