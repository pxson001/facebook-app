package com.facebook.composer.tip;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: composer_profile_details_fetch_error */
public class FeedOnlyPostInterstitialController implements ComposerInterstitialTip {
    public final TipSeenTracker f16997a;
    public Context f16998b;
    public View f16999c;
    private Tooltip f17000d;

    /* compiled from: composer_profile_details_fetch_error */
    class C13691 implements OnTooltipClickListener {
        final /* synthetic */ FeedOnlyPostInterstitialController f16996a;

        C13691(FeedOnlyPostInterstitialController feedOnlyPostInterstitialController) {
            this.f16996a = feedOnlyPostInterstitialController;
        }

        public final void m20941a() {
            this.f16996a.m20948a(true);
        }
    }

    @Inject
    public FeedOnlyPostInterstitialController(TipSeenTracker tipSeenTracker) {
        this.f16997a = tipSeenTracker;
    }

    public final long hI_() {
        return 0;
    }

    private boolean m20942d() {
        return this.f16998b != null;
    }

    public final void hG_() {
        Preconditions.checkState(m20942d());
        this.f17000d = new Tooltip(this.f16998b, 2);
        this.f17000d.b(2131234791);
        this.f17000d.a(Position.ABOVE);
        this.f17000d.t = -1;
        this.f17000d.a(new C13691(this));
        this.f17000d.f(this.f16999c);
    }

    public final void m20948a(boolean z) {
        Preconditions.checkState(m20942d());
        if (this.f17000d != null && this.f17000d.r) {
            this.f17000d.l();
            this.f17000d = null;
        }
        if (z) {
            this.f16997a.a();
        }
    }

    public final ComposerTip$Action m20943a(ComposerEvent composerEvent) {
        return ComposerTip$Action.NONE;
    }

    public final String m20949b() {
        return "4155";
    }

    public final void m20947a(Parcelable parcelable) {
    }

    public final void m20946a(long j) {
    }

    public final InterstitialControllerState m20944a(InterstitialTrigger interstitialTrigger) {
        if (!m20942d()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (this.f16997a.c()) {
            return this.f16999c != null ? InterstitialControllerState.ELIGIBLE : InterstitialControllerState.INELIGIBLE;
        } else {
            return InterstitialControllerState.INELIGIBLE;
        }
    }

    public final ImmutableList<InterstitialTrigger> m20950c() {
        return ImmutableList.of(new InterstitialTrigger(Action.COMPOSER));
    }

    public final void m20945a() {
        this.f16999c = null;
        this.f16998b = null;
        this.f17000d = null;
    }

    public final boolean hH_() {
        if (this.f17000d == null) {
            return false;
        }
        return this.f17000d.r;
    }
}
