package com.facebook.video.commercialbreak;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitor;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.video.commercialbreak.CommercialBreakMessageSubscriber.CommercialBreakMessage;
import com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin;
import com.facebook.video.commercialbreak.plugins.CommercialBreakPlugin.CommercialBreakInfoChangedListener;
import com.facebook.video.commercialbreak.protocol.FetchInstreamVideoAdsModels.InstreamVideoAdsQueryModel;
import com.facebook.video.commercialbreak.protocol.FetchInstreamVideoAdsModels.InstreamVideoAdsQueryModel.InstreamVideoAdsModel;
import com.facebook.video.player.events.RVPCommercialBreakStateChangeEvent.State;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: loggingClass */
class CommercialBreakInfoTracker$1 implements FutureCallback<GraphQLResult> {
    final /* synthetic */ GraphQLQueryFuture f9710a;
    final /* synthetic */ CommercialBreakInfoTracker$CommercialBreakInfo f9711b;
    final /* synthetic */ CommercialBreakMessage f9712c;
    final /* synthetic */ CommercialBreakInfoChangedListener f9713d;
    final /* synthetic */ CommercialBreakInfoTracker f9714e;

    CommercialBreakInfoTracker$1(CommercialBreakInfoTracker commercialBreakInfoTracker, GraphQLQueryFuture graphQLQueryFuture, CommercialBreakInfoTracker$CommercialBreakInfo commercialBreakInfoTracker$CommercialBreakInfo, CommercialBreakMessage commercialBreakMessage, CommercialBreakInfoChangedListener commercialBreakInfoChangedListener) {
        this.f9714e = commercialBreakInfoTracker;
        this.f9710a = graphQLQueryFuture;
        this.f9711b = commercialBreakInfoTracker$CommercialBreakInfo;
        this.f9712c = commercialBreakMessage;
        this.f9713d = commercialBreakInfoChangedListener;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || !(graphQLResult.e instanceof InstreamVideoAdsQueryModel) || this.f9710a.isCancelled()) {
            this.f9711b.f9721f = CommercialBreakVideoAdFetcher$State.FAILED;
            CommercialBreakInfoTracker.p(this.f9714e, "Video ad fetcher returned no result");
            return;
        }
        InstreamVideoAdsModel a = ((InstreamVideoAdsQueryModel) graphQLResult.e).m11474a();
        if (a == null) {
            this.f9711b.f9721f = CommercialBreakVideoAdFetcher$State.FAILED;
            CommercialBreakInfoTracker.p(this.f9714e, "Video ad fetcher returns no data model");
            return;
        }
        ImmutableList a2 = a.m11470a();
        if (a2.isEmpty()) {
            this.f9711b.f9721f = CommercialBreakVideoAdFetcher$State.FAILED;
            CommercialBreakInfoTracker.p(this.f9714e, "Video ad fetcher returns no ad");
            return;
        }
        this.f9711b.f9716a = FeedProps.c((Flattenable) a2.get(0));
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) this.f9711b.f9716a.a);
        VideoPrefetchVisitor a3 = this.f9714e.m.a(VideoPrefetchLocation.COMMERCIAL_BREAK, CommercialBreakInfoTracker.b);
        a3.a(o);
        a3.a();
        this.f9711b.f9721f = CommercialBreakVideoAdFetcher$State.SUCCESS;
        this.f9714e.l.b(this.f9712c.f9736a, true);
        CommercialBreakInfoTracker.p(this.f9714e, "Succeeded to fetch video ad");
        if (this.f9713d != null) {
            Object obj2;
            CommercialBreakInfoChangedListener commercialBreakInfoChangedListener = this.f9713d;
            String str = CommercialBreakPlugin.q;
            if (commercialBreakInfoChangedListener.a.b.e(commercialBreakInfoChangedListener.a.x) == State.WAIT_FOR_ADS) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                CommercialBreakPlugin.r(commercialBreakInfoChangedListener.a);
                commercialBreakInfoChangedListener.a.t.removeCallbacksAndMessages(null);
                commercialBreakInfoChangedListener.a.t.sendEmptyMessage(3);
            }
        }
    }

    public void onFailure(Throwable th) {
        this.f9711b.f9721f = CommercialBreakVideoAdFetcher$State.FAILED;
        this.f9714e.l.b(this.f9712c.f9736a, false);
        CommercialBreakInfoTracker.p(this.f9714e, "Failed to fetch video ad");
    }
}
