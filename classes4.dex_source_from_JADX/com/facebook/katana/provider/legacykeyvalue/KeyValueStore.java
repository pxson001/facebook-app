package com.facebook.katana.provider.legacykeyvalue;

import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.base.Preconditions;

@Deprecated
/* compiled from: get_fbids_for_hashes_no_cursor */
public class KeyValueStore {
    public final FbSharedPreferences f11074a;
    public final PrefKey f11075b;
    public final LegacyKeyValueStore f11076c;

    public KeyValueStore(FbSharedPreferences fbSharedPreferences, PrefKey prefKey, LegacyKeyValueStore legacyKeyValueStore) {
        this.f11074a = fbSharedPreferences;
        this.f11075b = prefKey;
        this.f11076c = legacyKeyValueStore;
    }

    public final void m11500a(String str) {
        this.f11076c.m11497b(str);
        this.f11074a.edit().a(m11498b(str)).commit();
    }

    public final String m11499a(String str, String str2) {
        String str3;
        String a = this.f11074a.a(m11498b(str), null);
        if (a == null) {
            a = this.f11076c.m11496a(str);
            m11501a(str, a == null ? "kvm_null_flag" : a, false);
            try {
                this.f11076c.m11497b(str);
                str3 = a;
            } catch (IllegalArgumentException e) {
            }
            return (str3 == null || "kvm_null_flag".equals(str3)) ? str2 : str3;
        }
        str3 = a;
        if (str3 == null) {
            return str2;
        }
    }

    final void m11501a(String str, String str2, boolean z) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        if (z) {
            Preconditions.checkArgument(!"kvm_null_flag".equals(str2), "%s can't be stored as a value in KVM, as it is a reserved keyword.", new Object[]{"kvm_null_flag"});
        }
        this.f11074a.edit().a(m11498b(str), str2).commit();
    }

    private PrefKey m11498b(String str) {
        return (PrefKey) this.f11075b.a(str);
    }
}
