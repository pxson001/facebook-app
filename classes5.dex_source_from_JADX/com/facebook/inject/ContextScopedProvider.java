package com.facebook.inject;

import android.app.Application;
import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import javax.inject.Provider;

/* compiled from: desktop_uri */
public class ContextScopedProvider<T> implements Provider<T> {
    private static final byte[] f5104a = new byte[]{(byte) 1};
    private final ContextScope f5105b;
    private final Provider<T> f5106c;
    private T f5107d;

    public ContextScopedProvider(ContextScope contextScope, Provider<T> provider) {
        this.f5105b = contextScope;
        this.f5106c = provider;
    }

    public T get() {
        ScopeSet a = ScopeSet.a();
        InjectorThreadStack injectorThreadStack = this.f5105b.getInjectorThreadStack();
        Context d = injectorThreadStack.d();
        if (d == null) {
            throw new ProvisioningException("Called context scoped provider outside of context scope");
        }
        if (!(d instanceof Application)) {
            a.a((byte) 8, f5104a);
        }
        byte b = a.b((byte) 8);
        try {
            T a2;
            PropertyBag a3 = ContextScope.a(d);
            synchronized (this) {
                if (a3 != null) {
                    a2 = a3.a(this);
                } else {
                    a2 = this.f5107d;
                }
                if (a2 == null) {
                    this.f5105b.a(d, injectorThreadStack);
                    try {
                        a2 = this.f5106c.get();
                        if (a3 != null) {
                            a3.a(this, a2);
                        } else {
                            this.f5107d = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
