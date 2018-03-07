package com.facebook.messaging.momentsinvite.analytics;

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
import com.facebook.messaging.momentsinvite.model.MomentsInviteXMAModel;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: java */
public class MomentsInviteLogger {
    private static MomentsInviteLogger f12291b;
    private static final Object f12292c = new Object();
    public final AnalyticsLogger f12293a;

    private static MomentsInviteLogger m12754b(InjectorLike injectorLike) {
        return new MomentsInviteLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MomentsInviteLogger(AnalyticsLogger analyticsLogger) {
        this.f12293a = analyticsLogger;
    }

    public static MomentsInviteLogger m12752a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MomentsInviteLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12292c) {
                MomentsInviteLogger momentsInviteLogger;
                if (a2 != null) {
                    momentsInviteLogger = (MomentsInviteLogger) a2.a(f12292c);
                } else {
                    momentsInviteLogger = f12291b;
                }
                if (momentsInviteLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12754b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12292c, b3);
                        } else {
                            f12291b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = momentsInviteLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static void m12753a(@Nullable MomentsInviteXMAModel momentsInviteXMAModel, HoneyClientEvent honeyClientEvent) {
        honeyClientEvent.c = "moments_invite";
        if (momentsInviteXMAModel != null) {
            if (momentsInviteXMAModel.d != null) {
                honeyClientEvent.b("share_xma_token", momentsInviteXMAModel.d);
            }
            if (momentsInviteXMAModel.f != null) {
                honeyClientEvent.b("share_id", momentsInviteXMAModel.f);
            }
        }
    }
}
