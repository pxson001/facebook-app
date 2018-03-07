package com.facebook.rtc.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.user.model.UserKey;

/* compiled from: application/vnd.wap.mms-message; charset=utf-8 */
public class RtcCallLogInfo implements Parcelable {
    public static final Creator<RtcCallLogInfo> CREATOR = new C23331();
    public long f19820a;
    public UserKey f19821b;
    public long f19822c;
    public long f19823d;
    public boolean f19824e;
    public int f19825f;
    public int f19826g;
    public boolean f19827h;
    public boolean f19828i;
    public ThreadKey f19829j;
    public boolean f19830k;

    /* compiled from: application/vnd.wap.mms-message; charset=utf-8 */
    final class C23331 implements Creator<RtcCallLogInfo> {
        C23331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RtcCallLogInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new RtcCallLogInfo[i];
        }
    }

    public RtcCallLogInfo(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f19820a = parcel.readLong();
        this.f19821b = (UserKey) parcel.readParcelable(UserKey.class.getClassLoader());
        this.f19822c = parcel.readLong();
        this.f19823d = parcel.readLong();
        this.f19824e = parcel.readInt() > 0;
        this.f19825f = parcel.readInt();
        this.f19826g = parcel.readInt();
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f19827h = z;
        if (parcel.readInt() > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f19828i = z;
        this.f19829j = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        if (parcel.readInt() <= 0) {
            z2 = false;
        }
        this.f19830k = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeLong(this.f19820a);
        parcel.writeParcelable(this.f19821b, i);
        parcel.writeLong(this.f19822c);
        parcel.writeLong(this.f19823d);
        parcel.writeInt(this.f19824e ? 1 : 0);
        parcel.writeInt(this.f19825f);
        parcel.writeInt(this.f19826g);
        if (this.f19827h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.f19828i) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.f19829j, i);
        if (!this.f19830k) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }

    public final boolean m19566a() {
        return this.f19826g == 3;
    }
}
