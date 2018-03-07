package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.event.FbEvent;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.drawee.fbpipeline.DegradableDraweeController;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.FbInjector;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.VideoAnimationHelper;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import javax.inject.Inject;

/* compiled from: defaultImpl */
public class BaseCoverImagePlugin extends RichVideoPlayerPlugin {
    private static final CallerContext f14157d = CallerContext.a(BaseCoverImagePlugin.class, "video_cover");
    public FbDraweeView f14158a;
    @Inject
    public VideoAnimationHelper f14159b;
    @Inject
    public FbDraweeControllerBuilder f14160c;

    /* compiled from: defaultImpl */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ BaseCoverImagePlugin f14165a;

        public PlayerStateChangedEventSubscriber(BaseCoverImagePlugin baseCoverImagePlugin) {
            this.f14165a = baseCoverImagePlugin;
        }

        public final void m14977b(FbEvent fbEvent) {
            BaseCoverImagePlugin.m14968a(this.f14165a, ((RVPPlayerStateChangedEvent) fbEvent).f14079b);
        }

        public final Class<RVPPlayerStateChangedEvent> m14976a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m14969a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        BaseCoverImagePlugin baseCoverImagePlugin = (BaseCoverImagePlugin) obj;
        VideoAnimationHelper a = VideoAnimationHelper.m14973a(fbInjector);
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(fbInjector);
        baseCoverImagePlugin.f14159b = a;
        baseCoverImagePlugin.f14160c = b;
    }

    public BaseCoverImagePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = BaseCoverImagePlugin.class;
        m14969a((Object) this, getContext());
        context.obtainStyledAttributes(attributeSet, R.styleable.Cover_Image_Plugin).recycle();
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
    }

    protected void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Object obj = null;
        if (this.f14158a.getVisibility() == 0 && (this.f14096h.m5480i() || this.f14096h.f5120q == PlayerType.FULL_SCREEN_PLAYER)) {
            obj = 1;
        }
        if (obj != null) {
            setCoverImageVisible(false);
        }
        if (richVideoPlayerParams.f4963b.containsKey("CoverImageParamsKey")) {
            Object obj2 = richVideoPlayerParams.f4963b.get("CoverImageParamsKey");
            if (obj2 instanceof ImageRequest) {
                FbPipelineDraweeController s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f14160c.a(f14157d).c((ImageRequest) obj2)).b(this.f14158a.getController())).s();
                if (s instanceof DegradableDraweeController) {
                    ((DegradableDraweeController) s).m4727a(0, FeatureType.VIDEO);
                }
                this.f14158a.setController(s);
                return;
            }
            m14906g();
            return;
        }
        m14906g();
    }

    protected final void mo378c() {
        this.f14158a.setController(null);
        setCoverImageVisible(true);
    }

    public static void m14968a(BaseCoverImagePlugin baseCoverImagePlugin, State state) {
        if (State.PLAYING == state) {
            baseCoverImagePlugin.f14159b.m14974a(baseCoverImagePlugin.f14158a, 100, 8);
        } else if (State.PLAYBACK_COMPLETE == state) {
            baseCoverImagePlugin.setCoverImageVisible(true);
        }
    }

    private void setCoverImageVisible(boolean z) {
        this.f14158a.animate().cancel();
        this.f14158a.setVisibility(z ? 0 : 8);
        this.f14158a.setAlpha(1.0f);
    }
}
