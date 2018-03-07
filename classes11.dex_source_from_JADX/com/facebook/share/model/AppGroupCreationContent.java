package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: orts */
public final class AppGroupCreationContent implements ShareModel {
    public static final Creator<AppGroupCreationContent> CREATOR = new C06171();
    private final String f4578a;
    private final String f4579b;
    private AppGroupPrivacy f4580c;

    /* compiled from: orts */
    final class C06171 implements Creator<AppGroupCreationContent> {
        C06171() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AppGroupCreationContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new AppGroupCreationContent[i];
        }
    }

    /* compiled from: orts */
    public enum AppGroupPrivacy {
        Open,
        Closed
    }

    AppGroupCreationContent(Parcel parcel) {
        this.f4578a = parcel.readString();
        this.f4579b = parcel.readString();
        this.f4580c = (AppGroupPrivacy) parcel.readSerializable();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4578a);
        parcel.writeString(this.f4579b);
        parcel.writeSerializable(this.f4580c);
    }
}
