package com.facebook.richdocument.view.widget.video;

import android.content.Context;
import com.facebook.content.event.FbEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.view.widget.media.plugins.VideoControlsPlugin;
import com.facebook.richdocument.view.widget.video.VideoPlayerStateMachine.VideoPlayerEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import javax.inject.Inject;

/* compiled from: nullstate_image_hdpi */
public class VideoControlsSyncPlugin extends RichVideoPlayerPlugin {
    @Inject
    public GatekeeperStoreImpl f7734a;
    public final boolean f7735b = this.f7734a.a(695, false);
    public VideoControlsPlugin f7736c;

    /* compiled from: nullstate_image_hdpi */
    /* synthetic */ class C08921 {
        static final /* synthetic */ int[] f7732a = new int[State.values().length];

        static {
            try {
                f7732a[State.ATTEMPT_TO_PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7732a[State.PLAYING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7732a[State.ATTEMPT_TO_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7732a[State.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7732a[State.PLAYBACK_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: nullstate_image_hdpi */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ VideoControlsSyncPlugin f7733a;

        public PlayerStateChangedEventSubscriber(VideoControlsSyncPlugin videoControlsSyncPlugin) {
            this.f7733a = videoControlsSyncPlugin;
        }

        public final void m8007b(FbEvent fbEvent) {
            switch (C08921.f7732a[((RVPPlayerStateChangedEvent) fbEvent).b.ordinal()]) {
                case 1:
                    if (this.f7733a.f7735b) {
                        this.f7733a.m8009a(VideoPlayerEvent.ATTEMPT_TO_PLAY);
                        return;
                    } else {
                        this.f7733a.m8009a(VideoPlayerEvent.SYSTEM_VIDEO_PLAY);
                        return;
                    }
                case 2:
                    this.f7733a.m8009a(VideoPlayerEvent.SYSTEM_VIDEO_PLAY);
                    return;
                case 3:
                case 4:
                    this.f7733a.m8009a(VideoPlayerEvent.SYSTEM_VIDEO_PAUSE);
                    return;
                case 5:
                    this.f7733a.m8009a(VideoPlayerEvent.SYSTEM_VIDEO_FINISHED);
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m8006a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m8008a(Object obj, Context context) {
        ((VideoControlsSyncPlugin) obj).f7734a = GatekeeperStoreImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public VideoControlsSyncPlugin(Context context) {
        super(context);
        Class cls = VideoControlsSyncPlugin.class;
        m8008a(this, getContext());
        this.f.add(new PlayerStateChangedEventSubscriber(this));
    }

    public final boolean m8009a(VideoPlayerEvent videoPlayerEvent) {
        if (this.f7736c != null) {
            return this.f7736c.m7999a(videoPlayerEvent);
        }
        return false;
    }
}
