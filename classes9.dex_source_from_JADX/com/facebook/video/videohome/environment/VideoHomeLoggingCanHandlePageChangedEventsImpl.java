package com.facebook.video.videohome.environment;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: start_battery_level */
public class VideoHomeLoggingCanHandlePageChangedEventsImpl extends CanHandleHScrollPageChangedEventsImpl {
    private final VideoHomeHScrollLoggingController f2876a;

    public static VideoHomeLoggingCanHandlePageChangedEventsImpl m2780b(InjectorLike injectorLike) {
        return new VideoHomeLoggingCanHandlePageChangedEventsImpl(VideoHomeHScrollLoggingController.m2773a(injectorLike));
    }

    @Inject
    public VideoHomeLoggingCanHandlePageChangedEventsImpl(VideoHomeHScrollLoggingController videoHomeHScrollLoggingController) {
        this.f2876a = videoHomeHScrollLoggingController;
    }

    public final void m2781a(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        Preconditions.checkNotNull(reactionUnitComponentNode);
        GraphQLStory ax = reactionUnitComponentFields.ax();
        String V = reactionUnitComponentFields.V();
        if (ax != null) {
            this.f2876a.m2778a(reactionUnitComponentNode, ax, V);
        }
    }

    public final void m2783b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        Preconditions.checkNotNull(reactionUnitComponentNode);
        GraphQLStory ax = reactionUnitComponentFields.ax();
        String V = reactionUnitComponentFields.V();
        if (ax != null) {
            this.f2876a.m2778a(reactionUnitComponentNode, ax, V);
        }
    }

    public final void m2782a(ReactionUnitComponentNode reactionUnitComponentNode) {
        Preconditions.checkNotNull(reactionUnitComponentNode);
        this.f2876a.m2777a(reactionUnitComponentNode);
    }
}
