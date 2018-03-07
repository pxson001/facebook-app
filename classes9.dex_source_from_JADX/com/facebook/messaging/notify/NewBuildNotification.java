package com.facebook.messaging.notify;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: iris_sequence_id */
public class NewBuildNotification extends MessagingNotification {
    public static final Creator<NewBuildNotification> CREATOR = new C14291();
    public final String f12728a;
    public final String f12729b;
    public final String f12730c;
    public final Intent f12731d;
    public boolean f12732e;

    /* compiled from: iris_sequence_id */
    final class C14291 implements Creator<NewBuildNotification> {
        C14291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NewBuildNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new NewBuildNotification[i];
        }
    }

    public NewBuildNotification(Parcel parcel) {
        super(parcel);
        this.f12728a = parcel.readString();
        this.f12729b = parcel.readString();
        this.f12730c = parcel.readString();
        this.f12731d = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f12732e = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12728a);
        parcel.writeString(this.f12729b);
        parcel.writeString(this.f12730c);
        parcel.writeParcelable(this.f12731d, i);
        ParcelUtil.a(parcel, this.f12732e);
    }
}
