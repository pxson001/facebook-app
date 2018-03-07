package com.facebook.facecastdisplay;

import com.facebook.common.util.StringUtil;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoCommentCoreFragmentModel;
import com.facebook.facecastdisplay.protocol.FetchLiveVideoEventsQueryModels.FeedbackLiveVideoCommentCoreFragmentModel.FeedbackModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesWithAggregatedRangesFieldsModel;
import javax.annotation.Nullable;

/* compiled from: sub_component_width_ratio */
public class LiveCommentEventModel extends LiveEventWithAuthorModel {
    public final String f2849a;
    public final String f2850b;
    @Nullable
    public final String f2851c;
    @Nullable
    public final String f2852d;
    public boolean f2853e;
    public boolean f2854f;
    public boolean f2855g;
    public int f2856h;
    public boolean f2857i;
    public boolean f2858j;

    public LiveCommentEventModel(LiveEventAuthor liveEventAuthor, String str, String str2, String str3, boolean z, boolean z2, boolean z3, int i) {
        super(liveEventAuthor);
        this.f2849a = str;
        String a = StringUtil.a(str, 200);
        int indexOf = a.indexOf(10);
        if (indexOf >= 0) {
            indexOf = a.indexOf(10, indexOf + 1);
            if (indexOf >= 0) {
                a = a.substring(0, indexOf);
            }
        }
        this.f2850b = a;
        this.f2851c = str2;
        this.f2852d = str3;
        this.f2853e = z;
        this.f2854f = z2;
        this.f2855g = z3;
        this.f2856h = i;
        this.f2858j = str.equals(this.f2850b);
        this.f2857i = false;
    }

    public final LiveEventType mo118a() {
        return LiveEventType.LIVE_COMMENT_EVENT;
    }

    public static LiveCommentEventModel m3146a(LiveEventAuthor liveEventAuthor, String str, int i) {
        return new LiveCommentEventModel(liveEventAuthor, str, null, null, false, false, false, i);
    }

    @Nullable
    public static LiveCommentEventModel m3147a(FeedbackLiveVideoCommentCoreFragmentModel feedbackLiveVideoCommentCoreFragmentModel) {
        DefaultTextWithEntitiesWithAggregatedRangesFieldsModel l = feedbackLiveVideoCommentCoreFragmentModel.m3531l();
        if (l == null) {
            return null;
        }
        String a = l.a();
        if (a == null) {
            return null;
        }
        LiveEventAuthor a2 = LiveEventAuthor.m3183a(feedbackLiveVideoCommentCoreFragmentModel.m3530k());
        if (a2 == null) {
            return null;
        }
        FeedbackModel m = feedbackLiveVideoCommentCoreFragmentModel.m3532m();
        if (m == null) {
            return null;
        }
        String l2 = m.m3511l();
        if (l2 == null) {
            return null;
        }
        String m2 = m.m3512m();
        if (m2 != null) {
            return new LiveCommentEventModel(a2, a, l2, m2, m.m3510k(), m.m3509j(), false, 0);
        }
        return null;
    }
}
