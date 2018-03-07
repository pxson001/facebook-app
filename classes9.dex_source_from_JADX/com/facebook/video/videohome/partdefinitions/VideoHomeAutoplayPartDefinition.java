package com.facebook.video.videohome.partdefinitions;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.DefaultVideoAutoplayControllerProvider;
import com.facebook.feed.autoplay.HasVideoAutoplay;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoFeedStoryInfo;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.videohome.environment.HasVideoHomePersistentState;
import com.facebook.video.videohome.environment.VideoHomeStoryPersistentState;
import com.facebook.video.videohome.views.VideoHomeVideoPlayerView;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: smstakeover_db */
public class VideoHomeAutoplayPartDefinition<E extends HasVideoHomePersistentState & HasVideoAutoplay<VideoHomeVideoPlayerView>> extends BaseSinglePartDefinition<Props, VideoHomeStoryPersistentState, E, VideoHomeVideoPlayerView> {
    private static VideoHomeAutoplayPartDefinition f3020b;
    private static final Object f3021c = new Object();
    private final DefaultVideoAutoplayControllerProvider f3022a;

    @Immutable
    /* compiled from: smstakeover_db */
    public final class Props {
        public final FeedProps<GraphQLStory> f3014a;
        public final VideoDisplayedInfo f3015b;
        public final VideoPlayerParams f3016c;
        public final VideoFeedStoryInfo f3017d;
        public final PlayerOrigin f3018e;
        public final String f3019f;

        public Props(FeedProps<GraphQLStory> feedProps, VideoDisplayedInfo videoDisplayedInfo, VideoPlayerParams videoPlayerParams, VideoFeedStoryInfo videoFeedStoryInfo, PlayerOrigin playerOrigin, String str) {
            this.f3014a = feedProps;
            this.f3015b = videoDisplayedInfo;
            this.f3016c = videoPlayerParams;
            this.f3017d = videoFeedStoryInfo;
            this.f3018e = playerOrigin;
            this.f3019f = str;
        }
    }

    private static VideoHomeAutoplayPartDefinition m2898b(InjectorLike injectorLike) {
        return new VideoHomeAutoplayPartDefinition((DefaultVideoAutoplayControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultVideoAutoplayControllerProvider.class));
    }

    public final Object m2899a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        VideoHomeStoryPersistentState a = ((HasVideoHomePersistentState) anyEnvironment).a(props.f3014a, props.f3019f);
        if (a.f2890d == null) {
            a.f2890d = this.f3022a.a(props.f3016c.b, a, props.f3015b, props.f3016c, props.f3017d, props.f3018e);
        }
        return a;
    }

    public final /* bridge */ /* synthetic */ void m2900a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -648417252);
        m2897a((VideoHomeStoryPersistentState) obj2, (HasVideoHomePersistentState) anyEnvironment, (VideoHomeVideoPlayerView) view);
        Logger.a(8, EntryType.MARK_POP, -2124334288, a);
    }

    public final void m2901b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((VideoHomeStoryPersistentState) obj2).f2892f = null;
    }

    public static VideoHomeAutoplayPartDefinition m2896a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeAutoplayPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3021c) {
                VideoHomeAutoplayPartDefinition videoHomeAutoplayPartDefinition;
                if (a2 != null) {
                    videoHomeAutoplayPartDefinition = (VideoHomeAutoplayPartDefinition) a2.a(f3021c);
                } else {
                    videoHomeAutoplayPartDefinition = f3020b;
                }
                if (videoHomeAutoplayPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2898b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3021c, b3);
                        } else {
                            f3020b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeAutoplayPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomeAutoplayPartDefinition(DefaultVideoAutoplayControllerProvider defaultVideoAutoplayControllerProvider) {
        this.f3022a = defaultVideoAutoplayControllerProvider;
    }

    private static void m2897a(VideoHomeStoryPersistentState videoHomeStoryPersistentState, E e, VideoHomeVideoPlayerView videoHomeVideoPlayerView) {
        videoHomeStoryPersistentState.f2892f = videoHomeVideoPlayerView;
        ((HasVideoAutoplay) e).b(videoHomeVideoPlayerView, videoHomeStoryPersistentState.f2890d);
    }
}
