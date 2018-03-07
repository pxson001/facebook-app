package com.facebook.controller.connectioncontroller.diskstore;

import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.graphql.executor.cache.RecursiveModelTransformer;
import com.facebook.graphql.executor.iface.CacheVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;

/* compiled from: options[] */
class DiskConnectionStore$3 implements Runnable {
    final /* synthetic */ GraphQLPersistableNode f8626a;
    final /* synthetic */ DiskConnectionStore f8627b;

    DiskConnectionStore$3(DiskConnectionStore diskConnectionStore, GraphQLPersistableNode graphQLPersistableNode) {
        this.f8627b = diskConnectionStore;
        this.f8626a = graphQLPersistableNode;
    }

    public void run() {
        GraphCursorDatabase graphCursorDatabase = this.f8627b.k;
        DiskConnectionStore diskConnectionStore = this.f8627b;
        GraphQLPersistableNode graphQLPersistableNode = this.f8626a;
        String a = graphQLPersistableNode.a();
        Preconditions.checkNotNull(a);
        CacheVisitor diskConnectionStore$6 = new DiskConnectionStore$6(diskConnectionStore, new RecursiveModelTransformer(GraphQLPersistableNode.class, new DiskConnectionStore$5(diskConnectionStore, graphQLPersistableNode)), ImmutableSet.of(a));
        if (diskConnectionStore$6 != null) {
            Collection a2 = diskConnectionStore$6.a();
            if (a2 != null && !a2.isEmpty()) {
                graphCursorDatabase.a(a2, diskConnectionStore$6, RegularImmutableList.a);
            }
        }
    }
}
