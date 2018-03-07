package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: t_callability_resp */
public class UserFbidIdentifier implements Parcelable, UserIdentifier {
    public static final Creator<UserFbidIdentifier> CREATOR = new C02101();
    private final String f3625a;

    /* compiled from: t_callability_resp */
    final class C02101 implements Creator<UserFbidIdentifier> {
        C02101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UserFbidIdentifier(parcel);
        }

        public final Object[] newArray(int i) {
            return new UserFbidIdentifier[i];
        }
    }

    public UserFbidIdentifier(String str) {
        this.f3625a = str;
    }

    public UserFbidIdentifier(Parcel parcel) {
        this.f3625a = parcel.readString();
    }

    public final String mo765a() {
        return this.f3625a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserFbidIdentifier)) {
            return false;
        }
        UserFbidIdentifier userFbidIdentifier = (UserFbidIdentifier) obj;
        if (this.f3625a != null) {
            if (this.f3625a.equals(userFbidIdentifier.f3625a)) {
                return true;
            }
        } else if (userFbidIdentifier.f3625a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f3625a != null ? this.f3625a.hashCode() : 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo765a());
    }
}
