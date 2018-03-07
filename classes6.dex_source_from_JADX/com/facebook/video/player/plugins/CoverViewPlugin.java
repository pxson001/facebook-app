package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.content.event.FbEvent;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: composer_attach_photo_failure */
public class CoverViewPlugin extends RichVideoPlayerPlugin {
    private ICoverView f19318a;
    private int f19319b;

    /* compiled from: composer_attach_photo_failure */
    /* synthetic */ class C14411 {
        static final /* synthetic */ int[] f19316a = new int[com.facebook.video.player.plugins.PlaybackController.State.values().length];

        static {
            try {
                f19316a[com.facebook.video.player.plugins.PlaybackController.State.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19316a[com.facebook.video.player.plugins.PlaybackController.State.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19316a[com.facebook.video.player.plugins.PlaybackController.State.ATTEMPT_TO_PLAY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19316a[com.facebook.video.player.plugins.PlaybackController.State.SEEKING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: composer_attach_photo_failure */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ CoverViewPlugin f19317a;

        public PlayerStateChangedEventSubscriber(CoverViewPlugin coverViewPlugin) {
            this.f19317a = coverViewPlugin;
        }

        public final void m28085b(FbEvent fbEvent) {
            CoverViewPlugin.m28086a(this.f19317a, ((RVPPlayerStateChangedEvent) fbEvent).b);
        }

        public final Class<RVPPlayerStateChangedEvent> m28084a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: composer_attach_photo_failure */
    @interface State {
    }

    public CoverViewPlugin(Context context) {
        this(context, null);
    }

    private CoverViewPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CoverViewPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19319b = 3;
        this.f.add(new PlayerStateChangedEventSubscriber(this));
    }

    public void setCoverView(ICoverView iCoverView) {
        this.f19318a = iCoverView;
        this.f19319b = 3;
        this.f19318a.m28126c();
        if (this.h != null) {
            m28086a(this, this.h.l);
        }
    }

    protected final void m28087a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (this.h != null) {
            m28086a(this, this.h.l);
        }
    }

    protected final void m28088c() {
        if (this.f19318a != null) {
            this.f19319b = 3;
            this.f19318a.m28126c();
        }
    }

    public static void m28086a(CoverViewPlugin coverViewPlugin, com.facebook.video.player.plugins.PlaybackController.State state) {
        if (coverViewPlugin.f19318a != null) {
            switch (C14411.f19316a[state.ordinal()]) {
                case 1:
                    if (coverViewPlugin.f19319b != 1) {
                        coverViewPlugin.f19318a.m28124a();
                    }
                    coverViewPlugin.f19319b = 1;
                    return;
                case 2:
                    if (coverViewPlugin.f19319b != 3) {
                        coverViewPlugin.f19318a.m28126c();
                    }
                    coverViewPlugin.f19319b = 3;
                    return;
                case 3:
                case 4:
                    if (coverViewPlugin.f19319b == 1 || coverViewPlugin.f19319b == 4) {
                        coverViewPlugin.f19319b = 4;
                        return;
                    }
            }
            if (coverViewPlugin.f19319b != 2) {
                coverViewPlugin.f19318a.m28125b();
            }
            coverViewPlugin.f19319b = 2;
        }
    }
}
