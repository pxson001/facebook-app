package com.facebook.appdiscovery.lite.analytics;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_recent_entity */
public class LiteInstallLogger {
    private static LiteInstallLogger f10556b;
    private static final Object f10557c = new Object();
    private final AnalyticsLogger f10558a;

    private static LiteInstallLogger m12458b(InjectorLike injectorLike) {
        return new LiteInstallLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LiteInstallLogger(AnalyticsLogger analyticsLogger) {
        this.f10558a = analyticsLogger;
    }

    public final void m12459a(@Nullable String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("app_discovery_lite_install_clicked");
        if (str != null) {
            honeyClientEvent.b("package_name", str);
        }
        this.f10558a.a(honeyClientEvent);
    }

    public static LiteInstallLogger m12457a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LiteInstallLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10557c) {
                LiteInstallLogger liteInstallLogger;
                if (a2 != null) {
                    liteInstallLogger = (LiteInstallLogger) a2.a(f10557c);
                } else {
                    liteInstallLogger = f10556b;
                }
                if (liteInstallLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12458b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10557c, b3);
                        } else {
                            f10556b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = liteInstallLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
