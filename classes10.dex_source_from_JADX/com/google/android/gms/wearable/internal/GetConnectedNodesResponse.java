package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class GetConnectedNodesResponse implements SafeParcelable {
    public static final Creator<GetConnectedNodesResponse> CREATOR = new zzar();
    public final int f13280a;
    public final int f13281b;
    public final List<NodeParcelable> f13282c;

    GetConnectedNodesResponse(int i, int i2, List<NodeParcelable> list) {
        this.f13280a = i;
        this.f13281b = i2;
        this.f13282c = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13280a);
        zzb.a(parcel, 2, this.f13281b);
        zzb.c(parcel, 3, this.f13282c, false);
        zzb.c(parcel, a);
    }
}
