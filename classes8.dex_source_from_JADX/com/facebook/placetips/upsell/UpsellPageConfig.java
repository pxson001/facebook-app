package com.facebook.placetips.upsell;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: camera_roll */
public class UpsellPageConfig implements Parcelable {
    public static final Creator<UpsellPageConfig> CREATOR = new C20551();
    public final UpsellPage f18545a;
    public final String f18546b;
    public final String f18547c;
    public final String f18548d;
    public final String f18549e;
    public final String f18550f;
    public final String f18551g;

    /* compiled from: camera_roll */
    final class C20551 implements Creator<UpsellPageConfig> {
        C20551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpsellPageConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpsellPageConfig[i];
        }
    }

    public UpsellPageConfig(UpsellPage upsellPage, String str, String str2, String str3, String str4, String str5, String str6) {
        this.f18545a = upsellPage;
        this.f18546b = str;
        this.f18547c = str2;
        this.f18548d = str3;
        this.f18549e = str4;
        this.f18550f = str5;
        this.f18551g = str6;
    }

    public UpsellPageConfig(Parcel parcel) {
        this.f18545a = UpsellPage.fromId(parcel.readString());
        this.f18546b = parcel.readString();
        this.f18547c = parcel.readString();
        this.f18548d = parcel.readString();
        this.f18549e = parcel.readString();
        this.f18550f = parcel.readString();
        this.f18551g = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18545a.getId());
        parcel.writeString(this.f18546b);
        parcel.writeString(this.f18547c);
        parcel.writeString(this.f18548d);
        parcel.writeString(this.f18549e);
        parcel.writeString(this.f18550f);
        parcel.writeString(this.f18551g);
    }

    public int describeContents() {
        return 0;
    }
}
