package com.facebook.selfupdate;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: hideSoftKeyboard */
public class Long_SelfUpdateLaunchIntervalMethodAutoProvider extends AbstractProvider<Long> {
    public Object get() {
        return SelfUpdateModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
