package com.facebook.commerce.publishing.fetcher;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cymk_view_impression */
public class AdminProductFetcher {
    private static AdminProductFetcher f15526b;
    private static final Object f15527c = new Object();
    public final GraphQLQueryExecutor f15528a;

    private static AdminProductFetcher m16029b(InjectorLike injectorLike) {
        return new AdminProductFetcher(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public AdminProductFetcher(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f15528a = graphQLQueryExecutor;
    }

    public static AdminProductFetcher m16028a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AdminProductFetcher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f15527c) {
                AdminProductFetcher adminProductFetcher;
                if (a2 != null) {
                    adminProductFetcher = (AdminProductFetcher) a2.a(f15527c);
                } else {
                    adminProductFetcher = f15526b;
                }
                if (adminProductFetcher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m16029b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f15527c, b3);
                        } else {
                            f15526b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = adminProductFetcher;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
