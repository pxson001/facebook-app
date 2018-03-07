package com.facebook.composer.minutiae.interstitial;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.facebook.common.util.TriState;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialIntentController;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: toControlY */
public class RidgeInterstitialController implements InterstitialIntentController {
    private final Provider<TriState> f1564a;
    public final RidgeOptInController f1565b;
    public final RidgeAnalyticsLogger f1566c;

    public static RidgeInterstitialController m1621b(InjectorLike injectorLike) {
        return new RidgeInterstitialController(IdBasedProvider.a(injectorLike, 637), RidgeOptInController.m1822b(injectorLike), RidgeAnalyticsLogger.m1552a(injectorLike));
    }

    public final Optional<Intent> m1625a(int i, Intent intent) {
        return Absent.INSTANCE;
    }

    @Inject
    public RidgeInterstitialController(Provider<TriState> provider, RidgeOptInController ridgeOptInController, RidgeAnalyticsLogger ridgeAnalyticsLogger) {
        this.f1564a = provider;
        this.f1565b = ridgeOptInController;
        this.f1566c = ridgeAnalyticsLogger;
    }

    public final String m1628b() {
        return "2326";
    }

    public final void m1627a(@Nullable Parcelable parcelable) {
    }

    public final void m1626a(long j) {
    }

    public final InterstitialControllerState m1624a(InterstitialTrigger interstitialTrigger) {
        if (!((TriState) this.f1564a.get()).asBoolean(false) || this.f1565b.m1832j()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m1629c() {
        return ImmutableList.of(new InterstitialTrigger(Action.MINUTIAE_TAG_PICKER));
    }

    public final Intent m1623a(Context context) {
        return new Intent(context, RidgeInterstitialActivity.class);
    }

    public final long hI_() {
        return 0;
    }

    public static int m1622d() {
        return 101;
    }
}
