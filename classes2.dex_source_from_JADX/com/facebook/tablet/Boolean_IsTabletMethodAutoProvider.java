package com.facebook.tablet;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

/* compiled from: spinner_fps */
public class Boolean_IsTabletMethodAutoProvider extends AbstractProvider<Boolean> {
    private static Boolean f4251a;
    private static final Object f4252b = new Object();

    private static Boolean m7865b(InjectorLike injectorLike) {
        return TabletModule.m7866a((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return TabletModule.m7866a((Context) getInstance(Context.class));
    }

    public static Boolean m7864a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            Boolean b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f4252b) {
                Boolean bool;
                if (a2 != null) {
                    bool = (Boolean) a2.mo818a(f4252b);
                } else {
                    bool = f4251a;
                }
                if (bool == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m7865b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f4252b, b3);
                        } else {
                            f4251a = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = bool;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
