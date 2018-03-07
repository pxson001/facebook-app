package com.facebook.api.feed;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: attachment_size */
public class SetHScrollUnitVisibleItemIndexParams implements Parcelable {
    public static final Creator<SetHScrollUnitVisibleItemIndexParams> CREATOR = new C09481();
    public final String f8737a;
    public final String f8738b;
    public final Integer f8739c;

    /* compiled from: attachment_size */
    final class C09481 implements Creator<SetHScrollUnitVisibleItemIndexParams> {
        C09481() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetHScrollUnitVisibleItemIndexParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetHScrollUnitVisibleItemIndexParams[i];
        }
    }

    public SetHScrollUnitVisibleItemIndexParams(String str, String str2, Integer num) {
        this.f8737a = str;
        this.f8738b = str2;
        this.f8739c = num;
    }

    public SetHScrollUnitVisibleItemIndexParams(Parcel parcel) {
        this.f8737a = parcel.readString();
        this.f8738b = parcel.readString();
        this.f8739c = Integer.valueOf(parcel.readInt());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8737a);
        parcel.writeString(this.f8738b);
        parcel.writeInt(this.f8739c.intValue());
    }

    public int describeContents() {
        return 0;
    }
}
