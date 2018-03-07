package com.facebook.abtest.qe.service;

import android.content.Context;
import android.os.Bundle;
import com.facebook.abtest.qe.protocol.sync.Logging.QuickExperimentLoggingMethod;
import com.facebook.abtest.qe.protocol.sync.QuickExperimentApiMethodsHelper;
import com.facebook.abtest.qe.protocol.sync.QuickExperimentLoggingParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner$Batch;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.MethodBatcher;
import com.facebook.http.protocol.MethodBatcherImpl;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: time_from_start */
public class QuickExperimentSyncServiceHandler implements BlueServiceHandler {
    private static QuickExperimentSyncServiceHandler f1042e;
    private static final Object f1043f = new Object();
    private final MethodBatcherImpl f1044a;
    public final QuickExperimentLoggingMethod f1045b;
    public final Provider<SingleMethodRunner> f1046c;
    private final Lazy<QuickExperimentDataMaintenanceHelper> f1047d;

    private static QuickExperimentSyncServiceHandler m1343b(InjectorLike injectorLike) {
        return new QuickExperimentSyncServiceHandler(MethodBatcherImpl.a(injectorLike), new QuickExperimentLoggingMethod(new QuickExperimentApiMethodsHelper()), IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedLazy.a(injectorLike, 94));
    }

    @Inject
    public QuickExperimentSyncServiceHandler(MethodBatcher methodBatcher, QuickExperimentLoggingMethod quickExperimentLoggingMethod, Provider<SingleMethodRunner> provider, Lazy<QuickExperimentDataMaintenanceHelper> lazy) {
        this.f1044a = methodBatcher;
        this.f1045b = quickExperimentLoggingMethod;
        this.f1046c = provider;
        this.f1047d = lazy;
    }

    public final OperationResult m1344a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("sync_qe".equals(str)) {
            return m1342a(operationParams, false);
        }
        if ("sync_sessionless_qe".equals(str)) {
            return m1342a(operationParams, true);
        }
        if ("log_to_qe".equals(str)) {
            ((AbstractSingleMethodRunner) this.f1046c.get()).a(this.f1045b, (QuickExperimentLoggingParams) operationParams.c.getParcelable("experiment_logging_params"), operationParams.e);
            return OperationResult.a;
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }

    public static QuickExperimentSyncServiceHandler m1341a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickExperimentSyncServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1043f) {
                QuickExperimentSyncServiceHandler quickExperimentSyncServiceHandler;
                if (a2 != null) {
                    quickExperimentSyncServiceHandler = (QuickExperimentSyncServiceHandler) a2.a(f1043f);
                } else {
                    quickExperimentSyncServiceHandler = f1042e;
                }
                if (quickExperimentSyncServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1343b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1043f, b3);
                        } else {
                            f1042e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickExperimentSyncServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private OperationResult m1342a(OperationParams operationParams, boolean z) {
        boolean z2 = false;
        ApiMethodRunner$Batch a = this.f1044a.a();
        Collection<BatchOperation> b = ((QuickExperimentDataMaintenanceHelper) this.f1047d.get()).m1360b(z);
        if (b.isEmpty()) {
            return OperationResult.a;
        }
        CallerContext callerContext;
        RequestPriority requestPriority;
        for (BatchOperation a2 : b) {
            a.mo888a(a2);
        }
        if (operationParams.e != null) {
            callerContext = operationParams.e;
        } else {
            callerContext = CallerContext.a(getClass());
        }
        Bundle bundle = operationParams.c;
        if (bundle != null && bundle.getBoolean("force_refresh", false)) {
            z2 = true;
        }
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        if (z2) {
            requestPriority = RequestPriority.INTERACTIVE;
        } else {
            requestPriority = RequestPriority.CAN_WAIT;
        }
        apiMethodRunnerParams.f = requestPriority;
        a.mo884a(z ? "handleGetSessionlessQEs" : "handleGetQEs", callerContext, apiMethodRunnerParams);
        Builder builder = ImmutableMap.builder();
        for (BatchOperation a22 : b) {
            builder.b(a22.f11919c, a.mo887a(a22.f11919c));
        }
        ((QuickExperimentDataMaintenanceHelper) this.f1047d.get()).m1359a(builder.b(), z);
        return OperationResult.a;
    }
}
