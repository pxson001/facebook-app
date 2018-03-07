package com.facebook.uberbar.api;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.search.api.protocol.FetchSearchTypeaheadResultParams;
import com.facebook.search.api.protocol.FetchSimpleSearchTypeaheadApiMethod;
import com.facebook.ui.typeahead.SearchResponse;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: total_search_duration */
public class UberbarServiceHandler implements BlueServiceHandler {
    private static UberbarServiceHandler f1413d;
    private static final Object f1414e = new Object();
    private final Provider<SingleMethodRunner> f1415a;
    private final FetchSimpleSearchTypeaheadApiMethod f1416b;
    private final PerformanceLogger f1417c;

    private static UberbarServiceHandler m1536b(InjectorLike injectorLike) {
        return new UberbarServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), FetchSimpleSearchTypeaheadApiMethod.b(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike));
    }

    @Inject
    public UberbarServiceHandler(Provider<SingleMethodRunner> provider, FetchSimpleSearchTypeaheadApiMethod fetchSimpleSearchTypeaheadApiMethod, PerformanceLogger performanceLogger) {
        this.f1415a = provider;
        this.f1416b = fetchSimpleSearchTypeaheadApiMethod;
        this.f1417c = performanceLogger;
    }

    public final OperationResult m1537a(OperationParams operationParams) {
        if ("fetch_uberbar_result".equals(operationParams.b)) {
            return m1534a(operationParams, 1769476, "SearchRemoteFetch");
        }
        throw new Exception("Unknown type");
    }

    private OperationResult m1534a(OperationParams operationParams, int i, String str) {
        this.f1417c.b(i, str);
        this.f1417c.d(i, str);
        try {
            ArrayList a = Lists.a(((SearchResponse) ((AbstractSingleMethodRunner) this.f1415a.get()).a(this.f1416b, (FetchSearchTypeaheadResultParams) operationParams.b().getParcelable("fetchQueryResultParams"))).b());
            this.f1417c.c(i, str);
            return OperationResult.a(a);
        } catch (Throwable e) {
            this.f1417c.f(i, str);
            throw new RuntimeException(e);
        }
    }

    public static UberbarServiceHandler m1535a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            UberbarServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1414e) {
                UberbarServiceHandler uberbarServiceHandler;
                if (a2 != null) {
                    uberbarServiceHandler = (UberbarServiceHandler) a2.a(f1414e);
                } else {
                    uberbarServiceHandler = f1413d;
                }
                if (uberbarServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1536b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1414e, b3);
                        } else {
                            f1413d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = uberbarServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
