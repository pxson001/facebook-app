package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzf implements Creator<PasswordSpecification> {
    public Object createFromParcel(Parcel parcel) {
        List list = null;
        int i = 0;
        int b = zza.b(parcel);
        int i2 = 0;
        List list2 = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str = zza.n(parcel, a);
                    break;
                case 2:
                    list2 = zza.A(parcel, a);
                    break;
                case 3:
                    list = zza.z(parcel, a);
                    break;
                case 4:
                    i2 = zza.e(parcel, a);
                    break;
                case 5:
                    i = zza.e(parcel, a);
                    break;
                case 1000:
                    i3 = zza.e(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new PasswordSpecification(i3, str, list2, list, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new PasswordSpecification[i];
    }
}
