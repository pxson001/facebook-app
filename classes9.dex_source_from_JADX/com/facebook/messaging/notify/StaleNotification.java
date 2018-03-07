package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: invite_status */
public class StaleNotification extends MessagingNotification {
    public static final Creator<StaleNotification> CREATOR = new C14361();
    public final String f12770a;
    public final String f12771b;
    public final String f12772c;
    public boolean f12773d;

    /* compiled from: invite_status */
    final class C14361 implements Creator<StaleNotification> {
        C14361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new StaleNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new StaleNotification[i];
        }
    }

    public StaleNotification(String str, String str2, String str3) {
        super(Type.STALE);
        this.f12770a = str;
        this.f12771b = str2;
        this.f12772c = str3;
    }

    protected StaleNotification(Parcel parcel) {
        super(parcel);
        this.f12770a = parcel.readString();
        this.f12771b = parcel.readString();
        this.f12772c = parcel.readString();
        this.f12773d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12770a);
        parcel.writeString(this.f12771b);
        parcel.writeString(this.f12772c);
        ParcelUtil.a(parcel, this.f12773d);
    }
}
