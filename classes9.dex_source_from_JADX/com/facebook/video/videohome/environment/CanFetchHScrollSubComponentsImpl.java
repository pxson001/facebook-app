package com.facebook.video.videohome.environment;

import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel;
import com.facebook.video.videohome.data.VideoHomeDataController;
import com.facebook.video.videohome.data.VideoHomeDataController.FetchHScrollRequestCallback;
import com.facebook.video.videohome.partdefinitions.VideoHomePaginatedHscrollLiveVideoComponentListPartDefinition.C02922;

/* compiled from: statusFromTimeline */
public class CanFetchHScrollSubComponentsImpl implements CanFetchHScrollSubComponents {
    private final VideoHomeDataController f2830a;
    private final ReactionSession f2831b;

    public CanFetchHScrollSubComponentsImpl(VideoHomeDataController videoHomeDataController, ReactionSession reactionSession) {
        this.f2830a = videoHomeDataController;
        this.f2831b = reactionSession;
    }

    public final void m2733a(ReactionUnitComponentNode reactionUnitComponentNode, C02922 c02922) {
        VideoHomeDataController videoHomeDataController = this.f2830a;
        ReactionSession reactionSession = this.f2831b;
        PaginatedComponentsModel c = ReactionUnitComponentUtil.c(reactionUnitComponentNode);
        DefaultPageInfoFields b = c.c().b();
        videoHomeDataController.f2813e.a(b.a(), new FetchHScrollRequestCallback(videoHomeDataController, reactionUnitComponentNode, c02922), 5, c.b(), reactionSession);
    }
}
