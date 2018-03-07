package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class PlaceReport implements SafeParcelable {
    public static final Creator<PlaceReport> CREATOR = new zzj();
    public final int f6457a;
    public final String f6458b;
    public final String f6459c;
    public final String f6460d;

    PlaceReport(int i, String str, String str2, String str3) {
        this.f6457a = i;
        this.f6458b = str;
        this.f6459c = str2;
        this.f6460d = str3;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzw.a(this.f6458b, placeReport.f6458b) && zzw.a(this.f6459c, placeReport.f6459c) && zzw.a(this.f6460d, placeReport.f6460d);
    }

    public int hashCode() {
        return zzw.a(new Object[]{this.f6458b, this.f6459c, this.f6460d});
    }

    public String toString() {
        zza a = zzw.a(this);
        a.a("placeId", this.f6458b);
        a.a("tag", this.f6459c);
        if (!"unknown".equals(this.f6460d)) {
            a.a("source", this.f6460d);
        }
        return a.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6457a);
        zzb.a(parcel, 2, this.f6458b, false);
        zzb.a(parcel, 3, this.f6459c, false);
        zzb.a(parcel, 4, this.f6460d, false);
        zzb.c(parcel, a);
    }
}
