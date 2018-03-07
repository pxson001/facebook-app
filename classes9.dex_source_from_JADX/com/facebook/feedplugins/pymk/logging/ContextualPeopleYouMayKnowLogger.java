package com.facebook.feedplugins.pymk.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
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
/* compiled from: TOPIC_TAB */
public class ContextualPeopleYouMayKnowLogger {
    private static ContextualPeopleYouMayKnowLogger f24717c;
    private static final Object f24718d = new Object();
    private final AnalyticsLogger f24719a;
    private final String f24720b = SafeUUIDGenerator.a().toString();

    private static ContextualPeopleYouMayKnowLogger m26585b(InjectorLike injectorLike) {
        return new ContextualPeopleYouMayKnowLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContextualPeopleYouMayKnowLogger(AnalyticsLogger analyticsLogger) {
        this.f24719a = analyticsLogger;
    }

    public static ContextualPeopleYouMayKnowLogger m26584a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ContextualPeopleYouMayKnowLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24718d) {
                ContextualPeopleYouMayKnowLogger contextualPeopleYouMayKnowLogger;
                if (a2 != null) {
                    contextualPeopleYouMayKnowLogger = (ContextualPeopleYouMayKnowLogger) a2.a(f24718d);
                } else {
                    contextualPeopleYouMayKnowLogger = f24717c;
                }
                if (contextualPeopleYouMayKnowLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26585b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24718d, b3);
                        } else {
                            f24717c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = contextualPeopleYouMayKnowLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
