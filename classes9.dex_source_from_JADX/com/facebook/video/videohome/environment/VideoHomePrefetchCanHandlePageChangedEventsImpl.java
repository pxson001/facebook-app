package com.facebook.video.videohome.environment;

import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionPaginatedComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.prefetch.VideoPrefetchHelper;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import com.facebook.video.videohome.prefetching.VideoHomeVideoPrefetchController;
import com.facebook.video.videohome.prefetching.VideoHomeVideoPrefetchController.VideoHomeVideoDelayedPrefetchHandler;
import com.facebook.video.videohome.sessionmanager.session.VideoHomeSession;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/* compiled from: start_ */
public class VideoHomePrefetchCanHandlePageChangedEventsImpl extends CanHandleHScrollPageChangedEventsImpl {
    public final VideoPrefetchHelper f2877a;
    public final VideoHomeVideoPrefetchController f2878b;
    private final VideoHomeConfig f2879c;
    private final VideoHomeSession f2880d;

    public static VideoHomePrefetchCanHandlePageChangedEventsImpl m2785b(InjectorLike injectorLike) {
        return new VideoHomePrefetchCanHandlePageChangedEventsImpl(VideoPrefetchHelper.m2638b(injectorLike), VideoHomeVideoPrefetchController.m3148a(injectorLike), VideoHomeConfig.a(injectorLike), VideoHomeSession.a(injectorLike));
    }

    private static List<ReactionUnitComponentFields> m2786b(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionPaginatedComponentFragment reactionPaginatedComponentFragment = (ReactionPaginatedComponentFragment) reactionUnitComponentNode.b;
        if (reactionPaginatedComponentFragment.dk() == null || reactionPaginatedComponentFragment.dk().c() == null) {
            return Collections.emptyList();
        }
        ImmutableList a = reactionPaginatedComponentFragment.dk().c().a();
        List<ReactionUnitComponentFields> arrayList = new ArrayList(a.size());
        int size = a.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((EdgesModel) a.get(i)).a());
        }
        return arrayList;
    }

    @Inject
    public VideoHomePrefetchCanHandlePageChangedEventsImpl(VideoPrefetchHelper videoPrefetchHelper, VideoHomeVideoPrefetchController videoHomeVideoPrefetchController, VideoHomeConfig videoHomeConfig, VideoHomeSession videoHomeSession) {
        this.f2877a = videoPrefetchHelper;
        this.f2878b = videoHomeVideoPrefetchController;
        this.f2879c = videoHomeConfig;
        this.f2880d = videoHomeSession;
    }

    public final void m2787a(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        if (this.f2879c.k && this.f2880d.i()) {
            m2784a(m2786b(reactionUnitComponentNode), i, 3, true);
        }
    }

    public final void m2788b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        m2784a(m2786b(reactionUnitComponentNode), i, 3, false);
    }

    private void m2784a(List<ReactionUnitComponentFields> list, int i, int i2, boolean z) {
        Preconditions.checkState(i >= 0);
        int i3 = i + 1;
        while (i3 <= i + i2 && i3 < list.size()) {
            GraphQLStory ax = ((ReactionUnitComponentFields) list.get(i3)).ax();
            if (ax != null) {
                GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax);
                if (!(o == null || o.r() == null || o.r().br() != GraphQLVideoBroadcastStatus.LIVE)) {
                    if (z) {
                        VideoHomeVideoPrefetchController videoHomeVideoPrefetchController = this.f2878b;
                        long a = videoHomeVideoPrefetchController.f3321d.l - (videoHomeVideoPrefetchController.f3322e.a() - videoHomeVideoPrefetchController.f3326i);
                        if (a <= 0) {
                            o.C();
                            videoHomeVideoPrefetchController.f3320c.m2640b(o, PrefetchOrigin.VIDEO_HOME);
                        } else {
                            o.C();
                            videoHomeVideoPrefetchController.f3325h.add(o);
                            if (videoHomeVideoPrefetchController.f3324g == null) {
                                videoHomeVideoPrefetchController.f3324g = new VideoHomeVideoDelayedPrefetchHandler(videoHomeVideoPrefetchController);
                            }
                            if (!videoHomeVideoPrefetchController.f3324g.hasMessages(2)) {
                                Long.valueOf(a);
                                videoHomeVideoPrefetchController.f3324g.sendEmptyMessageDelayed(2, a);
                            }
                        }
                    } else {
                        this.f2877a.m2640b(o, PrefetchOrigin.VIDEO_HOME);
                    }
                }
            }
            i3++;
        }
    }
}
