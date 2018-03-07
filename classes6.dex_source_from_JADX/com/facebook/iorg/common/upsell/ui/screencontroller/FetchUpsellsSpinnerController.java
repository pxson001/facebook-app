package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.view.View;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.iorg.common.upsell.annotations.IsInZeroUpsellShowUseDataOrStayFreeScreenGateKeeper;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.iorg.common.upsell.server.UpsellApiRequestManager;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.zero.constants.ZeroDialogFailureReason;
import com.facebook.iorg.common.zero.eventbus.events.ZeroDialogActionEvent;
import com.facebook.iorg.common.zero.eventbus.events.ZeroDialogActionEvent.ActionType;
import com.facebook.iorg.common.zero.interfaces.IorgAndroidThreadUtil;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.common.zero.interfaces.ZeroAnalyticsLogger;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.upsell.IorgFb4aAndroidThreadUtil;
import com.facebook.zero.upsell.service.FbUpsellPromoServiceManager;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: location_age_ms */
public class FetchUpsellsSpinnerController extends AbstractUpsellDialogScreenController {
    public final IorgFb4aAndroidThreadUtil f11418c;
    private final IorgFb4aAnalyticsLogger f11419d;
    private final FbZeroFeatureVisibilityHelper f11420e;
    public final FbUpsellPromoServiceManager f11421f;
    @IsInZeroUpsellShowUseDataOrStayFreeScreenGateKeeper
    public final Provider<Boolean> f11422g;

    /* compiled from: location_age_ms */
    public class C07211 implements FutureCallback<ZeroRecommendedPromoResult> {
        final /* synthetic */ FetchUpsellsSpinnerController f11417a;

        public C07211(FetchUpsellsSpinnerController fetchUpsellsSpinnerController) {
            this.f11417a = fetchUpsellsSpinnerController;
        }

        public void onSuccess(@Nullable Object obj) {
            ZeroRecommendedPromoResult zeroRecommendedPromoResult = (ZeroRecommendedPromoResult) obj;
            if (this.f11417a.f11391a != null) {
                if (zeroRecommendedPromoResult == null || !StringUtil.a(zeroRecommendedPromoResult.f11330i) || zeroRecommendedPromoResult.f11324c == null || zeroRecommendedPromoResult.f11324c.size() == 0) {
                    FetchUpsellsSpinnerController.m18208h(this.f11417a);
                    return;
                }
                this.f11417a.f11391a.aw = zeroRecommendedPromoResult;
                if (((Boolean) this.f11417a.f11422g.get()).booleanValue()) {
                    this.f11417a.f11391a.m18170a(Screen.USE_DATA_OR_STAY_IN_FREE);
                } else {
                    this.f11417a.f11391a.m18170a(Screen.PROMOS_LIST);
                }
            }
        }

        public void onFailure(Throwable th) {
            FetchUpsellsSpinnerController.m18208h(this.f11417a);
        }
    }

    @Inject
    public FetchUpsellsSpinnerController(IorgAndroidThreadUtil iorgAndroidThreadUtil, ZeroAnalyticsLogger zeroAnalyticsLogger, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, UpsellApiRequestManager upsellApiRequestManager, Provider<Boolean> provider) {
        this.f11418c = iorgAndroidThreadUtil;
        this.f11419d = zeroAnalyticsLogger;
        this.f11420e = zeroFeatureVisibilityHelper;
        this.f11421f = upsellApiRequestManager;
        this.f11422g = provider;
    }

    public final View mo1077a(Context context) {
        this.f11419d.a(UpsellsAnalyticsEvent.h, m18193e());
        View upsellDialogView = new UpsellDialogView(context);
        upsellDialogView.m18173a();
        if (this.f11420e.a(ZeroFeatureKey.NATIVE_UPSELL_INTERSTITIAL)) {
            this.f11418c.a(this.f11421f.a(new ZeroRecommendedPromoParams(2, SizeUtil.a(this.f11391a.jW_()), false, PromoLocation.INTERSTITIAL, this.f11391a.ar)), new C07211(this));
        } else {
            this.f11391a.m18170a(Screen.STANDARD_DATA_CHARGES_APPLY);
        }
        return upsellDialogView;
    }

    public static void m18208h(FetchUpsellsSpinnerController fetchUpsellsSpinnerController) {
        if (fetchUpsellsSpinnerController.f11391a != null) {
            UpsellDialogFragment upsellDialogFragment = fetchUpsellsSpinnerController.f11391a;
            upsellDialogFragment.ao.a(new ZeroDialogActionEvent(upsellDialogFragment.ar, ActionType.FAILURE, upsellDialogFragment.at, upsellDialogFragment.as, ZeroDialogFailureReason.UPSELL_FAILURE));
            upsellDialogFragment.ap();
        }
    }
}
