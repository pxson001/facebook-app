package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzl implements Creator<StreetViewPanoramaLocation> {
    public static StreetViewPanoramaLocation m9938a(Parcel parcel) {
        int b = zza.b(parcel);
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    i = zza.e(parcel, a);
                    break;
                case 2:
                    streetViewPanoramaLinkArr = (StreetViewPanoramaLink[]) zza.b(parcel, a, StreetViewPanoramaLink.CREATOR);
                    break;
                case 3:
                    latLng = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 4:
                    str = zza.n(parcel, a);
                    break;
                default:
                    zza.a(parcel, a);
                    break;
            }
        }
        if (parcel.dataPosition() == b) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9938a(parcel);
    }

    public Object[] newArray(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
