package com.facebook.groups.create.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: payments_reliability */
public class CreateGroupParams implements Parcelable {
    public static final Creator<CreateGroupParams> CREATOR = new C06981();
    public final String f6800a;
    public final String f6801b;
    public final String f6802c;
    public final String f6803d;
    public final String f6804e;
    public final String f6805f;
    public final String f6806g;
    public final String f6807h;

    /* compiled from: payments_reliability */
    final class C06981 implements Creator<CreateGroupParams> {
        C06981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreateGroupParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreateGroupParams[i];
        }
    }

    /* compiled from: payments_reliability */
    public class Builder {
        public String f6792a;
        public String f6793b;
        private String f6794c;
        private String f6795d;
        public String f6796e;
        public String f6797f;
        public String f6798g;
        private String f6799h;

        public final CreateGroupParams m7109a() {
            if (this.f6792a != null && this.f6793b != null) {
                return new CreateGroupParams(this.f6792a, this.f6793b, this.f6794c, this.f6795d, this.f6796e, this.f6797f, this.f6798g, this.f6799h);
            }
            throw new IllegalArgumentException("Missing required parameter for creating a group");
        }
    }

    public CreateGroupParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f6803d = str4;
        this.f6800a = str;
        this.f6801b = str2;
        this.f6802c = str3;
        this.f6804e = str5;
        this.f6805f = str6;
        this.f6806g = str7;
        this.f6807h = str8;
    }

    public CreateGroupParams(Parcel parcel) {
        this.f6800a = parcel.readString();
        this.f6801b = parcel.readString();
        this.f6802c = parcel.readString();
        this.f6803d = parcel.readString();
        this.f6804e = parcel.readString();
        this.f6805f = parcel.readString();
        this.f6806g = parcel.readString();
        this.f6807h = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6800a);
        parcel.writeString(this.f6801b);
        parcel.writeString(this.f6802c != null ? this.f6802c : "");
        parcel.writeString(this.f6803d != null ? this.f6803d : "");
        parcel.writeString(this.f6804e != null ? this.f6804e : "");
        parcel.writeString(this.f6805f != null ? this.f6805f : "");
        parcel.writeString(this.f6806g != null ? this.f6806g : "");
        parcel.writeString(this.f6807h != null ? this.f6807h : "");
    }
}
