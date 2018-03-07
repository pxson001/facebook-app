package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: isNotifyAggressively */
public class CalleeReadyNotification extends MessagingNotification {
    public static final Creator<CalleeReadyNotification> CREATOR = new C14201();
    public final String f12648a;
    public final String f12649b;
    public final String f12650c;
    public final boolean f12651d;
    public final long f12652e;
    public final String f12653f;

    /* compiled from: isNotifyAggressively */
    final class C14201 implements Creator<CalleeReadyNotification> {
        C14201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CalleeReadyNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new CalleeReadyNotification[i];
        }
    }

    public CalleeReadyNotification(Parcel parcel) {
        super(parcel);
        this.f12648a = parcel.readString();
        this.f12649b = parcel.readString();
        this.f12650c = parcel.readString();
        this.f12651d = parcel.readInt() != 0;
        this.f12652e = parcel.readLong();
        this.f12653f = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12648a);
        parcel.writeString(this.f12649b);
        parcel.writeString(this.f12650c);
        parcel.writeInt(this.f12651d ? 1 : 0);
        parcel.writeLong(this.f12652e);
        parcel.writeString(this.f12653f);
    }
}
