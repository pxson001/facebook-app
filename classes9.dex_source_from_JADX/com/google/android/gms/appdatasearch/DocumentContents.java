package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class DocumentContents implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public final int f20532a;
    public final DocumentSection[] f20533b;
    public final String f20534c;
    public final boolean f20535d;
    public final Account f20536e;

    DocumentContents(int i, DocumentSection[] documentSectionArr, String str, boolean z, Account account) {
        this.f20532a = i;
        this.f20533b = documentSectionArr;
        this.f20534c = str;
        this.f20535d = z;
        this.f20536e = account;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f20533b, i, false);
        zzb.a(parcel, 1000, this.f20532a);
        zzb.a(parcel, 2, this.f20534c, false);
        zzb.a(parcel, 3, this.f20535d);
        zzb.a(parcel, 4, this.f20536e, i, false);
        zzb.c(parcel, a);
    }
}
