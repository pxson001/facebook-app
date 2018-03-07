package com.facebook.orca.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: next_button */
public class SwitchToFbAccountNotification extends MessagingNotification {
    public static final Creator<SwitchToFbAccountNotification> CREATOR = new C09501();
    public final String f6272a;
    public final String f6273b;
    public final String f6274c;
    public boolean f6275d;

    /* compiled from: next_button */
    final class C09501 implements Creator<SwitchToFbAccountNotification> {
        C09501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SwitchToFbAccountNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new SwitchToFbAccountNotification[i];
        }
    }

    public SwitchToFbAccountNotification(String str, String str2, String str3) {
        super(Type.SWITCH_TO_FB_ACCOUNT);
        this.f6272a = str;
        this.f6273b = str2;
        this.f6274c = str3;
    }

    public SwitchToFbAccountNotification(Parcel parcel) {
        super(parcel);
        this.f6272a = parcel.readString();
        this.f6273b = parcel.readString();
        this.f6274c = parcel.readString();
        this.f6275d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.a(parcel);
        parcel.writeString(this.f6272a);
        parcel.writeString(this.f6273b);
        parcel.writeString(this.f6274c);
        ParcelUtil.a(parcel, this.f6275d);
    }
}
