package com.facebook.feedback.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import com.facebook.common.executors.ForUiThread;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: right item's drawable hierarchy was not properly set up */
public class VideoCommentInterstitialController implements InterstitialController {
    private static final PrefKey f4796a = ((PrefKey) SharedPrefKeys.a.a("feedback/VIDEO_COMMENT_NUX"));
    public final Context f4797b;
    public final TipSeenTracker f4798c;
    @ForUiThread
    public final Handler f4799d;
    public Runnable f4800e;
    public Tooltip f4801f;
    public boolean f4802g;
    public View f4803h;

    /* compiled from: right item's drawable hierarchy was not properly set up */
    public class C04701 implements OnTooltipClickListener {
        final /* synthetic */ VideoCommentInterstitialController f4794a;

        public C04701(VideoCommentInterstitialController videoCommentInterstitialController) {
            this.f4794a = videoCommentInterstitialController;
        }

        public final void m5327a() {
            VideoCommentInterstitialController videoCommentInterstitialController = this.f4794a;
            HandlerDetour.a(videoCommentInterstitialController.f4799d, videoCommentInterstitialController.f4800e);
            videoCommentInterstitialController.f4801f.l();
        }
    }

    /* compiled from: right item's drawable hierarchy was not properly set up */
    public class C04712 implements Runnable {
        final /* synthetic */ VideoCommentInterstitialController f4795a;

        public C04712(VideoCommentInterstitialController videoCommentInterstitialController) {
            this.f4795a = videoCommentInterstitialController;
        }

        public void run() {
            if (this.f4795a.f4801f != null) {
                this.f4795a.f4801f.f(this.f4795a.f4803h);
            }
        }
    }

    @Inject
    public VideoCommentInterstitialController(Context context, TipSeenTracker tipSeenTracker, Handler handler) {
        this.f4797b = context;
        this.f4798c = tipSeenTracker;
        this.f4798c.a(f4796a);
        this.f4799d = handler;
    }

    public final String m5331b() {
        return "4181";
    }

    public final void m5330a(Parcelable parcelable) {
    }

    public final void m5329a(long j) {
    }

    public final InterstitialControllerState m5328a(InterstitialTrigger interstitialTrigger) {
        if (this.f4802g && this.f4798c.c()) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m5332c() {
        return ImmutableList.of(CommentComposerNuxHelper.f4192a);
    }

    public final long hI_() {
        return 0;
    }
}
