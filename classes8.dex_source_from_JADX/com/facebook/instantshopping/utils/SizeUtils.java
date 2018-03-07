package com.facebook.instantshopping.utils;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;

@ContextScoped
/* compiled from: unknown view attribute =  */
public class SizeUtils {
    private static SizeUtils f1134b;
    private static final Object f1135c = new Object();
    public boolean f1136a;

    private static SizeUtils m1365b() {
        return new SizeUtils();
    }

    public static SizeUtils m1364a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SizeUtils b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1135c) {
                SizeUtils sizeUtils;
                if (a2 != null) {
                    sizeUtils = (SizeUtils) a2.a(f1135c);
                } else {
                    sizeUtils = f1134b;
                }
                if (sizeUtils == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m1365b();
                        if (a2 != null) {
                            a2.a(f1135c, b3);
                        } else {
                            f1134b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = sizeUtils;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
