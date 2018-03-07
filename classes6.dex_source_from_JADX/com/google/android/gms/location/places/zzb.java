package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class zzb implements Creator<AddPlaceRequest> {
    public Object createFromParcel(Parcel parcel) {
        Uri uri = null;
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        List list = null;
        String str2 = null;
        LatLng latLng = null;
        String str3 = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str3 = zza.n(parcel, a);
                    break;
                case 2:
                    latLng = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 3:
                    str2 = zza.n(parcel, a);
                    break;
                case 4:
                    list = zza.z(parcel, a);
                    break;
                case 5:
                    str = zza.n(parcel, a);
                    break;
                case 6:
                    uri = (Uri) zza.a(parcel, a, Uri.CREATOR);
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
            return new AddPlaceRequest(i, str3, latLng, str2, list, str, uri);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public Object[] newArray(int i) {
        return new AddPlaceRequest[i];
    }
}
