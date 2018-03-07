package com.facebook.friendsharing.souvenirs.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: RCTSourceCode */
class SouvenirsLogger$LoggingParameters implements Parcelable {
    public static final Creator<SouvenirsLogger$LoggingParameters> CREATOR = new C21091();
    public int f24223a = 0;
    public int f24224b = 0;
    public int f24225c = 0;
    public int f24226d = 0;
    public int f24227e = 0;
    public int f24228f = 0;
    public long f24229g = 0;
    public String f24230h;

    /* compiled from: RCTSourceCode */
    final class C21091 implements Creator<SouvenirsLogger$LoggingParameters> {
        C21091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SouvenirsLogger$LoggingParameters(parcel);
        }

        public final Object[] newArray(int i) {
            return new SouvenirsLogger$LoggingParameters[i];
        }
    }

    public SouvenirsLogger$LoggingParameters(Parcel parcel) {
        this.f24223a = parcel.readInt();
        this.f24224b = parcel.readInt();
        this.f24225c = parcel.readInt();
        this.f24226d = parcel.readInt();
        this.f24227e = parcel.readInt();
        this.f24228f = parcel.readInt();
        this.f24229g = parcel.readLong();
        this.f24230h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f24223a);
        parcel.writeInt(this.f24224b);
        parcel.writeInt(this.f24225c);
        parcel.writeInt(this.f24226d);
        parcel.writeInt(this.f24227e);
        parcel.writeInt(this.f24228f);
        parcel.writeLong(this.f24229g);
        parcel.writeString(this.f24230h);
    }
}
