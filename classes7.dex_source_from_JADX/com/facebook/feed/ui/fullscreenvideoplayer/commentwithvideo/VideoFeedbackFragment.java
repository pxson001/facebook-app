package com.facebook.feed.ui.fullscreenvideoplayer.commentwithvideo;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.api.ufiservices.common.FeedbackDisplayType;
import com.facebook.feed.ui.fullscreenvideoplayer.FeedFullScreenVideoPlayer;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FeedFullscreenSeekBarPlugin;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.FullscreenCallToActionEndscreenPlugin;
import com.facebook.feedback.ui.BaseFeedbackFragment;
import com.facebook.feedback.ui.FeedbackHeaderView;
import com.facebook.feedback.ui.FeedbackHeaderViewListenerProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.abtest.VideoQEConfig;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerType;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerCallbackListener;
import com.facebook.video.player.events.RVPErrorEvent;
import com.facebook.video.player.events.RVPStreamCompleteEvent;
import com.facebook.video.player.plugins.ClickToPlayAnimationPlugin;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.InlineSubtitlePlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: TimelineRenderCoreHeader */
public class VideoFeedbackFragment extends BaseFeedbackFragment {
    @Inject
    public Lazy<VideoQEConfig> aH;
    @Inject
    public FeedbackHeaderViewListenerProvider aI;
    private RichVideoPlayer aJ;
    public VideoFeedbackParams aK;
    public int aL;
    public boolean aM = false;
    private FeedbackHeaderView aN;
    private FeedFullScreenVideoPlayer aO;
    private List<RichVideoPlayerPlugin> aP;
    private RichVideoPlayerCallbackListener aQ;
    private List<RichVideoPlayerPlugin> aR;
    private LayoutParams aS;
    public boolean aT = false;
    private boolean aU = false;
    public boolean aV = false;
    private final RichVideoPlayerCallbackListener aW = new C18651(this);

    /* compiled from: TimelineRenderCoreHeader */
    class C18651 implements RichVideoPlayerCallbackListener {
        final /* synthetic */ VideoFeedbackFragment f21972a;

        C18651(VideoFeedbackFragment videoFeedbackFragment) {
            this.f21972a = videoFeedbackFragment;
        }

        public final void m24586a(RVPStreamCompleteEvent rVPStreamCompleteEvent) {
            this.f21972a.aT = true;
        }

        public final void m24584a() {
        }

        public final void m24585a(RVPErrorEvent rVPErrorEvent) {
        }
    }

    public static void m24588a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VideoFeedbackFragment videoFeedbackFragment = (VideoFeedbackFragment) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 11562);
        FeedbackHeaderViewListenerProvider feedbackHeaderViewListenerProvider = (FeedbackHeaderViewListenerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FeedbackHeaderViewListenerProvider.class);
        videoFeedbackFragment.aH = a;
        videoFeedbackFragment.aI = feedbackHeaderViewListenerProvider;
    }

    public final void mo217c(Bundle bundle) {
        boolean z;
        Class cls = VideoFeedbackFragment.class;
        m24588a((Object) this, getContext());
        if (this.aK != null) {
            this.aL = this.aK.f21975c;
            this.aM = this.aK.f21976d;
            this.aO = this.aK.f21978f;
        }
        this.aT = false;
        this.aU = false;
        if (this.aO != null && (this.aO instanceof FeedFullScreenVideoPlayer) && ((VideoQEConfig) this.aH.get()).c) {
            z = true;
        } else {
            z = false;
        }
        this.aV = z;
        super.mo217c(bundle);
    }

    public final View m24591a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -466978537);
        Context ay = ay();
        View inflate = LayoutInflater.from(ay).inflate(2130907672, viewGroup, false);
        this.aR = new ArrayList();
        this.aR.add(new CoverImagePlugin(ay));
        this.aR.add(new InlineSubtitlePlugin(ay));
        this.aR.add(new LoadingSpinnerPlugin(ay));
        this.aR.add(new ClickToPlayAnimationPlugin(ay));
        this.aR.add(new FeedFullscreenSeekBarPlugin(ay));
        this.aR.add(new FullscreenCallToActionEndscreenPlugin(ay));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1472708851, a);
        return inflate;
    }

    public final void mo211a(View view, Bundle bundle) {
        if (((VideoQEConfig) this.aH.get()).b) {
            this.aN = (FeedbackHeaderView) e(2131568335);
        } else {
            this.aN = (FeedbackHeaderView) e(2131568334);
        }
        this.aN.f4541g = this.aI.m5103a(this);
        m4742a(this.aN);
        super.mo211a(view, bundle);
        if (this.aV) {
            e(2131562414).setVisibility(8);
            aD();
        } else {
            this.aJ = (RichVideoPlayer) e(2131562414);
            this.aJ.a(new VideoPlugin(getContext()));
            m24587a(this.aJ);
        }
        this.aJ.a(this.aK.f21974b);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int i2 = (int) (((double) i) / 1.7777777777777777d);
        this.aS = this.aJ.getLayoutParams();
        this.aJ.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
        this.aJ.v = this.aW;
        if (!this.aV) {
            this.aJ.a(false, EventTriggerType.BY_FLYOUT);
            this.aJ.setPlayerType(PlayerType.FULL_SCREEN_PLAYER);
            this.aJ.setPlayerOrigin(this.aK.f21977e);
            this.aJ.a(this.aL, EventTriggerType.BY_FLYOUT);
        }
    }

    public final void mo209G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1783355552);
        if (this.aM && !this.aJ.u.l.isPlayingState()) {
            this.aJ.a(EventTriggerType.BY_FLYOUT);
        }
        super.mo209G();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -550788843, a);
    }

    public final void mo210H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1111683853);
        if (!this.aU) {
            this.aJ.b(EventTriggerType.BY_USER);
        }
        super.mo210H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 662039186, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 615096029);
        this.aL = this.aJ.getCurrentPositionMs();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1728487855, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 653655133);
        if (!this.aU && this.aV) {
            aE();
        }
        if (!this.aV) {
            this.aJ.a(true, EventTriggerType.BY_FLYOUT);
            this.aJ.g();
        }
        super.mY_();
        m4747b(this.aN);
        this.aN = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 782249617, a);
    }

    public final String ar() {
        return "flyout_video_feedback_animation";
    }

    protected final FeedbackDisplayType au() {
        return FeedbackDisplayType.VIDEO_FEEDBACK;
    }

    public final void m24592a() {
        if (this.aV) {
            aE();
        }
        this.aU = true;
        this.aL = this.aJ.getCurrentPositionMs();
        this.aM = this.aJ.u.l.isPlayingState();
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.orientation == 1) {
            this.aJ.setVisibility(0);
            this.aJ.a(EventTriggerType.BY_FLYOUT);
        }
        if (configuration.orientation == 2) {
            this.aJ.b(EventTriggerType.BY_FLYOUT);
            this.aJ.setVisibility(8);
        }
        super.onConfigurationChanged(configuration);
    }

    private void aD() {
        RichVideoPlayer richVideoPlayer = this.aO.getRichVideoPlayer();
        this.aP = richVideoPlayer.k();
        this.aQ = richVideoPlayer.v;
        this.aJ = richVideoPlayer;
        m24587a(this.aJ);
        ((CustomRelativeLayout) this.aJ.getParent()).detachRecyclableViewFromParent(this.aJ);
        ((CustomLinearLayout) this.T).attachRecyclableViewToParent(this.aJ, ((VideoQEConfig) this.aH.get()).b ? 0 : 3, this.aJ.getLayoutParams());
    }

    private void m24587a(RichVideoPlayer richVideoPlayer) {
        Preconditions.checkNotNull(this.aR);
        for (RichVideoPlayerPlugin a : this.aR) {
            richVideoPlayer.a(a);
        }
    }

    private void aE() {
        this.aJ.v = this.aQ;
        this.aJ.k();
        for (RichVideoPlayerPlugin a : this.aP) {
            this.aJ.a(a);
        }
        this.aJ.a(this.aK.f21974b);
        ((CustomLinearLayout) this.T).detachRecyclableViewFromParent(this.aJ);
        this.aJ.setLayoutParams(this.aS);
        this.aJ.requestLayout();
        this.aO.addView(this.aJ);
        this.aP.clear();
        this.aP = null;
        this.aQ = null;
        this.aS = null;
    }

    public final String am_() {
        return "video";
    }

    protected final Context ay() {
        return new ContextThemeWrapper(getContext(), 2131625259);
    }
}
