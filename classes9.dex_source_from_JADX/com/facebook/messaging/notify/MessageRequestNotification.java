package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: isDisableSound */
public class MessageRequestNotification extends MessagingNotification {
    public static final Creator<MessageRequestNotification> CREATOR = new C14261();
    public final String f12680a;
    public final String f12681b;
    public boolean f12682c;

    /* compiled from: isDisableSound */
    final class C14261 implements Creator<MessageRequestNotification> {
        C14261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MessageRequestNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new MessageRequestNotification[i];
        }
    }

    public MessageRequestNotification(String str, String str2) {
        super(Type.MESSAGE_REQUEST);
        this.f12680a = str;
        this.f12681b = str2;
    }

    protected MessageRequestNotification(Parcel parcel) {
        super(parcel);
        this.f12680a = parcel.readString();
        this.f12681b = parcel.readString();
        this.f12682c = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12680a);
        parcel.writeString(this.f12681b);
        ParcelUtil.a(parcel, this.f12682c);
    }
}
