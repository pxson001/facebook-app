package com.facebook.video.player.plugins;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.event.FbEvent;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Inject;

/* compiled from: composer_add_location_cancel */
public class OverlayImagePlugin extends RichVideoPlayerPlugin {
    private static final CallerContext f19363c = CallerContext.a(OverlayImagePlugin.class, "create_profile_video_android");
    protected FbDraweeView f19364a;
    @Inject
    public FbDraweeControllerBuilder f19365b;
    private int f19366d;

    /* compiled from: composer_add_location_cancel */
    /* synthetic */ class C14461 {
        static final /* synthetic */ int[] f19361a = new int[com.facebook.video.player.plugins.PlaybackController.State.values().length];

        static {
            try {
                f19361a[com.facebook.video.player.plugins.PlaybackController.State.PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19361a[com.facebook.video.player.plugins.PlaybackController.State.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19361a[com.facebook.video.player.plugins.PlaybackController.State.ATTEMPT_TO_PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19361a[com.facebook.video.player.plugins.PlaybackController.State.ATTEMPT_TO_PLAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19361a[com.facebook.video.player.plugins.PlaybackController.State.SEEKING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: composer_add_location_cancel */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ OverlayImagePlugin f19362a;

        public PlayerStateChangedEventSubscriber(OverlayImagePlugin overlayImagePlugin) {
            this.f19362a = overlayImagePlugin;
        }

        public final void m28140b(FbEvent fbEvent) {
            OverlayImagePlugin.m28141a(this.f19362a, ((RVPPlayerStateChangedEvent) fbEvent).b);
        }

        public final Class<RVPPlayerStateChangedEvent> m28139a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: composer_add_location_cancel */
    @interface State {
    }

    public static void m28142a(Object obj, Context context) {
        ((OverlayImagePlugin) obj).f19365b = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public OverlayImagePlugin(Context context) {
        this(context, null);
    }

    private OverlayImagePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private OverlayImagePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19366d = 2;
        Class cls = OverlayImagePlugin.class;
        m28142a((Object) this, getContext());
        setContentView(2130903812);
        this.f19364a = (FbDraweeView) a(2131560814);
        this.f.add(new PlayerStateChangedEventSubscriber(this));
    }

    protected final void m28143a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (richVideoPlayerParams.b.containsKey("OverlayImageParamsKey")) {
            Object obj = richVideoPlayerParams.b.get("OverlayImageParamsKey");
            if (obj instanceof Uri) {
                this.f19364a.setController(((FbDraweeControllerBuilder) this.f19365b.a(f19363c).b((Uri) obj).b(this.f19364a.getController())).s());
                if (this.h != null) {
                    m28141a(this, this.h.l);
                    return;
                }
                return;
            }
            g();
            return;
        }
        g();
    }

    protected final void m28144c() {
        this.f19364a.setVisibility(8);
        this.f19364a.setController(null);
    }

    public static void m28141a(OverlayImagePlugin overlayImagePlugin, com.facebook.video.player.plugins.PlaybackController.State state) {
        switch (C14461.f19361a[state.ordinal()]) {
            case 1:
            case 2:
            case 3:
                if (overlayImagePlugin.f19366d != 1) {
                    overlayImagePlugin.f19364a.setVisibility(0);
                }
                overlayImagePlugin.f19366d = 1;
                return;
            case 4:
            case 5:
                if (overlayImagePlugin.f19366d == 1 || overlayImagePlugin.f19366d == 3) {
                    overlayImagePlugin.f19366d = 3;
                    return;
                }
        }
        if (overlayImagePlugin.f19366d != 2) {
            overlayImagePlugin.f19364a.setVisibility(8);
        }
        overlayImagePlugin.f19366d = 2;
    }
}
