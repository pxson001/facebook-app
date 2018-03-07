package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: invite_link */
public class TincanMessageRequestNotification extends MessagingNotification {
    public static final Creator<TincanMessageRequestNotification> CREATOR = new C14371();
    public final String f12774a;
    public final String f12775b;
    public boolean f12776c;

    /* compiled from: invite_link */
    final class C14371 implements Creator<TincanMessageRequestNotification> {
        C14371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TincanMessageRequestNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new TincanMessageRequestNotification[i];
        }
    }

    public TincanMessageRequestNotification(String str, String str2) {
        super(Type.TINCAN_MESSAGE_REQUEST);
        this.f12774a = str;
        this.f12775b = str2;
    }

    protected TincanMessageRequestNotification(Parcel parcel) {
        super(parcel);
        this.f12774a = parcel.readString();
        this.f12775b = parcel.readString();
        this.f12776c = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12774a);
        parcel.writeString(this.f12775b);
        ParcelUtil.a(parcel, this.f12776c);
    }
}
