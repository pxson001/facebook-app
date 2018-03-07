package com.facebook.graphql.executor.cache;

import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLReadOnlyVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.base.Objects;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: runAnyBackgroundTasks */
public class InPlaceConsistentFieldVisitor extends GraphQLReadOnlyVisitor {
    private final Map<String, Map<String, Object>> f2994a;
    private final ConsistencyTuple f2995b = new ConsistencyTuple();
    public boolean f2996c;

    public InPlaceConsistentFieldVisitor(Map<String, Map<String, Object>> map) {
        this.f2994a = map;
    }

    protected final boolean m3283a(GraphQLVisitableModel graphQLVisitableModel) {
        if ((graphQLVisitableModel instanceof GraphQLPersistableNode) && (graphQLVisitableModel instanceof GraphQLVisitableConsistentModel)) {
            GraphQLVisitableConsistentModel graphQLVisitableConsistentModel = (GraphQLVisitableConsistentModel) graphQLVisitableModel;
            Map map = (Map) this.f2994a.get(((GraphQLPersistableNode) graphQLVisitableModel).a());
            if (!(map == null || map.isEmpty())) {
                boolean z = this.f2996c || m3282b(graphQLVisitableConsistentModel, map, this.f2995b);
                this.f2996c = z;
            }
        }
        return true;
    }

    static boolean m3279a(GraphQLVisitableConsistentModel graphQLVisitableConsistentModel, Map<String, Object> map, ConsistencyTuple consistencyTuple) {
        for (Entry entry : map.entrySet()) {
            graphQLVisitableConsistentModel.a((String) entry.getKey(), consistencyTuple);
            if (m3281a(consistencyTuple.a, entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    static boolean m3282b(GraphQLVisitableConsistentModel graphQLVisitableConsistentModel, Map<String, Object> map, ConsistencyTuple consistencyTuple) {
        boolean z = false;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            graphQLVisitableConsistentModel.a(str, consistencyTuple);
            Object obj = consistencyTuple.a;
            Object value = entry.getValue();
            if (m3281a(obj, value)) {
                try {
                    graphQLVisitableConsistentModel.a(str, value, false);
                    z = true;
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return z;
    }

    static boolean m3281a(Object obj, Object obj2) {
        if (obj == GraphQLVisitableConsistentModel.a || m3280a(obj) || m3280a(obj2) || Objects.equal(obj, obj2)) {
            return false;
        }
        return true;
    }

    private static boolean m3280a(Object obj) {
        return (obj instanceof Enum) && "UNSET_OR_UNRECOGNIZED_ENUM_VALUE".equals(((Enum) obj).name());
    }
}
