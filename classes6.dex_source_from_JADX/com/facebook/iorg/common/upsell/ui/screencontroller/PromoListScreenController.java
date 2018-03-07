package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.common.util.StringUtil;
import com.facebook.iorg.common.upsell.annotations.IsInZeroUpsellShowUseDataOrStayFreeScreenGateKeeper;
import com.facebook.iorg.common.upsell.model.PromoDataModel;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.model.UpsellListViewModel;
import com.facebook.iorg.common.upsell.server.UpsellPromo;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.iorg.common.upsell.ui.UpsellDialogActionList;
import com.facebook.iorg.common.upsell.ui.UpsellDialogActionList.UpsellDialogActionRow;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.upsell.ui.UpsellDialogList;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.iorg.common.upsell.ui.handlers.UpsellDontShowAgainHandler;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.common.zero.interfaces.ZeroAnalyticsLogger;
import com.facebook.iorg.common.zero.interfaces.ZeroFeatureVisibilityHelper;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.zero.FbZeroFeatureVisibilityHelper;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: location_accuracy */
public class PromoListScreenController extends AbstractUpsellDialogScreenController {
    public final IorgFb4aAnalyticsLogger f11425c;
    @IsInZeroUpsellShowUseDataOrStayFreeScreenGateKeeper
    private final Provider<Boolean> f11426d;
    private final FbZeroFeatureVisibilityHelper f11427e;
    private UpsellDialogView f11428f;
    public UpsellDontShowAgainHandler f11429g;
    public boolean f11430h = false;

    /* compiled from: location_accuracy */
    class C07221 implements OnCheckedChangeListener {
        final /* synthetic */ PromoListScreenController f11423a;

        C07221(PromoListScreenController promoListScreenController) {
            this.f11423a = promoListScreenController;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.f11423a.f11430h = z;
        }
    }

    /* compiled from: location_accuracy */
    class C07232 implements OnClickListener {
        final /* synthetic */ PromoListScreenController f11424a;

        C07232(PromoListScreenController promoListScreenController) {
            this.f11424a = promoListScreenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1811972199);
            UpsellPromo upsellPromo = (UpsellPromo) view.getTag();
            if (upsellPromo.f11296i) {
                this.f11424a.f11425c.a(UpsellsAnalyticsEvent.i);
                if (this.f11424a.f11430h) {
                    this.f11424a.f11429g.mo1072a(this.f11424a.f11391a.ar);
                }
                this.f11424a.f11391a.aq();
                Logger.a(2, EntryType.UI_INPUT_END, -163524708, a);
            } else if (StringUtil.a(upsellPromo.f11301n)) {
                Resources jW_ = this.f11424a.f11391a.jW_();
                this.f11424a.f11391a.m18169a(new PromoDataModel(upsellPromo.f11292e, jW_.getString(2131232863), "", upsellPromo.f11290c, upsellPromo.f11293f, upsellPromo.f11291d, jW_.getString(2131232864), upsellPromo.f11302o, PromoLocation.INTERSTITIAL));
                this.f11424a.f11391a.m18170a(Screen.BUY_CONFIRM);
                LogUtils.a(-281126221, a);
            } else {
                this.f11424a.f11425c.a(UpsellsAnalyticsEvent.m);
                this.f11424a.f11391a.a(new Intent("android.intent.action.VIEW", Uri.parse(upsellPromo.f11301n)));
                LogUtils.a(43094283, a);
            }
        }
    }

    @Inject
    public PromoListScreenController(ZeroAnalyticsLogger zeroAnalyticsLogger, Provider<Boolean> provider, ZeroFeatureVisibilityHelper zeroFeatureVisibilityHelper, UpsellDontShowAgainHandler upsellDontShowAgainHandler) {
        this.f11425c = zeroAnalyticsLogger;
        this.f11426d = provider;
        this.f11427e = zeroFeatureVisibilityHelper;
        this.f11429g = upsellDontShowAgainHandler;
    }

    public final View mo1077a(Context context) {
        this.f11428f = new UpsellDialogView(context);
        m18211a(this.f11391a.aw);
        return this.f11428f;
    }

    private void m18211a(@Nullable ZeroRecommendedPromoResult zeroRecommendedPromoResult) {
        if (this.f11391a != null && zeroRecommendedPromoResult != null) {
            boolean z;
            int size;
            UpsellPromo upsellPromo;
            if (StringUtil.a(zeroRecommendedPromoResult.f11331j)) {
                z = false;
            } else {
                z = true;
            }
            UpsellListViewModel upsellListViewModel = new UpsellListViewModel();
            ImmutableList immutableList = zeroRecommendedPromoResult.f11324c;
            if (z) {
                size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    upsellPromo = (UpsellPromo) immutableList.get(i);
                    if (upsellPromo.f11296i) {
                        m18210a(upsellListViewModel, upsellPromo, zeroRecommendedPromoResult.f11332k, true);
                        break;
                    }
                }
            }
            int size2 = immutableList.size();
            size = 0;
            boolean z2 = false;
            while (size < size2) {
                boolean z3;
                upsellPromo = (UpsellPromo) immutableList.get(size);
                if (StringUtil.a(upsellPromo.f11298k) && !(z && upsellPromo.f11296i)) {
                    if (!z || z2) {
                        m18210a(upsellListViewModel, upsellPromo, "", false);
                    } else {
                        m18210a(upsellListViewModel, upsellPromo, zeroRecommendedPromoResult.f11333l, false);
                        z3 = true;
                        size++;
                        z2 = z3;
                    }
                }
                z3 = z2;
                size++;
                z2 = z3;
            }
            if (!upsellListViewModel.m18133a().isEmpty()) {
                UpsellDialogViewModel upsellDialogViewModel = new UpsellDialogViewModel();
                upsellDialogViewModel.f11270r = this.f11391a.ax();
                upsellDialogViewModel = upsellDialogViewModel;
                upsellDialogViewModel.f11271s = zeroRecommendedPromoResult.f11325d;
                UpsellDialogViewModel a = upsellDialogViewModel.m18125a(Boolean.valueOf(true));
                if (StringUtil.a(zeroRecommendedPromoResult.f11327f)) {
                    a.m18126a(zeroRecommendedPromoResult.f11322a);
                } else {
                    a.m18126a(zeroRecommendedPromoResult.f11327f);
                }
                if (((Boolean) this.f11426d.get()).booleanValue()) {
                    a.m18129b(this.f11391a.b(2131232865), m18186a(Screen.USE_DATA_OR_STAY_IN_FREE));
                } else {
                    a.f11255c = zeroRecommendedPromoResult.f11323b;
                    a.m18129b(this.f11391a.b(2131232866), m18191c());
                    if (this.f11429g.mo1073b(this.f11391a.ar)) {
                        upsellListViewModel.f11279b = new C07221(this);
                    }
                }
                this.f11428f.m18174a(a);
                View g = m18212g();
                g.mo1070a(upsellListViewModel);
                this.f11428f.f11377c.addView(g);
            }
        }
    }

    private static void m18210a(UpsellListViewModel upsellListViewModel, UpsellPromo upsellPromo, String str, boolean z) {
        upsellListViewModel.m18132a(str, upsellPromo.f11290c, upsellPromo.f11291d, upsellPromo.f11295h, upsellPromo, z);
    }

    private UpsellDialogList m18212g() {
        UpsellDialogList upsellDialogActionList = new UpsellDialogActionList(this.f11391a.getContext());
        OnClickListener c07232 = new C07232(this);
        upsellDialogActionList.f11358b = c07232;
        for (UpsellDialogActionRow onClickListener : upsellDialogActionList.f11357a) {
            onClickListener.setOnClickListener(c07232);
        }
        return upsellDialogActionList;
    }
}
