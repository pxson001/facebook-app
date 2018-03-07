package com.facebook.iorg.common.upsell.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: mBirthdayMonth */
public class UpsellDialogScreenContent implements Parcelable {
    public static final Creator<UpsellDialogScreenContent> CREATOR = new C07071();
    public final String f11283a;
    public final String f11284b;
    public final String f11285c;
    public final String f11286d;
    public final String f11287e;

    /* compiled from: mBirthdayMonth */
    final class C07071 implements Creator<UpsellDialogScreenContent> {
        C07071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpsellDialogScreenContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpsellDialogScreenContent[i];
        }
    }

    public UpsellDialogScreenContent() {
        this.f11283a = "";
        this.f11284b = "";
        this.f11285c = "";
        this.f11286d = "";
        this.f11287e = "";
    }

    public UpsellDialogScreenContent(String str, String str2, String str3, String str4, String str5) {
        this.f11283a = str;
        this.f11284b = str2;
        this.f11285c = str3;
        this.f11286d = str4;
        this.f11287e = str5;
    }

    public UpsellDialogScreenContent(Parcel parcel) {
        this.f11283a = parcel.readString();
        this.f11284b = parcel.readString();
        this.f11285c = parcel.readString();
        this.f11286d = parcel.readString();
        this.f11287e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11283a);
        parcel.writeString(this.f11284b);
        parcel.writeString(this.f11285c);
        parcel.writeString(this.f11286d);
        parcel.writeString(this.f11287e);
    }
}
