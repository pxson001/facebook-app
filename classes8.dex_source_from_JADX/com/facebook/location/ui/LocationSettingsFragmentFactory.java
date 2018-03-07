package com.facebook.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: dismissed_by_user */
public class LocationSettingsFragmentFactory implements IFragmentFactory {
    public final Fragment m17708a(Intent intent) {
        Bundle bundle;
        if (intent == null) {
            bundle = null;
        } else {
            bundle = intent.getExtras();
        }
        LocationSettingsFragment locationSettingsFragment = new LocationSettingsFragment();
        locationSettingsFragment.g(bundle == null ? new Bundle() : new Bundle(bundle));
        return locationSettingsFragment;
    }
}
