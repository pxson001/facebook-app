package com.facebook.push.mqtt.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: gi */
public class SubscribeTopic implements Parcelable {
    public static final Creator<SubscribeTopic> CREATOR = new C05231();
    public final String f11058a;
    public final int f11059b;

    /* compiled from: gi */
    final class C05231 implements Creator<SubscribeTopic> {
        C05231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SubscribeTopic(parcel.readString(), parcel.readInt());
        }

        public final Object[] newArray(int i) {
            return new SubscribeTopic[i];
        }
    }

    public SubscribeTopic(String str, int i) {
        this.f11058a = str;
        this.f11059b = i;
    }

    public String toString() {
        return this.f11058a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SubscribeTopic subscribeTopic = (SubscribeTopic) obj;
        if (this.f11059b != subscribeTopic.f11059b) {
            return false;
        }
        if (Objects.equal(this.f11058a, subscribeTopic.f11058a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f11058a.hashCode() + this.f11059b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11058a);
        parcel.writeInt(this.f11059b);
    }
}
