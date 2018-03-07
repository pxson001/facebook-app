package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.inject.FbInjector;

/* compiled from: zero feature key was null */
public class ShowDialtoneOptinInterstitialPreference extends Preference {
    public final BaseFbBroadcastManager f146a;

    /* compiled from: zero feature key was null */
    class C00211 implements OnPreferenceClickListener {
        final /* synthetic */ ShowDialtoneOptinInterstitialPreference f145a;

        C00211(ShowDialtoneOptinInterstitialPreference showDialtoneOptinInterstitialPreference) {
            this.f145a = showDialtoneOptinInterstitialPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            ShowDialtoneOptinInterstitialPreference showDialtoneOptinInterstitialPreference = this.f145a;
            Intent intent = new Intent("com.facebook.zero.ZERO_SHOW_INTERSTITIAL");
            intent.putExtra("uri", FBLinks.a("dialtone_optin_interstitial"));
            showDialtoneOptinInterstitialPreference.f146a.a(intent);
            return true;
        }
    }

    public ShowDialtoneOptinInterstitialPreference(Context context) {
        super(context);
        this.f146a = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(FbInjector.get(context));
        setOnPreferenceClickListener(new C00211(this));
        setTitle(2131232981);
    }
}
