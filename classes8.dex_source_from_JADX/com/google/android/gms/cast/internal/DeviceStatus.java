package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;

public class DeviceStatus implements SafeParcelable {
    public static final Creator<DeviceStatus> CREATOR = new zzg();
    public final int f10120a;
    public double f10121b;
    public boolean f10122c;
    public int f10123d;
    public ApplicationMetadata f10124e;
    public int f10125f;

    public DeviceStatus() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    DeviceStatus(int i, double d, boolean z, int i2, ApplicationMetadata applicationMetadata, int i3) {
        this.f10120a = i;
        this.f10121b = d;
        this.f10122c = z;
        this.f10123d = i2;
        this.f10124e = applicationMetadata;
        this.f10125f = i3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        return this.f10121b == deviceStatus.f10121b && this.f10122c == deviceStatus.f10122c && this.f10123d == deviceStatus.f10123d && zzf.m11922a(this.f10124e, deviceStatus.f10124e) && this.f10125f == deviceStatus.f10125f;
    }

    public int hashCode() {
        return zzw.a(new Object[]{Double.valueOf(this.f10121b), Boolean.valueOf(this.f10122c), Integer.valueOf(this.f10123d), this.f10124e, Integer.valueOf(this.f10125f)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f10120a);
        zzb.a(parcel, 2, this.f10121b);
        zzb.a(parcel, 3, this.f10122c);
        zzb.a(parcel, 4, this.f10123d);
        zzb.a(parcel, 5, this.f10124e, i, false);
        zzb.a(parcel, 6, this.f10125f);
        zzb.c(parcel, a);
    }
}
