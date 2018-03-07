package com.facebook.instantshopping.logging;

import android.content.Context;
import android.os.SystemClock;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ShareType.newMessage */
public class InstantShoppingDwellTimeLogger {
    private static InstantShoppingDwellTimeLogger f23537g;
    private static final Object f23538h = new Object();
    private InstantShoppingAnalyticsLogger f23539a;
    public long f23540b;
    public long f23541c;
    public long f23542d;
    public long f23543e;
    public boolean f23544f;

    private static InstantShoppingDwellTimeLogger m24864b(InjectorLike injectorLike) {
        return new InstantShoppingDwellTimeLogger(InstantShoppingAnalyticsLogger.m24853a(injectorLike));
    }

    @Inject
    public InstantShoppingDwellTimeLogger(InstantShoppingAnalyticsLogger instantShoppingAnalyticsLogger) {
        this.f23539a = instantShoppingAnalyticsLogger;
    }

    public final void m24865a() {
        if (!this.f23544f) {
            this.f23541c += SystemClock.uptimeMillis() - this.f23540b;
        }
    }

    public final void m24866c() {
        m24865a();
        this.f23544f = true;
    }

    public static InstantShoppingDwellTimeLogger m24863a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingDwellTimeLogger b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23538h) {
                InstantShoppingDwellTimeLogger instantShoppingDwellTimeLogger;
                if (a2 != null) {
                    instantShoppingDwellTimeLogger = (InstantShoppingDwellTimeLogger) a2.a(f23538h);
                } else {
                    instantShoppingDwellTimeLogger = f23537g;
                }
                if (instantShoppingDwellTimeLogger == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24864b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23538h, b3);
                        } else {
                            f23537g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantShoppingDwellTimeLogger;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
