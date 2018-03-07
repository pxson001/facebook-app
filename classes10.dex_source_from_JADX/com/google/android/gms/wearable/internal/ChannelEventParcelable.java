package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class ChannelEventParcelable implements SafeParcelable {
    public static final Creator<ChannelEventParcelable> CREATOR = new zzn();
    public final int f13224a;
    public final ChannelImpl f13225b;
    public final int f13226c;
    public final int f13227d;
    public final int f13228e;

    ChannelEventParcelable(int i, ChannelImpl channelImpl, int i2, int i3, int i4) {
        this.f13224a = i;
        this.f13225b = channelImpl;
        this.f13226c = i2;
        this.f13227d = i3;
        this.f13228e = i4;
    }

    public final void m13322a(ChannelListener channelListener) {
        switch (this.f13226c) {
            case 1:
            case 2:
            case 3:
            case 4:
                return;
            default:
                Log.w("ChannelEventParcelable", "Unknown type: " + this.f13226c);
                return;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder append = new StringBuilder("ChannelEventParcelable[versionCode=").append(this.f13224a).append(", channel=").append(this.f13225b).append(", type=");
        int i = this.f13226c;
        switch (i) {
            case 1:
                str = "CHANNEL_OPENED";
                break;
            case 2:
                str = "CHANNEL_CLOSED";
                break;
            case 3:
                str = "INPUT_CLOSED";
                break;
            case 4:
                str = "OUTPUT_CLOSED";
                break;
            default:
                str = Integer.toString(i);
                break;
        }
        append = append.append(str).append(", closeReason=");
        i = this.f13227d;
        switch (i) {
            case 0:
                str = "CLOSE_REASON_NORMAL";
                break;
            case 1:
                str = "CLOSE_REASON_DISCONNECTED";
                break;
            case 2:
                str = "CLOSE_REASON_REMOTE_CLOSE";
                break;
            case 3:
                str = "CLOSE_REASON_LOCAL_CLOSE";
                break;
            default:
                str = Integer.toString(i);
                break;
        }
        return append.append(str).append(", appErrorCode=").append(this.f13228e).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = zzb.a(parcel);
        zzb.a(parcel, 1, this.f13224a);
        zzb.a(parcel, 2, this.f13225b, i, false);
        zzb.a(parcel, 3, this.f13226c);
        zzb.a(parcel, 4, this.f13227d);
        zzb.a(parcel, 5, this.f13228e);
        zzb.c(parcel, a);
    }
}
