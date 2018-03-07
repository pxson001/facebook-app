package com.facebook.friends.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: max_retry_count_after_network_error */
public class PYMKImpressionLogger {
    private static PYMKImpressionLogger f10642b;
    private static final Object f10643c = new Object();
    private final AnalyticsLogger f10644a;

    private static PYMKImpressionLogger m16757b(InjectorLike injectorLike) {
        return new PYMKImpressionLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PYMKImpressionLogger(AnalyticsLogger analyticsLogger) {
        this.f10644a = analyticsLogger;
    }

    public final void m16758a(long j, PeopleYouMayKnowLocation peopleYouMayKnowLocation, @Nullable PeopleYouMayKnowLocation peopleYouMayKnowLocation2, String str) {
        HoneyClientEvent b = new HoneyClientEvent("regular_pymk_imp").a("pymk_id", j).b("pymk_location", peopleYouMayKnowLocation.value);
        b.f = str;
        b = b;
        if (peopleYouMayKnowLocation2 != null) {
            b.b("pymk_ref", peopleYouMayKnowLocation2.value);
        }
        this.f10644a.c(b);
    }

    public final void m16759a(long j, PeopleYouMayKnowLocation peopleYouMayKnowLocation, String str) {
        m16758a(j, peopleYouMayKnowLocation, null, str);
    }

    public static PYMKImpressionLogger m16756a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PYMKImpressionLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10643c) {
                PYMKImpressionLogger pYMKImpressionLogger;
                if (a2 != null) {
                    pYMKImpressionLogger = (PYMKImpressionLogger) a2.a(f10643c);
                } else {
                    pYMKImpressionLogger = f10642b;
                }
                if (pYMKImpressionLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m16757b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10643c, b3);
                        } else {
                            f10642b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pYMKImpressionLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
