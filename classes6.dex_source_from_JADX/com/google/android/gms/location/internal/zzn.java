package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzn implements Creator<LocationRequestUpdateData> {
    public static LocationRequestUpdateData m8952a(Parcel parcel) {
        IBinder iBinder = null;
        int b = zza.b(parcel);
        int i = 0;
        int i2 = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i2 = zza.e(parcel, a);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) zza.a(parcel, a, LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinder3 = zza.o(parcel, a);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zza.a(parcel, a, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = zza.o(parcel, a);
                    break;
                case 6:
                    iBinder = zza.o(parcel, a);
                    break;
                case 1000:
                    i = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new LocationRequestUpdateData(i, i2, locationRequestInternal, iBinder3, pendingIntent, iBinder2, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m8952a(parcel);
    }

    public Object[] newArray(int i) {
        return new LocationRequestUpdateData[i];
    }
}
