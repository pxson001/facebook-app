package com.facebook.graphql.executor.cache;

import android.text.TextUtils;
import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.google.common.base.Throwables;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: sActiveLoaders */
public class CloningConsistentFieldTransform implements TypedModelVisitor<GraphQLPersistableNode> {
    private final Map<String, Map<String, Object>> f2991a;
    private final ConsistencyTuple f2992b = new ConsistencyTuple();

    @Nullable
    public final Object mo266a(@Nullable Object obj) {
        GraphQLPersistableNode graphQLPersistableNode = (GraphQLPersistableNode) obj;
        if (graphQLPersistableNode == null) {
            return null;
        }
        if (!(graphQLPersistableNode instanceof GraphQLVisitableConsistentModel)) {
            return graphQLPersistableNode;
        }
        CharSequence a = graphQLPersistableNode.a();
        if (TextUtils.isEmpty(a)) {
            return graphQLPersistableNode;
        }
        Map map = (Map) this.f2991a.get(a);
        if (map == null || map.isEmpty() || !InPlaceConsistentFieldVisitor.m3279a((GraphQLVisitableConsistentModel) graphQLPersistableNode, map, this.f2992b)) {
            return graphQLPersistableNode;
        }
        GraphQLVisitableConsistentModel a2 = m3274a((GraphQLVisitableConsistentModel) graphQLPersistableNode);
        m3275a(a2, map, this.f2992b);
        return (GraphQLPersistableNode) a2;
    }

    public CloningConsistentFieldTransform(Map<String, Map<String, Object>> map) {
        this.f2991a = map;
    }

    private static void m3275a(GraphQLVisitableConsistentModel graphQLVisitableConsistentModel, Map<String, Object> map, ConsistencyTuple consistencyTuple) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            graphQLVisitableConsistentModel.a(str, consistencyTuple);
            Object obj = consistencyTuple.a;
            Object value = entry.getValue();
            if (InPlaceConsistentFieldVisitor.m3281a(obj, value)) {
                try {
                    graphQLVisitableConsistentModel.a(str, value, true);
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
        }
    }

    private static GraphQLVisitableConsistentModel m3274a(GraphQLVisitableConsistentModel graphQLVisitableConsistentModel) {
        try {
            return (GraphQLVisitableConsistentModel) graphQLVisitableConsistentModel.clone();
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        }
    }
}
