package com.facebook.timeline.tempprofilepic.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: data_failures_fatal */
public final class ExpirationState implements Parcelable {
    public static final Creator<ExpirationState> CREATOR = new C12911();
    public static final ExpirationState f17894a = new ExpirationState(false, 0);
    public static final ExpirationState f17895b = new ExpirationState(true, 0);
    public final boolean f17896c;
    public final long f17897d;

    /* compiled from: data_failures_fatal */
    final class C12911 implements Creator<ExpirationState> {
        C12911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ExpirationState(parcel);
        }

        public final Object[] newArray(int i) {
            return new ExpirationState[i];
        }
    }

    public ExpirationState(boolean z, long j) {
        this.f17896c = z;
        this.f17897d = j;
    }

    public ExpirationState(Parcel parcel) {
        this.f17896c = ParcelUtil.a(parcel);
        this.f17897d = parcel.readLong();
    }

    public final long m26426b() {
        return this.f17897d;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f17896c);
        parcel.writeLong(this.f17897d);
    }
}
