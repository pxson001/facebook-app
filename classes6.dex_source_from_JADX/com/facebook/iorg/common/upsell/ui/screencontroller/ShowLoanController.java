package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.server.UpsellDialogScreenContent;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.common.zero.interfaces.ZeroAnalyticsLogger;
import com.facebook.iorg.common.zero.interfaces.ZeroBroadcastManager;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.upsell.IorgZeroFbBroadcastManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: locationSettingsRequest can't be null nor empty. */
public class ShowLoanController extends AbstractUpsellDialogScreenController {
    private final IorgZeroFbBroadcastManager f11433c;
    private final Provider<Boolean> f11434d;
    private final IorgFb4aAnalyticsLogger f11435e;

    @Inject
    public ShowLoanController(ZeroBroadcastManager zeroBroadcastManager, Provider<Boolean> provider, ZeroAnalyticsLogger zeroAnalyticsLogger) {
        this.f11433c = zeroBroadcastManager;
        this.f11434d = provider;
        this.f11435e = zeroAnalyticsLogger;
    }

    public final View mo1077a(Context context) {
        this.f11435e.a(UpsellsAnalyticsEvent.b, m18193e());
        if (!((Boolean) this.f11434d.get()).booleanValue()) {
            this.f11433c.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.UPSELL));
        }
        UpsellDialogScreenContent c = this.f11391a.ax.m18137c();
        UpsellDialogViewModel a = m18194f().m18126a(c.f11283a);
        a.f11255c = c.f11284b;
        UpsellDialogViewModel c2 = a.m18127a(c.f11285c, m18186a(Screen.BORROW_LOAN_CONFIRM)).m18129b(c.f11286d, mo1079d()).m18130c(c.f11287e, m18191c());
        View upsellDialogView = new UpsellDialogView(context);
        upsellDialogView.m18174a(c2);
        return upsellDialogView;
    }
}
