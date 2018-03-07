package com.facebook.instantshopping.utils;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.fasterxml.jackson.databind.JsonNode;

@ContextScoped
/* compiled from: unsave_link */
public class InstantShoppingDocumentContext {
    private static InstantShoppingDocumentContext f1108d;
    private static final Object f1109e = new Object();
    public String f1110a;
    public String f1111b;
    public JsonNode f1112c;

    private static InstantShoppingDocumentContext m1345d() {
        return new InstantShoppingDocumentContext();
    }

    public static InstantShoppingDocumentContext m1344a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            InstantShoppingDocumentContext d;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1109e) {
                InstantShoppingDocumentContext instantShoppingDocumentContext;
                if (a2 != null) {
                    instantShoppingDocumentContext = (InstantShoppingDocumentContext) a2.a(f1109e);
                } else {
                    instantShoppingDocumentContext = f1108d;
                }
                if (instantShoppingDocumentContext == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        d = m1345d();
                        if (a2 != null) {
                            a2.a(f1109e, d);
                        } else {
                            f1108d = d;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    d = instantShoppingDocumentContext;
                }
            }
            return d;
        } finally {
            a.c(b);
        }
    }
}
