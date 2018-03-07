package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.TriState;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: com.oculus.horizon.dev */
public class UserPhoneNumber implements Parcelable {
    public static final Creator<UserPhoneNumber> CREATOR = new C05131();
    public final String f5524a;
    public final String f5525b;
    public final String f5526c;
    public final int f5527d;
    private final TriState f5528e;

    /* compiled from: com.oculus.horizon.dev */
    final class C05131 implements Creator<UserPhoneNumber> {
        C05131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UserPhoneNumber(parcel);
        }

        public final Object[] newArray(int i) {
            return new UserPhoneNumber[i];
        }
    }

    public UserPhoneNumber(String str, String str2, int i) {
        this(str, str2, str2, i, TriState.UNSET);
    }

    public UserPhoneNumber(String str, String str2, String str3, int i) {
        this(str, str2, str3, i, TriState.UNSET);
    }

    public UserPhoneNumber(String str, String str2, String str3, int i, TriState triState) {
        this.f5524a = str;
        this.f5525b = str2;
        this.f5526c = str3;
        this.f5527d = i;
        this.f5528e = triState;
    }

    public final String m10367a() {
        return this.f5524a;
    }

    public final String m10368b() {
        return this.f5526c;
    }

    public final String m10369c() {
        return this.f5525b;
    }

    public final int m10370d() {
        return this.f5527d;
    }

    public final TriState m10371e() {
        return this.f5528e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserPhoneNumber userPhoneNumber = (UserPhoneNumber) obj;
        if (this.f5527d != userPhoneNumber.f5527d) {
            return false;
        }
        if (this.f5524a == null ? userPhoneNumber.f5524a != null : !this.f5524a.equals(userPhoneNumber.f5524a)) {
            return false;
        }
        if (this.f5528e != userPhoneNumber.f5528e) {
            return false;
        }
        if (this.f5526c == null ? userPhoneNumber.f5526c != null : !this.f5526c.equals(userPhoneNumber.f5526c)) {
            return false;
        }
        if (this.f5525b != null) {
            if (this.f5525b.equals(userPhoneNumber.f5525b)) {
                return true;
            }
        } else if (userPhoneNumber.f5525b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        int hashCode2 = (this.f5526c != null ? this.f5526c.hashCode() : 0) * 31;
        if (this.f5524a != null) {
            hashCode = this.f5524a.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode2 = (hashCode + hashCode2) * 31;
        if (this.f5525b != null) {
            hashCode = this.f5525b.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (((hashCode + hashCode2) * 31) + this.f5527d) * 31;
        if (this.f5528e != null) {
            i = this.f5528e.hashCode();
        }
        return hashCode + i;
    }

    public int describeContents() {
        return 0;
    }

    public UserPhoneNumber(Parcel parcel) {
        this.f5524a = parcel.readString();
        this.f5525b = parcel.readString();
        this.f5526c = parcel.readString();
        this.f5527d = parcel.readInt();
        this.f5528e = TriState.valueOf(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5524a);
        parcel.writeString(this.f5525b);
        parcel.writeString(this.f5526c);
        parcel.writeInt(this.f5527d);
        parcel.writeString(this.f5528e.name());
    }
}
