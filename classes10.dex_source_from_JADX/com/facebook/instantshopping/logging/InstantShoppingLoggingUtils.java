package com.facebook.instantshopping.logging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ShareType.forward */
public class InstantShoppingLoggingUtils {
    private static InstantShoppingLoggingUtils f23555b;
    private static final Object f23556c = new Object();
    private FunnelLoggerImpl f23557a;

    private static InstantShoppingLoggingUtils m24882b(InjectorLike injectorLike) {
        return new InstantShoppingLoggingUtils(FunnelLoggerImpl.a(injectorLike));
    }

    @Inject
    public InstantShoppingLoggingUtils(FunnelLoggerImpl funnelLoggerImpl) {
        this.f23557a = funnelLoggerImpl;
    }

    public final void m24883a(String str) {
        if (this.f23557a != null) {
            this.f23557a.b(FunnelRegistry.y, str);
        }
    }

    public final void m24884b(String str, String str2) {
        if (this.f23557a != null) {
            this.f23557a.a(FunnelRegistry.y, str, str2);
        }
    }

    public static InstantShoppingLoggingUtils m24879a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingLoggingUtils b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23556c) {
                InstantShoppingLoggingUtils instantShoppingLoggingUtils;
                if (a2 != null) {
                    instantShoppingLoggingUtils = (InstantShoppingLoggingUtils) a2.a(f23556c);
                } else {
                    instantShoppingLoggingUtils = f23555b;
                }
                if (instantShoppingLoggingUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24882b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23556c, b3);
                        } else {
                            f23555b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = instantShoppingLoggingUtils;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static Map<String, Object> m24880a(Map<String, Object> map, String str, Object obj) {
        if (map == null) {
            map = new HashMap();
        }
        map.put(str, obj);
        return map;
    }

    public static Map<String, Object> m24881a(Map<String, Object> map, Map<String, Object> map2) {
        if (map == null) {
            map = new HashMap();
        }
        map.putAll(map2);
        return map;
    }
}
