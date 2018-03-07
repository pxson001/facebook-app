package com.facebook.friends.logging;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.friends.constants.FriendRequestResponseRef;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: max_seen_by */
public class FriendRequestLogger {
    private static FriendRequestLogger f10638c;
    private static final Object f10639d = new Object();
    private final AnalyticsLogger f10640a;
    private final GatekeeperStoreImpl f10641b;

    private static FriendRequestLogger m16753b(InjectorLike injectorLike) {
        return new FriendRequestLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendRequestLogger(AnalyticsLogger analyticsLogger, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f10640a = analyticsLogger;
        this.f10641b = gatekeeperStoreImpl;
    }

    private void m16752a(long j, FriendRequestResponseRef friendRequestResponseRef, @Nullable FriendRequestResponseRef friendRequestResponseRef2, String str) {
        HoneyClientEvent b = new HoneyClientEvent("request_seen").a("request_id", j).b("request_surface", friendRequestResponseRef.value);
        b.c = "friend_request_waterfall";
        b = b;
        b.f = str;
        b = b;
        if (friendRequestResponseRef2 != null) {
            b.b("request_ref", friendRequestResponseRef2.value);
        }
        this.f10640a.c(b);
    }

    public static FriendRequestLogger m16751a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendRequestLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10639d) {
                FriendRequestLogger friendRequestLogger;
                if (a2 != null) {
                    friendRequestLogger = (FriendRequestLogger) a2.a(f10639d);
                } else {
                    friendRequestLogger = f10638c;
                }
                if (friendRequestLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m16753b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10639d, b3);
                        } else {
                            f10638c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendRequestLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m16754a(long j, FriendRequestResponseRef friendRequestResponseRef, String str) {
        m16752a(j, friendRequestResponseRef, null, str);
    }

    public final boolean m16755a() {
        return this.f10641b.a(666, false);
    }
}
