package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.content.event.FbEvent;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.spherical.ui.Spherical360GyroAnimationView;
import com.facebook.spherical.ui.Spherical360PhoneAnimationView;
import com.facebook.spherical.ui.SphericalNuxAnimationController;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPDismiss360NuxEvent;
import com.facebook.video.player.events.RVPFirstPlayEvent;
import com.facebook.video.player.events.RVPGyroDismissalEvent;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;

@DoNotStrip
/* compiled from: company */
public class Video360NuxAnimationPlugin extends RichVideoPlayerPlugin {
    public SphericalNuxAnimationController f19402a;
    public Spherical360GyroAnimationView f19403b;
    public Spherical360PhoneAnimationView f19404c;

    /* compiled from: company */
    public class Dismiss360NuxSubscriber extends RichVideoPlayerEventSubscriber<RVPDismiss360NuxEvent> {
        final /* synthetic */ Video360NuxAnimationPlugin f19398a;

        public Dismiss360NuxSubscriber(Video360NuxAnimationPlugin video360NuxAnimationPlugin) {
            this.f19398a = video360NuxAnimationPlugin;
        }

        public final void m28175b(FbEvent fbEvent) {
            this.f19398a.f19402a.m23869a();
        }

        public final Class<RVPDismiss360NuxEvent> m28174a() {
            return RVPDismiss360NuxEvent.class;
        }
    }

    /* compiled from: company */
    public class FirstPlayEventSubscriber extends RichVideoPlayerEventSubscriber<RVPFirstPlayEvent> {
        final /* synthetic */ Video360NuxAnimationPlugin f19399a;

        public FirstPlayEventSubscriber(Video360NuxAnimationPlugin video360NuxAnimationPlugin) {
            this.f19399a = video360NuxAnimationPlugin;
        }

        public final void m28177b(FbEvent fbEvent) {
            SphericalNuxAnimationController sphericalNuxAnimationController = this.f19399a.f19402a;
            sphericalNuxAnimationController.m23874g();
            sphericalNuxAnimationController.m23875h();
        }

        public final Class<RVPFirstPlayEvent> m28176a() {
            return RVPFirstPlayEvent.class;
        }
    }

    /* compiled from: company */
    public class GyroDismissSubscriber extends RichVideoPlayerEventSubscriber<RVPGyroDismissalEvent> {
        final /* synthetic */ Video360NuxAnimationPlugin f19400a;

        public GyroDismissSubscriber(Video360NuxAnimationPlugin video360NuxAnimationPlugin) {
            this.f19400a = video360NuxAnimationPlugin;
        }

        public final void m28179b(FbEvent fbEvent) {
            this.f19400a.f19402a.m23869a();
        }

        public final Class<RVPGyroDismissalEvent> m28178a() {
            return RVPGyroDismissalEvent.class;
        }
    }

    /* compiled from: company */
    public class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ Video360NuxAnimationPlugin f19401a;

        public PlayerStateChangedEventSubscriber(Video360NuxAnimationPlugin video360NuxAnimationPlugin) {
            this.f19401a = video360NuxAnimationPlugin;
        }

        public final void m28181b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (rVPPlayerStateChangedEvent.b == State.PAUSED) {
                this.f19401a.f19402a.m23869a();
            } else if (rVPPlayerStateChangedEvent.b == State.PLAYING) {
                r0 = this.f19401a.f19402a;
                if (r0.f16388f) {
                    if (r0.f16384b != null && r0.f16384b.isPaused()) {
                        r0.f16384b.resume();
                    }
                    if (r0.f16385c != null && r0.f16385c.isPaused()) {
                        r0.f16385c.resume();
                    }
                }
            } else if (rVPPlayerStateChangedEvent.b == State.PLAYBACK_COMPLETE) {
                this.f19401a.f19402a.m23869a();
            } else if (rVPPlayerStateChangedEvent.b == State.ATTEMPT_TO_PLAY) {
                r0 = this.f19401a.f19402a;
                if (r0.f16388f) {
                    if (r0.f16384b != null && r0.f16384b.isRunning()) {
                        r0.f16384b.pause();
                    }
                    if (r0.f16385c != null && r0.f16385c.isRunning()) {
                        r0.f16385c.pause();
                    }
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m28180a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    @DoNotStrip
    public Video360NuxAnimationPlugin(Context context) {
        this(context, null);
    }

    private Video360NuxAnimationPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private Video360NuxAnimationPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907186);
        this.f19403b = (Spherical360GyroAnimationView) a(2131567560);
        this.f19404c = (Spherical360PhoneAnimationView) a(2131567561);
        this.f19403b.setVisibility(0);
        this.f19402a = new SphericalNuxAnimationController();
        this.f.add(new FirstPlayEventSubscriber(this));
        this.f.add(new Dismiss360NuxSubscriber(this));
        this.f.add(new GyroDismissSubscriber(this));
        this.f.add(new PlayerStateChangedEventSubscriber(this));
    }

    protected final void m28182a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        if (z && this.f19403b != null && this.f19404c != null) {
            this.f19402a.m23870a(this.f19403b, 0, 300, 2000, 0);
            this.f19402a.m23871a(this.f19404c, 300, 300, 2000, 5400);
        }
    }

    protected final void m28183c() {
        super.c();
        this.f19402a.m23869a();
    }
}
