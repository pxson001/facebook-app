package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: t_dr_response */
public class UserEmailAddress implements Parcelable {
    public static final Creator<UserEmailAddress> CREATOR = new C02071();
    public final String f3571a;
    private final int f3572b;

    /* compiled from: t_dr_response */
    final class C02071 implements Creator<UserEmailAddress> {
        C02071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UserEmailAddress(parcel);
        }

        public final Object[] newArray(int i) {
            return new UserEmailAddress[i];
        }
    }

    public UserEmailAddress(String str, int i, boolean z) {
        if (z) {
            str = str.toLowerCase();
        }
        this.f3571a = str;
        this.f3572b = i;
    }

    public UserEmailAddress(String str, int i) {
        this(str, i, true);
    }

    public UserEmailAddress(Parcel parcel) {
        this.f3571a = parcel.readString();
        this.f3572b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3571a);
        parcel.writeInt(this.f3572b);
    }
}
