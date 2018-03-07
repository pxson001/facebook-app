package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPChromeBehaviorChangeEvent;
import com.facebook.video.player.events.RVPPlayIconStateEvent;
import com.facebook.video.player.events.RVPPlayIconStateEvent.State;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestPlayingEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: commerce_view_product_store_front */
public class VideoControlPlugin extends RichVideoPlayerPlugin {
    @VisibleForTesting
    final ImageButton f19415a;
    @VisibleForTesting
    final ImageButton f19416b;
    @Inject
    public Video360PlayerConfig f19417c;

    /* compiled from: commerce_view_product_store_front */
    class C14481 implements OnClickListener {
        final /* synthetic */ VideoControlPlugin f19411a;

        C14481(VideoControlPlugin videoControlPlugin) {
            this.f19411a = videoControlPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1865108126);
            if (this.f19411a.g == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1135615834, a);
                return;
            }
            this.f19411a.f19415a.setVisibility(8);
            this.f19411a.g.a(new RVPRequestPlayingEvent(EventTriggerType.BY_USER));
            this.f19411a.g.a(new RVPChromeBehaviorChangeEvent(ChromeBehavior.AUTO));
            LogUtils.a(-1268596649, a);
        }
    }

    /* compiled from: commerce_view_product_store_front */
    class C14492 implements OnClickListener {
        final /* synthetic */ VideoControlPlugin f19412a;

        C14492(VideoControlPlugin videoControlPlugin) {
            this.f19412a = videoControlPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1011043250);
            if (this.f19412a.g == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1165021966, a);
                return;
            }
            this.f19412a.f19416b.setVisibility(8);
            this.f19412a.g.a(new RVPRequestPausingEvent(EventTriggerType.BY_USER));
            LogUtils.a(-809654932, a);
        }
    }

    /* compiled from: commerce_view_product_store_front */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoControlPlugin f19413a;

        public PlayerStateChangedEventSubscriber(VideoControlPlugin videoControlPlugin) {
            this.f19413a = videoControlPlugin;
        }

        public final void m28187b(FbEvent fbEvent) {
            if (this.f19413a.h != null) {
                VideoControlPlugin.m28194d(this.f19413a);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m28186a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: commerce_view_product_store_front */
    class RVPPlayIconStateEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayIconStateEvent> {
        final /* synthetic */ VideoControlPlugin f19414a;

        public RVPPlayIconStateEventSubscriber(VideoControlPlugin videoControlPlugin) {
            this.f19414a = videoControlPlugin;
        }

        public final void m28189b(FbEvent fbEvent) {
            if (((RVPPlayIconStateEvent) fbEvent).a == State.HIDE) {
                this.f19414a.f19415a.setVisibility(8);
                this.f19414a.f19416b.setVisibility(8);
            }
        }

        public final Class<RVPPlayIconStateEvent> m28188a() {
            return RVPPlayIconStateEvent.class;
        }
    }

    private static <T extends View> void m28192a(Class<T> cls, T t) {
        m28193a((Object) t, t.getContext());
    }

    private static void m28193a(Object obj, Context context) {
        ((VideoControlPlugin) obj).f19417c = Video360PlayerConfig.b(FbInjector.get(context));
    }

    public VideoControlPlugin(Context context) {
        this(context, null);
    }

    public VideoControlPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoControlPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907661);
        m28192a(VideoControlPlugin.class, (View) this);
        this.f.add(new PlayerStateChangedEventSubscriber(this));
        this.f.add(new RVPPlayIconStateEventSubscriber(this));
        this.f19415a = (ImageButton) a(2131568305);
        this.f19416b = (ImageButton) a(2131568306);
        this.f19415a.setOnClickListener(new C14481(this));
        this.f19416b.setOnClickListener(new C14492(this));
    }

    private void m28190a(Video360PlayerConfig video360PlayerConfig) {
        this.f19417c = video360PlayerConfig;
    }

    protected final void m28195a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        m28194d(this);
    }

    public static void m28194d(VideoControlPlugin videoControlPlugin) {
        Preconditions.checkNotNull(videoControlPlugin.h);
        PlaybackController.State state = videoControlPlugin.h.l;
        if (state == PlaybackController.State.PLAYING) {
            videoControlPlugin.f19416b.setVisibility(0);
            videoControlPlugin.f19415a.setVisibility(8);
        } else if (state == PlaybackController.State.ATTEMPT_TO_PLAY) {
            videoControlPlugin.f19416b.setVisibility(8);
            videoControlPlugin.f19415a.setVisibility(8);
        } else {
            videoControlPlugin.f19416b.setVisibility(8);
            videoControlPlugin.f19415a.setVisibility(0);
        }
    }
}
