package com.facebook.composer.tip;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.facebook.analytics.NavigationLogger;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.10;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.minutiae.abtest.ExperimentsForMinutiaeAbTestModule;
import com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.tooltip.Tooltip.OnTooltipClickListener;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMinutiaeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_location */
public class MinutiaeNuxBubbleInterstitialController<DataProvider extends ProvidesIsMinutiaeSupported & ProvidesSessionId & ProvidesConfiguration> implements ComposerInterstitialTip {
    public final TipSeenTracker f17016a;
    private final ActivityPickerAnalyticsLogger f17017b;
    private final QeAccessor f17018c;
    public Context f17019d;
    public View f17020e;
    private Tooltip f17021f;
    public DataProvider f17022g;
    public 10 f17023h;

    /* compiled from: composer_location */
    class C13741 implements OnTooltipClickListener {
        final /* synthetic */ MinutiaeNuxBubbleInterstitialController f17015a;

        C13741(MinutiaeNuxBubbleInterstitialController minutiaeNuxBubbleInterstitialController) {
            this.f17015a = minutiaeNuxBubbleInterstitialController;
        }

        public final void m20958a() {
            if (this.f17015a.f17023h != null) {
                10 10 = this.f17015a.f17023h;
                ((NavigationLogger) 10.a.ap.get()).a("tap_composer_footer_buttons");
                ComposerFragment.bT(10.a);
            }
            this.f17015a.m20967a(true);
        }
    }

    @Inject
    public MinutiaeNuxBubbleInterstitialController(TipSeenTracker tipSeenTracker, ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger, QeAccessor qeAccessor) {
        this.f17016a = tipSeenTracker;
        this.f17017b = activityPickerAnalyticsLogger;
        this.f17018c = qeAccessor;
    }

    private boolean m20959d() {
        return this.f17022g != null;
    }

    public final void m20964a() {
        this.f17020e = null;
        this.f17019d = null;
        this.f17022g = null;
        this.f17023h = null;
        this.f17021f = null;
    }

    public final void hG_() {
        CharSequence a = this.f17018c.a(ExperimentsForMinutiaeAbTestModule.f1456b, null);
        Preconditions.checkState(m20959d());
        boolean z = m20961f() && a != null;
        Preconditions.checkState(z, "Invalid QE Config");
        this.f17021f = new Tooltip(this.f17019d, 2);
        this.f17021f.b(a);
        this.f17021f.t = -1;
        this.f17021f.a(new C13741(this));
        this.f17021f.a(Position.ABOVE);
        this.f17021f.f(this.f17020e);
        ActivityPickerAnalyticsLogger activityPickerAnalyticsLogger = this.f17017b;
        String ab = ((ProvidesSessionId) this.f17022g).ab();
        String e = m20960e();
        activityPickerAnalyticsLogger.m1545d(ab, e);
        activityPickerAnalyticsLogger.f1460a.a(ActivityPickerAnalyticsLogger.m1540f("minutiae_reshare_nux_shown", ab).f(e).a);
    }

    public final void m20967a(boolean z) {
        Preconditions.checkState(m20959d());
        if (this.f17021f != null && this.f17021f.r) {
            this.f17021f.l();
            this.f17021f = null;
        }
        if (z) {
            this.f17016a.a();
        }
    }

    public final boolean hH_() {
        if (this.f17021f == null) {
            return false;
        }
        return this.f17021f.r;
    }

    public final String m20968b() {
        return "2923";
    }

    public final void m20966a(@Nullable Parcelable parcelable) {
    }

    public final void m20965a(long j) {
    }

    public final InterstitialControllerState m20963a(InterstitialTrigger interstitialTrigger) {
        if (!m20959d()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (this.f17020e == null || this.f17020e.getVisibility() != 0 || this.f17020e.getWindowToken() == null) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (!this.f17016a.c()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        Object obj = (((ProvidesConfiguration) this.f17022g).o().getComposerType() == ComposerType.SHARE && this.f17022g.J()) ? 1 : null;
        if (obj == null) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (m20961f()) {
            return InterstitialControllerState.ELIGIBLE;
        }
        this.f17017b.m1545d(((ProvidesSessionId) this.f17022g).ab(), m20960e());
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m20969c() {
        return ImmutableList.of(new InterstitialTrigger(Action.COMPOSER));
    }

    public final long hI_() {
        return 0;
    }

    public final ComposerTip$Action m20962a(ComposerEvent composerEvent) {
        return ComposerTip$Action.NONE;
    }

    private String m20960e() {
        return this.f17018c.a(ExperimentsForMinutiaeAbTestModule.f1458d, null);
    }

    private boolean m20961f() {
        return this.f17018c.a(ExperimentsForMinutiaeAbTestModule.f1457c, false);
    }
}
