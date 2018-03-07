package com.facebook.privacy.checkup.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.privacy.checkup.manager.IDBackedPrivacyCheckupManager;

/* compiled from: SUGGESTIONS_TYPEAHEAD */
public class PrivacyGenericCheckupPagerAdapter extends FragmentPagerAdapter {
    private Resources f11245a;
    private IDBackedPrivacyCheckupManager f11246b;

    public PrivacyGenericCheckupPagerAdapter(Resources resources, FragmentManager fragmentManager, IDBackedPrivacyCheckupManager iDBackedPrivacyCheckupManager) {
        super(fragmentManager);
        this.f11245a = resources;
        this.f11246b = iDBackedPrivacyCheckupManager;
    }

    public final int m11639b() {
        return this.f11246b.m11327c();
    }

    public final CharSequence J_(int i) {
        return this.f11245a.getString(2131242325);
    }

    public final Fragment m11638a(int i) {
        PrivacyGenericCheckupFragment privacyGenericCheckupFragment = new PrivacyGenericCheckupFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("stepIndex", i);
        privacyGenericCheckupFragment.g(bundle);
        return privacyGenericCheckupFragment;
    }
}
