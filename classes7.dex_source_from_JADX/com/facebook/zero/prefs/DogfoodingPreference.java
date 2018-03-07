package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.zero.activity.ZeroDogfoodingAppActivity;
import javax.inject.Inject;

/* compiled from: zero_token */
public class DogfoodingPreference extends Preference {
    public final Context f129a;
    public SecureContextHelper f130b;

    /* compiled from: zero_token */
    class C00141 implements OnPreferenceClickListener {
        final /* synthetic */ DogfoodingPreference f128a;

        C00141(DogfoodingPreference dogfoodingPreference) {
            this.f128a = dogfoodingPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f128a.f130b.a(new Intent(this.f128a.f129a, ZeroDogfoodingAppActivity.class), this.f128a.f129a);
            return true;
        }
    }

    @Inject
    public DogfoodingPreference(@Assisted Context context, SecureContextHelper secureContextHelper) {
        super(context);
        this.f129a = context;
        this.f130b = secureContextHelper;
        setOnPreferenceClickListener(new C00141(this));
        setTitle(2131232986);
    }
}
