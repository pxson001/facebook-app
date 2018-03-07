package com.facebook.leadgen.event;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEventBus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: pin_subtitle */
public class LeadGenEventBus extends FbEventBus<LeadGenEventSubscriber, LeadGenEvent> {
    private static LeadGenEventBus f6379a;
    private static final Object f6380b = new Object();

    private static LeadGenEventBus m8216a() {
        return new LeadGenEventBus();
    }

    public static LeadGenEventBus m8217a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LeadGenEventBus a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f6380b) {
                LeadGenEventBus leadGenEventBus;
                if (a3 != null) {
                    leadGenEventBus = (LeadGenEventBus) a3.a(f6380b);
                } else {
                    leadGenEventBus = f6379a;
                }
                if (leadGenEventBus == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m8216a();
                        if (a3 != null) {
                            a3.a(f6380b, a2);
                        } else {
                            f6379a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = leadGenEventBus;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
