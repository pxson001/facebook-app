package com.facebook.zero.prefs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.iorg.common.upsell.server.UpsellPromo;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoParams;
import com.facebook.iorg.common.upsell.server.ZeroRecommendedPromoResult;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.upsell.IorgFb4aAndroidThreadUtil;
import com.facebook.zero.upsell.service.FbUpsellPromoServiceManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: z-m-static.xx.fbcdn.net */
public class UpsellApiTestPreference extends Preference {
    public final Context f156a;
    public IorgFb4aAndroidThreadUtil f157b;
    public FbUpsellPromoServiceManager f158c;

    /* compiled from: z-m-static.xx.fbcdn.net */
    class C00241 implements OnPreferenceClickListener {
        final /* synthetic */ UpsellApiTestPreference f152a;

        C00241(UpsellApiTestPreference upsellApiTestPreference) {
            this.f152a = upsellApiTestPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            UpsellApiTestPreference upsellApiTestPreference = this.f152a;
            upsellApiTestPreference.f157b.m252a(upsellApiTestPreference.f158c.m337a(new ZeroRecommendedPromoParams(2, SizeUtil.a(upsellApiTestPreference.getContext().getResources()), false, PromoLocation.INTERSTITIAL, ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL)), new C00252(upsellApiTestPreference));
            return true;
        }
    }

    /* compiled from: z-m-static.xx.fbcdn.net */
    public class C00252 implements FutureCallback<ZeroRecommendedPromoResult> {
        final /* synthetic */ UpsellApiTestPreference f153a;

        public C00252(UpsellApiTestPreference upsellApiTestPreference) {
            this.f153a = upsellApiTestPreference;
        }

        public void onSuccess(@Nullable Object obj) {
            ZeroRecommendedPromoResult zeroRecommendedPromoResult = (ZeroRecommendedPromoResult) obj;
            if (StringUtil.a(zeroRecommendedPromoResult.i)) {
                String str;
                UpsellApiTestPreference upsellApiTestPreference = this.f153a;
                int i = 1;
                int i2 = 0;
                FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(upsellApiTestPreference.f156a, 1);
                fbAlertDialogBuilder.a("Upsell API Success");
                fbAlertDialogBuilder.c("OK", new C00263(upsellApiTestPreference));
                if (StringUtil.a(zeroRecommendedPromoResult.j)) {
                    i = 0;
                }
                String str2 = "";
                if (i != 0) {
                    str = str2 + "Current Promo: " + zeroRecommendedPromoResult.k + "\n\n";
                } else {
                    str = str2 + "No Current Promo\n\n";
                }
                str = str + "Recommended Promos Count: " + zeroRecommendedPromoResult.c.size() + "\n\n";
                ImmutableList immutableList = zeroRecommendedPromoResult.c;
                int size = immutableList.size();
                CharSequence charSequence = str;
                while (i2 < size) {
                    UpsellPromo upsellPromo = (UpsellPromo) immutableList.get(i2);
                    i2++;
                    Object obj2 = charSequence + " * " + upsellPromo.b + " " + upsellPromo.f + "\n";
                }
                fbAlertDialogBuilder.b(charSequence);
                fbAlertDialogBuilder.a().show();
                return;
            }
            UpsellApiTestPreference.m124a(this.f153a, zeroRecommendedPromoResult.i);
        }

        public void onFailure(Throwable th) {
            UpsellApiTestPreference.m124a(this.f153a, th.getLocalizedMessage());
        }
    }

    /* compiled from: z-m-static.xx.fbcdn.net */
    public class C00263 implements OnClickListener {
        final /* synthetic */ UpsellApiTestPreference f154a;

        public C00263(UpsellApiTestPreference upsellApiTestPreference) {
            this.f154a = upsellApiTestPreference;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* compiled from: z-m-static.xx.fbcdn.net */
    class C00274 implements OnClickListener {
        final /* synthetic */ UpsellApiTestPreference f155a;

        C00274(UpsellApiTestPreference upsellApiTestPreference) {
            this.f155a = upsellApiTestPreference;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    @Inject
    public UpsellApiTestPreference(Context context, IorgFb4aAndroidThreadUtil iorgFb4aAndroidThreadUtil, FbUpsellPromoServiceManager fbUpsellPromoServiceManager) {
        super(context);
        this.f156a = context;
        this.f157b = iorgFb4aAndroidThreadUtil;
        this.f158c = fbUpsellPromoServiceManager;
        setOnPreferenceClickListener(new C00241(this));
        setTitle(2131232988);
    }

    public static void m124a(UpsellApiTestPreference upsellApiTestPreference, String str) {
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(upsellApiTestPreference.f156a, 1);
        fbAlertDialogBuilder.a("Upsell API Error");
        fbAlertDialogBuilder.b(str);
        fbAlertDialogBuilder.c("OK", new C00274(upsellApiTestPreference));
        fbAlertDialogBuilder.a().show();
    }
}
