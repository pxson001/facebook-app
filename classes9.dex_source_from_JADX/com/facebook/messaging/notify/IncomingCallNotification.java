package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: isGroupThread */
public class IncomingCallNotification extends MessagingNotification {
    public static final Creator<IncomingCallNotification> CREATOR = new C14231();
    public final String f12663a;
    public final String f12664b;
    public final String f12665c;
    public final long f12666d;
    public final Boolean f12667e;
    public final String f12668f;
    public final AlertDisposition f12669g;
    public final ThreadKey f12670h;
    public final CallType f12671i;

    /* compiled from: isGroupThread */
    final class C14231 implements Creator<IncomingCallNotification> {
        C14231() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new IncomingCallNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new IncomingCallNotification[i];
        }
    }

    /* compiled from: isGroupThread */
    public enum CallType {
        P2P,
        CONFERENCE
    }

    public IncomingCallNotification(Parcel parcel) {
        super(parcel);
        this.f12663a = parcel.readString();
        this.f12664b = parcel.readString();
        this.f12665c = parcel.readString();
        this.f12666d = parcel.readLong();
        this.f12667e = Boolean.valueOf(parcel.readInt() != 0);
        this.f12668f = parcel.readString();
        this.f12669g = new AlertDisposition();
        this.f12670h = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f12671i = (CallType) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12663a);
        parcel.writeString(this.f12664b);
        parcel.writeString(this.f12665c);
        parcel.writeLong(this.f12666d);
        parcel.writeInt(this.f12667e.booleanValue() ? 1 : 0);
        parcel.writeString(this.f12668f);
        parcel.writeParcelable(this.f12670h, i);
        parcel.writeSerializable(this.f12671i);
    }
}
