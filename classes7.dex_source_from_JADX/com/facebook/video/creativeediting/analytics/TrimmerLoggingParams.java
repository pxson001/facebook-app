package com.facebook.video.creativeediting.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.video.creativeediting.trimmer.StripHandleController.HandlePosition;

/* compiled from: dtsh */
public class TrimmerLoggingParams implements Parcelable {
    public static final Creator<TrimmerLoggingParams> CREATOR = new C11871();
    public int f15531a;
    public int f15532b;
    public int f15533c;
    public int f15534d;
    public int f15535e;

    /* compiled from: dtsh */
    final class C11871 implements Creator<TrimmerLoggingParams> {
        C11871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TrimmerLoggingParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new TrimmerLoggingParams[i];
        }
    }

    public TrimmerLoggingParams(Parcel parcel) {
        this.f15531a = parcel.readInt();
        this.f15532b = parcel.readInt();
        this.f15533c = parcel.readInt();
        this.f15534d = parcel.readInt();
        this.f15535e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f15531a);
        parcel.writeInt(this.f15532b);
        parcel.writeInt(this.f15533c);
        parcel.writeInt(this.f15534d);
        parcel.writeInt(this.f15535e);
    }

    public final int m19544c(HandlePosition handlePosition) {
        if (handlePosition == HandlePosition.LEFT) {
            return this.f15531a;
        }
        return this.f15532b;
    }

    public final int m19545d(HandlePosition handlePosition) {
        if (handlePosition == HandlePosition.LEFT) {
            return this.f15533c;
        }
        return this.f15534d;
    }
}
