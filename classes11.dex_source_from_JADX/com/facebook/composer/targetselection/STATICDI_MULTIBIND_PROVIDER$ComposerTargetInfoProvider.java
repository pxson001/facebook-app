package com.facebook.composer.targetselection;

import com.facebook.composer.activity.DefaultComposerTargetInfoProvider;
import com.facebook.composer.pagesintegration.PagesComposerTargetInfoProvider;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: rsvp_event */
public final class STATICDI_MULTIBIND_PROVIDER$ComposerTargetInfoProvider implements MultiBindIndexedProvider<ComposerTargetInfoProvider>, Provider<Set<ComposerTargetInfoProvider>> {
    private final InjectorLike f6983a;

    private STATICDI_MULTIBIND_PROVIDER$ComposerTargetInfoProvider(InjectorLike injectorLike) {
        this.f6983a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f6983a.getScopeAwareInjector(), this);
    }

    public static Set<ComposerTargetInfoProvider> m8284a(InjectorLike injectorLike) {
        return new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ComposerTargetInfoProvider(injectorLike));
    }

    public final int size() {
        return 2;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new DefaultComposerTargetInfoProvider();
            case 1:
                return new PagesComposerTargetInfoProvider();
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
