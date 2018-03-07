package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new zzo();
    public final int f13229a;
    public final String f13230b;
    public final String f13231c;
    public final String f13232d;

    ChannelImpl(int i, String str, String str2, String str3) {
        this.f13229a = i;
        this.f13230b = (String) zzx.a(str);
        this.f13231c = (String) zzx.a(str2);
        this.f13232d = (String) zzx.a(str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.f13230b.equals(channelImpl.f13230b) && zzw.a(channelImpl.f13231c, this.f13231c) && zzw.a(channelImpl.f13232d, this.f13232d) && channelImpl.f13229a == this.f13229a;
    }

    public int hashCode() {
        return this.f13230b.hashCode();
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.f13229a + ", token='" + this.f13230b + '\'' + ", nodeId='" + this.f13231c + '\'' + ", path='" + this.f13232d + '\'' + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13229a);
        zzb.a(parcel, 2, this.f13230b, false);
        zzb.a(parcel, 3, this.f13231c, false);
        zzb.a(parcel, 4, this.f13232d, false);
        zzb.c(parcel, a);
    }
}
