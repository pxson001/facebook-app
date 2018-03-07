package com.facebook.devicebasedlogin.nux;

import android.content.Context;
import android.content.Intent;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;

/* compiled from: This field is not of message type. */
public class DeviceBasedLoginSettings extends PreferenceCategory {

    /* compiled from: This field is not of message type. */
    class C29171 implements OnPreferenceClickListener {
        final /* synthetic */ DeviceBasedLoginSettings f24164a;

        C29171(DeviceBasedLoginSettings deviceBasedLoginSettings) {
            this.f24164a = deviceBasedLoginSettings;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f24164a.getContext().startActivity(new Intent(this.f24164a.getContext(), ActivateDeviceBasedLoginNuxActivity.class));
            return true;
        }
    }

    public DeviceBasedLoginSettings(Context context) {
        super(context);
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        setTitle("Device Based Login - internal");
        Preference preference = new Preference(getContext());
        preference.setTitle("Launch NUX");
        preference.setOnPreferenceClickListener(new C29171(this));
        addPreference(preference);
    }
}
