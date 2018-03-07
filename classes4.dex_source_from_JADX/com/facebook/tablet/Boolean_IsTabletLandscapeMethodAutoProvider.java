package com.facebook.tablet;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

/* compiled from: prompt_confidence */
public class Boolean_IsTabletLandscapeMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean f4082a;
    private static final Object f4083b = new Object();

    private static Boolean m4617b(InjectorLike injectorLike) {
        return TabletModule.b((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return TabletModule.b((Context) getInstance(Context.class));
    }

    public static Boolean m4616a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            Boolean b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4083b) {
                Boolean bool;
                if (a2 != null) {
                    bool = (Boolean) a2.a(f4083b);
                } else {
                    bool = f4082a;
                }
                if (bool == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4617b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4083b, b3);
                        } else {
                            f4082a = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = bool;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
