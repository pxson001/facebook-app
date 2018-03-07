package com.facebook.zero.prefs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;

/* compiled from: zeroBuyPromo */
public class ShowCarrierManagerPreference extends Preference {
    public final Context f143a;
    public final SecureContextHelper f144b;

    /* compiled from: zeroBuyPromo */
    class C00201 implements OnPreferenceClickListener {
        final /* synthetic */ ShowCarrierManagerPreference f142a;

        C00201(ShowCarrierManagerPreference showCarrierManagerPreference) {
            this.f142a = showCarrierManagerPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            ShowCarrierManagerPreference showCarrierManagerPreference = this.f142a;
            Intent intent = new Intent();
            intent.setData(Uri.parse(FBLinks.a("carrier_manager?ref=internal_settings")));
            showCarrierManagerPreference.f144b.a(intent, showCarrierManagerPreference.f143a);
            return true;
        }
    }

    public ShowCarrierManagerPreference(Context context) {
        super(context);
        this.f144b = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
        this.f143a = context;
        setOnPreferenceClickListener(new C00201(this));
        setTitle(2131232982);
    }
}
