package com.facebook.growth.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: elapsed_time_ms */
public class FullName implements Parcelable {
    public static final Creator<FullName> CREATOR = new C16161();
    public final String f14896a;
    public final String f14897b;
    public final String f14898c;
    public final String f14899d;

    /* compiled from: elapsed_time_ms */
    final class C16161 implements Creator<FullName> {
        C16161() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FullName(parcel);
        }

        public final Object[] newArray(int i) {
            return new FullName[i];
        }
    }

    public FullName(String str, String str2, String str3, String str4) {
        this.f14897b = str;
        this.f14899d = str2;
        this.f14898c = str3;
        this.f14896a = str4;
    }

    public FullName(Parcel parcel) {
        this.f14897b = parcel.readString();
        this.f14899d = parcel.readString();
        this.f14898c = parcel.readString();
        this.f14896a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14897b);
        parcel.writeString(this.f14899d);
        parcel.writeString(this.f14898c);
        parcel.writeString(this.f14896a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof FullName)) {
            return false;
        }
        FullName fullName = (FullName) obj;
        if (Objects.equal(this.f14897b, fullName.f14897b) && Objects.equal(this.f14899d, fullName.f14899d) && Objects.equal(this.f14898c, fullName.f14898c) && Objects.equal(this.f14896a, fullName.f14896a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f14897b, this.f14899d, this.f14898c, this.f14896a});
    }

    public String toString() {
        if (!StringUtil.c(this.f14896a)) {
            return this.f14896a;
        }
        String str = "";
        if (!StringUtil.c(this.f14897b)) {
            str = this.f14897b;
        }
        if (!StringUtil.c(this.f14899d)) {
            if (StringUtil.a(str)) {
                str = this.f14899d;
            } else {
                str = str + " " + this.f14899d;
            }
        }
        if (StringUtil.c(this.f14898c)) {
            return str;
        }
        if (StringUtil.a(str)) {
            return this.f14898c;
        }
        return str + " " + this.f14898c;
    }
}
