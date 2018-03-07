package com.facebook.saved.launcher;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: return_scopes */
public final class STATICDI_MULTIBIND_PROVIDER$SavedActivityLauncherWithResult implements MultiBindIndexedProvider<SavedActivityLauncherWithResult>, Provider<Set<SavedActivityLauncherWithResult>> {
    private final InjectorLike f9192a;

    public STATICDI_MULTIBIND_PROVIDER$SavedActivityLauncherWithResult(InjectorLike injectorLike) {
        this.f9192a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f9192a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 1;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return SavedReviewComposerLauncherWithResult.m9220b(injector);
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
