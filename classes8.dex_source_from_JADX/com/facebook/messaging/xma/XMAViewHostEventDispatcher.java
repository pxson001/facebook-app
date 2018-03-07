package com.facebook.messaging.xma;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.WeakHashMap;

@ContextScoped
/* compiled from: time_saved_ms DESC */
public class XMAViewHostEventDispatcher {
    private static XMAViewHostEventDispatcher f1576b;
    private static final Object f1577c = new Object();
    public final WeakHashMap<XMAViewHostEventListener, Boolean> f1578a = new WeakHashMap();

    private static XMAViewHostEventDispatcher m1750c() {
        return new XMAViewHostEventDispatcher();
    }

    public static XMAViewHostEventDispatcher m1749a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            XMAViewHostEventDispatcher c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1577c) {
                XMAViewHostEventDispatcher xMAViewHostEventDispatcher;
                if (a2 != null) {
                    xMAViewHostEventDispatcher = (XMAViewHostEventDispatcher) a2.a(f1577c);
                } else {
                    xMAViewHostEventDispatcher = f1576b;
                }
                if (xMAViewHostEventDispatcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m1750c();
                        if (a2 != null) {
                            a2.a(f1577c, c);
                        } else {
                            f1576b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = xMAViewHostEventDispatcher;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
