package com.facebook.growth.nux.preferences;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.growth.nux.UserAccountNUXActivity;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: p2p_reset_pin */
public class LaunchNUXPreference extends Preference {
    @Inject
    public SecureContextHelper f7495a;

    /* compiled from: p2p_reset_pin */
    public class C08311 implements OnPreferenceClickListener {
        final /* synthetic */ Context f7493a;
        final /* synthetic */ LaunchNUXPreference f7494b;

        public C08311(LaunchNUXPreference launchNUXPreference, Context context) {
            this.f7494b = launchNUXPreference;
            this.f7493a = context;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f7494b.f7495a.a(new Intent(this.f7493a, UserAccountNUXActivity.class), this.f7493a);
            return true;
        }
    }

    public static void m7800a(Object obj, Context context) {
        ((LaunchNUXPreference) obj).f7495a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public LaunchNUXPreference(Context context) {
        super(context);
        Class cls = LaunchNUXPreference.class;
        m7800a(this, getContext());
    }
}
