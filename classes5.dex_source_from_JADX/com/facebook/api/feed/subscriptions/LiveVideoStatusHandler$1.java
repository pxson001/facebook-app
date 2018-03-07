package com.facebook.api.feed.subscriptions;

import com.facebook.api.feed.subscriptions.LiveVideoStatusSubscriptionsModels.LiveVideoStatusUpdateSubscriptionModel;
import com.facebook.api.feed.subscriptions.LiveVideoStatusSubscriptionsModels.LiveVideoStatusUpdateSubscriptionModel.VideoModel;
import com.facebook.api.feedcache.db.FeedDbMutationService;
import com.facebook.api.feedcache.db.FeedDbMutationService$FeedDbLiveVideoStatusUpdateRequest;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: asInterface */
public class LiveVideoStatusHandler$1 implements FutureCallback<LiveVideoStatusUpdateSubscriptionModel> {
    final /* synthetic */ FeedDbMutationService f8777a;
    final /* synthetic */ String f8778b;
    final /* synthetic */ LiveVideoStatusHandler f8779c;

    public LiveVideoStatusHandler$1(LiveVideoStatusHandler liveVideoStatusHandler, FeedDbMutationService feedDbMutationService, String str) {
        this.f8779c = liveVideoStatusHandler;
        this.f8777a = feedDbMutationService;
        this.f8778b = str;
    }

    public void onSuccess(@Nullable Object obj) {
        LiveVideoStatusUpdateSubscriptionModel liveVideoStatusUpdateSubscriptionModel = (LiveVideoStatusUpdateSubscriptionModel) obj;
        if (liveVideoStatusUpdateSubscriptionModel != null && liveVideoStatusUpdateSubscriptionModel.m14689a() != null) {
            Object obj2;
            VideoModel a = liveVideoStatusUpdateSubscriptionModel.m14689a();
            LiveVideoStatusHandler liveVideoStatusHandler = this.f8779c;
            GraphQLVideoBroadcastStatus j = a.m14686j();
            if (j == GraphQLVideoBroadcastStatus.LIVE_STOPPED || j == GraphQLVideoBroadcastStatus.SEAL_STARTED || j == GraphQLVideoBroadcastStatus.VOD_READY) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                this.f8777a.a(new FeedDbMutationService$FeedDbLiveVideoStatusUpdateRequest(this.f8778b, a.m14687k()));
            }
        }
    }

    public void onFailure(Throwable th) {
        BLog.b("LiveVideoStatusHandler", "LiveVideoStatusUpdateSubscription query failed", th);
    }
}
