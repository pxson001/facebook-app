package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.storyset.experiment.VideoSetsQeAccessor;
import com.facebook.feedplugins.storyset.funnel.StorySetFunnelLogger;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.inject.FbInjector;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: polling_enabled */
public class VolumeIconPlugin extends RichVideoPlayerPlugin {
    @Inject
    public VideoSetsQeAccessor f4453a;
    @Inject
    public StorySetFunnelLogger f4454b;
    @Inject
    public VideoLoggingUtils f4455c;
    private View f4456d;
    private View f4457l;
    private boolean f4458m;

    /* compiled from: polling_enabled */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VolumeIconPlugin f4464a;

        public PlayerStateChangedEventSubscriber(VolumeIconPlugin volumeIconPlugin) {
            this.f4464a = volumeIconPlugin;
        }

        public final void m4973b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (VolumeIconPlugin.m4959d(this.f4464a)) {
                VolumeIconPlugin.m4955a(this.f4464a, rVPPlayerStateChangedEvent.f14079b);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m4972a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m4956a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VolumeIconPlugin volumeIconPlugin = (VolumeIconPlugin) obj;
        VideoSetsQeAccessor a = VideoSetsQeAccessor.a(fbInjector);
        StorySetFunnelLogger b = StorySetFunnelLogger.m4966b(fbInjector);
        VideoLoggingUtils a2 = VideoLoggingUtils.a(fbInjector);
        volumeIconPlugin.f4453a = a;
        volumeIconPlugin.f4454b = b;
        volumeIconPlugin.f4455c = a2;
    }

    public VolumeIconPlugin(Context context) {
        this(context, null);
    }

    private VolumeIconPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VolumeIconPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4458m = true;
        Class cls = VolumeIconPlugin.class;
        m4956a((Object) this, getContext());
        setContentView(2130907758);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f4456d = m14861a(2131568495);
        this.f4457l = m14861a(2131568494);
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (m4959d(this)) {
            if (z) {
                GraphQLStorySet graphQLStorySet;
                if (richVideoPlayerParams == null || richVideoPlayerParams.f4963b == null) {
                    graphQLStorySet = null;
                } else if (richVideoPlayerParams.f4963b.get("GraphQLStoryProps") instanceof FeedProps) {
                    FeedProps feedProps = (FeedProps) richVideoPlayerParams.f4963b.get("GraphQLStoryProps");
                    if (feedProps.c() instanceof GraphQLStorySet) {
                        graphQLStorySet = (GraphQLStorySet) feedProps.c();
                    } else {
                        graphQLStorySet = null;
                    }
                } else {
                    graphQLStorySet = null;
                }
                GraphQLStorySet graphQLStorySet2 = graphQLStorySet;
                this.f4456d.setOnClickListener(new 1(this, richVideoPlayerParams, graphQLStorySet2));
                this.f4457l.setOnClickListener(new 2(this, richVideoPlayerParams, graphQLStorySet2));
            }
            Preconditions.checkNotNull(this.f14096h);
            m4955a(this, this.f14096h.f5115l);
        }
    }

    public static void m4954a(VolumeIconPlugin volumeIconPlugin, GraphQLStorySet graphQLStorySet, int i) {
        if (graphQLStorySet != null) {
            volumeIconPlugin.f4454b.m4968a(FunnelRegistry.A, graphQLStorySet, i, "position:" + graphQLStorySet.ac_());
        }
    }

    public static void m4957b(VolumeIconPlugin volumeIconPlugin, RichVideoPlayerParams richVideoPlayerParams) {
        if (volumeIconPlugin.f14097i != null && volumeIconPlugin.f14096h != null) {
            volumeIconPlugin.f4455c.a(richVideoPlayerParams.f4962a.f4836e, PlayerType.INLINE_PLAYER.value, EventTriggerType.BY_USER.value, volumeIconPlugin.f14097i.getCurrentPositionMs(), richVideoPlayerParams.f4962a.f4833b, volumeIconPlugin.f14096h.m5485o(), richVideoPlayerParams.f4962a.f4837f, richVideoPlayerParams.f4962a);
        }
    }

    public static void m4958c(VolumeIconPlugin volumeIconPlugin, RichVideoPlayerParams richVideoPlayerParams) {
        if (volumeIconPlugin.f14097i != null && volumeIconPlugin.f14096h != null) {
            volumeIconPlugin.f4455c.b(richVideoPlayerParams.f4962a.f4836e, PlayerType.INLINE_PLAYER.value, EventTriggerType.BY_USER.value, volumeIconPlugin.f14097i.getCurrentPositionMs(), richVideoPlayerParams.f4962a.f4833b, volumeIconPlugin.f14096h.m5485o(), richVideoPlayerParams.f4962a.f4837f, richVideoPlayerParams.f4962a);
        }
    }

    protected final void mo378c() {
        if (m4959d(this)) {
            m4955a(this, State.PAUSED);
        }
    }

    public static boolean m4959d(VolumeIconPlugin volumeIconPlugin) {
        return volumeIconPlugin.f4453a.f() && volumeIconPlugin.f14096h != null && volumeIconPlugin.f14096h.m5485o().subOrigin.equals(PlayerOrigin.VIDEO_SETS.subOrigin);
    }

    public static void m4955a(VolumeIconPlugin volumeIconPlugin, State state) {
        if (!state.isPlayingState()) {
            volumeIconPlugin.f4458m = true;
            volumeIconPlugin.setVolumeState(true);
            volumeIconPlugin.m4953a(8, 8);
        } else if (volumeIconPlugin.f4458m) {
            volumeIconPlugin.m4953a(8, 0);
        } else {
            volumeIconPlugin.m4953a(0, 8);
        }
    }

    private void m4953a(int i, int i2) {
        this.f4456d.setVisibility(i);
        this.f4457l.setVisibility(i2);
    }

    public static void m4960e(VolumeIconPlugin volumeIconPlugin) {
        State state;
        volumeIconPlugin.f4458m = !volumeIconPlugin.f4458m;
        volumeIconPlugin.setVolumeState(volumeIconPlugin.f4458m);
        if (volumeIconPlugin.f14096h == null) {
            state = State.ERROR;
        } else {
            state = volumeIconPlugin.f14096h.f5115l;
        }
        m4955a(volumeIconPlugin, state);
    }

    private void setVolumeState(boolean z) {
        if (this.f14097i != null) {
            this.f14097i.m14830a(z, EventTriggerType.BY_USER);
        }
    }
}
