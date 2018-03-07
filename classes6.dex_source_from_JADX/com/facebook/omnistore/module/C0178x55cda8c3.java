package com.facebook.omnistore.module;

import com.facebook.contacts.omnistore.ContactsOmnistoreModule;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.omnistore.module.OmnistoreIndexerRegistration.IndexerFunctionMultibindWrapper;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: target_profile_pic_url */
public final class C0178x55cda8c3 implements MultiBindIndexedProvider<IndexerFunctionMultibindWrapper>, Provider<Set<IndexerFunctionMultibindWrapper>> {
    public final InjectorLike mInjector;

    public C0178x55cda8c3(InjectorLike injectorLike) {
        this.mInjector = injectorLike;
    }

    public final /* bridge */ /* synthetic */ Object get() {
        return new MultiBinderSet(this.mInjector.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<IndexerFunctionMultibindWrapper>> getLazySet(InjectorLike injectorLike) {
        return ProviderLazy.a(new C0178x55cda8c3(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public static Set<IndexerFunctionMultibindWrapper> getSet(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new C0178x55cda8c3(injectorLike));
    }

    public final int size() {
        return 1;
    }

    public final IndexerFunctionMultibindWrapper provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return ContactsOmnistoreModule.a(IdBasedLazy.a(injector, 8767));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
