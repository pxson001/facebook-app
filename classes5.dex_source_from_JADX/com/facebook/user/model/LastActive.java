package com.facebook.user.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: comment_draft_cleared */
public class LastActive implements Parcelable {
    public static final Creator<LastActive> CREATOR = new C05111();
    public final long f5514a;

    /* compiled from: comment_draft_cleared */
    final class C05111 implements Creator<LastActive> {
        C05111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LastActive(parcel);
        }

        public final Object[] newArray(int i) {
            return new LastActive[i];
        }
    }

    public LastActive(long j) {
        this.f5514a = j;
    }

    public LastActive(Parcel parcel) {
        this.f5514a = parcel.readLong();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f5514a != ((LastActive) obj).f5514a) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (int) (this.f5514a ^ (this.f5514a >>> 32));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f5514a);
    }
}
