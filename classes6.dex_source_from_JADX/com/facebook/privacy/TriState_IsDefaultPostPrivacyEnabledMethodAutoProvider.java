package com.facebook.privacy;

import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: fetch_friend_list_feed */
public class TriState_IsDefaultPostPrivacyEnabledMethodAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return PrivacyModule.m22542a((FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
