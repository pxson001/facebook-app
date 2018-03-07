package com.facebook.pages.common.contactinbox.util;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLPageLeadGenInfoState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.Map;
import javax.annotation.Nullable;

@ContextScoped
/* compiled from: sprouts_metadata_flow_state */
public class PagesContactInboxCache {
    private static PagesContactInboxCache f1456c;
    private static final Object f1457d = new Object();
    public Bundle f1458a;
    private final Map<String, GraphQLPageLeadGenInfoState> f1459b = new ArrayMap();

    private static PagesContactInboxCache m2130c() {
        return new PagesContactInboxCache();
    }

    public final synchronized void m2132a(String str, GraphQLPageLeadGenInfoState graphQLPageLeadGenInfoState) {
        this.f1459b.put(str, graphQLPageLeadGenInfoState);
    }

    public final void m2133b() {
        this.f1458a = null;
        this.f1459b.clear();
    }

    @Nullable
    public final synchronized GraphQLPageLeadGenInfoState m2131a(String str) {
        return (GraphQLPageLeadGenInfoState) this.f1459b.get(str);
    }

    public static PagesContactInboxCache m2129a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesContactInboxCache c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1457d) {
                PagesContactInboxCache pagesContactInboxCache;
                if (a2 != null) {
                    pagesContactInboxCache = (PagesContactInboxCache) a2.a(f1457d);
                } else {
                    pagesContactInboxCache = f1456c;
                }
                if (pagesContactInboxCache == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m2130c();
                        if (a2 != null) {
                            a2.a(f1457d, c);
                        } else {
                            f1456c = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = pagesContactInboxCache;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
