package com.facebook.places.create.home;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: card_number_edit_text */
public class HomeActivityLoggerData implements Parcelable {
    public static final Creator<HomeActivityLoggerData> CREATOR = new C19941();
    public String f18302a;
    public boolean f18303b;
    public String f18304c;
    public String f18305d;
    public long f18306e;
    public String f18307f;

    /* compiled from: card_number_edit_text */
    final class C19941 implements Creator<HomeActivityLoggerData> {
        C19941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new HomeActivityLoggerData(parcel);
        }

        public final Object[] newArray(int i) {
            return new HomeActivityLoggerData[i];
        }
    }

    public HomeActivityLoggerData() {
        this.f18303b = false;
    }

    protected HomeActivityLoggerData(Parcel parcel) {
        this.f18304c = parcel.readString();
        this.f18305d = parcel.readString();
        this.f18302a = parcel.readString();
        this.f18307f = parcel.readString();
        this.f18306e = parcel.readLong();
        this.f18303b = parcel.readByte() != (byte) 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18304c);
        parcel.writeString(this.f18305d);
        parcel.writeString(this.f18302a);
        parcel.writeString(this.f18307f);
        parcel.writeLong(this.f18306e);
        parcel.writeByte((byte) (this.f18303b ? 1 : 0));
    }
}
