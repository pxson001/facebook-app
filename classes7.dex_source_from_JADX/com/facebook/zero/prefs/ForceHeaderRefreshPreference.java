package com.facebook.zero.prefs;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.inject.FbInjector;

/* compiled from: zero_interstitial */
public class ForceHeaderRefreshPreference extends Preference {
    public final BaseFbBroadcastManager f132a;

    /* compiled from: zero_interstitial */
    class C00151 implements OnPreferenceClickListener {
        final /* synthetic */ ForceHeaderRefreshPreference f131a;

        C00151(ForceHeaderRefreshPreference forceHeaderRefreshPreference) {
            this.f131a = forceHeaderRefreshPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f131a.f132a.a("com.facebook.zero.ACTION_FORCE_ZERO_HEADER_REFRESH");
            return true;
        }
    }

    public ForceHeaderRefreshPreference(Context context) {
        super(context);
        this.f132a = (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(FbInjector.get(context));
        setOnPreferenceClickListener(new C00151(this));
        setTitle(2131232983);
    }
}
