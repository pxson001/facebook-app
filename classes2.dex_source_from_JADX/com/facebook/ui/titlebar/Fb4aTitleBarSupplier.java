package com.facebook.ui.titlebar;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.titlebar.FbTitleBarSupplier;

@ContextScoped
/* compiled from: strings */
public class Fb4aTitleBarSupplier implements FbTitleBarSupplier {
    private static Fb4aTitleBarSupplier f3980b;
    private static final Object f3981c = new Object();
    public Fb4aTitleBar f3982a;

    private static Fb4aTitleBarSupplier m6584b() {
        return new Fb4aTitleBarSupplier();
    }

    public final Fb4aTitleBar m6585a() {
        return this.f3982a;
    }

    public /* synthetic */ Object get() {
        return this.f3982a;
    }

    public final void m6586a(Fb4aTitleBar fb4aTitleBar) {
        this.f3982a = fb4aTitleBar;
    }

    public static Fb4aTitleBarSupplier m6583a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            Fb4aTitleBarSupplier b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f3981c) {
                Fb4aTitleBarSupplier fb4aTitleBarSupplier;
                if (a2 != null) {
                    fb4aTitleBarSupplier = (Fb4aTitleBarSupplier) a2.mo818a(f3981c);
                } else {
                    fb4aTitleBarSupplier = f3980b;
                }
                if (fb4aTitleBarSupplier == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.m1474e();
                        b3 = m6584b();
                        if (a2 != null) {
                            a2.mo822a(f3981c, b3);
                        } else {
                            f3980b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = fb4aTitleBarSupplier;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
