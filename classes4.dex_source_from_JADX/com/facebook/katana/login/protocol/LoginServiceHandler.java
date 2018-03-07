package com.facebook.katana.login.protocol;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sms_auto_retrieve */
public class LoginServiceHandler implements BlueServiceHandler {
    public static final CallerContext f2119a = CallerContext.a(LoginServiceHandler.class);
    private static LoginServiceHandler f2120d;
    private static final Object f2121e = new Object();
    public final AbstractSingleMethodRunner f2122b;
    public final LoginBroadcastEligibilityCheckMethod f2123c;

    private static LoginServiceHandler m2220b(InjectorLike injectorLike) {
        return new LoginServiceHandler((AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new LoginBroadcastEligibilityCheckMethod());
    }

    @Inject
    public LoginServiceHandler(AbstractSingleMethodRunner abstractSingleMethodRunner, LoginBroadcastEligibilityCheckMethod loginBroadcastEligibilityCheckMethod) {
        this.f2122b = abstractSingleMethodRunner;
        this.f2123c = loginBroadcastEligibilityCheckMethod;
    }

    public final OperationResult m2221a(OperationParams operationParams) {
        if (operationParams.b.equals("login_broadcast_eligibility_check")) {
            return OperationResult.a((LoginBroadcastEligibilityResult) this.f2122b.a(this.f2123c, null, f2119a));
        }
        return OperationResult.a(ErrorCode.OTHER);
    }

    public static LoginServiceHandler m2219a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LoginServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2121e) {
                LoginServiceHandler loginServiceHandler;
                if (a2 != null) {
                    loginServiceHandler = (LoginServiceHandler) a2.a(f2121e);
                } else {
                    loginServiceHandler = f2120d;
                }
                if (loginServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2220b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2121e, b3);
                        } else {
                            f2120d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = loginServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
