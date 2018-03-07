package com.facebook.messaging.newphoto;

import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: return_scopes */
public final class C0544x42625aba implements MultiBindIndexedProvider<NewPhotoIntentReceiverStateChangeListener>, Provider<Set<NewPhotoIntentReceiverStateChangeListener>> {
    private final InjectorLike f3370a;

    public C0544x42625aba(InjectorLike injectorLike) {
        this.f3370a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f3370a.getScopeAwareInjector(), this);
    }

    public final int size() {
        return 0;
    }

    public final Object provide(Injector injector, int i) {
        throw new IllegalArgumentException("Invalid binding index");
    }
}
