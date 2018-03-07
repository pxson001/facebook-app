package com.facebook.contacts.ccu;

import com.facebook.common.util.TriState;
import com.facebook.growth.prefs.FriendFinderPrefKeys;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: ipc call failed */
public class ContactsUploadStatusHelper {
    public final Provider<String> f10178a;
    public final FbSharedPreferences f10179b;

    public static ContactsUploadStatusHelper m10642b(InjectorLike injectorLike) {
        return new ContactsUploadStatusHelper(IdBasedProvider.a(injectorLike, 4442), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public ContactsUploadStatusHelper(Provider<String> provider, FbSharedPreferences fbSharedPreferences) {
        this.f10178a = provider;
        this.f10179b = fbSharedPreferences;
    }

    public final boolean m10645a() {
        PrefKey d = m10643d();
        PrefKey a = GrowthPrefKeys.m1227a((String) this.f10178a.get());
        if (d == null || a == null) {
            return false;
        }
        TriState b = this.f10179b.b(a);
        return (b == TriState.UNSET || b == this.f10179b.b(d)) ? false : true;
    }

    public final TriState m10646b() {
        PrefKey d = m10643d();
        PrefKey a = GrowthPrefKeys.m1227a((String) this.f10178a.get());
        if (d == null || a == null) {
            return TriState.UNSET;
        }
        if (m10645a()) {
            m10644a(this.f10179b.b(a).asBoolean(false));
        }
        return this.f10179b.b(d);
    }

    public final void m10644a(boolean z) {
        PrefKey prefKey;
        PrefKey d = m10643d();
        String str = (String) this.f10178a.get();
        if (Strings.isNullOrEmpty(str)) {
            prefKey = null;
        } else {
            prefKey = (PrefKey) ContactsUploadPrefKeys.d.a(str);
        }
        PrefKey prefKey2 = prefKey;
        PrefKey a = FriendFinderPrefKeys.a((String) this.f10178a.get(), this.f10179b);
        PrefKey a2 = GrowthPrefKeys.m1227a((String) this.f10178a.get());
        if (d != null && prefKey2 != null) {
            this.f10179b.edit().putBoolean(d, z).commit();
            this.f10179b.edit().putBoolean(prefKey2, z).commit();
            this.f10179b.edit().putBoolean(a, z).commit();
            this.f10179b.edit().putBoolean(a2, z).commit();
            if (!z) {
                this.f10179b.edit().a(ContactsUploadPrefKeys.a);
                this.f10179b.edit().a(ContactsUploadPrefKeys.b);
            }
        }
    }

    public final void m10647c() {
        PrefKey d = m10643d();
        if (d != null) {
            this.f10179b.edit().a(d).commit();
        }
    }

    @Nullable
    private PrefKey m10643d() {
        String str = (String) this.f10178a.get();
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        return (PrefKey) ContactsUploadPrefKeys.c.a(str);
    }
}
