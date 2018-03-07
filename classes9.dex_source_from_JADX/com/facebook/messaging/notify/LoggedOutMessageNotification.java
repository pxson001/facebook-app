package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.messaging.notify.MessagingNotification.Type;
import com.facebook.push.PushProperty;
import com.facebook.push.PushSource;

/* compiled from: isDisableVibrate */
public class LoggedOutMessageNotification extends MessagingNotification {
    public static final Creator<LoggedOutMessageNotification> CREATOR = new C14251();
    public final String f12676a;
    public final String f12677b;
    private final PushProperty f12678c;
    public boolean f12679d;

    /* compiled from: isDisableVibrate */
    final class C14251 implements Creator<LoggedOutMessageNotification> {
        C14251() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new LoggedOutMessageNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new LoggedOutMessageNotification[i];
        }
    }

    public LoggedOutMessageNotification(String str, String str2, PushProperty pushProperty) {
        super(Type.LOGGED_OUT_MESSAGE);
        this.f12676a = str;
        this.f12677b = str2;
        this.f12678c = pushProperty;
    }

    public LoggedOutMessageNotification(Parcel parcel) {
        super(parcel);
        this.f12676a = parcel.readString();
        this.f12677b = parcel.readString();
        this.f12678c = (PushProperty) parcel.readParcelable(PushProperty.class.getClassLoader());
        this.f12679d = ParcelUtil.a(parcel);
    }

    public final PushSource m13113d() {
        return this.f12678c.a;
    }

    public final String m13114e() {
        return this.f12678c.b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12676a);
        parcel.writeString(this.f12677b);
        parcel.writeParcelable(this.f12678c, i);
        ParcelUtil.a(parcel, this.f12679d);
    }
}
