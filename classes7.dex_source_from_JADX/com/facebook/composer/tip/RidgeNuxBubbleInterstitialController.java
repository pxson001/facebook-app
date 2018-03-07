package com.facebook.composer.tip;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.facebook.common.util.TriState;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: composer_hint */
public class RidgeNuxBubbleInterstitialController<DataProvider extends ProvidesTargetAlbum & ProvidesConfiguration & ProvidesTargetData & ProvidesMinutiae> implements ComposerInterstitialTip {
    public final TipSeenTracker f17026a;
    private final Provider<TriState> f17027b;
    private final RidgeOptInController f17028c;
    public Context f17029d;
    public View f17030e;
    private Tooltip f17031f;
    public DataProvider f17032g;

    /* compiled from: composer_hint */
    class C13761 implements OnTooltipClickListener {
        final /* synthetic */ RidgeNuxBubbleInterstitialController f17025a;

        C13761(RidgeNuxBubbleInterstitialController ridgeNuxBubbleInterstitialController) {
            this.f17025a = ridgeNuxBubbleInterstitialController;
        }

        public final void m20972a() {
            this.f17025a.m20979a(true);
        }
    }

    @Inject
    public RidgeNuxBubbleInterstitialController(TipSeenTracker tipSeenTracker, Provider<TriState> provider, RidgeOptInController ridgeOptInController) {
        this.f17027b = provider;
        this.f17026a = tipSeenTracker;
        this.f17028c = ridgeOptInController;
    }

    private boolean m20973d() {
        return this.f17029d != null;
    }

    public final void m20976a() {
        this.f17030e = null;
        this.f17029d = null;
        this.f17032g = null;
        this.f17031f = null;
    }

    public final void hG_() {
        Preconditions.checkState(m20973d());
        this.f17031f = new Tooltip(this.f17029d, 2);
        this.f17031f.b(this.f17029d.getResources().getString(2131234696));
        this.f17031f.t = -1;
        this.f17031f.a(new C13761(this));
        this.f17031f.a(Position.ABOVE);
        this.f17031f.f(this.f17030e);
    }

    public final void m20979a(boolean z) {
        Preconditions.checkState(m20973d());
        if (this.f17031f != null && this.f17031f.r) {
            this.f17031f.l();
            this.f17031f = null;
        }
        if (z) {
            this.f17026a.a();
        }
    }

    public final boolean hH_() {
        if (this.f17031f == null) {
            return false;
        }
        return this.f17031f.r;
    }

    public final String m20980b() {
        return "2377";
    }

    public final void m20978a(Parcelable parcelable) {
    }

    public final void m20977a(long j) {
    }

    public final InterstitialControllerState m20975a(InterstitialTrigger interstitialTrigger) {
        if (!m20973d()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (!this.f17026a.c()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (this.f17028c.m1827c()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (this.f17030e == null || this.f17030e.getVisibility() != 0 || this.f17030e.getWindowToken() == null) {
            return InterstitialControllerState.INELIGIBLE;
        }
        boolean z = (((ProvidesTargetData) this.f17032g).s().targetType == TargetType.UNDIRECTED || ((ProvidesTargetData) this.f17032g).s().targetType == TargetType.USER) && ((TriState) this.f17027b.get()).asBoolean(false) && ((ProvidesMinutiae) this.f17032g).l() == null && this.f17032g.ad() == null && ((ProvidesConfiguration) this.f17032g).o().getComposerType() != ComposerType.SHARE;
        if (z) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m20981c() {
        return ImmutableList.of(new InterstitialTrigger(Action.COMPOSER));
    }

    public final long hI_() {
        return 0;
    }

    public final ComposerTip$Action m20974a(ComposerEvent composerEvent) {
        return ComposerTip$Action.NONE;
    }
}
