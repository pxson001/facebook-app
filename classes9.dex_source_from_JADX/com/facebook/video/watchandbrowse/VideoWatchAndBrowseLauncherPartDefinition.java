package com.facebook.video.watchandbrowse;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feedplugins.attachments.video.FeedAnalyticsUtil;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.InlineVideoPersistentState;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.player.FullScreenVideoListener;
import com.facebook.video.player.PlayerActivityManager;
import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

/* compiled from: should_show_to_viewer */
public class VideoWatchAndBrowseLauncherPartDefinition<E extends HasFeedListType & HasPersistentState, V extends View & CanLaunchWatchAndBrowse> extends BaseSinglePartDefinition<Props, Void, E, V> {
    private final Lazy<VideoZeroDialogPartDefinition> f3388a;
    public final PlayerActivityManager f3389b;
    private final AutoplayStateManagerProvider f3390c;
    public final WatchAndMoreType f3391d;

    /* compiled from: should_show_to_viewer */
    public class LaunchWatchAndBrowseClickListener implements OnClickListener {
        final /* synthetic */ VideoWatchAndBrowseLauncherPartDefinition f3379a;
        private final FeedProps<GraphQLStory> f3380b;
        private final PlayerOrigin f3381c;
        private final InlineVideoPersistentState f3382d;
        private final AtomicReference<FullscreenTransitionListener> f3383e;
        private final E f3384f;

        public LaunchWatchAndBrowseClickListener(VideoWatchAndBrowseLauncherPartDefinition videoWatchAndBrowseLauncherPartDefinition, FeedProps<GraphQLStory> feedProps, PlayerOrigin playerOrigin, InlineVideoPersistentState inlineVideoPersistentState, AtomicReference<FullscreenTransitionListener> atomicReference, E e) {
            this.f3379a = videoWatchAndBrowseLauncherPartDefinition;
            this.f3380b = feedProps;
            this.f3381c = playerOrigin;
            this.f3382d = inlineVideoPersistentState;
            this.f3383e = atomicReference;
            this.f3384f = e;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 540466221);
            if (view instanceof CanLaunchWatchAndBrowse) {
                m3213a(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -586777968, a);
        }

        private void m3213a(View view) {
            if (!this.f3382d.b().q) {
                this.f3379a.f3389b.a(EventTriggerType.BY_NEWSFEED_OCCLUSION);
                this.f3382d.b().a();
                FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(view.getContext(), FullScreenVideoPlayerHost.class);
                if (fullScreenVideoPlayerHost != null) {
                    VideoWatchAndBrowseRootView videoWatchAndBrowseRootView = (VideoWatchAndBrowseRootView) fullScreenVideoPlayerHost.n();
                    Preconditions.checkNotNull(videoWatchAndBrowseRootView);
                    videoWatchAndBrowseRootView.f3404c = new VideoWatchAndBrowseExitListener(this.f3383e);
                    CanLaunchWatchAndBrowse canLaunchWatchAndBrowse = (CanLaunchWatchAndBrowse) view;
                    switch (this.f3379a.f3391d) {
                        case WATCH_AND_BROWSE:
                            videoWatchAndBrowseRootView.m3240a(this.f3380b, canLaunchWatchAndBrowse.getTransitionNode(), canLaunchWatchAndBrowse.getSeekPosition(), canLaunchWatchAndBrowse.getLastStartPosition(), this.f3381c, this.f3382d.c());
                            return;
                        case WATCH_AND_SHOP:
                            videoWatchAndBrowseRootView.m3241a(this.f3380b, canLaunchWatchAndBrowse.getTransitionNode(), canLaunchWatchAndBrowse.getSeekPosition(), canLaunchWatchAndBrowse.getLastStartPosition(), this.f3381c, this.f3382d.c(), this.f3384f);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    @Immutable
    /* compiled from: should_show_to_viewer */
    public final class Props {
        public final FeedProps<GraphQLStoryAttachment> f3385a;
        public final AtomicReference<FullscreenTransitionListener> f3386b;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, AtomicReference<FullscreenTransitionListener> atomicReference) {
            this.f3385a = feedProps;
            this.f3386b = atomicReference;
        }
    }

    /* compiled from: should_show_to_viewer */
    class VideoWatchAndBrowseExitListener implements FullscreenTransitionListener, FullScreenVideoListener {
        private final AtomicReference<FullscreenTransitionListener> f3387a;

        public VideoWatchAndBrowseExitListener(AtomicReference<FullscreenTransitionListener> atomicReference) {
            this.f3387a = atomicReference;
        }

        public final void m3214a(EventTriggerType eventTriggerType) {
        }

        public final void m3215a(EventTriggerType eventTriggerType, ExitFullScreenResult exitFullScreenResult) {
            m3216a(exitFullScreenResult);
        }

        public final void m3216a(ExitFullScreenResult exitFullScreenResult) {
            FullscreenTransitionListener fullscreenTransitionListener = (FullscreenTransitionListener) this.f3387a.get();
            if (fullscreenTransitionListener != null) {
                fullscreenTransitionListener.a(exitFullScreenResult);
            }
        }
    }

    public final Object m3218a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        FeedProps e = AttachmentProps.e(props.f3385a);
        GraphQLStory graphQLStory = (GraphQLStory) e.a;
        GraphQLMedia r = ((GraphQLStoryAttachment) props.f3385a.a).r();
        String b;
        if (r != null) {
            b = r.b();
        } else {
            b = null;
        }
        if (!(graphQLStory == null || graphQLStory.c() == null || r1 == null)) {
            subParts.a((SinglePartDefinition) this.f3388a.get(), new com.facebook.feedplugins.attachments.video.VideoZeroDialogPartDefinition.Props(new LaunchWatchAndBrowseClickListener(this, e, FeedAnalyticsUtil.a(hasFeedListType.c()), m3217a(props.f3385a, hasFeedListType), props.f3386b, hasFeedListType)));
        }
        return null;
    }

    @Inject
    public VideoWatchAndBrowseLauncherPartDefinition(PlayerActivityManager playerActivityManager, AutoplayStateManagerProvider autoplayStateManagerProvider, Lazy<VideoZeroDialogPartDefinition> lazy, @Assisted WatchAndMoreType watchAndMoreType) {
        this.f3389b = playerActivityManager;
        this.f3390c = autoplayStateManagerProvider;
        this.f3388a = lazy;
        this.f3391d = watchAndMoreType;
    }

    private InlineVideoPersistentState m3217a(FeedProps<GraphQLStoryAttachment> feedProps, E e) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        FeedProps e2 = AttachmentProps.e(feedProps);
        return (InlineVideoPersistentState) ((HasPersistentState) e).a(new InlineVideoStoryKey(e2, GraphQLMediaConversionHelper.b(graphQLStoryAttachment.r()), this.f3390c), (CacheableEntity) e2.a);
    }
}
