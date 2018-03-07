package com.facebook.facecast.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: b-m.facebook.com */
public class VideoBroadcastCalculateStatsRequest implements Parcelable {
    public static final Creator<VideoBroadcastCalculateStatsRequest> CREATOR = new C16271();
    public final String f18799a;
    public final int f18800b;
    public final long f18801c;

    /* compiled from: b-m.facebook.com */
    final class C16271 implements Creator<VideoBroadcastCalculateStatsRequest> {
        C16271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoBroadcastCalculateStatsRequest(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoBroadcastCalculateStatsRequest[i];
        }
    }

    public VideoBroadcastCalculateStatsRequest(String str, int i, long j) {
        this.f18799a = str;
        this.f18800b = i;
        this.f18801c = j;
    }

    public VideoBroadcastCalculateStatsRequest(Parcel parcel) {
        this.f18799a = parcel.readString();
        this.f18800b = parcel.readInt();
        this.f18801c = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18799a);
        parcel.writeInt(this.f18800b);
        parcel.writeLong(this.f18801c);
    }
}
