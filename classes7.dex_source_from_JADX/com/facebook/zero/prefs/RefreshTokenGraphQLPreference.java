package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.inject.FbInjector;
import com.facebook.zero.sdk.common.TokenRequestReason;

/* compiled from: zero_carrier */
public class RefreshTokenGraphQLPreference extends Preference {
    public final BaseFbBroadcastManager f137a;

    /* compiled from: zero_carrier */
    class C00171 implements OnPreferenceClickListener {
        final /* synthetic */ RefreshTokenGraphQLPreference f136a;

        C00171(RefreshTokenGraphQLPreference refreshTokenGraphQLPreference) {
            this.f136a = refreshTokenGraphQLPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f136a.f137a.a(new Intent("com.facebook.zero.ACTION_ZERO_REFRESH_TOKEN").putExtra("zero_token_request_reason", TokenRequestReason.GRAPHQL_VERIFICATION));
            return true;
        }
    }

    public RefreshTokenGraphQLPreference(Context context) {
        super(context);
        this.f137a = (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(FbInjector.get(context));
        setOnPreferenceClickListener(new C00171(this));
        setTitle(2131232977);
    }
}
