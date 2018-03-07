package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.server.UpsellDialogScreenContent;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.common.zero.interfaces.ZeroAnalyticsLogger;
import com.facebook.iorg.common.zero.interfaces.ZeroBroadcastManager;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.upsell.IorgZeroFbBroadcastManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: log_api_requests */
public class BuySuccessController extends AbstractUpsellDialogScreenController {
    private final IorgZeroFbBroadcastManager f11414c;
    private final Provider<Boolean> f11415d;
    private final IorgFb4aAnalyticsLogger f11416e;

    @Inject
    public BuySuccessController(ZeroBroadcastManager zeroBroadcastManager, Provider<Boolean> provider, ZeroAnalyticsLogger zeroAnalyticsLogger) {
        this.f11414c = zeroBroadcastManager;
        this.f11415d = provider;
        this.f11416e = zeroAnalyticsLogger;
    }

    public final View mo1077a(Context context) {
        this.f11416e.a(UpsellsAnalyticsEvent.g, m18193e());
        if (!((Boolean) this.f11415d.get()).booleanValue()) {
            this.f11414c.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.UPSELL));
        }
        UpsellDialogScreenContent c = this.f11391a.ax.m18137c();
        UpsellDialogViewModel a = m18194f().m18126a(c.f11283a);
        a.f11255c = c.f11284b;
        UpsellDialogViewModel a2 = a.m18127a(c.f11285c, mo1079d());
        View upsellDialogView = new UpsellDialogView(context);
        upsellDialogView.m18174a(a2);
        return upsellDialogView;
    }
}
