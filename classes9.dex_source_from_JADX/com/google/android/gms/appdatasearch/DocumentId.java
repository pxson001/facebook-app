package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class DocumentId implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public final int f20537a;
    public final String f20538b;
    public final String f20539c;
    public final String f20540d;

    DocumentId(int i, String str, String str2, String str3) {
        this.f20537a = i;
        this.f20538b = str;
        this.f20539c = str2;
        this.f20540d = str3;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("DocumentId[packageName=%s, corpusName=%s, uri=%s]", new Object[]{this.f20538b, this.f20539c, this.f20540d});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f20538b, false);
        zzb.a(parcel, 1000, this.f20537a);
        zzb.a(parcel, 2, this.f20539c, false);
        zzb.a(parcel, 3, this.f20540d, false);
        zzb.c(parcel, a);
    }
}
