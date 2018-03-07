package com.facebook.graphql.consistency.service;

import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.graphql.executor.iface.CacheVisitor;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: place_type */
class GraphQLConsistencyQueue$OptimisticRunnable implements Runnable {
    final /* synthetic */ GraphQLConsistencyQueue f3182a;
    private final int f3183b;

    public GraphQLConsistencyQueue$OptimisticRunnable(GraphQLConsistencyQueue graphQLConsistencyQueue, int i) {
        this.f3182a = graphQLConsistencyQueue;
        this.f3183b = i;
    }

    public void run() {
        this.f3182a.c.b();
        CacheVisitor cacheVisitor = (CacheVisitor) this.f3182a.b.get(this.f3183b);
        if (cacheVisitor != null) {
            Collection arrayList = new ArrayList(this.f3182a.b.size());
            synchronized (this.f3182a.b) {
                for (int i = 0; i < this.f3182a.b.size(); i++) {
                    arrayList.add(this.f3182a.b.valueAt(i));
                }
            }
            Collection a = cacheVisitor.a();
            if (this.f3182a.f.j(9764865, this.f3183b)) {
                GraphQLConsistencyQueue.a(this.f3182a, 9764865, this.f3183b, a);
            }
            for (GraphCursorDatabase a2 : this.f3182a.g) {
                a2.a(a, arrayList);
            }
            this.f3182a.f.b(9764865, this.f3183b, (short) 2);
        }
    }
}
