package com.facebook.iorg.common.upsell.ui.screencontroller;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.iorg.common.upsell.model.PromoDataModel;
import com.facebook.iorg.common.upsell.model.UpsellDialogViewModel;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.upsell.ui.UpsellDialogView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.Map;

/* compiled from: logging_start_time */
public abstract class AbstractUpsellDialogScreenController {
    public UpsellDialogFragment f11391a;
    public PromoDataModel f11392b;

    /* compiled from: logging_start_time */
    class C07161 implements OnClickListener {
        final /* synthetic */ AbstractUpsellDialogScreenController f11387a;

        C07161(AbstractUpsellDialogScreenController abstractUpsellDialogScreenController) {
            this.f11387a = abstractUpsellDialogScreenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1352895203);
            this.f11387a.f11391a.ar();
            Logger.a(2, EntryType.UI_INPUT_END, -153048714, a);
        }
    }

    /* compiled from: logging_start_time */
    class C07172 implements OnClickListener {
        final /* synthetic */ AbstractUpsellDialogScreenController f11388a;

        C07172(AbstractUpsellDialogScreenController abstractUpsellDialogScreenController) {
            this.f11388a = abstractUpsellDialogScreenController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1566879149);
            this.f11388a.f11391a.aq();
            Logger.a(2, EntryType.UI_INPUT_END, 2035810906, a);
        }
    }

    public abstract View mo1077a(Context context);

    public final void m18189a(UpsellDialogFragment upsellDialogFragment, PromoDataModel promoDataModel) {
        this.f11391a = upsellDialogFragment;
        this.f11392b = promoDataModel;
    }

    public void m18188a() {
    }

    public void mo1078a(UpsellDialogView upsellDialogView) {
    }

    protected final OnClickListener m18191c() {
        return new C07161(this);
    }

    protected OnClickListener mo1079d() {
        return new C07172(this);
    }

    protected final OnClickListener m18186a(final Screen screen) {
        return new OnClickListener(this) {
            final /* synthetic */ AbstractUpsellDialogScreenController f11390b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1574460096);
                this.f11390b.f11391a.m18170a(screen);
                Logger.a(2, EntryType.UI_INPUT_END, 1017571656, a);
            }
        };
    }

    public static Map<String, String> m18185a(String str, String str2) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("promo_id", str);
        hashMap.put("location", str2);
        return hashMap;
    }

    protected final Map<String, String> m18193e() {
        return this.f11392b != null ? m18185a(this.f11392b.f11244a, this.f11392b.f11252i.getParamName()) : Maps.c();
    }

    protected final UpsellDialogViewModel m18194f() {
        UpsellDialogViewModel upsellDialogViewModel = new UpsellDialogViewModel();
        if (this.f11392b != null) {
            upsellDialogViewModel.m18126a(this.f11392b.f11245b);
        }
        ZeroRecommendedPromoResult zeroRecommendedPromoResult = this.f11391a.aw;
        if (zeroRecommendedPromoResult != null) {
            upsellDialogViewModel.f11271s = zeroRecommendedPromoResult.f11325d;
        }
        return upsellDialogViewModel;
    }
}
