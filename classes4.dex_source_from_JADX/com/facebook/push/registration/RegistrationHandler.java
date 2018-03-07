package com.facebook.push.registration;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.FbAppType;
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
import com.facebook.push.fbpushtoken.RegisterPushTokenMethod;
import com.facebook.push.fbpushtoken.RegisterPushTokenNoUserMethod;
import com.facebook.push.fbpushtoken.RegisterPushTokenNoUserParams;
import com.facebook.push.fbpushtoken.RegisterPushTokenParams;
import com.facebook.push.fbpushtoken.RegisterPushTokenResult;
import com.facebook.push.fbpushtoken.ReportAppDeletionMethod;
import com.facebook.push.fbpushtoken.ReportAppDeletionParams;
import com.facebook.push.fbpushtoken.UnregisterPushTokenMethod;
import com.facebook.push.fbpushtoken.UnregisterPushTokenParams;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: ice_connection_state */
public class RegistrationHandler implements BlueServiceHandler {
    public static final CallerContext f10550f = CallerContext.a(RegistrationHandler.class);
    private static RegistrationHandler f10551g;
    private static final Object f10552h = new Object();
    public final RegisterPushTokenMethod f10553a;
    public final UnregisterPushTokenMethod f10554b;
    public final ReportAppDeletionMethod f10555c;
    public final RegisterPushTokenNoUserMethod f10556d;
    public final Provider<SingleMethodRunner> f10557e;

    private static RegistrationHandler m11089b(InjectorLike injectorLike) {
        return new RegistrationHandler(new RegisterPushTokenMethod(), UnregisterPushTokenMethod.m10894a(injectorLike), new ReportAppDeletionMethod(), new RegisterPushTokenNoUserMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class)), IdBasedSingletonScopeProvider.a(injectorLike, 2289));
    }

    public final OperationResult m11090a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("register_push".equals(str)) {
            return OperationResult.a((RegisterPushTokenResult) ((AbstractSingleMethodRunner) this.f10557e.get()).a(this.f10553a, (RegisterPushTokenParams) operationParams.c.getParcelable("registerPushTokenParams")));
        } else if ("unregister_push".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10557e.get()).a(this.f10554b, (UnregisterPushTokenParams) operationParams.c.getParcelable("unregisterPushTokenParams"));
            return OperationResult.a;
        } else if ("report_app_deletion".equals(str)) {
            ((AbstractSingleMethodRunner) this.f10557e.get()).a(this.f10555c, (ReportAppDeletionParams) operationParams.c.getParcelable("reportAppDeletionParams"));
            return OperationResult.a;
        } else if ("register_push_no_user".equals(str)) {
            return OperationResult.a((RegisterPushTokenResult) ((AbstractSingleMethodRunner) this.f10557e.get()).a(this.f10556d, (RegisterPushTokenNoUserParams) operationParams.c.getParcelable("registerPushTokenNoUserParams"), f10550f));
        } else {
            throw new Exception("Unknown type");
        }
    }

    public static RegistrationHandler m11088a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RegistrationHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10552h) {
                RegistrationHandler registrationHandler;
                if (a2 != null) {
                    registrationHandler = (RegistrationHandler) a2.a(f10552h);
                } else {
                    registrationHandler = f10551g;
                }
                if (registrationHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11089b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10552h, b3);
                        } else {
                            f10551g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = registrationHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public RegistrationHandler(RegisterPushTokenMethod registerPushTokenMethod, UnregisterPushTokenMethod unregisterPushTokenMethod, ReportAppDeletionMethod reportAppDeletionMethod, RegisterPushTokenNoUserMethod registerPushTokenNoUserMethod, Provider<SingleMethodRunner> provider) {
        this.f10553a = registerPushTokenMethod;
        this.f10554b = unregisterPushTokenMethod;
        this.f10555c = reportAppDeletionMethod;
        this.f10556d = registerPushTokenNoUserMethod;
        this.f10557e = provider;
    }
}
