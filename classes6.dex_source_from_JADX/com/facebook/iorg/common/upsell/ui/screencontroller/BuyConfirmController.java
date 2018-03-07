package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.ui.UpsellDialogButton;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.zero.upsell.IorgFb4aAndroidThreadUtil;
import com.facebook.zero.upsell.service.FbUpsellPromoServiceManager;
import javax.inject.Inject;

/* compiled from: logging_event_time */
public class BuyConfirmController extends AbstractUpsellDialogScreenController {
    public final IorgFb4aAndroidThreadUtil f11404c;
    public final IorgFb4aAnalyticsLogger f11405d;
    public final FbUpsellPromoServiceManager f11406e;

    @Inject
    public BuyConfirmController(IorgFb4aAndroidThreadUtil iorgFb4aAndroidThreadUtil, IorgFb4aAnalyticsLogger iorgFb4aAnalyticsLogger, FbUpsellPromoServiceManager fbUpsellPromoServiceManager) {
        this.f11404c = iorgFb4aAndroidThreadUtil;
        this.f11405d = iorgFb4aAnalyticsLogger;
        this.f11406e = fbUpsellPromoServiceManager;
    }

    public final View mo1077a(Context context) {
        this.f11405d.a(UpsellsAnalyticsEvent.d, m18193e());
        UpsellDialogView upsellDialogView = new UpsellDialogView(context);
        mo1078a(upsellDialogView);
        return upsellDialogView;
    }

    public final void mo1078a(UpsellDialogView upsellDialogView) {
        UpsellDialogViewModel f = m18194f();
        String str = this.f11392b.f11247d;
        String str2 = this.f11392b.f11249f;
        String str3 = this.f11392b.f11248e;
        String str4 = this.f11392b.f11251h;
        f.f11257e = str;
        f.f11258f = str2;
        f.f11259g = str3;
        f.f11260h = str4;
        upsellDialogView.m18174a(f.m18127a(this.f11392b.f11250g, (OnClickListener) new PromoPurchaseOnClickListener(this, this.f11391a, this.f11404c, this.f11405d, this.f11406e) {
            final /* synthetic */ BuyConfirmController f11403a;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1948138615);
                ((UpsellDialogButton) view).m18152a();
                view.setEnabled(false);
                View view2 = this.f11403a.f11391a.T;
                if (view2 != null) {
                    view2 = view2.findViewById(2131568212);
                    if (view2 != null) {
                        view2.setEnabled(false);
                    }
                }
                super.onClick(view);
                Logger.a(2, EntryType.UI_INPUT_END, 173567412, a);
            }

            protected final String mo1074a() {
                return this.f11403a.f11392b.f11244a;
            }

            protected final PromoLocation mo1075b() {
                return this.f11403a.f11392b.f11252i;
            }
        }).m18129b(this.f11391a.b(2131232865), m18186a(Screen.PROMOS_LIST)).m18125a(Boolean.valueOf(true)));
    }
}
