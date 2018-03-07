package com.facebook.payments.history.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: long[] */
public class ProfileImage implements Parcelable {
    public static final Creator<ProfileImage> CREATOR = new C12501();
    private final String f8411a;
    private final int f8412b;
    private final int f8413c;
    private final float f8414d;
    private final String f8415e;

    /* compiled from: long[] */
    final class C12501 implements Creator<ProfileImage> {
        C12501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfileImage(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfileImage[i];
        }
    }

    public static ProfileImageBuilder newBuilder() {
        return new ProfileImageBuilder();
    }

    public ProfileImage(Parcel parcel) {
        this.f8411a = parcel.readString();
        this.f8412b = parcel.readInt();
        this.f8413c = parcel.readInt();
        this.f8414d = parcel.readFloat();
        this.f8415e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8411a);
        parcel.writeInt(this.f8412b);
        parcel.writeInt(this.f8413c);
        parcel.writeFloat(this.f8414d);
        parcel.writeString(this.f8415e);
    }
}
