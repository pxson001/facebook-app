package com.facebook.inject;

import java.lang.annotation.Annotation;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: x-flatbuffer-fallback-json */
public class SingletonScope implements Scope, ScopeWithInit {
    private FbInjector f647a;
    public final ContextScope f648b;
    private SingletonAwareInjector f649c;

    SingletonScope(ContextScope contextScope) {
        this.f648b = contextScope;
    }

    public Class<? extends Annotation> annotationType() {
        return Singleton.class;
    }

    public final void mo195a(FbInjector fbInjector) {
        this.f647a = fbInjector;
        this.f649c = new SingletonAwareInjector(this.f647a, this);
    }

    public final <T> Provider<T> mo194a(Provider<T> provider) {
        return new SingletonProvider(this, provider);
    }

    public InjectorThreadStack enterScope() {
        InjectorThreadStack injectorThreadStack = this.f647a.getInjectorThreadStack();
        injectorThreadStack.m1468a();
        injectorThreadStack.m1470a(this.f649c);
        return injectorThreadStack;
    }

    public static void m1338a(InjectorThreadStack injectorThreadStack) {
        injectorThreadStack.m1471b();
        injectorThreadStack.m1472c();
    }
}
