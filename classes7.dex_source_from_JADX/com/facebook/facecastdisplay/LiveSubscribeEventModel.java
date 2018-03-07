package com.facebook.facecastdisplay;

import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveSubscriptionQueryModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FetchLiveSubscriptionQueryModel.OwnerModel;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import javax.annotation.Nullable;

/* compiled from: audio/vnd.dts */
public class LiveSubscribeEventModel extends LiveEventWithAuthorModel {
    public String f18934a;
    public boolean f18935b;

    private LiveSubscribeEventModel(LiveEventAuthor liveEventAuthor, String str, boolean z) {
        super(liveEventAuthor);
        this.f18934a = str;
        this.f18935b = z;
    }

    public final LiveEventType mo118a() {
        return LiveEventType.LIVE_SUBSCRIBE_EVENT;
    }

    @Nullable
    public static LiveSubscribeEventModel m22529a(FetchLiveSubscriptionQueryModel fetchLiveSubscriptionQueryModel) {
        if (fetchLiveSubscriptionQueryModel == null) {
            return null;
        }
        String j = fetchLiveSubscriptionQueryModel.m3677j();
        if (j == null || !fetchLiveSubscriptionQueryModel.m3679l()) {
            return null;
        }
        OwnerModel k = fetchLiveSubscriptionQueryModel.m3678k();
        LiveEventAuthor liveEventAuthor = null;
        if (k != null) {
            String l = k.m3671l();
            String j2 = k.m3669j();
            if (!(l == null || j2 == null)) {
                liveEventAuthor = new LiveEventAuthor(l, j2, false);
            }
        }
        LiveEventAuthor liveEventAuthor2 = liveEventAuthor;
        if (liveEventAuthor2 == null) {
            return null;
        }
        GraphQLLiveVideoSubscriptionStatus k2 = k.m3670k();
        if (k2 == null) {
            return null;
        }
        return new LiveSubscribeEventModel(liveEventAuthor2, j, k2 == GraphQLLiveVideoSubscriptionStatus.ALL);
    }
}
