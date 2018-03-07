package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new zzc();
    public static zznl f6368a = zzno.c();
    private static Comparator<Scope> f6369l = new C05631();
    public final int f6370b;
    public List<Scope> f6371c;
    public String f6372d;
    public String f6373e;
    public String f6374f;
    public String f6375g;
    public Uri f6376h;
    public String f6377i;
    public long f6378j;
    public String f6379k;

    final class C05631 implements Comparator<Scope> {
        C05631() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((Scope) obj).b.compareTo(((Scope) obj2).b);
        }
    }

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list) {
        this.f6370b = i;
        this.f6372d = str;
        this.f6373e = str2;
        this.f6374f = str3;
        this.f6375g = str4;
        this.f6376h = uri;
        this.f6377i = str5;
        this.f6378j = j;
        this.f6379k = str6;
        this.f6371c = list;
    }

    public static GoogleSignInAccount m12068a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Set hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount a = m12069a(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        a.f6377i = jSONObject.optString("serverAuthCode", null);
        return a;
    }

    private static GoogleSignInAccount m12069a(String str, String str2, String str3, String str4, Uri uri, Long l, String str5, Set<Scope> set) {
        if (l == null) {
            l = Long.valueOf(f6368a.a() / 1000);
        }
        return new GoogleSignInAccount(2, str, str2, str3, str4, uri, null, l.longValue(), zzx.a(str5), new ArrayList((Collection) zzx.a(set)));
    }

    private JSONObject m12070k() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m12071a() != null) {
                jSONObject.put("id", m12071a());
            }
            if (m12072b() != null) {
                jSONObject.put("tokenId", m12072b());
            }
            if (m12073c() != null) {
                jSONObject.put("email", m12073c());
            }
            if (m12074d() != null) {
                jSONObject.put("displayName", m12074d());
            }
            if (m12075e() != null) {
                jSONObject.put("photoUrl", m12075e().toString());
            }
            if (m12076f() != null) {
                jSONObject.put("serverAuthCode", m12076f());
            }
            jSONObject.put("expirationTime", this.f6378j);
            jSONObject.put("obfuscatedIdentifier", m12077h());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f6371c, f6369l);
            for (Scope a : this.f6371c) {
                jSONArray.put(a.a());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final String m12071a() {
        return this.f6372d;
    }

    public final String m12072b() {
        return this.f6373e;
    }

    public final String m12073c() {
        return this.f6374f;
    }

    public final String m12074d() {
        return this.f6375g;
    }

    public int describeContents() {
        return 0;
    }

    public final Uri m12075e() {
        return this.f6376h;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof GoogleSignInAccount) ? false : ((GoogleSignInAccount) obj).m12078i().equals(m12078i());
    }

    public final String m12076f() {
        return this.f6377i;
    }

    public final String m12077h() {
        return this.f6379k;
    }

    public final String m12078i() {
        return m12070k().toString();
    }

    public final String m12079j() {
        JSONObject k = m12070k();
        k.remove("serverAuthCode");
        return k.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6370b);
        zzb.m12247a(parcel, 2, this.f6372d, false);
        zzb.m12247a(parcel, 3, this.f6373e, false);
        zzb.m12247a(parcel, 4, this.f6374f, false);
        zzb.m12247a(parcel, 5, this.f6375g, false);
        zzb.m12245a(parcel, 6, (Parcelable) this.f6376h, i, false);
        zzb.m12247a(parcel, 7, this.f6377i, false);
        zzb.m12242a(parcel, 8, this.f6378j);
        zzb.m12247a(parcel, 9, this.f6379k, false);
        zzb.m12259c(parcel, 10, this.f6371c, false);
        zzb.m12258c(parcel, a);
    }
}
