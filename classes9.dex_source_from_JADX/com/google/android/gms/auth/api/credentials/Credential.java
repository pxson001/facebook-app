package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class Credential implements SafeParcelable {
    public static final Creator<Credential> CREATOR = new zza();
    public final int f3587a;
    public final String f3588b;
    public final String f3589c;
    public final Uri f3590d;
    public final List<IdToken> f3591e;
    public final String f3592f;
    public final String f3593g;
    public final String f3594h;
    public final String f3595i;

    Credential(int i, String str, String str2, Uri uri, List<IdToken> list, String str3, String str4, String str5, String str6) {
        this.f3587a = i;
        String trim = ((String) zzx.a(str, "credential identifier cannot be null")).trim();
        zzx.a(trim, "credential identifier cannot be empty");
        this.f3588b = trim;
        this.f3589c = str2;
        this.f3590d = uri;
        this.f3591e = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f3592f = str3;
        if (str3 == null || !str3.isEmpty()) {
            if (!TextUtils.isEmpty(str4)) {
                trim = Uri.parse(str4).getScheme();
                boolean z = "http".equalsIgnoreCase(trim) || "https".equalsIgnoreCase(trim);
                zzx.b(z);
            }
            this.f3593g = str4;
            this.f3594h = str5;
            this.f3595i = str6;
            if (!TextUtils.isEmpty(this.f3592f) && !TextUtils.isEmpty(this.f3593g)) {
                throw new IllegalStateException("password and accountType cannot both be set");
            }
            return;
        }
        throw new IllegalArgumentException("password cannot be empty");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f3588b, credential.f3588b) && TextUtils.equals(this.f3589c, credential.f3589c) && zzw.a(this.f3590d, credential.f3590d) && TextUtils.equals(this.f3592f, credential.f3592f) && TextUtils.equals(this.f3593g, credential.f3593g) && TextUtils.equals(this.f3594h, credential.f3594h);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f3588b, this.f3589c, this.f3590d, this.f3592f, this.f3593g, this.f3594h});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f3588b, false);
        zzb.a(parcel, 1000, this.f3587a);
        zzb.a(parcel, 2, this.f3589c, false);
        zzb.a(parcel, 3, this.f3590d, i, false);
        zzb.c(parcel, 4, this.f3591e, false);
        zzb.a(parcel, 5, this.f3592f, false);
        zzb.a(parcel, 6, this.f3593g, false);
        zzb.a(parcel, 7, this.f3594h, false);
        zzb.a(parcel, 8, this.f3595i, false);
        zzb.c(parcel, a);
    }
}
