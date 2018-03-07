package com.facebook.spherical.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: estimated_video_bit_rate */
public class KeyframeParams implements Parcelable {
    public static final Creator<KeyframeParams> CREATOR = new C11381();
    public final long f16163a;
    public final int f16164b;
    public final int f16165c;

    /* compiled from: estimated_video_bit_rate */
    final class C11381 implements Creator<KeyframeParams> {
        C11381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new KeyframeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new KeyframeParams[i];
        }
    }

    /* compiled from: estimated_video_bit_rate */
    public class Builder {
        public long f16160a;
        public int f16161b;
        public int f16162c;
    }

    public KeyframeParams(Builder builder) {
        this.f16163a = builder.f16160a;
        this.f16164b = builder.f16161b;
        this.f16165c = builder.f16162c;
    }

    KeyframeParams(Parcel parcel) {
        this.f16163a = parcel.readLong();
        this.f16164b = parcel.readInt();
        this.f16165c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f16163a);
        parcel.writeInt(this.f16164b);
        parcel.writeInt(this.f16165c);
    }
}
