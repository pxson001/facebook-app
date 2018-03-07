package com.google.android.gms.auth;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    public final int f6355a;
    public final String f6356b;
    public final Long f6357c;
    public final boolean f6358d;
    public final boolean f6359e;
    public final List<String> f6360f;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.f6355a = i;
        this.f6356b = zzx.a(str);
        this.f6357c = l;
        this.f6358d = z;
        this.f6359e = z2;
        this.f6360f = list;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f6356b, tokenData.f6356b) && zzw.a(this.f6357c, tokenData.f6357c) && this.f6358d == tokenData.f6358d && this.f6359e == tokenData.f6359e && zzw.a(this.f6360f, tokenData.f6360f);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6356b, this.f6357c, Boolean.valueOf(this.f6358d), Boolean.valueOf(this.f6359e), this.f6360f});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.m12237a(parcel);
        zzb.m12241a(parcel, 1, this.f6355a);
        zzb.m12247a(parcel, 2, this.f6356b, false);
        zzb.m12246a(parcel, 3, this.f6357c, false);
        zzb.m12249a(parcel, 4, this.f6358d);
        zzb.m12249a(parcel, 5, this.f6359e);
        zzb.m12257b(parcel, 6, this.f6360f, false);
        zzb.m12258c(parcel, a);
    }
}
