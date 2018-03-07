package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: org.chromium.net.ProxyChangeListener$ProxyReceiver */
public final class AppInviteContent implements ShareModel {
    public static final Creator<AppInviteContent> CREATOR = new C06181();
    private final String f4581a;
    private final String f4582b;

    /* compiled from: org.chromium.net.ProxyChangeListener$ProxyReceiver */
    final class C06181 implements Creator<AppInviteContent> {
        C06181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AppInviteContent(parcel);
        }

        public final Object[] newArray(int i) {
            return new AppInviteContent[i];
        }
    }

    AppInviteContent(Parcel parcel) {
        this.f4581a = parcel.readString();
        this.f4582b = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4581a);
        parcel.writeString(this.f4582b);
    }
}
