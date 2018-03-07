package com.facebook.messaging.business.commerce.model.retail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: video_transcode_is_segmented */
public class RetailAddress implements Parcelable {
    public static final Creator<RetailAddress> CREATOR = new C00661();
    @Nullable
    public final String f623a;
    @Nullable
    public final String f624b;
    @Nullable
    public final String f625c;
    @Nullable
    public final String f626d;
    @Nullable
    public final String f627e;
    @Nullable
    public final String f628f;
    @Nullable
    public final String f629g;
    public final double f630h;
    public final double f631i;

    /* compiled from: video_transcode_is_segmented */
    final class C00661 implements Creator<RetailAddress> {
        C00661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RetailAddress(parcel);
        }

        public final Object[] newArray(int i) {
            return new RetailAddress[i];
        }
    }

    public RetailAddress(RetailAddressBuilder retailAddressBuilder) {
        this.f623a = retailAddressBuilder.f632a;
        this.f624b = retailAddressBuilder.f633b;
        this.f625c = retailAddressBuilder.f634c;
        this.f626d = retailAddressBuilder.f635d;
        this.f627e = retailAddressBuilder.f636e;
        this.f628f = retailAddressBuilder.f637f;
        this.f629g = retailAddressBuilder.f638g;
        this.f630h = retailAddressBuilder.f639h;
        this.f631i = retailAddressBuilder.f640i;
    }

    public RetailAddress(Parcel parcel) {
        this.f623a = parcel.readString();
        this.f624b = parcel.readString();
        this.f625c = parcel.readString();
        this.f626d = parcel.readString();
        this.f627e = parcel.readString();
        this.f628f = parcel.readString();
        this.f629g = parcel.readString();
        this.f630h = parcel.readDouble();
        this.f631i = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f623a);
        parcel.writeString(this.f624b);
        parcel.writeString(this.f625c);
        parcel.writeString(this.f626d);
        parcel.writeString(this.f627e);
        parcel.writeString(this.f628f);
        parcel.writeString(this.f629g);
        parcel.writeDouble(this.f630h);
        parcel.writeDouble(this.f631i);
    }
}
