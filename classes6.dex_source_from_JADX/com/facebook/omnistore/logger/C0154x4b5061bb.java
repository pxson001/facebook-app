package com.facebook.omnistore.logger;

import com.facebook.inject.AbstractDefaultScopeLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;

/* compiled from: text_only_name */
public final class C0154x4b5061bb extends AbstractDefaultScopeLazy {
    public C0154x4b5061bb(InjectorLike injectorLike) {
        super(injectorLike);
    }

    protected final Object onGetInstance(InjectorLike injectorLike) {
        return FakeOmnistoreErrorReporter.m4244x2b61d28b(injectorLike);
    }

    public static Lazy<FakeOmnistoreErrorReporter> getLazy(InjectorLike injectorLike) {
        return new C0154x4b5061bb(injectorLike);
    }
}
