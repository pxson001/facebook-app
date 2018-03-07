package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzsd;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzf {
    public final Account f18104a;
    public final Set<Scope> f18105b;
    public final Set<Scope> f18106c;
    public final Map<Api<?>, zza> f18107d;
    private final int f18108e;
    private final View f18109f;
    public final String f18110g;
    public final String f18111h;
    public final zzsd f18112i;
    public Integer f18113j;

    public zzf(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zzsd com_google_android_gms_internal_zzsd) {
        Map map2;
        this.f18104a = account;
        this.f18105b = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.f18107d = map2;
        this.f18109f = view;
        this.f18108e = i;
        this.f18110g = str;
        this.f18111h = str2;
        this.f18112i = com_google_android_gms_internal_zzsd;
        Set hashSet = new HashSet(this.f18105b);
        for (zza com_google_android_gms_common_internal_zzf_zza : this.f18107d.values()) {
            hashSet.addAll(com_google_android_gms_common_internal_zzf_zza.a);
        }
        this.f18106c = Collections.unmodifiableSet(hashSet);
    }

    public static zzf m25412a(Context context) {
        return new Builder(context).m25140a();
    }

    public final Account m25413a() {
        return this.f18104a;
    }

    public final Account m25414b() {
        return this.f18104a != null ? this.f18104a : new Account("<<default account>>", "com.google");
    }

    public final Map<Api<?>, zza> m25415e() {
        return this.f18107d;
    }

    public final Integer m25416i() {
        return this.f18113j;
    }
}
