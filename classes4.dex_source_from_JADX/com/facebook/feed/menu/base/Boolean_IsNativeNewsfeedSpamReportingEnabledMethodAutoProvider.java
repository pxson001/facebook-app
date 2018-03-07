package com.facebook.feed.menu.base;

import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: negative_button_string */
public class Boolean_IsNativeNewsfeedSpamReportingEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return BaseMenuModule.b((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
