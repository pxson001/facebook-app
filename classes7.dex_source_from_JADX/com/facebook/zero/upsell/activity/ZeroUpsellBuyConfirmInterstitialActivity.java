package com.facebook.zero.upsell.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.FbInjector;
import com.facebook.iorg.common.upsell.model.PromoDataModel;
import com.facebook.iorg.common.upsell.model.PromoLocation;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment;
import com.facebook.iorg.common.upsell.ui.UpsellDialogFragment.Screen;
import com.facebook.iorg.common.zero.constants.ZeroDialogState;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Charsets;
import java.net.URLDecoder;
import javax.inject.Inject;

/* compiled from: wall_share */
public class ZeroUpsellBuyConfirmInterstitialActivity extends FbFragmentActivity {
    private static final Class<?> f260r = ZeroUpsellBuyConfirmInterstitialActivity.class;
    @Inject
    public FbZeroDialogController f261p;
    @Inject
    public AbstractFbErrorReporter f262q;

    /* compiled from: wall_share */
    class C00411 implements Listener {
        final /* synthetic */ ZeroUpsellBuyConfirmInterstitialActivity f259a;

        C00411(ZeroUpsellBuyConfirmInterstitialActivity zeroUpsellBuyConfirmInterstitialActivity) {
            this.f259a = zeroUpsellBuyConfirmInterstitialActivity;
        }

        public final void m258a(Object obj) {
            this.f259a.m265i();
        }

        public final void m257a() {
            this.f259a.m266j();
        }
    }

    private static <T extends Context> void m261a(Class<T> cls, T t) {
        m262a((Object) t, (Context) t);
    }

    public static void m262a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ZeroUpsellBuyConfirmInterstitialActivity zeroUpsellBuyConfirmInterstitialActivity = (ZeroUpsellBuyConfirmInterstitialActivity) obj;
        FbZeroDialogController b = FbZeroDialogController.b(fbInjector);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        zeroUpsellBuyConfirmInterstitialActivity.f261p = b;
        zeroUpsellBuyConfirmInterstitialActivity.f262q = abstractFbErrorReporter;
    }

    protected final void m264b(Bundle bundle) {
        super.b(bundle);
        Class cls = ZeroUpsellBuyConfirmInterstitialActivity.class;
        m262a((Object) this, (Context) this);
        if (bundle == null) {
            Intent intent = getIntent();
            if (intent == null) {
                m263k();
                return;
            }
            PromoDataModel promoDataModel = (PromoDataModel) intent.getParcelableExtra("promo_data_model");
            if (promoDataModel == null) {
                String stringExtra = intent.getStringExtra("extra_launch_uri");
                if (stringExtra == null) {
                    m263k();
                    return;
                } else {
                    Uri parse = Uri.parse(stringExtra);
                    promoDataModel = new PromoDataModel(m259a(parse, "promo_id"), m259a(parse, "title"), m259a(parse, "top_message"), m259a(parse, "promo_name"), m259a(parse, "promo_price"), m259a(parse, "message"), m259a(parse, "button_text"), m259a(parse, "extra_text"), PromoLocation.MEGAPHONE);
                }
            }
            m260a(promoDataModel);
        }
    }

    private String m259a(Uri uri, String str) {
        String queryParameter = uri.getQueryParameter(str);
        if (queryParameter == null) {
            return null;
        }
        try {
            return URLDecoder.decode(queryParameter, Charsets.UTF_8.name());
        } catch (Throwable e) {
            this.f262q.a(f260r.getSimpleName(), "Error decoding query param " + str, e);
            return queryParameter;
        }
    }

    private void m263k() {
        m260a(null);
    }

    private void m260a(PromoDataModel promoDataModel) {
        this.f261p.a(ZeroFeatureKey.BUY_CONFIRM_INTERSTITIAL, null, new C00411(this));
        FbZeroDialogController fbZeroDialogController = this.f261p;
        FragmentManager kO_ = kO_();
        ZeroFeatureKey zeroFeatureKey = ZeroFeatureKey.BUY_CONFIRM_INTERSTITIAL;
        fbZeroDialogController.a();
        if (!ZeroDialogController.a(kO_, zeroFeatureKey)) {
            UpsellDialogFragment.a(zeroFeatureKey, promoDataModel, Screen.BUY_CONFIRM, 0, null, ZeroDialogState.UPSELL_WITHOUT_DATA_CONTROL).a(kO_, zeroFeatureKey.prefString);
        }
    }

    public final void m265i() {
        setResult(-1);
        finish();
    }

    public final void m266j() {
        setResult(0);
        finish();
    }
}
