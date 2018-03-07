package com.facebook.adinterfaces.events;

import android.content.Context;
import android.util.SparseArray;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.external.events.AdInterfacesEvent;
import com.facebook.adinterfaces.external.events.AdInterfacesEventSubscriber;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEventBus;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: \d{3}[\-]\d{3} */
public class AdInterfacesEventBus extends FbEventBus<AdInterfacesEventSubscriber, AdInterfacesEvent> {
    private static AdInterfacesEventBus f21651c;
    private static final Object f21652d = new Object();
    public final SparseArray<IntentHandler> f21653a = new SparseArray();
    public final AdInterfacesErrorReporter f21654b;

    private static AdInterfacesEventBus m22729b(InjectorLike injectorLike) {
        return new AdInterfacesEventBus(AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public AdInterfacesEventBus(AdInterfacesErrorReporter adInterfacesErrorReporter) {
        this.f21654b = adInterfacesErrorReporter;
    }

    public final void m22730a(int i, IntentHandler intentHandler) {
        this.f21653a.put(i, intentHandler);
    }

    public static AdInterfacesEventBus m22728a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AdInterfacesEventBus b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21652d) {
                AdInterfacesEventBus adInterfacesEventBus;
                if (a2 != null) {
                    adInterfacesEventBus = (AdInterfacesEventBus) a2.a(f21652d);
                } else {
                    adInterfacesEventBus = f21651c;
                }
                if (adInterfacesEventBus == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22729b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21652d, b3);
                        } else {
                            f21651c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = adInterfacesEventBus;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
