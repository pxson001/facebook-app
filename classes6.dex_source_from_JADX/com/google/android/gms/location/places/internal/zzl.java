package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public class zzl implements Creator<PlaceImpl> {
    private static PlaceImpl m9100a(Parcel parcel) {
        int b = zza.b(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        Bundle bundle = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        List list3 = null;
        LatLng latLng = null;
        float f = 0.0f;
        LatLngBounds latLngBounds = null;
        String str6 = null;
        Uri uri = null;
        boolean z = false;
        float f2 = 0.0f;
        int i2 = 0;
        long j = 0;
        boolean z2 = false;
        PlaceLocalization placeLocalization = null;
        while (parcel.dataPosition() < b) {
            int a = zza.a(parcel);
            switch (zza.a(a)) {
                case 1:
                    str = zza.n(parcel, a);
                    break;
                case 2:
                    bundle = zza.p(parcel, a);
                    break;
                case 3:
                    placeLocalization = (PlaceLocalization) zza.a(parcel, a, PlaceLocalization.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) zza.a(parcel, a, LatLng.CREATOR);
                    break;
                case 5:
                    f = zza.j(parcel, a);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.a(parcel, a, LatLngBounds.CREATOR);
                    break;
                case 7:
                    str6 = zza.n(parcel, a);
                    break;
                case 8:
                    uri = (Uri) zza.a(parcel, a, Uri.CREATOR);
                    break;
                case 9:
                    z = zza.b(parcel, a);
                    break;
                case 10:
                    f2 = zza.j(parcel, a);
                    break;
                case 11:
                    i2 = zza.e(parcel, a);
                    break;
                case 12:
                    j = zza.g(parcel, a);
                    break;
                case 13:
                    list2 = zza.z(parcel, a);
                    break;
                case 14:
                    str3 = zza.n(parcel, a);
                    break;
                case 15:
                    str4 = zza.n(parcel, a);
                    break;
                case 16:
                    str5 = zza.n(parcel, a);
                    break;
                case 17:
                    list3 = zza.A(parcel, a);
                    break;
                case 18:
                    z2 = zza.b(parcel, a);
                    break;
                case 19:
                    str2 = zza.n(parcel, a);
                    break;
                case 20:
                    list = zza.z(parcel, a);
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
            return new PlaceImpl(i, str, list, list2, bundle, str2, str3, str4, str5, list3, latLng, f, latLngBounds, str6, uri, z, f2, i2, j, z2, placeLocalization);
        }
        throw new zza.zza("Overread allowed size end=" + b, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m9100a(parcel);
    }

    public Object[] newArray(int i) {
        return new PlaceImpl[i];
    }
}
