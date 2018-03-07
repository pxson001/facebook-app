package com.facebook.zero.upsell.ui;

import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.upsell.ui.handlers.UpsellDontShowAgainHandler;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.util.ZeroSharedPreferences;
import com.facebook.zero.util.FbZeroSharedPreferences;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: visit_insights_tab */
public class ZeroUpsellDontShowAgainHandler implements UpsellDontShowAgainHandler {
    private static final ImmutableSet<ZeroFeatureKey> f305a = ImmutableSet.of(ZeroFeatureKey.DIALTONE_PHOTO, ZeroFeatureKey.DIALTONE_MANUAL_SWITCHER_MODE);
    private ZeroSharedPreferences f306b;
    private FbZeroFeatureVisibilityHelper f307c;

    public static ZeroUpsellDontShowAgainHandler m343b(InjectorLike injectorLike) {
        return new ZeroUpsellDontShowAgainHandler((ZeroSharedPreferences) FbZeroSharedPreferences.a(injectorLike), FbZeroFeatureVisibilityHelper.a(injectorLike));
    }

    @Inject
    public ZeroUpsellDontShowAgainHandler(ZeroSharedPreferences zeroSharedPreferences, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper) {
        this.f306b = zeroSharedPreferences;
        this.f307c = fbZeroFeatureVisibilityHelper;
    }

    public final void m344a(ZeroFeatureKey zeroFeatureKey) {
        this.f306b.a().a(ZeroPrefKeys.a(zeroFeatureKey).toString(), false).a();
    }

    public final boolean m345b(ZeroFeatureKey zeroFeatureKey) {
        boolean z = this.f307c.a(ZeroFeatureKey.UPSELL_DONT_WARN_AGAIN) && !f305a.contains(zeroFeatureKey);
        if (!z) {
            return false;
        }
        String a = this.f306b.a("zero_rating2/clearable/interstitials_seen", "");
        for (String equals : a.split("\\s+")) {
            if (equals.equals(zeroFeatureKey.toString())) {
                return true;
            }
        }
        this.f306b.a().a("zero_rating2/clearable/interstitials_seen", a + " " + zeroFeatureKey.toString()).a();
        return false;
    }
}
