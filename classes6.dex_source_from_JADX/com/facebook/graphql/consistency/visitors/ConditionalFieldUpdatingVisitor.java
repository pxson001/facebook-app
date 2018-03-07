package com.facebook.graphql.consistency.visitors;

import com.facebook.graphql.executor.iface.CacheVisitorAnalytics;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Set;

/* compiled from: mPromptTitle */
public abstract class ConditionalFieldUpdatingVisitor<TField> implements CacheVisitorAnalytics, GraphQLModelMutatingVisitor {
    private final ConsistencyTuple f10954a = new ConsistencyTuple();
    private final ImmutableSet<String> f10955b;
    private final int f10956c;
    private final String f10957d;
    private final ImmutableSet<TField> f10958e;
    private final TField f10959f;

    public ConditionalFieldUpdatingVisitor(Collection<String> collection, int i, String str, ImmutableSet<TField> immutableSet, TField tField) {
        this.f10956c = i;
        this.f10955b = ImmutableSet.copyOf(collection);
        this.f10958e = immutableSet;
        this.f10957d = str;
        this.f10959f = tField;
    }

    public final GraphQLVisitableModel m17604b(GraphQLVisitableModel graphQLVisitableModel) {
        m17601a(graphQLVisitableModel);
        graphQLVisitableModel.a(this);
        return graphQLVisitableModel;
    }

    private void m17601a(GraphQLVisitableModel graphQLVisitableModel) {
        if (graphQLVisitableModel.jK_() == this.f10956c && (graphQLVisitableModel instanceof GraphQLVisitableConsistentModel) && (graphQLVisitableModel instanceof GraphQLPersistableNode) && this.f10955b.contains(((GraphQLPersistableNode) graphQLVisitableModel).a())) {
            GraphQLVisitableConsistentModel graphQLVisitableConsistentModel = (GraphQLVisitableConsistentModel) graphQLVisitableModel;
            graphQLVisitableConsistentModel.a(this.f10957d, this.f10954a);
            if (this.f10954a.a == null || this.f10958e.contains(this.f10954a.a)) {
                try {
                    graphQLVisitableConsistentModel.a(this.f10957d, this.f10959f, false);
                } catch (CloneNotSupportedException e) {
                }
            }
        }
    }

    public final synchronized <TModel> TModel m17602a(TModel tModel) {
        if (tModel instanceof GraphQLVisitableModel) {
            m17604b((GraphQLVisitableModel) tModel);
        }
        return tModel;
    }

    public final Set<String> m17603a() {
        return this.f10955b;
    }
}
