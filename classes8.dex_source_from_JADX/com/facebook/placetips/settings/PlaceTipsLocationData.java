package com.facebook.placetips.settings;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: save_page_tap */
public class PlaceTipsLocationData implements Parcelable {
    public static final Creator<PlaceTipsLocationData> CREATOR = new C04921();
    public int f3904a;
    public int f3905b;
    public double f3906c;
    public double f3907d;
    public double f3908e;
    public int f3909f;
    public double f3910g;

    /* compiled from: save_page_tap */
    final class C04921 implements Creator<PlaceTipsLocationData> {
        C04921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlaceTipsLocationData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlaceTipsLocationData[i];
        }
    }

    public final PlaceTipsLocationData m3878a(int i) {
        this.f3904a = i;
        return this;
    }

    public final PlaceTipsLocationData m3880b(int i) {
        this.f3905b = i;
        return this;
    }

    public final PlaceTipsLocationData m3877a(double d) {
        this.f3906c = d;
        return this;
    }

    public final PlaceTipsLocationData m3879b(double d) {
        this.f3907d = d;
        return this;
    }

    public final PlaceTipsLocationData m3881c(double d) {
        this.f3908e = d;
        return this;
    }

    public final PlaceTipsLocationData m3882c(int i) {
        this.f3909f = i;
        return this;
    }

    public final PlaceTipsLocationData m3883d(double d) {
        this.f3910g = d;
        return this;
    }

    public PlaceTipsLocationData() {
        this.f3904a = 0;
        this.f3905b = 0;
        this.f3906c = 0.0d;
        this.f3907d = 0.0d;
        this.f3908e = 0.0d;
        this.f3909f = 0;
        this.f3910g = 0.0d;
    }

    public PlaceTipsLocationData(Parcel parcel) {
        this.f3904a = parcel.readInt();
        this.f3905b = parcel.readInt();
        this.f3906c = parcel.readDouble();
        this.f3907d = parcel.readDouble();
        this.f3908e = parcel.readDouble();
        this.f3909f = parcel.readInt();
        this.f3910g = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3904a);
        parcel.writeInt(this.f3905b);
        parcel.writeDouble(this.f3906c);
        parcel.writeDouble(this.f3907d);
        parcel.writeDouble(this.f3908e);
        parcel.writeInt(this.f3909f);
        parcel.writeDouble(this.f3910g);
    }
}
