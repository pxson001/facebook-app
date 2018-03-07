package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.zero.activity.ZeroInternSettingsActivity;

/* compiled from: zero_header_request_params_fetch_failed */
public class LaunchZeroRatingInternSettingsPreference extends Preference {
    public final Context f134a;
    public final SecureContextHelper f135b;

    /* compiled from: zero_header_request_params_fetch_failed */
    class C00161 implements OnPreferenceClickListener {
        final /* synthetic */ LaunchZeroRatingInternSettingsPreference f133a;

        C00161(LaunchZeroRatingInternSettingsPreference launchZeroRatingInternSettingsPreference) {
            this.f133a = launchZeroRatingInternSettingsPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            LaunchZeroRatingInternSettingsPreference launchZeroRatingInternSettingsPreference = this.f133a;
            launchZeroRatingInternSettingsPreference.f135b.a(new Intent(launchZeroRatingInternSettingsPreference.f134a, ZeroInternSettingsActivity.class), launchZeroRatingInternSettingsPreference.f134a);
            return true;
        }
    }

    public LaunchZeroRatingInternSettingsPreference(Context context) {
        super(context);
        this.f135b = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
        this.f134a = context;
        setOnPreferenceClickListener(new C00161(this));
        setTitle(2131232987);
    }
}
