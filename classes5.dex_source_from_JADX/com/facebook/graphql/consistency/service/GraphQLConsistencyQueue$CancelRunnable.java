package com.facebook.graphql.consistency.service;

import com.facebook.graphql.cursor.database.GraphCursorDatabase;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: place_type */
class GraphQLConsistencyQueue$CancelRunnable implements Runnable {
    final /* synthetic */ GraphQLConsistencyQueue f3176a;
    private final int f3177b;
    private final Collection<String> f3178c;

    public GraphQLConsistencyQueue$CancelRunnable(GraphQLConsistencyQueue graphQLConsistencyQueue, int i, Collection<String> collection) {
        this.f3176a = graphQLConsistencyQueue;
        this.f3177b = i;
        this.f3178c = collection;
    }

    public void run() {
        this.f3176a.c.b();
        Collection arrayList = new ArrayList(this.f3176a.b.size());
        synchronized (this.f3176a.b) {
            for (int i = 0; i < this.f3176a.b.size(); i++) {
                arrayList.add(this.f3176a.b.valueAt(i));
            }
        }
        for (GraphCursorDatabase a : this.f3176a.g) {
            a.a(this.f3178c, arrayList);
        }
        this.f3176a.f.b(9764865, this.f3177b, (short) 4);
        this.f3176a.f.b(9764866, this.f3177b, (short) 4);
    }
}
