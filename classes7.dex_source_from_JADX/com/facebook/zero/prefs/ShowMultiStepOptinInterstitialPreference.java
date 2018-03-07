package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.inject.FbInjector;

/* compiled from: z-m.ak.fbcdn.net */
public class ShowMultiStepOptinInterstitialPreference extends Preference {
    public final BaseFbBroadcastManager f148a;

    /* compiled from: z-m.ak.fbcdn.net */
    class C00221 implements OnPreferenceClickListener {
        final /* synthetic */ ShowMultiStepOptinInterstitialPreference f147a;

        C00221(ShowMultiStepOptinInterstitialPreference showMultiStepOptinInterstitialPreference) {
            this.f147a = showMultiStepOptinInterstitialPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            ShowMultiStepOptinInterstitialPreference showMultiStepOptinInterstitialPreference = this.f147a;
            Intent intent = new Intent("com.facebook.zero.ZERO_SHOW_INTERSTITIAL");
            intent.putExtra("uri", FBLinks.a("zero_interstitial"));
            showMultiStepOptinInterstitialPreference.f148a.a(intent);
            return true;
        }
    }

    public ShowMultiStepOptinInterstitialPreference(Context context) {
        super(context);
        this.f148a = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(FbInjector.get(context));
        setOnPreferenceClickListener(new C00221(this));
        setTitle(2131232980);
    }
}
