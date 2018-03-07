package com.facebook.messaging.inbox2.data.graphql;

import android.net.ConnectivityManager;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.messaging.inbox2.data.common.InboxUnitFetcherHelper;
import com.facebook.messaging.inbox2.graphql.InboxV2Query.InboxV2QueryString;
import com.facebook.ultralight.Inject;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: sessionKey */
public class InboxUnitGraphQLQueryExecutorHelper {
    public final ConnectivityManager f2758a;
    private final InboxUnitFetcherHelper f2759b;

    @Inject
    public InboxUnitGraphQLQueryExecutorHelper(ConnectivityManager connectivityManager, InboxUnitFetcherHelper inboxUnitFetcherHelper) {
        this.f2758a = connectivityManager;
        this.f2759b = inboxUnitFetcherHelper;
    }

    public final InboxV2QueryString m2714b() {
        Map a = this.f2759b.m2711a();
        GraphQlQueryString inboxV2QueryString = new InboxV2QueryString();
        for (Entry entry : a.entrySet()) {
            inboxV2QueryString.b((String) entry.getKey(), entry.getValue());
        }
        return inboxV2QueryString;
    }
}
