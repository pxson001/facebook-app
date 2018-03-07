package com.facebook.video.videohome.liveupdates;

import com.facebook.debug.log.BLog;
import com.facebook.facecastdisplay.protocol.FetchVideoBroadcastQueryModels.VideoBroadcastFragmentModel;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.video.videohome.protocol.VideoHomeSubscriptionsModels.LiveVideoBroadcastStatusUpdateSubscriptionModel;
import com.google.common.util.concurrent.FutureCallback;

/* compiled from: spend_info */
public class BroadcastStatusUpdateManager$2 implements FutureCallback<LiveVideoBroadcastStatusUpdateSubscriptionModel> {
    final /* synthetic */ String f2946a;
    final /* synthetic */ BroadcastStatusUpdateManager f2947b;

    public BroadcastStatusUpdateManager$2(BroadcastStatusUpdateManager broadcastStatusUpdateManager, String str) {
        this.f2947b = broadcastStatusUpdateManager;
        this.f2946a = str;
    }

    public void onSuccess(Object obj) {
        LiveVideoBroadcastStatusUpdateSubscriptionModel liveVideoBroadcastStatusUpdateSubscriptionModel = (LiveVideoBroadcastStatusUpdateSubscriptionModel) obj;
        if (liveVideoBroadcastStatusUpdateSubscriptionModel == null || liveVideoBroadcastStatusUpdateSubscriptionModel.a() == null) {
            BroadcastStatusUpdateManager.b(this.f2947b, this.f2946a);
            return;
        }
        VideoBroadcastFragmentModel a = liveVideoBroadcastStatusUpdateSubscriptionModel.a();
        GraphQLVideoBroadcastStatus d = a.d();
        BroadcastStatusUpdateManager broadcastStatusUpdateManager = this.f2947b;
        String str = this.f2946a;
        if (d != GraphQLVideoBroadcastStatus.VOD_READY) {
            a = null;
        }
        BroadcastStatusUpdateManager.a(broadcastStatusUpdateManager, str, d, a);
    }

    public void onFailure(Throwable th) {
        BLog.b("BroadcastStatusUpdateManager", "LiveVideoBroadcastStatusUpdateSubscription query failed", th);
    }
}
