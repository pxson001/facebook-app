package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: com.oculus.horizon */
public class UserSmsIdentifier implements Parcelable, UserIdentifier {
    public static final Creator<UserSmsIdentifier> CREATOR = new C05141();
    private final String f5529a;
    public final String f5530b;

    /* compiled from: com.oculus.horizon */
    final class C05141 implements Creator<UserSmsIdentifier> {
        C05141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UserSmsIdentifier(parcel);
        }

        public final Object[] newArray(int i) {
            return new UserSmsIdentifier[i];
        }
    }

    public UserSmsIdentifier(String str, String str2) {
        this.f5529a = str;
        this.f5530b = str2;
    }

    public final String m10372a() {
        return this.f5529a;
    }

    public final String m10373b() {
        return this.f5530b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserSmsIdentifier userSmsIdentifier = (UserSmsIdentifier) obj;
        if (Objects.equal(this.f5529a, userSmsIdentifier.f5529a) && Objects.equal(this.f5530b, userSmsIdentifier.f5530b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f5529a, this.f5530b});
    }

    public int describeContents() {
        return 0;
    }

    public UserSmsIdentifier(Parcel parcel) {
        this.f5529a = parcel.readString();
        this.f5530b = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m10372a());
        parcel.writeString(this.f5530b);
    }
}
