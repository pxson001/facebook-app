package com.facebook.widget.hscrollrecyclerview;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: diode_promotion */
public class HScrollDimensionCache {
    private static HScrollDimensionCache f13823b;
    private static final Object f13824c = new Object();
    private final ArrayMap<String, int[]> f13825a = new ArrayMap();

    private static HScrollDimensionCache m14594a() {
        return new HScrollDimensionCache();
    }

    public final void m14596a(String str, int[] iArr) {
        this.f13825a.put(str, iArr);
    }

    public final int[] m14597a(String str) {
        return (int[]) this.f13825a.get(str);
    }

    public final boolean m14598b(String str) {
        return !StringUtil.a(str) && this.f13825a.containsKey(str);
    }

    public static HScrollDimensionCache m14595a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollDimensionCache a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f13824c) {
                HScrollDimensionCache hScrollDimensionCache;
                if (a3 != null) {
                    hScrollDimensionCache = (HScrollDimensionCache) a3.a(f13824c);
                } else {
                    hScrollDimensionCache = f13823b;
                }
                if (hScrollDimensionCache == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m14594a();
                        if (a3 != null) {
                            a3.a(f13824c, a2);
                        } else {
                            f13823b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = hScrollDimensionCache;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
