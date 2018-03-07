package com.facebook.quickpromotion.annotations;

import com.facebook.feedplugins.pymk.quickpromotion.PymkQPFragmentClassSetProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.orca.DiodeQpFragmentClassSetProvider;
import com.facebook.messaging.quickpromotion.MessengerQPFragmentClassSetProvider;
import com.facebook.quickpromotion.ui.QPDefaultFragmentClassSetProvider;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: unknown relative layout param =  */
public final class C0607x483689f implements MultiBindIndexedProvider<QuickPromotionFragmentClassSetProvider>, Provider<Set<QuickPromotionFragmentClassSetProvider>> {
    private final InjectorLike f4607a;

    public C0607x483689f(InjectorLike injectorLike) {
        this.f4607a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f4607a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 4;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return PymkQPFragmentClassSetProvider.a(injector);
            case 1:
                return DiodeQpFragmentClassSetProvider.a(injector);
            case 2:
                return MessengerQPFragmentClassSetProvider.a(injector);
            case 3:
                return QPDefaultFragmentClassSetProvider.m4652a(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
