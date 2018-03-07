package com.facebook.video.channelfeed;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.videos.ui.HasChannelFeedLauncherInfo;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.analytics.vpvlogging.VpvEventHelper;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.video.FullScreenVideoPlayerHost;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.PlayerActivityManager;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: osm_config */
public class LaunchChannelFeedClickListener implements OnClickListener {
    public final InlineToChannelFeedTransitionManagerProvider f5886a;
    public final PlayerActivityManager f5887b;
    public final VpvEventHelper f5888c;
    public final ChannelFeedParams f5889d;
    @Nullable
    public final VideoStoryPersistentState f5890e;
    public final AtomicReference<FullscreenTransitionListener> f5891f;
    @Nullable
    private final OnLaunchCallback f5892g;
    @Nullable
    public HasChannelFeedLauncherInfo f5893h;

    @Inject
    public LaunchChannelFeedClickListener(InlineToChannelFeedTransitionManagerProvider inlineToChannelFeedTransitionManagerProvider, PlayerActivityManager playerActivityManager, VpvEventHelper vpvEventHelper, @Assisted ChannelFeedParams channelFeedParams, @Assisted VideoStoryPersistentState videoStoryPersistentState, @Assisted AtomicReference<FullscreenTransitionListener> atomicReference, @Assisted HasChannelFeedLauncherInfo hasChannelFeedLauncherInfo, @Assisted OnLaunchCallback onLaunchCallback) {
        this.f5886a = inlineToChannelFeedTransitionManagerProvider;
        this.f5887b = playerActivityManager;
        this.f5888c = vpvEventHelper;
        this.f5889d = channelFeedParams;
        this.f5890e = videoStoryPersistentState;
        this.f5891f = atomicReference;
        this.f5893h = hasChannelFeedLauncherInfo;
        this.f5892g = onLaunchCallback;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1387303891);
        if (this.f5893h == null && (view instanceof HasChannelFeedLauncherInfo)) {
            this.f5893h = (HasChannelFeedLauncherInfo) view;
        }
        FullScreenVideoPlayerHost fullScreenVideoPlayerHost = (FullScreenVideoPlayerHost) ContextUtils.a(view.getContext(), FullScreenVideoPlayerHost.class);
        AutoplayStateManager b = this.f5890e != null ? this.f5890e.mo422b() : null;
        if (b == null || !b.f4933q) {
            InlineToChannelFeedTransitionManager a2 = this.f5886a.m6349a(fullScreenVideoPlayerHost, this.f5889d);
            this.f5887b.a(EventTriggerType.BY_USER);
            if (b != null) {
                b.m5311a();
            }
            this.f5888c.m4608a();
            FullscreenTransitionListener fullscreenTransitionListener = (FullscreenTransitionListener) this.f5891f.get();
            if (!(fullscreenTransitionListener instanceof FullscreenTransitionListenerDecorator)) {
                this.f5891f.set(new 1(this, fullscreenTransitionListener));
            }
            a2.a(this.f5893h, this.f5891f);
        }
        if (this.f5892g != null) {
            this.f5892g.a();
        }
        Logger.a(2, EntryType.UI_INPUT_END, 661886249, a);
    }
}
