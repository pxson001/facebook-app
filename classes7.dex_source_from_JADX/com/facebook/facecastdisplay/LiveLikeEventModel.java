package com.facebook.facecastdisplay;

import com.facebook.common.util.CollectionUtil;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoCommentCoreFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoCommentCoreFragmentModel.NotableLikersModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveEventAuthorModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.LiveNotableLikedCommentsQueryModel.FeedbackModel.NotableLikedCommentsModel.EdgesModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithAggregatedRangesFieldsModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: author_rating_integer */
public class LiveLikeEventModel extends LiveEventWithAuthorModel {
    public final LiveEventAuthor f18894a;
    public final LiveCommentEventModel f18895b;

    private LiveLikeEventModel(LiveEventAuthor liveEventAuthor, LiveCommentEventModel liveCommentEventModel) {
        super(liveEventAuthor);
        this.f18894a = liveEventAuthor;
        this.f18895b = liveCommentEventModel;
    }

    public final LiveEventType mo118a() {
        return LiveEventType.LIVE_LIKE_EVENT;
    }

    @Nullable
    public static LiveLikeEventModel m22500a(EdgesModel edgesModel, String str) {
        if (edgesModel == null || str == null) {
            return null;
        }
        FeedbackLiveVideoCommentCoreFragmentModel a = edgesModel.m3831a();
        if (a == null) {
            return null;
        }
        LiveEventAuthorModel k = a.m3530k();
        if (k == null) {
            return null;
        }
        NotableLikersModel n = a.m3533n();
        if (n == null) {
            return null;
        }
        ImmutableList a2 = n.m3522a();
        if (CollectionUtil.a(a2)) {
            return null;
        }
        LiveEventAuthorModel a3 = ((NotableLikersModel.EdgesModel) a2.get(0)).m3517a();
        if (a3 == null) {
            return null;
        }
        if (str.equals(a3.m3822j())) {
            return null;
        }
        DefaultTextWithEntitiesWithAggregatedRangesFieldsModel l = a.m3531l();
        if (l == null) {
            return null;
        }
        return new LiveLikeEventModel(LiveEventAuthor.m3183a(a3), LiveCommentEventModel.m3146a(LiveEventAuthor.m3183a(k), l.a(), 0));
    }
}
