package com.facebook.events.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: cannot create attachment for draft */
public class PublicEventsActionBarGoingButtonSelector {
    private static PublicEventsActionBarGoingButtonSelector f17893b;
    private static final Object f17894c = new Object();
    public int f17895a = 0;

    private static PublicEventsActionBarGoingButtonSelector m18307c() {
        return new PublicEventsActionBarGoingButtonSelector();
    }

    public final boolean m18308a() {
        return this.f17895a == 1;
    }

    public final boolean m18309b() {
        return this.f17895a == 1;
    }

    public static PublicEventsActionBarGoingButtonSelector m18306a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PublicEventsActionBarGoingButtonSelector c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17894c) {
                PublicEventsActionBarGoingButtonSelector publicEventsActionBarGoingButtonSelector;
                if (a2 != null) {
                    publicEventsActionBarGoingButtonSelector = (PublicEventsActionBarGoingButtonSelector) a2.a(f17894c);
                } else {
                    publicEventsActionBarGoingButtonSelector = f17893b;
                }
                if (publicEventsActionBarGoingButtonSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m18307c();
                        if (a2 != null) {
                            a2.a(f17894c, c);
                        } else {
                            f17893b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = publicEventsActionBarGoingButtonSelector;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
