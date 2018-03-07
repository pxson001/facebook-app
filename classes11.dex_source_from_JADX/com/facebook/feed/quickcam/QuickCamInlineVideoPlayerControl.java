package com.facebook.feed.quickcam;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.facebook.feed.quickcam.QuickCamFragment.ButtonStates;
import com.facebook.feed.quickcam.QuickCamFragment.C09531;
import com.facebook.inject.InjectorLike;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.AbstractVideoPlayerListener;
import com.facebook.video.engine.Constants.VideoError;
import com.facebook.video.engine.VideoPlayer.PlayerState;
import com.facebook.video.player.InlineVideoPlayer;

@TargetApi(11)
/* compiled from: drawee_controller */
public class QuickCamInlineVideoPlayerControl {
    public InlineVideoPlayer f7547a;
    public ImageView f7548b;
    public ImageView f7549c;
    public C09531 f7550d;
    public int f7551e = 0;

    /* compiled from: drawee_controller */
    public class C09621 extends AbstractVideoPlayerListener {
        final /* synthetic */ QuickCamInlineVideoPlayerControl f7546a;

        public C09621(QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl) {
            this.f7546a = quickCamInlineVideoPlayerControl;
        }

        public final void m8766a(Bitmap bitmap) {
            this.f7546a.f7548b.setImageBitmap(bitmap);
            this.f7546a.f7548b.invalidate();
        }

        public final void m8768a(EventTriggerType eventTriggerType, boolean z) {
            QuickCamInlineVideoPlayerControl.m8777g(this.f7546a);
        }

        public final void m8772b(EventTriggerType eventTriggerType, boolean z) {
        }

        public final void m8774c(EventTriggerType eventTriggerType, boolean z) {
        }

        public final void m8767a(EventTriggerType eventTriggerType) {
            QuickCamInlineVideoPlayerControl.m8778h(this.f7546a);
        }

        public final void m8771b(EventTriggerType eventTriggerType) {
            QuickCamInlineVideoPlayerControl.m8778h(this.f7546a);
            QuickCamInlineVideoPlayerControl.m8776f(this.f7546a);
        }

        public final void m8773c(EventTriggerType eventTriggerType) {
            QuickCamInlineVideoPlayerControl.m8778h(this.f7546a);
        }

        public final void m8769a(PlayerState playerState) {
            if (playerState == PlayerState.STATE_PLAYBACK_COMPLETED) {
                QuickCamInlineVideoPlayerControl.m8778h(this.f7546a);
                QuickCamInlineVideoPlayerControl.m8776f(this.f7546a);
                this.f7546a.f7551e = 0;
            }
        }

        public final void m8770a(String str, VideoError videoError) {
            QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl = this.f7546a;
            if (quickCamInlineVideoPlayerControl.f7550d != null) {
                C09531 c09531 = quickCamInlineVideoPlayerControl.f7550d;
                c09531.f7527a.aH = false;
                c09531.f7527a.aS = ButtonStates.PLAY;
                QuickCamFragment.aC(c09531.f7527a);
            }
        }
    }

    public static QuickCamInlineVideoPlayerControl m8775a(InjectorLike injectorLike) {
        return new QuickCamInlineVideoPlayerControl();
    }

    public static void m8776f(QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl) {
        if (quickCamInlineVideoPlayerControl.f7547a != null && quickCamInlineVideoPlayerControl.f7548b != null && quickCamInlineVideoPlayerControl.f7549c != null) {
            quickCamInlineVideoPlayerControl.f7547a.asViewGroup().setVisibility(4);
            quickCamInlineVideoPlayerControl.f7548b.setVisibility(0);
            quickCamInlineVideoPlayerControl.f7549c.setVisibility(0);
            quickCamInlineVideoPlayerControl.f7549c.bringToFront();
        }
    }

    public static void m8777g(QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl) {
        if (quickCamInlineVideoPlayerControl.f7547a != null && quickCamInlineVideoPlayerControl.f7548b != null && quickCamInlineVideoPlayerControl.f7549c != null) {
            quickCamInlineVideoPlayerControl.f7547a.asViewGroup().setVisibility(0);
            quickCamInlineVideoPlayerControl.f7548b.setVisibility(4);
            quickCamInlineVideoPlayerControl.f7549c.setVisibility(4);
        }
    }

    public static void m8778h(QuickCamInlineVideoPlayerControl quickCamInlineVideoPlayerControl) {
        if (quickCamInlineVideoPlayerControl.f7550d != null) {
            quickCamInlineVideoPlayerControl.f7550d.m8739a();
        }
    }

    public final boolean m8780e() {
        return this.f7547a.b();
    }

    public final void m8779a(int i) {
        if (this.f7547a != null) {
            this.f7547a.setVisibility(i);
        }
    }
}
