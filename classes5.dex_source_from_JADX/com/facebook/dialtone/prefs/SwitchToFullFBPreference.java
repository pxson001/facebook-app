package com.facebook.dialtone.prefs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;

/* compiled from: [property ' */
public class SwitchToFullFBPreference extends Preference {
    public final SecureContextHelper f11864a;
    public final UriIntentMapper f11865b;
    public final Context f11866c;

    /* compiled from: [property ' */
    class C11141 implements OnPreferenceClickListener {
        final /* synthetic */ SwitchToFullFBPreference f11863a;

        C11141(SwitchToFullFBPreference switchToFullFBPreference) {
            this.f11863a = switchToFullFBPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            SwitchToFullFBPreference switchToFullFBPreference = this.f11863a;
            Intent a = switchToFullFBPreference.f11865b.a(switchToFullFBPreference.getContext(), "dialtone://switch_to_full_fb");
            if (a == null) {
                a = new Intent();
                a.setData(Uri.parse("dialtone://switch_to_full_fb"));
            }
            switchToFullFBPreference.f11864a.a(a, switchToFullFBPreference.f11866c);
            return true;
        }
    }

    public SwitchToFullFBPreference(Context context) {
        super(context);
        this.f11866c = context;
        FbInjector fbInjector = FbInjector.get(context);
        this.f11864a = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        this.f11865b = (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector);
        setOnPreferenceClickListener(new C11141(this));
        setTitle(2131232622);
    }
}
