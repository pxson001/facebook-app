package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;

public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    public int f6368a;
    public LocationRequestInternal f6369b;
    public zzd f6370c;
    public PendingIntent f6371d;
    public zzc f6372e;
    public zzg f6373f;
    public final int f6374g;

    public LocationRequestUpdateData(int i, int i2, LocationRequestInternal locationRequestInternal, IBinder iBinder, PendingIntent pendingIntent, IBinder iBinder2, IBinder iBinder3) {
        zzc com_google_android_gms_location_zzc;
        zzg com_google_android_gms_location_internal_zzg = null;
        this.f6374g = i;
        this.f6368a = i2;
        this.f6369b = locationRequestInternal;
        this.f6370c = iBinder == null ? null : zza.m8945a(iBinder);
        this.f6371d = pendingIntent;
        if (iBinder2 == null) {
            com_google_android_gms_location_zzc = null;
        } else {
            zzc com_google_android_gms_location_zzc2;
            if (iBinder2 == null) {
                com_google_android_gms_location_zzc2 = null;
            } else {
                IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
                com_google_android_gms_location_zzc2 = (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new zzc.zza.zza(iBinder2) : (zzc) queryLocalInterface;
            }
            com_google_android_gms_location_zzc = com_google_android_gms_location_zzc2;
        }
        this.f6372e = com_google_android_gms_location_zzc;
        if (iBinder3 != null) {
            com_google_android_gms_location_internal_zzg = zzg.zza.m8870a(iBinder3);
        }
        this.f6373f = com_google_android_gms_location_internal_zzg;
    }

    public static LocationRequestUpdateData m8859a(zzc com_google_android_gms_location_zzc, zzg com_google_android_gms_location_internal_zzg) {
        return new LocationRequestUpdateData(1, 2, null, null, null, com_google_android_gms_location_zzc.asBinder(), com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
    }

    public static LocationRequestUpdateData m8860a(zzd com_google_android_gms_location_zzd, zzg com_google_android_gms_location_internal_zzg) {
        return new LocationRequestUpdateData(1, 2, null, com_google_android_gms_location_zzd.asBinder(), null, null, com_google_android_gms_location_internal_zzg != null ? com_google_android_gms_location_internal_zzg.asBinder() : null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6368a);
        zzb.a(parcel, 1000, this.f6374g);
        zzb.a(parcel, 2, this.f6369b, i, false);
        zzb.a(parcel, 3, this.f6370c == null ? null : this.f6370c.asBinder(), false);
        zzb.a(parcel, 4, this.f6371d, i, false);
        zzb.a(parcel, 5, this.f6372e == null ? null : this.f6372e.asBinder(), false);
        zzb.a(parcel, 6, this.f6373f == null ? null : this.f6373f.asBinder(), false);
        zzb.c(parcel, a);
    }
}
