package com.facebook.instantshopping.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.ScrollValueChangedEventSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.ScrollValueChangedEvent;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Shared Experiment */
public class InstantShoppingDidScrollLogger extends ScrollValueChangedEventSubscriber {
    private static InstantShoppingDidScrollLogger f23532d;
    private static final Object f23533e = new Object();
    private boolean f23534a;
    public RichDocumentEventBus f23535b;
    private final InstantShoppingAnalyticsLogger f23536c;

    private static InstantShoppingDidScrollLogger m24861b(InjectorLike injectorLike) {
        return new InstantShoppingDidScrollLogger(RichDocumentEventBus.a(injectorLike), InstantShoppingAnalyticsLogger.m24853a(injectorLike));
    }

    public final void m24862b(FbEvent fbEvent) {
        ScrollValueChangedEvent scrollValueChangedEvent = (ScrollValueChangedEvent) fbEvent;
        if (!this.f23534a && scrollValueChangedEvent.b > 0) {
            this.f23536c.m24858a("instant_shopping_did_scroll");
            this.f23534a = true;
        }
    }

    @Inject
    public InstantShoppingDidScrollLogger(RichDocumentEventBus richDocumentEventBus, InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger) {
        this.f23535b = richDocumentEventBus;
        this.f23536c = instantShoppingAnalyticsLogger;
    }

    public static InstantShoppingDidScrollLogger m24860a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingDidScrollLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23533e) {
                InstantShoppingDidScrollLogger instantShoppingDidScrollLogger;
                if (a2 != null) {
                    instantShoppingDidScrollLogger = (InstantShoppingDidScrollLogger) a2.a(f23533e);
                } else {
                    instantShoppingDidScrollLogger = f23532d;
                }
                if (instantShoppingDidScrollLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24861b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23533e, b3);
                        } else {
                            f23532d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantShoppingDidScrollLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
