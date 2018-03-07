package com.facebook.events.logging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: change_hotlike */
public class BuyTicketsLoggingInfo implements Parcelable {
    public static final Creator<BuyTicketsLoggingInfo> CREATOR = new C25171();
    public int f17773a;
    public int f17774b;
    public int f17775c;
    public int f17776d;
    public int f17777e;
    public boolean f17778f;

    /* compiled from: change_hotlike */
    final class C25171 implements Creator<BuyTicketsLoggingInfo> {
        C25171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BuyTicketsLoggingInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new BuyTicketsLoggingInfo[i];
        }
    }

    protected BuyTicketsLoggingInfo(Parcel parcel) {
        this.f17773a = parcel.readInt();
        this.f17774b = parcel.readInt();
        this.f17775c = parcel.readInt();
        this.f17776d = parcel.readInt();
        this.f17777e = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f17773a);
        parcel.writeInt(this.f17774b);
        parcel.writeInt(this.f17775c);
        parcel.writeInt(this.f17776d);
        parcel.writeInt(this.f17777e);
    }

    public int describeContents() {
        return 0;
    }
}
