package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPlaceRequest implements SafeParcelable {
    public static final Creator<AddPlaceRequest> CREATOR = new zzb();
    public final int f6409a;
    public final String f6410b;
    public final LatLng f6411c;
    public final String f6412d;
    public final List<Integer> f6413e;
    public final String f6414f;
    public final Uri f6415g;

    AddPlaceRequest(int i, String str, LatLng latLng, String str2, List<Integer> list, String str3, Uri uri) {
        boolean z = false;
        this.f6409a = i;
        this.f6410b = zzx.a(str);
        this.f6411c = (LatLng) zzx.a(latLng);
        this.f6412d = zzx.a(str2);
        this.f6413e = new ArrayList((Collection) zzx.a(list));
        zzx.b(!this.f6413e.isEmpty(), "At least one place type should be provided.");
        if (!(TextUtils.isEmpty(str3) && uri == null)) {
            z = true;
        }
        zzx.b(z, "One of phone number or URI should be provided.");
        this.f6414f = str3;
        this.f6415g = uri;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return zzw.a(this).a("name", this.f6410b).a("latLng", this.f6411c).a("address", this.f6412d).a("placeTypes", this.f6413e).a("phoneNumer", this.f6414f).a("websiteUri", this.f6415g).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6410b, false);
        zzb.a(parcel, 1000, this.f6409a);
        zzb.a(parcel, 2, this.f6411c, i, false);
        zzb.a(parcel, 3, this.f6412d, false);
        zzb.a(parcel, 4, this.f6413e, false);
        zzb.a(parcel, 5, this.f6414f, false);
        zzb.a(parcel, 6, this.f6415g, i, false);
        zzb.c(parcel, a);
    }
}
