package com.facebook.api.prefetch;

import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: post/%s */
final class InFlightRequestsMap {
    private final HashMap<GraphQLPrefetchPolicy, ArrayList<RequestEntry>> f9429a = new HashMap();

    private void m14415a(Collection<String> collection, GraphQLPrefetchPolicy graphQLPrefetchPolicy, ListenableFuture<?> listenableFuture) {
        Futures.m2457a((ListenableFuture) listenableFuture, new 1(this, graphQLPrefetchPolicy, m14416b(collection, graphQLPrefetchPolicy, listenableFuture)));
    }

    public final void m14418a(String str, GraphQLPrefetchPolicy graphQLPrefetchPolicy, ListenableFuture listenableFuture) {
        m14415a(ImmutableList.of(str), graphQLPrefetchPolicy, listenableFuture);
    }

    private synchronized RequestEntry m14416b(Collection<String> collection, GraphQLPrefetchPolicy graphQLPrefetchPolicy, ListenableFuture listenableFuture) {
        RequestEntry requestEntry;
        requestEntry = new RequestEntry(collection, listenableFuture);
        m14413a(graphQLPrefetchPolicy).add(requestEntry);
        return requestEntry;
    }

    public static synchronized void m14414a(InFlightRequestsMap inFlightRequestsMap, GraphQLPrefetchPolicy graphQLPrefetchPolicy, RequestEntry requestEntry) {
        synchronized (inFlightRequestsMap) {
            inFlightRequestsMap.m14413a(graphQLPrefetchPolicy).remove(requestEntry);
        }
    }

    @Nullable
    public final synchronized <T> ListenableFuture<GraphQLResult<T>> m14417a(String str, GraphQLPrefetchPolicy<T> graphQLPrefetchPolicy) {
        ListenableFuture<GraphQLResult<T>> listenableFuture;
        Iterator it = m14413a(graphQLPrefetchPolicy).iterator();
        loop0:
        while (it.hasNext()) {
            RequestEntry requestEntry = (RequestEntry) it.next();
            for (String equals : requestEntry.a) {
                if (str.equals(equals)) {
                    listenableFuture = requestEntry.b;
                    break loop0;
                }
            }
        }
        listenableFuture = null;
        return listenableFuture;
    }

    private ArrayList<RequestEntry> m14413a(GraphQLPrefetchPolicy graphQLPrefetchPolicy) {
        ArrayList<RequestEntry> arrayList = (ArrayList) this.f9429a.get(graphQLPrefetchPolicy);
        if (arrayList != null) {
            return arrayList;
        }
        arrayList = new ArrayList();
        this.f9429a.put(graphQLPrefetchPolicy, arrayList);
        return arrayList;
    }
}
