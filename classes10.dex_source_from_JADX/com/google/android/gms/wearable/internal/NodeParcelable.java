package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.Node;

public class NodeParcelable implements SafeParcelable, Node {
    public static final Creator<NodeParcelable> CREATOR = new zzbp();
    public final int f13337a;
    private final String f13338b;
    public final String f13339c;
    public final int f13340d;
    private final boolean f13341e;

    NodeParcelable(int i, String str, String str2, int i2, boolean z) {
        this.f13337a = i;
        this.f13338b = str;
        this.f13339c = str2;
        this.f13340d = i2;
        this.f13341e = z;
    }

    public final String mo583a() {
        return this.f13338b;
    }

    public final boolean mo584b() {
        return this.f13341e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof NodeParcelable) ? false : ((NodeParcelable) obj).f13338b.equals(this.f13338b);
    }

    public int hashCode() {
        return this.f13338b.hashCode();
    }

    public String toString() {
        return "Node{" + this.f13339c + ", id=" + this.f13338b + ", hops=" + this.f13340d + ", isNearby=" + this.f13341e + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13337a);
        zzb.a(parcel, 2, mo583a(), false);
        zzb.a(parcel, 3, this.f13339c, false);
        zzb.a(parcel, 4, this.f13340d);
        zzb.a(parcel, 5, mo584b());
        zzb.c(parcel, a);
    }
}
