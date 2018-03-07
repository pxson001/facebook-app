package com.facebook.messaging.notify;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.notify.MessagingNotification.Type;

/* compiled from: is not Long-Integer header field! */
public class MissedCallNotification extends MessagingNotification {
    public static final Creator<MissedCallNotification> CREATOR = new C14271();
    public final String f12714a;
    public final String f12715b;
    public final String f12716c;
    public final long f12717d;
    public final Boolean f12718e;
    public final String f12719f;
    public final AlertDisposition f12720g;
    public final MissCallType f12721h;
    public final ThreadKey f12722i;

    /* compiled from: is not Long-Integer header field! */
    final class C14271 implements Creator<MissedCallNotification> {
        C14271() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MissedCallNotification(parcel);
        }

        public final Object[] newArray(int i) {
            return new MissedCallNotification[i];
        }
    }

    /* compiled from: is not Long-Integer header field! */
    public enum MissCallType {
        P2P,
        CONFERENCE_ON_GOING,
        CONFERENCE_ENDED
    }

    public MissedCallNotification(String str, String str2, String str3, long j, boolean z, String str4, AlertDisposition alertDisposition, MissCallType missCallType, ThreadKey threadKey) {
        super(Type.MISSED_CALL);
        this.f12714a = str;
        this.f12715b = str2;
        this.f12716c = str3;
        this.f12717d = j;
        this.f12718e = Boolean.valueOf(z);
        this.f12719f = str4;
        this.f12720g = alertDisposition;
        this.f12721h = missCallType;
        this.f12722i = threadKey;
    }

    public MissedCallNotification(Parcel parcel) {
        super(parcel);
        this.f12714a = parcel.readString();
        this.f12715b = parcel.readString();
        this.f12716c = parcel.readString();
        this.f12717d = parcel.readLong();
        this.f12718e = Boolean.valueOf(parcel.readInt() != 0);
        this.f12719f = parcel.readString();
        this.f12720g = new AlertDisposition();
        this.f12721h = MissCallType.values()[parcel.readInt()];
        this.f12722i = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
    }

    public final boolean m13123a() {
        return this.f12721h == MissCallType.CONFERENCE_ON_GOING || this.f12721h == MissCallType.CONFERENCE_ENDED;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.m13110a(parcel);
        parcel.writeString(this.f12714a);
        parcel.writeString(this.f12715b);
        parcel.writeString(this.f12716c);
        parcel.writeLong(this.f12717d);
        parcel.writeInt(this.f12718e.booleanValue() ? 1 : 0);
        parcel.writeString(this.f12719f);
        parcel.writeInt(this.f12721h.ordinal());
        parcel.writeParcelable(this.f12722i, i);
    }
}
