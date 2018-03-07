package com.facebook.fbui.runtimelinter;

import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: vnd.android.cursor.item/phone_v2 */
public class Boolean_IsRuntimeLinterEnabledMethodAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return RuntimeLinterModule.a((FbAppType) getInstance(FbAppType.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(this));
    }
}
