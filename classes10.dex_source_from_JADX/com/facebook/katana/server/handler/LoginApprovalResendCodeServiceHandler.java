package com.facebook.katana.server.handler;

import android.content.Context;
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
import com.facebook.katana.server.LoginApprovalResendCodeParams;
import com.facebook.katana.server.protocol.LoginApprovalResendCodeMethod;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: trackers */
public class LoginApprovalResendCodeServiceHandler implements BlueServiceHandler {
    private static LoginApprovalResendCodeServiceHandler f1165c;
    private static final Object f1166d = new Object();
    private final LoginApprovalResendCodeMethod f1167a;
    private final Provider<SingleMethodRunner> f1168b;

    private static LoginApprovalResendCodeServiceHandler m1191b(InjectorLike injectorLike) {
        return new LoginApprovalResendCodeServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new LoginApprovalResendCodeMethod());
    }

    @Inject
    public LoginApprovalResendCodeServiceHandler(Provider<SingleMethodRunner> provider, LoginApprovalResendCodeMethod loginApprovalResendCodeMethod) {
        this.f1168b = provider;
        this.f1167a = loginApprovalResendCodeMethod;
    }

    public final OperationResult m1192a(OperationParams operationParams) {
        String str = operationParams.b;
        if (!"login_approval_resend_code".equals(str) || operationParams.c == null) {
            throw new IllegalArgumentException("unknown operation type: " + str);
        }
        ((AbstractSingleMethodRunner) this.f1168b.get()).a(this.f1167a, (LoginApprovalResendCodeParams) operationParams.c.getParcelable("loginApprovalsResendCodeParams"), CallerContext.a(LoginApprovalResendCodeServiceHandler.class));
        return OperationResult.a;
    }

    public static LoginApprovalResendCodeServiceHandler m1190a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LoginApprovalResendCodeServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1166d) {
                LoginApprovalResendCodeServiceHandler loginApprovalResendCodeServiceHandler;
                if (a2 != null) {
                    loginApprovalResendCodeServiceHandler = (LoginApprovalResendCodeServiceHandler) a2.a(f1166d);
                } else {
                    loginApprovalResendCodeServiceHandler = f1165c;
                }
                if (loginApprovalResendCodeServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1191b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1166d, b3);
                        } else {
                            f1165c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = loginApprovalResendCodeServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
