package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class ApplicationStatus implements SafeParcelable {
    public static final Creator<ApplicationStatus> CREATOR = new zza();
    public final int f10118a;
    public String f10119b;

    public ApplicationStatus() {
        this(1, null);
    }

    ApplicationStatus(int i, String str) {
        this.f10118a = i;
        this.f10119b = str;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationStatus)) {
            return false;
        }
        return zzf.m11922a(this.f10119b, ((ApplicationStatus) obj).f10119b);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f10119b});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f10118a);
        zzb.a(parcel, 2, this.f10119b, false);
        zzb.c(parcel, a);
    }
}
