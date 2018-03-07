package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONObject;

public class SignInAccount implements SafeParcelable {
    public static final Creator<SignInAccount> CREATOR = new zzf();
    public final int f6397a;
    public String f6398b;
    public String f6399c;
    public String f6400d;
    public String f6401e;
    public Uri f6402f;
    public GoogleSignInAccount f6403g;
    public String f6404h;
    public String f6405i;

    SignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, GoogleSignInAccount googleSignInAccount, String str5, String str6) {
        this.f6397a = i;
        this.f6400d = zzx.a(str3, "Email cannot be empty.");
        this.f6401e = str4;
        this.f6402f = uri;
        this.f6398b = str;
        this.f6399c = str2;
        this.f6403g = googleSignInAccount;
        this.f6404h = zzx.a(str5);
        this.f6405i = str6;
    }

    private static SignInAccount m12088a(zze com_google_android_gms_auth_api_signin_zze, String str, String str2, String str3, Uri uri, String str4, String str5) {
        String str6 = null;
        if (com_google_android_gms_auth_api_signin_zze != null) {
            str6 = com_google_android_gms_auth_api_signin_zze.zzmC();
        }
        return new SignInAccount(2, str6, str, str2, str3, uri, null, str4, str5);
    }

    public static SignInAccount m12089a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        SignInAccount a = m12088a(zze.zzbI(jSONObject.optString("providerId", null)), jSONObject.optString("tokenId", null), jSONObject.getString("email"), jSONObject.optString("displayName", null), !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null, jSONObject.getString("localId"), jSONObject.optString("refreshToken"));
        a.f6403g = GoogleSignInAccount.m12068a(jSONObject.optString("googleSignInAccount"));
        return a;
    }

    private JSONObject m12090j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("email", m12092b());
            if (!TextUtils.isEmpty(this.f6401e)) {
                jSONObject.put("displayName", this.f6401e);
            }
            if (this.f6402f != null) {
                jSONObject.put("photoUrl", this.f6402f.toString());
            }
            if (!TextUtils.isEmpty(this.f6398b)) {
                jSONObject.put("providerId", this.f6398b);
            }
            if (!TextUtils.isEmpty(this.f6399c)) {
                jSONObject.put("tokenId", this.f6399c);
            }
            if (this.f6403g != null) {
                jSONObject.put("googleSignInAccount", this.f6403g.m12078i());
            }
            if (!TextUtils.isEmpty(this.f6405i)) {
                jSONObject.put("refreshToken", this.f6405i);
            }
            jSONObject.put("localId", m12094f());
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final SignInAccount m12091a(GoogleSignInAccount googleSignInAccount) {
        this.f6403g = googleSignInAccount;
        return this;
    }

    public final String m12092b() {
        return this.f6400d;
    }

    public int describeContents() {
        return 0;
    }

    public final GoogleSignInAccount m12093e() {
        return this.f6403g;
    }

    public final String m12094f() {
        return this.f6404h;
    }

    public final String m12095h() {
        return m12090j().toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6397a);
        zzb.m12247a(parcel, 2, this.f6398b, false);
        zzb.m12247a(parcel, 3, this.f6399c, false);
        zzb.m12247a(parcel, 4, this.f6400d, false);
        zzb.m12247a(parcel, 5, this.f6401e, false);
        zzb.m12245a(parcel, 6, (Parcelable) this.f6402f, i, false);
        zzb.m12245a(parcel, 7, (Parcelable) this.f6403g, i, false);
        zzb.m12247a(parcel, 8, this.f6404h, false);
        zzb.m12247a(parcel, 9, this.f6405i, false);
        zzb.m12258c(parcel, a);
    }
}
