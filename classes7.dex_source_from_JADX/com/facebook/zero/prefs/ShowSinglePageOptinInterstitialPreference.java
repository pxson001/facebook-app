package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.zero.activity.NativeOptinInterstitialActivity;

/* compiled from: z-m-www.facebook.com */
public class ShowSinglePageOptinInterstitialPreference extends Preference {
    public final Context f150a;
    public final SecureContextHelper f151b;

    /* compiled from: z-m-www.facebook.com */
    class C00231 implements OnPreferenceClickListener {
        final /* synthetic */ ShowSinglePageOptinInterstitialPreference f149a;

        C00231(ShowSinglePageOptinInterstitialPreference showSinglePageOptinInterstitialPreference) {
            this.f149a = showSinglePageOptinInterstitialPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            ShowSinglePageOptinInterstitialPreference showSinglePageOptinInterstitialPreference = this.f149a;
            showSinglePageOptinInterstitialPreference.f151b.a(new Intent(showSinglePageOptinInterstitialPreference.f150a, NativeOptinInterstitialActivity.class), showSinglePageOptinInterstitialPreference.f150a);
            return true;
        }
    }

    public ShowSinglePageOptinInterstitialPreference(Context context) {
        super(context);
        this.f151b = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
        this.f150a = context;
        setOnPreferenceClickListener(new C00231(this));
        setTitle(2131232979);
    }
}
