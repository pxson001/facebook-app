package com.facebook.inject;

import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.inject.Key;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: delegate */
public class MultiBinderProvider<T> implements Provider<Set<T>> {
    public final Key<? extends T>[] f5147a;
    private final FbInjector f5148b;
    private final Key<? extends T> f5149c;

    /* compiled from: delegate */
    class C04881 implements MultiBindIndexedProvider<T> {
        final /* synthetic */ MultiBinderProvider f5146a;

        C04881(MultiBinderProvider multiBinderProvider) {
            this.f5146a = multiBinderProvider;
        }

        public T provide(Injector injector, int i) {
            return injector.getInstance(this.f5146a.f5147a[i]);
        }

        public int size() {
            return this.f5146a.f5147a.length;
        }
    }

    MultiBinderProvider(FbInjector fbInjector, List<Key<? extends T>> list, Key<? extends T> key) {
        this.f5148b = fbInjector;
        this.f5147a = (Key[]) list.toArray(new Key[list.size()]);
        this.f5149c = key;
    }

    public Object get() {
        TracerDetour.a("MultiBinderProvider: %s", this.f5149c, 1809034400);
        try {
            Object multiBinderSet = new MultiBinderSet(this.f5148b.getScopeAwareInjector(), new C04881(this));
            return multiBinderSet;
        } finally {
            TracerDetour.a(603307086);
        }
    }
}
