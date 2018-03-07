package com.facebook.messaging.media.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mCode */
public final class LocalMediaLoaderParams implements Parcelable {
    public static final Creator<LocalMediaLoaderParams> CREATOR = new C13101();
    public final boolean f11656a;
    public final int f11657b;

    /* compiled from: mCode */
    final class C13101 implements Creator<LocalMediaLoaderParams> {
        C13101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LocalMediaLoaderParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new LocalMediaLoaderParams[i];
        }
    }

    public LocalMediaLoaderParams(boolean z) {
        this(z, 0);
    }

    public LocalMediaLoaderParams(boolean z, int i) {
        this.f11656a = z;
        this.f11657b = i;
    }

    public LocalMediaLoaderParams(Parcel parcel) {
        this.f11656a = ParcelUtil.a(parcel);
        this.f11657b = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f11656a);
        parcel.writeInt(this.f11657b);
    }

    public final int describeContents() {
        return 0;
    }
}
