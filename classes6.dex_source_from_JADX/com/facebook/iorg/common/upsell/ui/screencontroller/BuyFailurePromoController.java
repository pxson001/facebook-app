package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.server.UpsellDialogScreenContent;
import com.facebook.iorg.common.upsell.server.ZeroPromoResult;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.common.zero.interfaces.ZeroAnalyticsLogger;
import com.facebook.iorg.common.zero.interfaces.ZeroBroadcastManager;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.upsell.IorgZeroFbBroadcastManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: logger_creation_time */
public class BuyFailurePromoController extends AbstractUpsellDialogScreenController {
    private final IorgZeroFbBroadcastManager f11407c;
    private final Provider<Boolean> f11408d;
    private final IorgFb4aAnalyticsLogger f11409e;
    private final FbZeroFeatureVisibilityHelper f11410f;

    @Inject
    public BuyFailurePromoController(ZeroBroadcastManager zeroBroadcastManager, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, Provider<Boolean> provider, ZeroAnalyticsLogger zeroAnalyticsLogger) {
        this.f11407c = zeroBroadcastManager;
        this.f11410f = zeroFeatureVisibilityHelper;
        this.f11408d = provider;
        this.f11409e = zeroAnalyticsLogger;
    }

    public final View mo1077a(Context context) {
        this.f11409e.a(UpsellsAnalyticsEvent.f, m18193e());
        if (!((Boolean) this.f11408d.get()).booleanValue()) {
            this.f11407c.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.UPSELL));
        }
        ZeroPromoResult zeroPromoResult = this.f11391a.ax;
        UpsellDialogViewModel f = m18194f();
        if (zeroPromoResult == null) {
            String b;
            if (this.f11392b == null || StringUtil.a(this.f11392b.f11245b)) {
                b = this.f11391a.b(2131232860);
            } else {
                b = this.f11392b.f11245b;
            }
            UpsellDialogViewModel a = f.m18128a(b, true);
            if (this.f11392b == null || StringUtil.a(this.f11392b.f11247d)) {
                b = this.f11391a.b(2131232861);
            } else {
                b = this.f11392b.f11247d;
            }
            a.f11255c = b;
            a = a;
            if (this.f11392b == null || StringUtil.a(this.f11392b.f11250g)) {
                b = this.f11391a.b(2131232862);
            } else {
                b = this.f11392b.f11250g;
            }
            a.m18129b(b, m18191c());
        } else {
            UpsellDialogScreenContent c = zeroPromoResult.m18137c();
            UpsellDialogViewModel a2 = f.m18126a(c.f11283a);
            a2.f11255c = c.f11284b;
            a2.m18127a(c.f11285c, m18191c()).m18129b(c.f11286d, mo1079d());
        }
        View upsellDialogView = new UpsellDialogView(context);
        upsellDialogView.m18174a(f);
        return upsellDialogView;
    }
}
