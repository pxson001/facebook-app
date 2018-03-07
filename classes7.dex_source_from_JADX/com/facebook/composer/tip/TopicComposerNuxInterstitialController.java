package com.facebook.composer.tip;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_event_tab */
public class TopicComposerNuxInterstitialController implements ComposerInterstitialTip {
    public final TipSeenTracker f17065a;
    public final TopicFeedsTestUtil f17066b;
    public Context f17067c;
    private Tooltip f17068d;
    public ViewGroup f17069e;

    @Inject
    public TopicComposerNuxInterstitialController(TipSeenTracker tipSeenTracker, TopicFeedsTestUtil topicFeedsTestUtil) {
        this.f17065a = tipSeenTracker;
        this.f17066b = topicFeedsTestUtil;
    }

    private boolean m21012d() {
        return this.f17067c != null;
    }

    public final void m21015a() {
        this.f17067c = null;
        this.f17068d = null;
        this.f17069e = null;
    }

    public final void hG_() {
        Preconditions.checkState(m21012d());
        View findViewById = this.f17069e.findViewById(2131560646);
        if (findViewById != null) {
            this.f17068d = new Tooltip(this.f17067c, 2);
            this.f17068d.t = -1;
            this.f17068d.b(this.f17067c.getResources().getString(2131234785));
            this.f17068d.f(findViewById);
        }
    }

    public final void m21018a(boolean z) {
        Preconditions.checkState(m21012d());
        if (this.f17068d != null && this.f17068d.r) {
            this.f17068d.l();
            this.f17068d = null;
        }
        if (z) {
            this.f17065a.a();
        }
    }

    public final boolean hH_() {
        if (this.f17068d == null) {
            return false;
        }
        return this.f17068d.r;
    }

    public final String m21019b() {
        return "4096";
    }

    public final void m21017a(@Nullable Parcelable parcelable) {
    }

    public final void m21016a(long j) {
    }

    public final InterstitialControllerState m21014a(InterstitialTrigger interstitialTrigger) {
        if (m21012d() && this.f17065a.c() && this.f17066b.d()) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m21020c() {
        return ImmutableList.of(new InterstitialTrigger(Action.COMPOSER));
    }

    public final long hI_() {
        return 86400000;
    }

    public final ComposerTip$Action m21013a(ComposerEvent composerEvent) {
        return ComposerTip$Action.SHOW;
    }
}
