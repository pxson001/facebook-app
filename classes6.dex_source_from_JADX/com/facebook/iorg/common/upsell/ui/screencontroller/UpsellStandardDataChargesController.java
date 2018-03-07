package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.view.View;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

/* compiled from: locationAttachment */
public class UpsellStandardDataChargesController extends AbstractUpsellDialogScreenController {
    private final IorgFb4aAnalyticsLogger f11436c;

    @Inject
    public UpsellStandardDataChargesController(IorgFb4aAnalyticsLogger iorgFb4aAnalyticsLogger) {
        this.f11436c = iorgFb4aAnalyticsLogger;
    }

    public final View mo1077a(Context context) {
        this.f11436c.a(UpsellsAnalyticsEvent.a);
        UpsellDialogViewModel f = m18194f();
        f.f11255c = this.f11392b.f11247d;
        UpsellDialogViewModel b = f.m18129b(this.f11391a.b(2131232866), m18191c());
        ZeroFeatureKey zeroFeatureKey = this.f11391a.ar;
        String b2 = this.f11391a.b(2131232867);
        if (zeroFeatureKey == ZeroFeatureKey.DIALTONE_PHOTO || zeroFeatureKey == ZeroFeatureKey.DIALTONE_PHOTO_CAPPING || zeroFeatureKey == ZeroFeatureKey.DIALTONE_FEED_CAPPING || zeroFeatureKey == ZeroFeatureKey.DIALTONE_FACEWEB) {
            b2 = this.f11391a.b(2131232872);
        }
        b.m18127a(b2, mo1079d());
        View upsellDialogView = new UpsellDialogView(context);
        upsellDialogView.m18174a(b);
        return upsellDialogView;
    }
}
