package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    public final int f6775a;
    public final List<LatLng> f6776b;
    public final List<List<LatLng>> f6777c;
    public float f6778d;
    public int f6779e;
    public int f6780f;
    public float f6781g;
    public boolean f6782h;
    public boolean f6783i;

    public PolygonOptions() {
        this.f6778d = 10.0f;
        this.f6779e = -16777216;
        this.f6780f = 0;
        this.f6781g = 0.0f;
        this.f6782h = true;
        this.f6783i = false;
        this.f6775a = 1;
        this.f6776b = new ArrayList();
        this.f6777c = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.f6778d = 10.0f;
        this.f6779e = -16777216;
        this.f6780f = 0;
        this.f6781g = 0.0f;
        this.f6782h = true;
        this.f6783i = false;
        this.f6775a = i;
        this.f6776b = list;
        this.f6777c = list2;
        this.f6778d = f;
        this.f6779e = i2;
        this.f6780f = i3;
        this.f6781g = f2;
        this.f6782h = z;
        this.f6783i = z2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f6775a);
        zzb.c(parcel, 2, this.f6776b, false);
        List list = this.f6777c;
        if (list != null) {
            int b = zzb.b(parcel, 3);
            parcel.writeList(list);
            zzb.c(parcel, b);
        } else if (null != null) {
            zzb.b(parcel, 3, 0);
        }
        zzb.a(parcel, 4, this.f6778d);
        zzb.a(parcel, 5, this.f6779e);
        zzb.a(parcel, 6, this.f6780f);
        zzb.a(parcel, 7, this.f6781g);
        zzb.a(parcel, 8, this.f6782h);
        zzb.a(parcel, 9, this.f6783i);
        zzb.c(parcel, a);
    }
}
