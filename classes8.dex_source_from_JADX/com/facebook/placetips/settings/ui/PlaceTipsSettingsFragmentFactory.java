package com.facebook.placetips.settings.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;

/* compiled from: captcha */
public class PlaceTipsSettingsFragmentFactory implements IFragmentFactory {
    public final Fragment m22394a(Intent intent) {
        Bundle bundle;
        if (intent == null) {
            bundle = null;
        } else {
            bundle = intent.getExtras();
        }
        PlaceTipsSettingsFragment placeTipsSettingsFragment = new PlaceTipsSettingsFragment();
        placeTipsSettingsFragment.g(bundle == null ? new Bundle() : new Bundle(bundle));
        return placeTipsSettingsFragment;
    }
}
