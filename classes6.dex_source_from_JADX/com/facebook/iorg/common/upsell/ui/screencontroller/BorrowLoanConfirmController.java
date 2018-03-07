package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.server.UpsellApiRequestManager;
import com.facebook.iorg.common.upsell.server.UpsellDialogScreenContent;
import com.facebook.iorg.common.upsell.ui.UpsellDialogButton;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.zero.interfaces.IorgAndroidThreadUtil;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.common.zero.interfaces.ZeroAnalyticsLogger;
import com.facebook.iorg.common.zero.interfaces.ZeroBroadcastManager;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.upsell.IorgFb4aAndroidThreadUtil;
import com.facebook.zero.upsell.IorgZeroFbBroadcastManager;
import com.facebook.zero.upsell.service.FbUpsellPromoServiceManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: logging_identifier */
public class BorrowLoanConfirmController extends AbstractUpsellDialogScreenController {
    private final IorgZeroFbBroadcastManager f11398c;
    private final Provider<Boolean> f11399d;
    public final IorgFb4aAnalyticsLogger f11400e;
    public final IorgFb4aAndroidThreadUtil f11401f;
    public final FbUpsellPromoServiceManager f11402g;

    @Inject
    public BorrowLoanConfirmController(ZeroBroadcastManager zeroBroadcastManager, Provider<Boolean> provider, ZeroAnalyticsLogger zeroAnalyticsLogger, IorgAndroidThreadUtil iorgAndroidThreadUtil, UpsellApiRequestManager upsellApiRequestManager) {
        this.f11398c = zeroBroadcastManager;
        this.f11399d = provider;
        this.f11400e = zeroAnalyticsLogger;
        this.f11401f = iorgAndroidThreadUtil;
        this.f11402g = upsellApiRequestManager;
    }

    public final View mo1077a(Context context) {
        this.f11400e.a(UpsellsAnalyticsEvent.j, m18193e());
        if (!((Boolean) this.f11399d.get()).booleanValue()) {
            this.f11398c.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.UPSELL));
        }
        UpsellDialogScreenContent upsellDialogScreenContent = (UpsellDialogScreenContent) this.f11391a.ax.f11311d.get(1);
        UpsellDialogViewModel a = m18194f().m18126a(upsellDialogScreenContent.f11283a);
        a.f11255c = upsellDialogScreenContent.f11284b;
        UpsellDialogViewModel b = a.m18127a(upsellDialogScreenContent.f11285c, (OnClickListener) new PromoPurchaseOnClickListener(this, this.f11391a, this.f11401f, this.f11400e, this.f11402g) {
            final /* synthetic */ BorrowLoanConfirmController f11397a;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1908927118);
                ((UpsellDialogButton) view).m18152a();
                view.setEnabled(false);
                super.onClick(view);
                Logger.a(2, EntryType.UI_INPUT_END, 1948881477, a);
            }

            protected final String mo1074a() {
                return this.f11397a.f11391a.ax.f11310c.f11292e;
            }

            protected final PromoLocation mo1075b() {
                return this.f11397a.f11392b.f11252i;
            }
        }).m18129b(upsellDialogScreenContent.f11286d, m18191c());
        View upsellDialogView = new UpsellDialogView(context);
        upsellDialogView.m18174a(b);
        return upsellDialogView;
    }
}
