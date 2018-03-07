package com.facebook.katana.provider.legacykeyvalue;

import android.content.Context;
import com.facebook.inject.FbInjector;
import com.facebook.katana.app.module.LegacyKeyValueStore_UserValuesManagerBackendMethodAutoProvider;
import com.facebook.katana.app.module.MainProcessModule;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import javax.inject.Inject;

@Deprecated
/* compiled from: getting the id response */
public class UserValuesManager {
    public final KeyValueStore f11062a;

    @Inject
    public UserValuesManager(KeyValueStore keyValueStore) {
        this.f11062a = keyValueStore;
    }

    public static void m11490a(Context context, boolean z) {
        m11489a(context, "ringtone", Boolean.valueOf(z));
    }

    public static boolean m11491a(Context context) {
        return Boolean.parseBoolean(m11487a(context, "ringtone", "false"));
    }

    public static void m11488a(Context context, String str) {
        if (str == null) {
            m11494d(context).f11062a.m11500a("current_account");
            return;
        }
        m11494d(context).m11493b("current_account", str);
    }

    public static String m11492b(Context context) {
        return m11487a(context, "current_account", null);
    }

    private static String m11487a(Context context, String str, String str2) {
        return m11494d(context).f11062a.m11499a(str, str2);
    }

    private static void m11489a(Context context, String str, Object obj) {
        m11494d(context).m11493b(str, obj == null ? null : obj.toString());
    }

    private void m11493b(String str, String str2) {
        this.f11062a.m11501a(str, str2, true);
    }

    public static UserValuesManager m11494d(Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        return new UserValuesManager(MainProcessModule.a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), LegacyKeyValueStore_UserValuesManagerBackendMethodAutoProvider.m11495b(fbInjector)));
    }
}
