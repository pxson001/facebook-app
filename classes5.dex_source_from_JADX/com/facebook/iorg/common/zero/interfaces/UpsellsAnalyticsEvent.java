package com.facebook.iorg.common.zero.interfaces;

import javax.annotation.Nullable;

/* compiled from: TOPICS */
public class UpsellsAnalyticsEvent extends ZeroAnalyticsEventShim {
    public static final UpsellsAnalyticsEvent f13895a = new UpsellsAnalyticsEvent("upsell_standard_data_impression");
    public static final UpsellsAnalyticsEvent f13896b = new UpsellsAnalyticsEvent("upsell_show_loan_impression");
    public static final UpsellsAnalyticsEvent f13897c = new UpsellsAnalyticsEvent("upsell_buy_attempt");
    public static final UpsellsAnalyticsEvent f13898d = new UpsellsAnalyticsEvent("upsell_buy_confirm_impression");
    public static final UpsellsAnalyticsEvent f13899e = new UpsellsAnalyticsEvent("upsell_buy_maybe_impression");
    public static final UpsellsAnalyticsEvent f13900f = new UpsellsAnalyticsEvent("upsell_buy_failure_impression");
    public static final UpsellsAnalyticsEvent f13901g = new UpsellsAnalyticsEvent("upsell_buy_success_impression");
    public static final UpsellsAnalyticsEvent f13902h = new UpsellsAnalyticsEvent("upsell_interstitial_impression");
    public static final UpsellsAnalyticsEvent f13903i = new UpsellsAnalyticsEvent("upsell_continue_with_current_promo");
    public static final UpsellsAnalyticsEvent f13904j = new UpsellsAnalyticsEvent("upsell_borrow_loan_confirm_impression");
    public static final UpsellsAnalyticsEvent f13905k = new UpsellsAnalyticsEvent("click", "zero_extra_charges_dialog");
    public static final UpsellsAnalyticsEvent f13906l = new UpsellsAnalyticsEvent("click", "zero_upsell_dialog");
    public static final UpsellsAnalyticsEvent f13907m = new UpsellsAnalyticsEvent("upsell_carrier_external_portal_click");

    private UpsellsAnalyticsEvent(String str) {
        super(str, null);
    }

    private UpsellsAnalyticsEvent(String str, @Nullable String str2) {
        super(str, str2);
    }
}
