package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.notify.MessagingNotification.Type;
import com.facebook.push.PushProperty;

/* compiled from: invitee_credentials */
public class SimpleMessageNotification extends MessagingNotification {
    public static final Creator<SimpleMessageNotification> CREATOR = new C14351();
    public final String f12768a;
    public final PushProperty f12769b;

    /* compiled from: invitee_credentials */
    final class C14351 implements Creator<SimpleMessageNotification> {
        C14351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimpleMessageNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimpleMessageNotification[i];
        }
    }

    public SimpleMessageNotification(String str, PushProperty pushProperty, Type type) {
        super(type);
        this.f12768a = str;
        this.f12769b = pushProperty;
    }

    public SimpleMessageNotification(Parcel parcel) {
        super(parcel);
        this.f12768a = parcel.readString();
        this.f12769b = (PushProperty) parcel.readParcelable(PushProperty.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12768a);
        parcel.writeParcelable(this.f12769b, i);
    }
}
