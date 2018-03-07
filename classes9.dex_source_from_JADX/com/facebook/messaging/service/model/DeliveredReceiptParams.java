package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.UserKey;

/* compiled from: create_p2p_platform_context */
public class DeliveredReceiptParams implements Parcelable {
    public static final Creator<DeliveredReceiptParams> CREATOR = new C20011();
    public final ThreadKey f17037a;
    public final UserKey f17038b;
    public final String f17039c;
    public final long f17040d;
    public final long f17041e;

    /* compiled from: create_p2p_platform_context */
    final class C20011 implements Creator<DeliveredReceiptParams> {
        C20011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeliveredReceiptParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeliveredReceiptParams[i];
        }
    }

    public DeliveredReceiptParams(ThreadKey threadKey, UserKey userKey, String str, long j, long j2) {
        this.f17037a = threadKey;
        this.f17038b = userKey;
        this.f17039c = str;
        this.f17040d = j;
        this.f17041e = j2;
    }

    public DeliveredReceiptParams(Parcel parcel) {
        this.f17037a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17038b = UserKey.a(parcel.readString());
        this.f17039c = parcel.readString();
        this.f17040d = parcel.readLong();
        this.f17041e = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17037a, i);
        parcel.writeString(this.f17038b.c());
        parcel.writeString(this.f17039c);
        parcel.writeLong(this.f17040d);
        parcel.writeLong(this.f17041e);
    }
}
