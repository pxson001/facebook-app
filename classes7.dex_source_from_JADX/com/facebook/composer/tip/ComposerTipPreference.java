package com.facebook.composer.tip;

import android.content.Context;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import com.facebook.composer.minutiae.prefs.MinutiaePrefKeys;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.FbInjector;
import com.facebook.interstitial.api.FetchInterstitialsParams;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.widget.prefs.OrcaListPreference;
import com.google.common.collect.ImmutableList;

/* compiled from: composer_source_type_not_found */
public class ComposerTipPreference extends OrcaListPreference {
    public FbSharedPreferences f16980a;
    public DefaultBlueServiceOperationFactory f16981b;

    /* compiled from: composer_source_type_not_found */
    public class C13681 implements OnPreferenceChangeListener {
        final /* synthetic */ ComposerTipPreference f16979a;

        public C13681(ComposerTipPreference composerTipPreference) {
            this.f16979a = composerTipPreference;
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (obj.equals(ComposerInterstitialControllers.RIDGE_NUX.name())) {
                this.f16979a.f16980a.edit().a(MinutiaePrefKeys.f1618f).a(MinutiaePrefKeys.f1616d).a(MinutiaePrefKeys.f1619g).a(MinutiaePrefKeys.f1617e).a(MinutiaePrefKeys.f1622j).a(MinutiaePrefKeys.f1623k).a(ComposerInterstitialControllers.RIDGE_NUX.prefKey).commit();
                ComposerTipPreference.m20937a(this.f16979a, "2326", ComposerInterstitialControllers.RIDGE_NUX.interstitialId);
            }
            if (obj.equals(ComposerInterstitialControllers.MINUTIAE_RESHARE_NUX.name())) {
                this.f16979a.f16980a.edit().a(MinutiaePrefKeys.f1615c).commit();
                ComposerTipPreference.m20937a(this.f16979a, ComposerInterstitialControllers.MINUTIAE_RESHARE_NUX.interstitialId);
            }
            if (obj.equals(ComposerInterstitialControllers.PUBLISH_MODE_SELECTOR_NUX.name())) {
                this.f16979a.f16980a.edit().a(ComposerInterstitialControllers.PUBLISH_MODE_SELECTOR_NUX.prefKey).commit();
                ComposerTipPreference.m20937a(this.f16979a, ComposerInterstitialControllers.PUBLISH_MODE_SELECTOR_NUX.interstitialId);
            }
            if (obj.equals(ComposerInterstitialControllers.TOPIC_COMPOSER_NUX.name())) {
                this.f16979a.f16980a.edit().a(ComposerInterstitialControllers.TOPIC_COMPOSER_NUX.prefKey).commit();
                ComposerTipPreference.m20937a(this.f16979a, ComposerInterstitialControllers.TOPIC_COMPOSER_NUX.interstitialId);
            }
            if (obj.equals(ComposerInterstitialControllers.FEED_ONLY_POST_NUX.name())) {
                this.f16979a.f16980a.edit().a(ComposerInterstitialControllers.FEED_ONLY_POST_NUX.prefKey).commit();
                ComposerTipPreference.m20937a(this.f16979a, ComposerInterstitialControllers.FEED_ONLY_POST_NUX.interstitialId);
            }
            return true;
        }
    }

    public static void m20938a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ComposerTipPreference composerTipPreference = (ComposerTipPreference) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        composerTipPreference.f16980a = fbSharedPreferences;
        composerTipPreference.f16981b = b;
    }

    public ComposerTipPreference(Context context) {
        super(context);
        Class cls = ComposerTipPreference.class;
        m20938a((Object) this, context);
        int i = 0;
        ComposerInterstitialControllers[] composerInterstitialControllersArr = new ComposerInterstitialControllers[]{ComposerInterstitialControllers.RIDGE_NUX, ComposerInterstitialControllers.MINUTIAE_RESHARE_NUX, ComposerInterstitialControllers.PUBLISH_MODE_SELECTOR_NUX, ComposerInterstitialControllers.TOPIC_COMPOSER_NUX, ComposerInterstitialControllers.FEED_ONLY_POST_NUX};
        CharSequence[] charSequenceArr = new String[5];
        CharSequence[] charSequenceArr2 = new String[5];
        while (i < 5) {
            charSequenceArr[i] = "Reset " + composerInterstitialControllersArr[i].description;
            charSequenceArr2[i] = composerInterstitialControllersArr[i].name();
            i++;
        }
        setTitle("Composer Tip & Nux Settings");
        setSummary("List of Tip & Nux settings available to configure (on device only).");
        setEntries(charSequenceArr);
        setEntryValues(charSequenceArr2);
        setDialogTitle("Ignore the radio buttons. Options are not mutually exclusive.");
        setPositiveButtonText("Ok");
        setNegativeButtonText("Cancel");
        setKey("ComposerTipPreference");
        setOnPreferenceChangeListener(new C13681(this));
    }

    public static void m20937a(ComposerTipPreference composerTipPreference, String... strArr) {
        FetchInterstitialsParams fetchInterstitialsParams = new FetchInterstitialsParams(ImmutableList.copyOf(strArr));
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchAndUpdateInterstitialsParams", fetchInterstitialsParams);
        BlueServiceOperationFactoryDetour.a(composerTipPreference.f16981b, "interstitials_fetch_and_update", bundle, -1440232177).a();
    }
}
