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

/* compiled from: log_exposure */
public class BuyMaybeController extends AbstractUpsellDialogScreenController {
    private final IorgZeroFbBroadcastManager f11411c;
    private final Provider<Boolean> f11412d;
    private final IorgFb4aAnalyticsLogger f11413e;

    @Inject
    public BuyMaybeController(ZeroBroadcastManager zeroBroadcastManager, Provider<Boolean> provider, ZeroAnalyticsLogger zeroAnalyticsLogger) {
        this.f11411c = zeroBroadcastManager;
        this.f11412d = provider;
        this.f11413e = zeroAnalyticsLogger;
    }

    public final View mo1077a(Context context) {
        this.f11413e.a(UpsellsAnalyticsEvent.e, m18193e());
        if (!((Boolean) this.f11412d.get()).booleanValue()) {
            this.f11411c.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.UPSELL));
        }
        UpsellDialogScreenContent c = this.f11391a.ax.m18137c();
        UpsellDialogViewModel a = m18194f().m18126a(c.f11283a);
        a.f11255c = c.f11284b;
        UpsellDialogViewModel a2 = a.m18127a(c.f11285c, m18191c());
        View upsellDialogView = new UpsellDialogView(context);
        upsellDialogView.m18174a(a2);
        return upsellDialogView;
    }
}
