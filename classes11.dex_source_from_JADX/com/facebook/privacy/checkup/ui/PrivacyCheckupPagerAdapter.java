package com.facebook.privacy.checkup.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.facebook.debug.log.BLog;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupStepType;
import java.io.Serializable;

/* compiled from: SecondTabType */
public class PrivacyCheckupPagerAdapter extends FragmentPagerAdapter {
    Resources f11132a;
    PrivacyCheckupStepType[] f11133b;

    public PrivacyCheckupPagerAdapter(Resources resources, FragmentManager fragmentManager, PrivacyCheckupStepType[] privacyCheckupStepTypeArr) {
        super(fragmentManager);
        this.f11132a = resources;
        this.f11133b = privacyCheckupStepTypeArr;
    }

    public final Fragment m11521a(int i) {
        PrivacyCheckupComposerStepFragment privacyCheckupComposerStepFragment;
        Serializable serializable = this.f11133b[i];
        Intent intent = new Intent();
        intent.putExtra("extra_privacy_checkup_step", serializable);
        Bundle bundle;
        if (serializable == PrivacyCheckupStepType.COMPOSER_STEP) {
            bundle = new Bundle();
            bundle.putAll(intent.getExtras());
            PrivacyCheckupComposerStepFragment privacyCheckupComposerStepFragment2 = new PrivacyCheckupComposerStepFragment();
            privacyCheckupComposerStepFragment2.g(bundle);
            privacyCheckupComposerStepFragment = privacyCheckupComposerStepFragment2;
        } else {
            bundle = new Bundle();
            bundle.putAll(intent.getExtras());
            PrivacyCheckupStepFragment privacyCheckupStepFragment = new PrivacyCheckupStepFragment();
            privacyCheckupStepFragment.g(bundle);
            PrivacyCheckupStepFragment privacyCheckupStepFragment2 = privacyCheckupStepFragment;
        }
        return privacyCheckupComposerStepFragment;
    }

    public final int m11522b() {
        return this.f11133b.length;
    }

    public final CharSequence J_(int i) {
        return m11524f(i);
    }

    public final PrivacyCheckupStepType m11523e(int i) {
        return this.f11133b[i];
    }

    public final String m11524f(int i) {
        int i2;
        switch (this.f11133b[i]) {
            case COMPOSER_STEP:
                i2 = 2131242283;
                break;
            case PROFILE_STEP:
                i2 = 2131242284;
                break;
            case APPS_STEP:
                i2 = 2131242285;
                break;
            default:
                BLog.c(getClass().getSimpleName(), "Unable to find title for step: %s", new Object[]{this.f11133b[i].name()});
                i2 = -1;
                break;
        }
        if (i2 == -1) {
            return null;
        }
        return this.f11132a.getString(i2);
    }
}
