package com.facebook.composer.inlinesprouts;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fundraiser_page_tapped_share */
public class InlineSproutsAnalyticsLogger {
    private static InlineSproutsAnalyticsLogger f6556b;
    private static final Object f6557c = new Object();
    public final AnalyticsLogger f6558a;

    private static InlineSproutsAnalyticsLogger m8020b(InjectorLike injectorLike) {
        return new InlineSproutsAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public InlineSproutsAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f6558a = analyticsLogger;
    }

    public static HoneyClientEvent m8021c(String str, String str2) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "inline_sprouts";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = str2;
        return honeyClientEvent;
    }

    public static InlineSproutsAnalyticsLogger m8019a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InlineSproutsAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6557c) {
                InlineSproutsAnalyticsLogger inlineSproutsAnalyticsLogger;
                if (a2 != null) {
                    inlineSproutsAnalyticsLogger = (InlineSproutsAnalyticsLogger) a2.a(f6557c);
                } else {
                    inlineSproutsAnalyticsLogger = f6556b;
                }
                if (inlineSproutsAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8020b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6557c, b3);
                        } else {
                            f6556b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = inlineSproutsAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
