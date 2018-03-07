package com.facebook.analytics.service;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: third_party_impression_logging_urls */
public class AnalyticsServiceHandler implements BlueServiceHandler {
    private static AnalyticsServiceHandler f1201b;
    private static final Object f1202c = new Object();
    private final Lazy<HoneyAnalyticsUploadHandler> f1203a;

    private static AnalyticsServiceHandler m1456b(InjectorLike injectorLike) {
        return new AnalyticsServiceHandler(IdBasedSingletonScopeProvider.b(injectorLike, 191));
    }

    @Inject
    public AnalyticsServiceHandler(Lazy<HoneyAnalyticsUploadHandler> lazy) {
        this.f1203a = lazy;
    }

    public final OperationResult m1458a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("analytics_upload".equals(str)) {
            return m1457b(operationParams);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    private OperationResult m1457b(OperationParams operationParams) {
        ((HoneyAnalyticsUploadHandler) this.f1203a.get()).m1471a(operationParams.c.getString("flush_tag"));
        return OperationResult.a;
    }

    public static AnalyticsServiceHandler m1455a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnalyticsServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1202c) {
                AnalyticsServiceHandler analyticsServiceHandler;
                if (a2 != null) {
                    analyticsServiceHandler = (AnalyticsServiceHandler) a2.a(f1202c);
                } else {
                    analyticsServiceHandler = f1201b;
                }
                if (analyticsServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1456b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1202c, b3);
                        } else {
                            f1201b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = analyticsServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
