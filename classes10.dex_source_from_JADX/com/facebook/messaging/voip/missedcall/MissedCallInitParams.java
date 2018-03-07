package com.facebook.messaging.voip.missedcall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: picked_photo_fbid */
public class MissedCallInitParams implements Parcelable {
    public static final Creator<MissedCallInitParams> CREATOR = new C06751();
    public final long f4925a;
    public final String f4926b;

    /* compiled from: picked_photo_fbid */
    final class C06751 implements Creator<MissedCallInitParams> {
        C06751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MissedCallInitParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new MissedCallInitParams[i];
        }
    }

    public static MissedCallInitParamsBuilder newBuilder() {
        return new MissedCallInitParamsBuilder();
    }

    public MissedCallInitParams(Parcel parcel) {
        this.f4925a = parcel.readLong();
        this.f4926b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4925a);
        parcel.writeString(this.f4926b);
    }
}
