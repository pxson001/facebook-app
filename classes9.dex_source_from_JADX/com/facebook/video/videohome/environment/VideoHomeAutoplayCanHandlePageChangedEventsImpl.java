package com.facebook.video.videohome.environment;

import com.facebook.feed.autoplay.HasVideoAutoDimming;
import com.facebook.feed.autoplay.HasVideoAutoplay;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanHandleHScrollPageChangedEventsImpl;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.video.videohome.views.VideoHomeVideoPlayerView;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: state_save_pin */
public class VideoHomeAutoplayCanHandlePageChangedEventsImpl<E extends HasVideoHomePersistentState & HasVideoAutoplay & HasVideoAutoDimming> extends CanHandleHScrollPageChangedEventsImpl {
    @Nullable
    private WeakReference<E> f2833a;

    public static VideoHomeAutoplayCanHandlePageChangedEventsImpl m2735b(InjectorLike injectorLike) {
        return new VideoHomeAutoplayCanHandlePageChangedEventsImpl();
    }

    public final void m2736a(E e) {
        Preconditions.checkNotNull(e);
        this.f2833a = new WeakReference(e);
    }

    public final void m2737b(int i, ReactionUnitComponentFields reactionUnitComponentFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        if (this.f2833a != null) {
            HasVideoHomePersistentState hasVideoHomePersistentState = (HasVideoHomePersistentState) this.f2833a.get();
            if (hasVideoHomePersistentState != null) {
                GraphQLStory ax = reactionUnitComponentFields.ax();
                if (ax != null) {
                    VideoHomeStoryPersistentState a = hasVideoHomePersistentState.a(FeedProps.c(ax), reactionUnitComponentNode.c);
                    VideoHomeVideoPlayerView videoHomeVideoPlayerView = (VideoHomeVideoPlayerView) a.f2892f;
                    if (videoHomeVideoPlayerView != null) {
                        ((HasVideoAutoplay) hasVideoHomePersistentState).b(videoHomeVideoPlayerView, a.f2890d);
                        ((HasVideoAutoDimming) hasVideoHomePersistentState).a(videoHomeVideoPlayerView, a.f2889c);
                    }
                }
            }
        }
    }
}
