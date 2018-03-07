package com.facebook.auth.login;

import android.content.Context;
import com.facebook.auth.login.CheckApprovedMachineMethod.Result;
import com.facebook.common.callercontext.CallerContext;
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
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: system_time_ms */
public class CheckApprovedMachineServiceHandler implements BlueServiceHandler {
    private static CheckApprovedMachineServiceHandler f2287c;
    private static final Object f2288d = new Object();
    private final CheckApprovedMachineMethod f2289a;
    private final Provider<SingleMethodRunner> f2290b;

    private static CheckApprovedMachineServiceHandler m3182b(InjectorLike injectorLike) {
        return new CheckApprovedMachineServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new CheckApprovedMachineMethod());
    }

    @Inject
    public CheckApprovedMachineServiceHandler(Provider<SingleMethodRunner> provider, CheckApprovedMachineMethod checkApprovedMachineMethod) {
        this.f2290b = provider;
        this.f2289a = checkApprovedMachineMethod;
    }

    public final OperationResult m3183a(OperationParams operationParams) {
        String str = operationParams.b;
        if (!"check_approved_machine".equals(str) || operationParams.c == null) {
            throw new IllegalArgumentException("unknown operation type: " + str);
        }
        return OperationResult.a((Result) ((AbstractSingleMethodRunner) this.f2290b.get()).a(this.f2289a, (CheckApprovedMachineParams) operationParams.c.getParcelable("checkApprovedMachineParams"), CallerContext.a(CheckApprovedMachineServiceHandler.class)));
    }

    public static CheckApprovedMachineServiceHandler m3181a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CheckApprovedMachineServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2288d) {
                CheckApprovedMachineServiceHandler checkApprovedMachineServiceHandler;
                if (a2 != null) {
                    checkApprovedMachineServiceHandler = (CheckApprovedMachineServiceHandler) a2.a(f2288d);
                } else {
                    checkApprovedMachineServiceHandler = f2287c;
                }
                if (checkApprovedMachineServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3182b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2288d, b3);
                        } else {
                            f2287c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = checkApprovedMachineServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
