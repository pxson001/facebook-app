package com.facebook.richdocument.utils;

import android.content.Context;
import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_theme_list */
public class ConnectionQualityMonitor {
    private static ConnectionQualityMonitor f23881c;
    private static final Object f23882d = new Object();
    private final FbDataConnectionManager f23883a;
    private ConnectionQuality f23884b;

    private static ConnectionQualityMonitor m32272b(InjectorLike injectorLike) {
        return new ConnectionQualityMonitor(FbDataConnectionManager.m3787a(injectorLike));
    }

    @Inject
    public ConnectionQualityMonitor(FbDataConnectionManager fbDataConnectionManager) {
        this.f23883a = fbDataConnectionManager;
    }

    public final ConnectionQuality m32273a() {
        if (this.f23884b == null) {
            this.f23884b = this.f23883a.m3801c();
        }
        return this.f23884b;
    }

    public static ConnectionQualityMonitor m32271a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ConnectionQualityMonitor b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23882d) {
                ConnectionQualityMonitor connectionQualityMonitor;
                if (a2 != null) {
                    connectionQualityMonitor = (ConnectionQualityMonitor) a2.mo818a(f23882d);
                } else {
                    connectionQualityMonitor = f23881c;
                }
                if (connectionQualityMonitor == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32272b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23882d, b3);
                        } else {
                            f23881c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = connectionQualityMonitor;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
