package com.facebook.graphql.executor.cache;

import com.facebook.debug.log.BLog;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLReadOnlyVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import javax.annotation.Nullable;

/* compiled from: fetchComposerPrivacyOptions */
public class GraphQLConsistencyCacheVisitor extends GraphQLReadOnlyVisitor {
    private static final Class<?> f11793b = GraphQLConsistencyCacheVisitor.class;
    boolean f11794a = false;
    private final ConsistencyTuple f11795c = new ConsistencyTuple();
    private GraphQLConsistencyMemoryCache f11796d;
    private ConsistencyConfigImpl f11797e;

    public GraphQLConsistencyCacheVisitor(GraphQLConsistencyMemoryCache graphQLConsistencyMemoryCache, ConsistencyConfigImpl consistencyConfigImpl) {
        this.f11796d = graphQLConsistencyMemoryCache;
        this.f11797e = consistencyConfigImpl;
    }

    private boolean m12394a(@Nullable String str, GraphQLVisitableModel graphQLVisitableModel, String str2) {
        if (!(graphQLVisitableModel instanceof GraphQLVisitableConsistentModel)) {
            return false;
        }
        ((GraphQLVisitableConsistentModel) graphQLVisitableModel).a(str2, this.f11795c);
        Object obj = this.f11795c.a;
        if (obj != GraphQLVisitableConsistentModel.a) {
            return this.f11796d.mo872a(str, str2, obj);
        }
        return false;
    }

    public final boolean m12395a(GraphQLVisitableModel graphQLVisitableModel) {
        if (graphQLVisitableModel instanceof GraphQLPersistableNode) {
            String a = ((GraphQLPersistableNode) graphQLVisitableModel).a();
            try {
                String[] a2 = this.f11797e.a(graphQLVisitableModel.jK_());
                if (!(a2 == null || a2.length == 0)) {
                    for (String a3 : a2) {
                        if (m12394a(a, graphQLVisitableModel, a3)) {
                            this.f11794a = true;
                        }
                    }
                }
            } catch (Throwable e) {
                BLog.b(f11793b, "Failed to read field from model", e);
            } catch (Throwable e2) {
                BLog.b(f11793b, "Failed to serialize list field to json", e2);
            }
        }
        return true;
    }
}
