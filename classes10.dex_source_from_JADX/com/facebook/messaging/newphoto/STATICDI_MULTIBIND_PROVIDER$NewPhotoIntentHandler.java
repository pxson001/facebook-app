package com.facebook.messaging.newphoto;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: return_scopes */
public final class STATICDI_MULTIBIND_PROVIDER$NewPhotoIntentHandler implements MultiBindIndexedProvider<NewPhotoIntentHandler>, Provider<Set<NewPhotoIntentHandler>> {
    private final InjectorLike f3369a;

    public STATICDI_MULTIBIND_PROVIDER$NewPhotoIntentHandler(InjectorLike injectorLike) {
        this.f3369a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3369a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}
