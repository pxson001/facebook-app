package com.facebook.inject;

import javax.inject.Provider;

/* compiled from: default_share_message */
public class SingletonAwareInjector$1 implements Provider<T> {
    final /* synthetic */ Provider f5158a;
    final /* synthetic */ SingletonAwareInjector f5159b;

    public SingletonAwareInjector$1(SingletonAwareInjector singletonAwareInjector, Provider provider) {
        this.f5159b = singletonAwareInjector;
        this.f5158a = provider;
    }

    public T get() {
        InjectorThreadStack enterScope = this.f5159b.a.enterScope();
        try {
            T t = this.f5158a.get();
            return t;
        } finally {
            SingletonAwareInjector.a(this.f5159b);
            SingletonScope.a(enterScope);
        }
    }
}
