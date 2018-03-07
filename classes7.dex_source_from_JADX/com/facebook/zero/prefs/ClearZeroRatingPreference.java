package com.facebook.zero.prefs;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.inject.FbInjector;

/* compiled from: zero_upsell */
public class ClearZeroRatingPreference extends Preference {
    public final BaseFbBroadcastManager f127a;

    /* compiled from: zero_upsell */
    class C00131 implements OnPreferenceClickListener {
        final /* synthetic */ ClearZeroRatingPreference f126a;

        C00131(ClearZeroRatingPreference clearZeroRatingPreference) {
            this.f126a = clearZeroRatingPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f126a.f127a.a("com.facebook.zero.ZERO_RATING_CLEAR_SETTINGS");
            return true;
        }
    }

    public ClearZeroRatingPreference(Context context) {
        super(context);
        this.f127a = (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(FbInjector.get(context));
        setOnPreferenceClickListener(new C00131(this));
        setTitle(2131232978);
    }
}
