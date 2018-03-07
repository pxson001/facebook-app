package com.facebook.events.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: sync_api_version */
public class EventArtist implements Parcelable {
    public static final Creator<EventArtist> CREATOR = new C02341();
    public final String f2698a;
    public final String f2699b;
    public final String f2700c;
    public final boolean f2701d;
    public final int f2702e;
    public final String f2703f;

    /* compiled from: sync_api_version */
    final class C02341 implements Creator<EventArtist> {
        C02341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventArtist(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventArtist[i];
        }
    }

    /* compiled from: sync_api_version */
    public class Builder {
        public String f2692a;
        public String f2693b;
        public String f2694c;
        public boolean f2695d;
        public int f2696e;
        public String f2697f;
    }

    public EventArtist(Builder builder) {
        this.f2699b = builder.f2692a;
        this.f2698a = builder.f2693b;
        this.f2700c = builder.f2694c;
        this.f2701d = builder.f2695d;
        this.f2702e = builder.f2696e;
        this.f2703f = builder.f2697f;
    }

    public EventArtist(Parcel parcel) {
        boolean z = true;
        this.f2698a = parcel.readString();
        this.f2699b = parcel.readString();
        this.f2700c = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f2701d = z;
        this.f2702e = parcel.readInt();
        this.f2703f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2698a);
        parcel.writeString(this.f2699b);
        parcel.writeString(this.f2700c);
        parcel.writeByte(this.f2701d ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f2702e);
        parcel.writeString(this.f2703f);
    }
}
