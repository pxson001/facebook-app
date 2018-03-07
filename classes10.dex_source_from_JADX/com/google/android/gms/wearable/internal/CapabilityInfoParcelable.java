package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Creator<CapabilityInfoParcelable> CREATOR = new zzk();
    public final int f13219a;
    private final Object f13220b = new Object();
    private final String f13221c;
    public final List<NodeParcelable> f13222d;
    private Set<Node> f13223e;

    CapabilityInfoParcelable(int i, String str, List<NodeParcelable> list) {
        this.f13219a = i;
        this.f13221c = str;
        this.f13222d = list;
        this.f13223e = null;
    }

    public final String mo574a() {
        return this.f13221c;
    }

    public final Set<Node> mo575b() {
        Set<Node> set;
        synchronized (this.f13220b) {
            if (this.f13223e == null) {
                this.f13223e = new HashSet(this.f13222d);
            }
            set = this.f13223e;
        }
        return set;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) obj;
        if (this.f13219a != capabilityInfoParcelable.f13219a) {
            return false;
        }
        if (this.f13221c == null ? capabilityInfoParcelable.f13221c != null : !this.f13221c.equals(capabilityInfoParcelable.f13221c)) {
            return false;
        }
        if (this.f13222d != null) {
            if (this.f13222d.equals(capabilityInfoParcelable.f13222d)) {
                return true;
            }
        } else if (capabilityInfoParcelable.f13222d == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f13221c != null ? this.f13221c.hashCode() : 0) + (this.f13219a * 31)) * 31;
        if (this.f13222d != null) {
            i = this.f13222d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CapabilityInfo{" + this.f13221c + ", " + this.f13222d + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13219a);
        zzb.a(parcel, 2, mo574a(), false);
        zzb.c(parcel, 3, this.f13222d, false);
        zzb.c(parcel, a);
    }
}
