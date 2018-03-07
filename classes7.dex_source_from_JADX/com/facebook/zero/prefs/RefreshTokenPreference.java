package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.inject.FbInjector;
import com.facebook.zero.sdk.common.TokenRequestReason;

/* compiled from: zeroGetRecommendedPromo */
public class RefreshTokenPreference extends Preference {
    public final BaseFbBroadcastManager f139a;

    /* compiled from: zeroGetRecommendedPromo */
    class C00181 implements OnPreferenceClickListener {
        final /* synthetic */ RefreshTokenPreference f138a;

        C00181(RefreshTokenPreference refreshTokenPreference) {
            this.f138a = refreshTokenPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f138a.f139a.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.DEBUG));
            return true;
        }
    }

    public RefreshTokenPreference(Context context) {
        super(context);
        this.f139a = (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(FbInjector.get(context));
        setOnPreferenceClickListener(new C00181(this));
        setTitle(2131232976);
    }
}
