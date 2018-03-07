package com.facebook.graphql.consistency.service;

import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import com.facebook.graphql.executor.iface.CacheVisitor;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: place_type */
class GraphQLConsistencyQueue$ConfirmedRunnable implements Runnable {
    final /* synthetic */ GraphQLConsistencyQueue f3179a;
    private final int f3180b;
    private final CacheVisitor f3181c;

    public GraphQLConsistencyQueue$ConfirmedRunnable(GraphQLConsistencyQueue graphQLConsistencyQueue, int i, CacheVisitor cacheVisitor) {
        this.f3179a = graphQLConsistencyQueue;
        this.f3180b = i;
        this.f3181c = cacheVisitor;
    }

    public void run() {
        this.f3179a.c.b();
        Collection arrayList = new ArrayList(this.f3179a.b.size());
        synchronized (this.f3179a.b) {
            this.f3179a.b.remove(this.f3180b);
            for (int i = 0; i < this.f3179a.b.size(); i++) {
                arrayList.add(this.f3179a.b.valueAt(i));
            }
        }
        Collection a = this.f3181c.a();
        if (this.f3179a.f.j(9764866, this.f3180b)) {
            this.f3179a.f.b(9764866, this.f3180b, "visitor_name", GraphQLConsistencyQueue.b(this.f3181c));
            GraphQLConsistencyQueue.a(this.f3179a, 9764865, this.f3180b, a);
        }
        for (GraphCursorDatabase a2 : this.f3179a.g) {
            a2.a(a, this.f3181c, arrayList);
        }
        this.f3179a.f.b(9764866, this.f3180b, (short) 2);
    }
}
