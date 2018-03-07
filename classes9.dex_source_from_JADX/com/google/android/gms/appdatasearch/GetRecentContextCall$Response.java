package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class GetRecentContextCall$Response implements Result, SafeParcelable {
    public static final zzg CREATOR = new zzg();
    public Status f20557a;
    public List<UsageInfo> f20558b;
    public String[] f20559c;
    public final int f20560d;

    public GetRecentContextCall$Response() {
        this.f20560d = 1;
    }

    GetRecentContextCall$Response(int i, Status status, List<UsageInfo> list, String[] strArr) {
        this.f20560d = i;
        this.f20557a = status;
        this.f20558b = list;
        this.f20559c = strArr;
    }

    public final Status cp_() {
        return this.f20557a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1000, this.f20560d);
        zzb.a(parcel, 1, this.f20557a, i, false);
        zzb.c(parcel, 2, this.f20558b, false);
        zzb.a(parcel, 3, this.f20559c, false);
        zzb.c(parcel, a);
    }
}
