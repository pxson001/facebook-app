package com.facebook.goodwill.dailydialogue.adapter;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.goodwill.dailydialogue.data.DailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: qe_write_json_failed */
class DailyDialogueInjectedFeedAdapter$StoryCallback extends AbstractDisposableFutureCallback<DailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult> {
    final /* synthetic */ DailyDialogueInjectedFeedAdapter f3940a;

    public DailyDialogueInjectedFeedAdapter$StoryCallback(DailyDialogueInjectedFeedAdapter dailyDialogueInjectedFeedAdapter) {
        this.f3940a = dailyDialogueInjectedFeedAdapter;
    }

    protected final void m4396a(Object obj) {
        GraphQLFeedUnitEdge graphQLFeedUnitEdge;
        DailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult dailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult = (DailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult) obj;
        String str = null;
        if (dailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult != null) {
            graphQLFeedUnitEdge = dailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult.f4247b;
        } else {
            graphQLFeedUnitEdge = null;
        }
        if (dailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult != null) {
            str = dailyDialoguePinnedUnitsProtocol$DailyDialogueFetchResult.f4248c;
        }
        HandlerDetour.a(this.f3940a.h, new Runnable(this) {
            final /* synthetic */ DailyDialogueInjectedFeedAdapter$StoryCallback f3950c;

            public void run() {
                this.f3950c.f3940a.a(graphQLFeedUnitEdge, str);
            }
        }, -842628758);
    }

    protected final void m4397a(Throwable th) {
        DailyDialogueInjectedFeedAdapter.f(this.f3940a);
    }
}
