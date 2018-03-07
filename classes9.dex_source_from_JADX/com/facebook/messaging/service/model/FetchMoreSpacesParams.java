package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;

/* compiled from: cpu_time */
public class FetchMoreSpacesParams implements Parcelable {
    public static final Creator<FetchMoreSpacesParams> CREATOR = new C20171();
    private final DataFreshnessParam f17074a;
    private final long f17075b;
    private final int f17076c;

    /* compiled from: cpu_time */
    final class C20171 implements Creator<FetchMoreSpacesParams> {
        C20171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMoreSpacesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMoreSpacesParams[i];
        }
    }

    public static FetchMoreSpacesParamsBuilder newBuilder() {
        return new FetchMoreSpacesParamsBuilder();
    }

    public FetchMoreSpacesParams(Parcel parcel) {
        this.f17074a = DataFreshnessParam.valueOf(parcel.readString());
        this.f17075b = parcel.readLong();
        this.f17076c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f17074a.toString());
        parcel.writeLong(this.f17075b);
        parcel.writeInt(this.f17076c);
    }
}
