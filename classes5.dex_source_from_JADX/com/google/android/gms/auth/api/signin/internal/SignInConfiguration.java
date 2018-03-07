package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONObject;

public final class SignInConfiguration implements SafeParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzm();
    public final int f6406a;
    public final String f6407b;
    public String f6408c;
    public EmailSignInOptions f6409d;
    public GoogleSignInOptions f6410e;
    public FacebookSignInOptions f6411f;
    public String f6412g;

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, FacebookSignInOptions facebookSignInOptions, String str3) {
        this.f6406a = i;
        this.f6407b = zzx.a(str);
        this.f6408c = str2;
        this.f6409d = emailSignInOptions;
        this.f6410e = googleSignInOptions;
        this.f6411f = facebookSignInOptions;
        this.f6412g = str3;
    }

    private JSONObject m12096h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.f6407b);
            if (!TextUtils.isEmpty(this.f6408c)) {
                jSONObject.put("serverClientId", this.f6408c);
            }
            if (this.f6409d != null) {
                jSONObject.put("emailSignInOptions", this.f6409d.m12064d());
            }
            if (this.f6410e != null) {
                jSONObject.put("googleSignInOptions", this.f6410e.m12087g());
            }
            if (this.f6411f != null) {
                jSONObject.put("facebookSignInOptions", this.f6411f.m12067c());
            }
            if (!TextUtils.isEmpty(this.f6412g)) {
                jSONObject.put("apiKey", this.f6412g);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final String m12097a() {
        return this.f6407b;
    }

    public final String m12098b() {
        return this.f6408c;
    }

    public final EmailSignInOptions m12099c() {
        return this.f6409d;
    }

    public final GoogleSignInOptions m12100d() {
        return this.f6410e;
    }

    public final int describeContents() {
        return 0;
    }

    public final FacebookSignInOptions m12101e() {
        return this.f6411f;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.f6407b.equals(signInConfiguration.m12097a())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f6408c)) {
                if (!TextUtils.isEmpty(signInConfiguration.m12098b())) {
                    return false;
                }
            } else if (!this.f6408c.equals(signInConfiguration.m12098b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f6412g)) {
                if (!TextUtils.isEmpty(signInConfiguration.m12102f())) {
                    return false;
                }
            } else if (!this.f6412g.equals(signInConfiguration.m12102f())) {
                return false;
            }
            if (this.f6409d == null) {
                if (signInConfiguration.m12099c() != null) {
                    return false;
                }
            } else if (!this.f6409d.equals(signInConfiguration.m12099c())) {
                return false;
            }
            if (this.f6411f == null) {
                if (signInConfiguration.m12101e() != null) {
                    return false;
                }
            } else if (!this.f6411f.equals(signInConfiguration.m12101e())) {
                return false;
            }
            if (this.f6410e == null) {
                if (signInConfiguration.m12100d() != null) {
                    return false;
                }
            } else if (!this.f6410e.equals(signInConfiguration.m12100d())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public final String m12102f() {
        return this.f6412g;
    }

    public final String m12103g() {
        return m12096h().toString();
    }

    public final int hashCode() {
        return new zze().m12104a(this.f6407b).m12104a(this.f6408c).m12104a(this.f6412g).m12104a(this.f6409d).m12104a(this.f6410e).m12104a(this.f6411f).f6414b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6406a);
        zzb.m12247a(parcel, 2, this.f6407b, false);
        zzb.m12247a(parcel, 3, this.f6408c, false);
        zzb.m12245a(parcel, 4, (Parcelable) this.f6409d, i, false);
        zzb.m12245a(parcel, 5, (Parcelable) this.f6410e, i, false);
        zzb.m12245a(parcel, 6, (Parcelable) this.f6411f, i, false);
        zzb.m12247a(parcel, 7, this.f6412g, false);
        zzb.m12258c(parcel, a);
    }
}
