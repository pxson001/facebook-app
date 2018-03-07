package com.facebook.contacts.upload.prefs;

import com.facebook.common.util.TriState;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: group_activity */
public class ContactUploadStatusHelper {
    private final Provider<String> f10956a;
    private final FbSharedPreferences f10957b;

    public static ContactUploadStatusHelper m11414b(InjectorLike injectorLike) {
        return new ContactUploadStatusHelper(IdBasedProvider.a(injectorLike, 4442), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public ContactUploadStatusHelper(Provider<String> provider, FbSharedPreferences fbSharedPreferences) {
        this.f10956a = provider;
        this.f10957b = fbSharedPreferences;
    }

    public final boolean m11418a() {
        m11416d();
        PrefKey c = m11415c();
        if (c == null) {
            return false;
        }
        return this.f10957b.a(c, false);
    }

    public final TriState m11419b() {
        m11416d();
        PrefKey c = m11415c();
        if (c == null) {
            return TriState.UNSET;
        }
        return this.f10957b.b(c);
    }

    public static ContactUploadStatusHelper m11413a(InjectorLike injectorLike) {
        return m11414b(injectorLike);
    }

    public final void m11417a(boolean z) {
        m11416d();
        PrefKey c = m11415c();
        if (c != null) {
            this.f10957b.edit().putBoolean(c, z).commit();
        }
    }

    @Nullable
    private PrefKey m11415c() {
        String str = (String) this.f10956a.get();
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        return (PrefKey) ContactsUploadPrefKeys.f10959b.a(str);
    }

    private synchronized void m11416d() {
        PrefKey c = m11415c();
        if (!(c == null || this.f10957b.a(c) || !this.f10957b.a(ContactsUploadPrefKeys.f10958a))) {
            TriState b = this.f10957b.b(ContactsUploadPrefKeys.f10958a);
            if (b.isSet()) {
                this.f10957b.edit().putBoolean(c, b.asBoolean(false)).commit();
            }
        }
    }
}
