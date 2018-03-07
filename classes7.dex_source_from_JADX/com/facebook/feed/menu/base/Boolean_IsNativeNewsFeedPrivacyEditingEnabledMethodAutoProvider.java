package com.facebook.feed.menu.base;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: ambient_wifis */
public class Boolean_IsNativeNewsFeedPrivacyEditingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return BaseMenuModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
