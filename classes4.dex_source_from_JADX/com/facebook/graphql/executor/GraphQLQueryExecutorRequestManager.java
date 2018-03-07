package com.facebook.graphql.executor;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.pending.GraphQLPendingRequestManager;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tagline */
public class GraphQLQueryExecutorRequestManager implements GraphQLPendingRequestManager {
    private static GraphQLQueryExecutorRequestManager f1315b;
    private static final Object f1316c = new Object();
    private final GraphQLQueryExecutor f1317a;

    private static GraphQLQueryExecutorRequestManager m1551b(InjectorLike injectorLike) {
        return new GraphQLQueryExecutorRequestManager(GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    GraphQLQueryExecutorRequestManager(GraphQLQueryExecutor graphQLQueryExecutor) {
        this.f1317a = graphQLQueryExecutor;
    }

    public final void mo86a() {
        this.f1317a.a();
    }

    public static GraphQLQueryExecutorRequestManager m1550a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphQLQueryExecutorRequestManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1316c) {
                GraphQLQueryExecutorRequestManager graphQLQueryExecutorRequestManager;
                if (a2 != null) {
                    graphQLQueryExecutorRequestManager = (GraphQLQueryExecutorRequestManager) a2.a(f1316c);
                } else {
                    graphQLQueryExecutorRequestManager = f1315b;
                }
                if (graphQLQueryExecutorRequestManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1551b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1316c, b3);
                        } else {
                            f1315b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = graphQLQueryExecutorRequestManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void mo87b() {
        GraphQLQueryExecutor.t = new ReentrantReadWriteLock();
    }
}
