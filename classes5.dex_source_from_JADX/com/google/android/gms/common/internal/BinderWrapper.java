package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new C05661();
    private IBinder f6528a = null;

    final class C05661 implements Creator<BinderWrapper> {
        C05661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        public final Object[] newArray(int i) {
            return new BinderWrapper[i];
        }
    }

    public BinderWrapper(IBinder iBinder) {
        this.f6528a = iBinder;
    }

    public BinderWrapper(Parcel parcel) {
        this.f6528a = parcel.readStrongBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f6528a);
    }
}
