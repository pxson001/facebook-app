package com.facebook.zero.prefs;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.zero.token.request.ZeroTokenHttpRequestHandler;

/* compiled from: zeroBuyPromoParams */
public class SendTokenHttpHeaderPreference extends Preference {
    public final ZeroTokenHttpRequestHandler f141a;

    /* compiled from: zeroBuyPromoParams */
    class C00191 implements OnPreferenceClickListener {
        final /* synthetic */ SendTokenHttpHeaderPreference f140a;

        C00191(SendTokenHttpHeaderPreference sendTokenHttpHeaderPreference) {
            this.f140a = sendTokenHttpHeaderPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f140a.f141a.a(Boolean.valueOf(true));
            return true;
        }
    }

    public SendTokenHttpHeaderPreference(Context context) {
        super(context);
        this.f141a = ZeroTokenHttpRequestHandler.a(FbInjector.get(context));
        setOnPreferenceClickListener(new C00191(this));
        setTitle(2131232991);
    }
}
