package com.facebook.graphql.visitor;

import android.text.TextUtils;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: global_searchability_id */
public class GraphQLIdFindingVisitor extends GraphQLReadOnlyVisitor {
    public final Set<String> f22226a = new HashSet();

    public final boolean mo2927a(GraphQLVisitableModel graphQLVisitableModel) {
        if (graphQLVisitableModel instanceof GraphQLPersistableNode) {
            CharSequence a = ((GraphQLPersistableNode) graphQLVisitableModel).mo2834a();
            if (!TextUtils.isEmpty(a)) {
                this.f22226a.add(a);
            }
        }
        if (graphQLVisitableModel instanceof HasCustomTags) {
            ImmutableList d = ((HasCustomTags) graphQLVisitableModel).mo2874d();
            if (d != null) {
                int size = d.size();
                for (int i = 0; i < size; i++) {
                    String str = (String) d.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        this.f22226a.add(str);
                    }
                }
            }
        }
        return true;
    }
}
