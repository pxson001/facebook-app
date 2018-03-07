package com.facebook.growth.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: ellipsize */
public class Birthday implements Parcelable {
    public static final Creator<Birthday> CREATOR = new C16131();
    public final int f14887a;
    public final int f14888b;
    public final int f14889c;

    /* compiled from: ellipsize */
    final class C16131 implements Creator<Birthday> {
        C16131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Birthday(parcel);
        }

        public final Object[] newArray(int i) {
            return new Birthday[i];
        }
    }

    public Birthday(int i, int i2, int i3) {
        this.f14887a = i3;
        this.f14888b = i2;
        this.f14889c = i;
    }

    public Birthday(Parcel parcel) {
        this.f14887a = parcel.readInt();
        this.f14888b = parcel.readInt();
        this.f14889c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f14887a);
        parcel.writeInt(this.f14888b);
        parcel.writeInt(this.f14889c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Birthday)) {
            return false;
        }
        Birthday birthday = (Birthday) obj;
        if (Objects.equal(Integer.valueOf(this.f14887a), Integer.valueOf(birthday.f14887a)) && Objects.equal(Integer.valueOf(this.f14888b), Integer.valueOf(birthday.f14888b)) && Objects.equal(Integer.valueOf(this.f14889c), Integer.valueOf(birthday.f14889c))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.f14887a), Integer.valueOf(this.f14888b), Integer.valueOf(this.f14889c)});
    }
}
