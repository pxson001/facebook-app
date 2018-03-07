package com.facebook.auth.datastore.impl;

import android.text.TextUtils;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.crudolib.prefs.LightSharedPreferences$Editor;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.module.UserSerialization;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: user-agent */
public class UserDataStorage {
    private final LightSharedPreferencesFactory f1487a;
    private final Lazy<FbSharedPreferences> f1488b;
    private final Lazy<UserSerialization> f1489c;

    @Inject
    public UserDataStorage(LightSharedPreferencesFactory lightSharedPreferencesFactory, Lazy<FbSharedPreferences> lazy, Lazy<UserSerialization> lazy2) {
        this.f1487a = lightSharedPreferencesFactory;
        this.f1488b = lazy;
        this.f1489c = lazy2;
    }

    @Nullable
    final User m2880a(String str) {
        User user = null;
        LightSharedPreferencesImpl d = m2879d(str);
        if (d == null) {
            return null;
        }
        if (d.m2647a("is_imported", false)) {
            return UserDataStore.m5751a(Type.FACEBOOK, d);
        }
        if (!((FbSharedPreferences) this.f1488b.get()).mo284a()) {
            return null;
        }
        LightSharedPreferences$Editor b = d.m2648b();
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) this.f1488b.get();
        if (fbSharedPreferences.mo285a(AuthPrefKeys.f2962q)) {
            String a = fbSharedPreferences.mo278a(AuthPrefKeys.f2962q, null);
            if (a != null) {
                user = ((UserSerialization) this.f1489c.get()).m21857a(Type.FACEBOOK, a);
                if (user != null) {
                    UserDataStore.m5752a(user, b);
                }
            }
            Editor edit = fbSharedPreferences.edit();
            edit.mo1271a(AuthPrefKeys.f2962q);
            edit.commit();
        }
        b.mo3285a("is_imported", true);
        b.mo3286b();
        return user;
    }

    final void m2881a(@Nullable User user) {
        if (user != null) {
            LightSharedPreferencesImpl d = m2879d(user.f3598a);
            if (d != null) {
                LightSharedPreferences$Editor b = d.m2648b();
                if (!d.m2647a("is_imported", false) && ((FbSharedPreferences) this.f1488b.get()).mo285a(AuthPrefKeys.f2962q)) {
                    Editor edit = ((FbSharedPreferences) this.f1488b.get()).edit();
                    edit.mo1271a(AuthPrefKeys.f2962q);
                    edit.commit();
                }
                b.mo3278a();
                UserDataStore.m5752a(user, b);
                b.mo3285a("is_imported", true);
                b.mo3286b();
            }
        }
    }

    final boolean m2882b(String str) {
        LightSharedPreferencesImpl d = m2879d(str);
        if (d == null) {
            return false;
        }
        return !TextUtils.isEmpty(d.m2643a("uid", null));
    }

    final void m2883c(String str) {
        LightSharedPreferencesImpl d = m2879d(str);
        if (d != null) {
            boolean a = d.m2647a("is_imported", false);
            LightSharedPreferences$Editor b = d.m2648b();
            b.mo3278a();
            if (a) {
                b.mo3285a("is_imported", true);
            }
            b.mo3286b();
        }
    }

    @VisibleForTesting
    private LightSharedPreferencesImpl m2879d(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f1487a.m2550a("logged_in_" + str);
    }
}
