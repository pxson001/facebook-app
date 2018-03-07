package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.graphql.executor.iface.TypedModelVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import javax.annotation.Nullable;

/* compiled from: options[] */
public class DiskConnectionStore$5 implements TypedModelVisitor<GraphQLPersistableNode> {
    final /* synthetic */ GraphQLPersistableNode f8631a;
    final /* synthetic */ DiskConnectionStore f8632b;

    public DiskConnectionStore$5(DiskConnectionStore diskConnectionStore, GraphQLPersistableNode graphQLPersistableNode) {
        this.f8632b = diskConnectionStore;
        this.f8631a = graphQLPersistableNode;
    }

    @Nullable
    public final Object m12433a(@Nullable Object obj) {
        GraphQLPersistableNode graphQLPersistableNode = (GraphQLPersistableNode) obj;
        if (graphQLPersistableNode != null && this.f8631a.a().equals(graphQLPersistableNode.a()) && graphQLPersistableNode.getClass() == this.f8631a.getClass()) {
            return this.f8631a;
        }
        return graphQLPersistableNode;
    }
}
