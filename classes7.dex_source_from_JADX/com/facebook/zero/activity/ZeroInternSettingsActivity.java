package com.facebook.zero.activity;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.prefs.AllowZeroRatingOnWifiPreference;
import com.facebook.zero.prefs.ClearZeroRatingPreference;
import com.facebook.zero.prefs.DogfoodingPreference;
import com.facebook.zero.prefs.DogfoodingPreferenceProvider;
import com.facebook.zero.prefs.ForceHeaderRefreshPreference;
import com.facebook.zero.prefs.RefreshTokenGraphQLPreference;
import com.facebook.zero.prefs.RefreshTokenPreference;
import com.facebook.zero.prefs.SendTokenHttpHeaderPreference;
import com.facebook.zero.prefs.ShowCarrierManagerPreference;
import com.facebook.zero.prefs.ShowDialtoneOptinInterstitialPreference;
import com.facebook.zero.prefs.ShowMultiStepOptinInterstitialPreference;
import com.facebook.zero.prefs.ShowSinglePageOptinInterstitialPreference;
import com.facebook.zero.prefs.UpsellApiTestPreference;
import com.facebook.zero.prefs.UrlDebugPreference;
import com.facebook.zero.prefs.ZeroInternStatusPreference;
import com.facebook.zero.upsell.IorgFb4aAndroidThreadUtil;
import com.facebook.zero.upsell.service.FbUpsellPromoServiceManager;
import javax.inject.Inject;

/* compiled from: ्ए */
public class ZeroInternSettingsActivity extends FbPreferenceActivity {
    @Inject
    DogfoodingPreferenceProvider f26a;
    @Inject
    UpsellApiTestPreference f27b;
    @Inject
    UrlDebugPreference f28c;
    private ZeroInternStatusPreference f29d;

    private static <T extends Context> void m31a(Class<T> cls, T t) {
        m32a((Object) t, (Context) t);
    }

    public static void m32a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ZeroInternSettingsActivity) obj).m30a((DogfoodingPreferenceProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DogfoodingPreferenceProvider.class), new UpsellApiTestPreference((Context) injectorLike.getInstance(Context.class), IorgFb4aAndroidThreadUtil.m250a(injectorLike), FbUpsellPromoServiceManager.m335a(injectorLike)), new UrlDebugPreference((Context) injectorLike.getInstance(Context.class)));
    }

    private void m30a(DogfoodingPreferenceProvider dogfoodingPreferenceProvider, UpsellApiTestPreference upsellApiTestPreference, UrlDebugPreference urlDebugPreference) {
        this.f26a = dogfoodingPreferenceProvider;
        this.f27b = upsellApiTestPreference;
        this.f28c = urlDebugPreference;
    }

    protected final void m33b(Bundle bundle) {
        super.b(bundle);
        Class cls = ZeroInternSettingsActivity.class;
        m32a((Object) this, (Context) this);
        setTitle("Zero Rating Settings");
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        setPreferenceScreen(createPreferenceScreen);
        this.f29d = new ZeroInternStatusPreference(this);
        Preference preferenceCategory = new PreferenceCategory(this);
        preferenceCategory.setTitle(2131232969);
        createPreferenceScreen.addPreference(preferenceCategory);
        preferenceCategory.addPreference(this.f29d);
        preferenceCategory.addPreference(this.f28c);
        preferenceCategory.addPreference(new RefreshTokenPreference(this));
        preferenceCategory.addPreference(new RefreshTokenGraphQLPreference(this));
        preferenceCategory.addPreference(new ClearZeroRatingPreference(this));
        preferenceCategory.addPreference(new AllowZeroRatingOnWifiPreference(this));
        preferenceCategory.addPreference(new ForceHeaderRefreshPreference(this));
        preferenceCategory.addPreference(this.f27b);
        preferenceCategory.addPreference(new ShowCarrierManagerPreference(this));
        preferenceCategory.addPreference(new ShowSinglePageOptinInterstitialPreference(this));
        preferenceCategory.addPreference(new ShowMultiStepOptinInterstitialPreference(this));
        preferenceCategory.addPreference(new ShowDialtoneOptinInterstitialPreference(this));
        preferenceCategory.addPreference(new DogfoodingPreference(this, (SecureContextHelper) DefaultSecureContextHelper.a(this.f26a)));
        preferenceCategory.addPreference(new SendTokenHttpHeaderPreference(this));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f29d != null) {
            this.f29d.f164b.b();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f29d != null) {
            this.f29d.f164b.c();
        }
    }
}
