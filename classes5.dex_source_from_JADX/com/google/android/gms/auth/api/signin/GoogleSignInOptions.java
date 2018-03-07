package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GoogleSignInOptions implements Optional, SafeParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new zzd();
    public static final Scope f6386a = new Scope("profile");
    public static final Scope f6387b = new Scope("email");
    public static final Scope f6388c = new Scope("openid");
    public static final GoogleSignInOptions f6389d;
    public final int f6390e;
    private final ArrayList<Scope> f6391f;
    public Account f6392g;
    public boolean f6393h;
    public final boolean f6394i;
    public final boolean f6395j;
    public String f6396k;

    public final class Builder {
        public Set<Scope> f6380a = new HashSet();
        public boolean f6381b;
        public boolean f6382c;
        public boolean f6383d;
        public String f6384e;
        public Account f6385f;
    }

    static {
        Builder builder = new Builder();
        builder.f6380a.add(f6388c);
        builder = builder;
        builder.f6380a.add(f6386a);
        builder = builder;
        f6389d = new GoogleSignInOptions(builder.f6380a, builder.f6385f, builder.f6383d, builder.f6381b, builder.f6382c, builder.f6384e);
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str) {
        this.f6390e = i;
        this.f6391f = arrayList;
        this.f6392g = account;
        this.f6393h = z;
        this.f6394i = z2;
        this.f6395j = z3;
        this.f6396k = str;
    }

    private GoogleSignInOptions(Set<Scope> set, Account account, boolean z, boolean z2, boolean z3, String str) {
        this(1, new ArrayList(set), account, z, z2, z3, str);
    }

    private JSONObject m12080h() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f6391f.iterator();
            while (it.hasNext()) {
                jSONArray.put(((Scope) it.next()).a());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f6392g != null) {
                jSONObject.put("accountName", this.f6392g.name);
            }
            jSONObject.put("idTokenRequested", this.f6393h);
            jSONObject.put("forceCodeForRefreshToken", this.f6395j);
            jSONObject.put("serverAuthRequested", this.f6394i);
            if (!TextUtils.isEmpty(this.f6396k)) {
                jSONObject.put("serverClientId", this.f6396k);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final ArrayList<Scope> m12081a() {
        return new ArrayList(this.f6391f);
    }

    public final Account m12082b() {
        return this.f6392g;
    }

    public final boolean m12083c() {
        return this.f6393h;
    }

    public final boolean m12084d() {
        return this.f6394i;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean m12085e() {
        return this.f6395j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.f6391f.size() != googleSignInOptions.m12081a().size() || !this.f6391f.containsAll(googleSignInOptions.m12081a())) {
                return false;
            }
            if (this.f6392g == null) {
                if (googleSignInOptions.m12082b() != null) {
                    return false;
                }
            } else if (!this.f6392g.equals(googleSignInOptions.m12082b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f6396k)) {
                if (!TextUtils.isEmpty(googleSignInOptions.m12086f())) {
                    return false;
                }
            } else if (!this.f6396k.equals(googleSignInOptions.m12086f())) {
                return false;
            }
            return this.f6395j == googleSignInOptions.m12085e() && this.f6393h == googleSignInOptions.m12083c() && this.f6394i == googleSignInOptions.m12084d();
        } catch (ClassCastException e) {
            return false;
        }
    }

    public final String m12086f() {
        return this.f6396k;
    }

    public final String m12087g() {
        return m12080h().toString();
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        Iterator it = this.f6391f.iterator();
        while (it.hasNext()) {
            arrayList.add(((Scope) it.next()).b);
        }
        Collections.sort(arrayList);
        return new zze().m12104a(arrayList).m12104a(this.f6392g).m12104a(this.f6396k).m12105a(this.f6395j).m12105a(this.f6393h).m12105a(this.f6394i).f6414b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6390e);
        zzb.m12259c(parcel, 2, m12081a(), false);
        zzb.m12245a(parcel, 3, (Parcelable) this.f6392g, i, false);
        zzb.m12249a(parcel, 4, this.f6393h);
        zzb.m12249a(parcel, 5, this.f6394i);
        zzb.m12249a(parcel, 6, this.f6395j);
        zzb.m12247a(parcel, 7, this.f6396k, false);
        zzb.m12258c(parcel, a);
    }
}
