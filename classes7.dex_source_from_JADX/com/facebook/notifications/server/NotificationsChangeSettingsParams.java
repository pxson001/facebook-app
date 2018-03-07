package com.facebook.notifications.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: mon */
public class NotificationsChangeSettingsParams implements Parcelable {
    public static final Creator<NotificationsChangeSettingsParams> CREATOR = new C07021();
    public final String f8695a;
    public final String f8696b;
    public final String f8697c;
    public final String f8698d;
    public final String f8699e;

    /* compiled from: mon */
    final class C07021 implements Creator<NotificationsChangeSettingsParams> {
        C07021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NotificationsChangeSettingsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new NotificationsChangeSettingsParams[i];
        }
    }

    public NotificationsChangeSettingsParams(Parcel parcel) {
        this.f8695a = parcel.readString();
        this.f8696b = parcel.readString();
        this.f8697c = parcel.readString();
        this.f8698d = parcel.readString();
        this.f8699e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8695a);
        parcel.writeString(this.f8696b);
        parcel.writeString(this.f8697c);
        parcel.writeString(this.f8698d);
        parcel.writeString(this.f8699e);
    }
}
