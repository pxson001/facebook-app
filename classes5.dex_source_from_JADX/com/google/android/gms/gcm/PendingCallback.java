package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PendingCallback implements Parcelable {
    public static final Creator<PendingCallback> CREATOR = new C07841();
    final IBinder f6802a;

    final class C07841 implements Creator<PendingCallback> {
        C07841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        public final Object[] newArray(int i) {
            return new PendingCallback[i];
        }
    }

    public PendingCallback(Parcel parcel) {
        this.f6802a = parcel.readStrongBinder();
    }

    public final IBinder m12700a() {
        return this.f6802a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f6802a);
    }
}
