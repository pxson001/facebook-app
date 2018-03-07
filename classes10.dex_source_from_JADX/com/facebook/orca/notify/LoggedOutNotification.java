package com.facebook.orca.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: no_title */
public class LoggedOutNotification extends MessagingNotification {
    public static final Creator<LoggedOutNotification> CREATOR = new C09491();
    public final String f6235a;
    public final String f6236b;
    public final String f6237c;
    public boolean f6238d;

    /* compiled from: no_title */
    final class C09491 implements Creator<LoggedOutNotification> {
        C09491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LoggedOutNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new LoggedOutNotification[i];
        }
    }

    public LoggedOutNotification(String str, String str2, String str3) {
        super(Type.USER_LOGGED_OUT);
        this.f6235a = str;
        this.f6236b = str2;
        this.f6237c = str3;
    }

    public LoggedOutNotification(Parcel parcel) {
        super(parcel);
        this.f6235a = parcel.readString();
        this.f6236b = parcel.readString();
        this.f6237c = parcel.readString();
        this.f6238d = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.a(parcel);
        parcel.writeString(this.f6235a);
        parcel.writeString(this.f6236b);
        parcel.writeString(this.f6237c);
        ParcelUtil.a(parcel, this.f6238d);
    }
}
