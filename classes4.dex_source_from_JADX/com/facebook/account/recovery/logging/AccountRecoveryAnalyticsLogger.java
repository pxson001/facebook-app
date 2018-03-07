package com.facebook.account.recovery.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.growth.experiment.InitialAppLaunchExperimentLogger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: trim_time */
public class AccountRecoveryAnalyticsLogger {
    private static AccountRecoveryAnalyticsLogger f690c;
    private static final Object f691d = new Object();
    public final AnalyticsLogger f692a;
    public final Lazy<InitialAppLaunchExperimentLogger> f693b;

    private static AccountRecoveryAnalyticsLogger m1059b(InjectorLike injectorLike) {
        return new AccountRecoveryAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 2206));
    }

    public static AccountRecoveryAnalyticsLogger m1058a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AccountRecoveryAnalyticsLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f691d) {
                AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger;
                if (a2 != null) {
                    accountRecoveryAnalyticsLogger = (AccountRecoveryAnalyticsLogger) a2.a(f691d);
                } else {
                    accountRecoveryAnalyticsLogger = f690c;
                }
                if (accountRecoveryAnalyticsLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1059b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f691d, b3);
                        } else {
                            f690c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = accountRecoveryAnalyticsLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public AccountRecoveryAnalyticsLogger(AnalyticsLogger analyticsLogger, Lazy<InitialAppLaunchExperimentLogger> lazy) {
        this.f692a = analyticsLogger;
        this.f693b = lazy;
    }

    public final void m1063e() {
        AnalyticsLogger analyticsLogger = this.f692a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.FB4A_ACCOUNT_RECOVERY.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent, 1);
        ((InitialAppLaunchExperimentLogger) this.f693b.get()).m988a(EventType.FB4A_ACCOUNT_RECOVERY.getEventName(), true);
    }

    public final void m1060a(String str) {
        AnalyticsLogger analyticsLogger = this.f692a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.LOGIN_FROM_MSITE.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent.b("device_id", str), 1);
    }

    public final void m1064k() {
        AnalyticsLogger analyticsLogger = this.f692a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.DEVICE_DATA_READY.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent, 1);
    }

    public final void m1065l() {
        AnalyticsLogger analyticsLogger = this.f692a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.CUID_READY.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent, 1);
    }

    public final void m1062b(String str) {
        AnalyticsLogger analyticsLogger = this.f692a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.SEARCH_VIEWED.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent.b("search_type", str), 1);
    }

    public final void m1061a(boolean z) {
        ((InitialAppLaunchExperimentLogger) this.f693b.get()).m988a(EventType.CAPTCHA_REQUIRED.getEventName(), z);
    }

    public final void m1066l(String str) {
        AnalyticsLogger analyticsLogger = this.f692a;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(EventType.CODE_SUBMITTED.getEventName());
        honeyClientEvent.c = "account_recovery";
        analyticsLogger.b(honeyClientEvent.b("crypted_id", str), 1);
    }
}
