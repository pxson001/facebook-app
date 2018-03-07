package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONObject;

public class EmailSignInOptions implements SafeParcelable {
    public static final Creator<EmailSignInOptions> CREATOR = new zza();
    public final int f6361a;
    public final Uri f6362b;
    public String f6363c;
    public Uri f6364d;

    EmailSignInOptions(int i, Uri uri, String str, Uri uri2) {
        zzx.a(uri, "Server widget url cannot be null in order to use email/password sign in.");
        zzx.a(uri.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.b(Patterns.WEB_URL.matcher(uri.toString()).matches(), "Invalid server widget url");
        this.f6361a = i;
        this.f6362b = uri;
        this.f6363c = str;
        this.f6364d = uri2;
    }

    private JSONObject m12060e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.f6362b.toString());
            if (!TextUtils.isEmpty(this.f6363c)) {
                jSONObject.put("modeQueryName", this.f6363c);
            }
            if (this.f6364d != null) {
                jSONObject.put("tosUrl", this.f6364d.toString());
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final Uri m12061a() {
        return this.f6362b;
    }

    public final Uri m12062b() {
        return this.f6364d;
    }

    public final String m12063c() {
        return this.f6363c;
    }

    public final String m12064d() {
        return m12060e().toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
            if (!this.f6362b.equals(emailSignInOptions.m12061a())) {
                return false;
            }
            if (this.f6364d == null) {
                if (emailSignInOptions.m12062b() != null) {
                    return false;
                }
            } else if (!this.f6364d.equals(emailSignInOptions.m12062b())) {
                return false;
            }
            if (TextUtils.isEmpty(this.f6363c)) {
                if (!TextUtils.isEmpty(emailSignInOptions.m12063c())) {
                    return false;
                }
            } else if (!this.f6363c.equals(emailSignInOptions.m12063c())) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zze().m12104a(this.f6362b).m12104a(this.f6364d).m12104a(this.f6363c).f6414b;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6361a);
        zzb.m12245a(parcel, 2, (Parcelable) this.f6362b, i, false);
        zzb.m12247a(parcel, 3, this.f6363c, false);
        zzb.m12245a(parcel, 4, (Parcelable) this.f6364d, i, false);
        zzb.m12258c(parcel, a);
    }
}
