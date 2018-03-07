package com.facebook.friending.jewel.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: filter_value_selected_text */
public class PYMKResponseParams implements Parcelable {
    public static final Creator<PYMKResponseParams> CREATER = new C14071();
    public final long f13306a;
    public final Response f13307b;

    /* compiled from: filter_value_selected_text */
    final class C14071 implements Creator<PYMKResponseParams> {
        C14071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PYMKResponseParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PYMKResponseParams[i];
        }
    }

    /* compiled from: filter_value_selected_text */
    public enum Response {
        POSITIVE,
        NEGATIVE,
        SECONDARY
    }

    public PYMKResponseParams(Parcel parcel) {
        this.f13306a = parcel.readLong();
        this.f13307b = Response.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f13306a);
        parcel.writeString(this.f13307b.name());
    }
}
