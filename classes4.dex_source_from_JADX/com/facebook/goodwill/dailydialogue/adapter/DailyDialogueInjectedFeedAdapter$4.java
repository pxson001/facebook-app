package com.facebook.goodwill.dailydialogue.adapter;

import com.facebook.goodwill.dailydialogue.data.DailyDialoguePinnedUnitsProtocol;
import com.facebook.goodwill.dailydialogue.protocol.FetchDailyDialoguePinnedUnitsGraphQL.DailyDialoguePinnedStoryQueryString;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.TimeZone;
import java.util.concurrent.Callable;

/* compiled from: qe_write_json_failed */
class DailyDialogueInjectedFeedAdapter$4 implements Callable<ListenableFuture> {
    final /* synthetic */ DailyDialogueInjectedFeedAdapter f3939a;

    DailyDialogueInjectedFeedAdapter$4(DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter) {
        this.f3939a = dailyDialogueInjectedFeedAdapter;
    }

    public Object call() {
        DailyDialoguePinnedUnitsProtocol dailyDialoguePinnedUnitsProtocol = this.f3939a.g;
        GraphQlQueryString dailyDialoguePinnedStoryQueryString = new DailyDialoguePinnedStoryQueryString();
        dailyDialoguePinnedStoryQueryString.a("scale", GraphQlQueryDefaults.a());
        dailyDialoguePinnedStoryQueryString.a("width", Integer.valueOf(dailyDialoguePinnedUnitsProtocol.d.c()));
        dailyDialoguePinnedStoryQueryString.a("gmt_offset_minutes", Long.valueOf(((long) TimeZone.getDefault().getRawOffset()) / 60000));
        return Futures.a(dailyDialoguePinnedUnitsProtocol.c.a(GraphQLRequest.a(dailyDialoguePinnedStoryQueryString).a(GraphQLCachePolicy.c)), dailyDialoguePinnedUnitsProtocol.a, dailyDialoguePinnedUnitsProtocol.b);
    }
}
