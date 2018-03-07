package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzc implements Creator<AddListenerRequest> {
    public Object createFromParcel(Parcel parcel) {
        String str = null;
        int b = zza.b(parcel);
        int i = 0;
        String str2 = null;
        IntentFilter[] intentFilterArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    iBinder = zza.o(parcel, a);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) zza.b(parcel, a, IntentFilter.CREATOR);
                    break;
                case 4:
                    str2 = zza.n(parcel, a);
                    break;
                case 5:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new AddListenerRequest(i, iBinder, intentFilterArr, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new AddListenerRequest[i];
    }
}
