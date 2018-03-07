package com.facebook.feedplugins.pymk.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TOPIC_SWIPE */
public class PeopleYouMayKnowAnalyticsLogger {
    private static PeopleYouMayKnowAnalyticsLogger f24721e;
    private static final Object f24722f = new Object();
    private final AnalyticsLogger f24723a;
    private final String f24724b = "ccu_promo_card_position";
    private final String f24725c = "ccu_promo_scrolling_position";
    private final String f24726d = SafeUUIDGenerator.a().toString();

    private static PeopleYouMayKnowAnalyticsLogger m26588b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PeopleYouMayKnowAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f24723a = analyticsLogger;
    }

    public final void m26590a(int i) {
        this.f24723a.a(m26586a("pymk_ccu_footer_scrolling_promo_shown").a("ccu_promo_scrolling_position", i));
    }

    public final void m26591b(int i) {
        this.f24723a.a(m26586a("pymk_ccu_promo_card_shown").a("ccu_promo_card_position", i));
    }

    public final void m26589a() {
        this.f24723a.a(m26586a("pymk_ccu_promo_card_clicked"));
    }

    private HoneyClientEvent m26586a(String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.c = "native_newsfeed";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = this.f24726d;
        return honeyClientEvent;
    }

    public static PeopleYouMayKnowAnalyticsLogger m26587a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24722f) {
                PeopleYouMayKnowAnalyticsLogger peopleYouMayKnowAnalyticsLogger;
                if (a2 != null) {
                    peopleYouMayKnowAnalyticsLogger = (PeopleYouMayKnowAnalyticsLogger) a2.a(f24722f);
                } else {
                    peopleYouMayKnowAnalyticsLogger = f24721e;
                }
                if (peopleYouMayKnowAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26588b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24722f, b3);
                        } else {
                            f24721e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
