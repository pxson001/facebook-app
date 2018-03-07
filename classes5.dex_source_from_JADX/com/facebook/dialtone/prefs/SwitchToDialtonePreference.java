package com.facebook.dialtone.prefs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;

/* compiled from: \ */
public class SwitchToDialtonePreference extends Preference {
    public final SecureContextHelper f11860a;
    public final UriIntentMapper f11861b;
    public final Context f11862c;

    /* compiled from: \ */
    class C11131 implements OnPreferenceClickListener {
        final /* synthetic */ SwitchToDialtonePreference f11859a;

        C11131(SwitchToDialtonePreference switchToDialtonePreference) {
            this.f11859a = switchToDialtonePreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            SwitchToDialtonePreference switchToDialtonePreference = this.f11859a;
            Bundle bundle = new Bundle();
            bundle.putString("ref", "dialtone_automode");
            Intent a = switchToDialtonePreference.f11861b.a(switchToDialtonePreference.getContext(), "dialtone://switch_to_dialtone");
            if (a == null) {
                a = new Intent();
                a.setData(Uri.parse("dialtone://switch_to_dialtone"));
            }
            a.putExtras(bundle);
            switchToDialtonePreference.f11860a.a(a, switchToDialtonePreference.f11862c);
            return true;
        }
    }

    public SwitchToDialtonePreference(Context context) {
        super(context);
        this.f11862c = context;
        FbInjector fbInjector = FbInjector.get(context);
        this.f11860a = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        this.f11861b = (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector);
        setOnPreferenceClickListener(new C11131(this));
        setTitle(2131232621);
    }
}
