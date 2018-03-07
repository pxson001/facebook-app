package com.facebook.richdocument.event;

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
/* compiled from: primary */
public class RichDocumentEventBus extends FbEventBus<RichDocumentEventSubscriber, RichDocumentEvent> {
    private static RichDocumentEventBus f5155a;
    private static final Object f5156b = new Object();

    private static RichDocumentEventBus m5129a() {
        return new RichDocumentEventBus();
    }

    public static RichDocumentEventBus m5130a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RichDocumentEventBus a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f5156b) {
                RichDocumentEventBus richDocumentEventBus;
                if (a3 != null) {
                    richDocumentEventBus = (RichDocumentEventBus) a3.a(f5156b);
                } else {
                    richDocumentEventBus = f5155a;
                }
                if (richDocumentEventBus == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m5129a();
                        if (a3 != null) {
                            a3.a(f5156b, a2);
                        } else {
                            f5155a = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = richDocumentEventBus;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
