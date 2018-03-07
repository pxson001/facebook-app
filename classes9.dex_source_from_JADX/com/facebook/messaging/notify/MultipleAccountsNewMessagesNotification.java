package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: is not Encoded-String-Value header field! */
public class MultipleAccountsNewMessagesNotification extends MessagingNotification {
    public static final Creator<MultipleAccountsNewMessagesNotification> CREATOR = new C14281();
    public final String f12723a;
    public final String f12724b;
    public final String f12725c;
    public final String f12726d;
    public boolean f12727e;

    /* compiled from: is not Encoded-String-Value header field! */
    final class C14281 implements Creator<MultipleAccountsNewMessagesNotification> {
        C14281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MultipleAccountsNewMessagesNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new MultipleAccountsNewMessagesNotification[i];
        }
    }

    public MultipleAccountsNewMessagesNotification(Parcel parcel) {
        super(parcel);
        this.f12723a = parcel.readString();
        this.f12724b = parcel.readString();
        this.f12725c = parcel.readString();
        this.f12726d = parcel.readString();
        this.f12727e = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12723a);
        parcel.writeString(this.f12724b);
        parcel.writeString(this.f12725c);
        parcel.writeString(this.f12726d);
        ParcelUtil.a(parcel, this.f12727e);
    }
}
