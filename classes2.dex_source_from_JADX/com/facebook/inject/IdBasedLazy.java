package com.facebook.inject;

/* compiled from: was expecting double-quote to start field name */
public class IdBasedLazy<T> extends AbstractDefaultScopeLazy<T> {
    private final int f907a;

    private IdBasedLazy(int i, InjectorLike injectorLike) {
        super(injectorLike);
        this.f907a = i;
    }

    protected T onGetInstance(InjectorLike injectorLike) {
        return FbInjectorImpl.m1266a(injectorLike, this.f907a);
    }

    public static <T> Lazy<T> m1808a(InjectorLike injectorLike, int i) {
        return new IdBasedLazy(i, injectorLike);
    }
}
