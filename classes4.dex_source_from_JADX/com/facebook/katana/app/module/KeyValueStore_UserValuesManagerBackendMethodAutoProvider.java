package com.facebook.katana.app.module;

import com.facebook.inject.AbstractProvider;
import com.facebook.katana.provider.legacykeyvalue.KeyValueStore;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: get_sso_user_params */
public class KeyValueStore_UserValuesManagerBackendMethodAutoProvider extends AbstractProvider<KeyValueStore> {
    public Object get() {
        return MainProcessModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(this), LegacyKeyValueStore_UserValuesManagerBackendMethodAutoProvider.m11495b(this));
    }
}
