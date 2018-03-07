package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnLongClickListener;
import com.facebook.content.event.FbEvent;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.inbox2.recents.ExpandableItemContainer.ExpandableItemView;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.VideoPlugin;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: selfupdate_start_fetching_from_fql */
public class InboxRecentItemVideoView extends RichVideoPlayer implements ExpandableItemView {
    @Nullable
    private RecentVideoInboxItem f2890i;
    public ExpandableItemContainer f2891j;
    private InboxRecentItemVideoControlsPlugin f2892k;
    private final RichVideoPlayerEventSubscriber f2893l = new C04741(this);

    /* compiled from: selfupdate_start_fetching_from_fql */
    class C04741 extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ InboxRecentItemVideoView f2886a;
        private boolean f2887b;

        C04741(InboxRecentItemVideoView inboxRecentItemVideoView) {
            this.f2886a = inboxRecentItemVideoView;
        }

        public final void m2852b(FbEvent fbEvent) {
            switch (C04752.f2888a[((RVPPlayerStateChangedEvent) fbEvent).b.ordinal()]) {
                case 1:
                    this.f2887b = true;
                    return;
                case 2:
                    if (this.f2887b) {
                        this.f2887b = false;
                        InboxRecentItemVideoView.m2858t(this.f2886a);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m2851a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: selfupdate_start_fetching_from_fql */
    /* synthetic */ class C04752 {
        static final /* synthetic */ int[] f2888a = new int[State.values().length];

        static {
            try {
                f2888a[State.SEEKING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2888a[State.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: selfupdate_start_fetching_from_fql */
    public class InboxRecentItemVideoViewEnvironment implements AnyPlayerEnvironment {
        final /* synthetic */ InboxRecentItemVideoView f2889a;

        public InboxRecentItemVideoViewEnvironment(InboxRecentItemVideoView inboxRecentItemVideoView) {
            this.f2889a = inboxRecentItemVideoView;
        }

        public final void m2853a() {
            this.f2889a.f2891j.m2821a();
        }

        public final void m2854b() {
            this.f2889a.f2891j.m2823b();
        }
    }

    public InboxRecentItemVideoView(Context context) {
        super(context);
    }

    public InboxRecentItemVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InboxRecentItemVideoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.f2892k.setOnLongClickListener(onLongClickListener);
    }

    public void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1438467695);
        super.onFinishInflate();
        m2855a(getContext());
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 873813708, a);
    }

    private void m2855a(Context context) {
        InboxRecentItemVideoViewEnvironment inboxRecentItemVideoViewEnvironment = new InboxRecentItemVideoViewEnvironment(this);
        this.f2892k = new InboxRecentItemVideoControlsPlugin(context, inboxRecentItemVideoViewEnvironment);
        a(new VideoPlugin(context));
        a(new CoverImagePlugin(context));
        a(new LoadingSpinnerPlugin(context));
        a(this.f2892k);
        a(new InboxRecentItemVideoExpandCollapsePlugin(context, inboxRecentItemVideoViewEnvironment));
        if (ChatHeadsContextDetector.a(context)) {
            a(new InboxRecentItemVideoChatHeadsReceiverPlugin(context));
        }
        a(this.f2893l);
        setShouldCropToFit(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public static void m2858t(InboxRecentItemVideoView inboxRecentItemVideoView) {
        Map hashMap = new HashMap();
        hashMap.put("ms", Integer.toString(inboxRecentItemVideoView.getCurrentPositionMs()));
        hashMap.put("pc", Integer.toString(Math.round(inboxRecentItemVideoView.getPlaybackPercentage() * 100.0f)));
        inboxRecentItemVideoView.f2891j.m2822a("seek_video", hashMap);
    }

    void setRecentVideoInboxItem(@Nullable RecentVideoInboxItem recentVideoInboxItem) {
        if (this.f2890i != recentVideoInboxItem) {
            this.f2890i = recentVideoInboxItem;
            if (this.f2890i == null) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            VideoDataSourceBuilder videoDataSourceBuilder = new VideoDataSourceBuilder();
            videoDataSourceBuilder.a = recentVideoInboxItem.f2951i;
            videoDataSourceBuilder = videoDataSourceBuilder;
            videoDataSourceBuilder.b = recentVideoInboxItem.f2952j;
            videoDataSourceBuilder = videoDataSourceBuilder;
            videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
            VideoPlayerParams m = new VideoPlayerParamsBuilder().a(videoDataSourceBuilder.i()).m();
            Builder builder = new Builder();
            builder.a = m;
            a(builder.a(getAdditionalDataMap()).b());
            a(false, EventTriggerType.BY_ANDROID);
            this.f2891j.m2823b();
        }
    }

    private ImmutableMap<String, Object> getAdditionalDataMap() {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        if (!(this.f2890i == null || this.f2890i.f2954l == null)) {
            builder.b("CoverImageParamsKey", ImageRequest.a(this.f2890i.f2954l));
        }
        return builder.b();
    }

    private InboxRecentItemVideoExpandCollapsePlugin getExpandCollapsePlugin() {
        InboxRecentItemVideoExpandCollapsePlugin inboxRecentItemVideoExpandCollapsePlugin = (InboxRecentItemVideoExpandCollapsePlugin) a(InboxRecentItemVideoExpandCollapsePlugin.class);
        Preconditions.checkState(inboxRecentItemVideoExpandCollapsePlugin != null);
        return inboxRecentItemVideoExpandCollapsePlugin;
    }

    public final void lX_() {
        requestFocus();
        getExpandCollapsePlugin().g.a(new InboxRecentItemVideoExpandStateChangeEvent(true));
    }

    public final void lY_() {
        b(EventTriggerType.BY_USER);
        getExpandCollapsePlugin().g.a(new InboxRecentItemVideoExpandStateChangeEvent(false));
    }

    public void setExpandableItemContainer(ExpandableItemContainer expandableItemContainer) {
        this.f2891j = expandableItemContainer;
    }

    public InboxRecentItem getInboxItem() {
        return this.f2890i;
    }
}
