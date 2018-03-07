package com.facebook.messaging.business.commerce.model.retail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: video_transcode_flow_count */
public class RetailAdjustment implements Parcelable {
    public static final Creator<RetailAdjustment> CREATOR = new C00671();
    public final String f641a;
    public final String f642b;

    /* compiled from: video_transcode_flow_count */
    final class C00671 implements Creator<RetailAdjustment> {
        C00671() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RetailAdjustment(parcel);
        }

        public final Object[] newArray(int i) {
            return new RetailAdjustment[i];
        }
    }

    public RetailAdjustment(RetailAdjustmentBuilder retailAdjustmentBuilder) {
        this.f641a = retailAdjustmentBuilder.f643a;
        this.f642b = retailAdjustmentBuilder.f644b;
    }

    public RetailAdjustment(Parcel parcel) {
        this.f641a = parcel.readString();
        this.f642b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f641a);
        parcel.writeString(this.f642b);
    }
}
